import { useNavigate, useParams } from 'react-router-dom'
import { useEffect, useState } from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import { v4 as uuidv4 } from 'uuid';
import moment from 'moment'
import { fetchData, getStatus, getTradeStatus, fetchNoHeaders, postData } from '../../utils/utils';

const workflowEventLabelStyled = {
    fontStyle: 'Italic',
    fontWeight: 'bold'
}

const workflowEventDisplay = {
    display: 'block',
    padding: '.4rem',
    backgroundColor: 'white'
}

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`vertical-tabpanel-${index}`}
      aria-labelledby={`vertical-tab-${index}`}
      style={{ width: "100%"}}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }}>
          <Typography>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired,
};

function a11yProps(index) {
  return {
    id: `vertical-tab-${index}`,
    'aria-controls': `vertical-tabpanel-${index}`
  };
}

const TradeDetails = ({workflowStatus, tradeId, id}) => {
  const tradeDetails = () => {
    if (workflowStatus?.tradeMatchingService) {
      return workflowStatus?.tradeMatchingService?.filter(trade => trade.tradeId === tradeId)[0]?.workflowEvents
    } else if (workflowStatus?.tradeClearingService) {
      return workflowStatus?.tradeClearingService?.filter(trade => trade.tradeId === tradeId)[0]?.workflowEvents
    }
  }
  
  const clearTrade = async (date) => {
    const headers = {
      "Content-Type": "application/json",
      'x-api-key': process.env.REACT_APP_X_API_KEY,
      'x-participant-id': process.env.REACT_APP_X_PARTICIPANT_ID,
      'x-api-request-id': uuidv4(),
      'x-financial-member-id': id.toUpperCase(),
      'x-simulation-date': date
    }
     const response = await postData( headers, `/repoTrades/clearing?tradeId=${tradeId}`)
  }

  const settleTrade = async (date) => {
    const headers = {
      "Content-Type": "application/json",
      'x-api-key': process.env.REACT_APP_X_API_KEY,
      'x-participant-id': process.env.REACT_APP_X_PARTICIPANT_ID,
      'x-api-request-id': uuidv4(),
      'x-financial-member-id': id.toUpperCase(),
      'x-simulation-date': date
    }
     const response = await postData( headers, `/repoTrades/settlement?tradeId=${tradeId}`)
  }
  const navigate = useNavigate()
  const date = tradeDetails()?.length> 0 && new Date(tradeDetails()[0]?.eventTimeStamp)
    return (
        <Box>
    <h4 style={{marginBottom: '2rem'}}>Workflow Event Details</h4>
    {(tradeDetails()?.length> 0) && tradeDetails().map((singleTrade, i) =>
      <Box
        style={{display: 'flex', justifyContent: 'space-around', paddingBottom: '2rem'}}
    >
        <div style={{display: 'inline-block'}}>
            <span style={workflowEventLabelStyled}>Event Sequence</span>
            <span style={workflowEventDisplay}>{singleTrade.eventSequence}</span>
        </div>
        <div  style={{display: 'inline-block'}}>
            <span style={workflowEventLabelStyled}>Trade Status</span>
            <span style={workflowEventDisplay}>{getTradeStatus(singleTrade.tradeStatus)}</span>
        </div>
        <div  style={{display: 'inline-block'}}>
            <span style={workflowEventLabelStyled}>Trade Matching Status</span>
            <span style={workflowEventDisplay}>{getStatus(singleTrade.tradeMatchingStatus)}</span>
        </div>
        <div  style={{display: 'inline-block'}}>
            <span style={workflowEventLabelStyled}>Event Time</span>
            <span style={workflowEventDisplay}>{moment(date).format('MMMM Do YYYY, h:mm:ss a')}</span>
        </div>

    </Box>
    )}
    <Box 
        style={{width: '40%', margin: 'auto'}}
    >
        <h4 style={{marginBottom: '2rem'}}>Trades Actions</h4>
        <Button style={{background: 'red', color: 'white', padding: '.5rem', marginRight: '1rem', width: '40%'}} onClick={() => clearTrade()}>Clear</Button>
        <Button style={{background: 'green', color: 'white', padding: '.5rem', marginLeft: '1rem', width: '40%'}} onClick={() => settleTrade()} >Settle</Button>
    </Box>
</Box>
    )
}

const getFmi = (tradeId) => {
  const lastDigit = tradeId.split('').pop()
  switch (lastDigit) {
    case '0':
      return 'TRADE_MATCHING_SERVICE'
    case '1':
      return 'TRADE_CLEARING_SERVICE'
    case '2':
      return 'TRADE_SETTLEMENT_SERVICE'
    default:
  }
}

export default function Dashboard(props) {
  const {id} = useParams()
  const [value, setValue] = useState(0);
  const [listOfTrades, setListOfTrades] = useState([])
  const [workflowStatus, setWorkflowStatus] = useState({
    tradeMatchingService: null,
    tradeClearingService: null,
    tradeSettlementService: null
  })

const getData = async (listOfTrades, getFmi) => {
  const headers = {
      "Content-Type": "application/json",
      'x-api-key': process.env.REACT_APP_X_API_KEY,
      'x-participant-id': process.env.REACT_APP_X_PARTICIPANT_ID,
      'x-api-request-id': uuidv4(),
      'x-financial-member-id': id.toUpperCase()
    }
    const tradeData = await fetchData( headers, `/repoTrades/tradeWorkflowStatus/?tradeId=${listOfTrades.tradeId}&fmi=${getFmi(listOfTrades.tradeId)}`)
    setWorkflowStatus(tradeData)
}

//Get the list of trades from the DB
  useEffect(() => {
    const getTradesList = async () => {
      const tradesList = await fetchNoHeaders(`/repoTrades/tradesList/?loggedInUser=${id.toUpperCase()}`)
      setListOfTrades(tradesList)
      if (tradesList.length > 0) {
        const response = await getData(tradesList[value], getFmi)
        console.log({ response})
      }
      return tradesList
    }
    getTradesList()
  }, [])


  useEffect(() => {
  }, [])
  const handleChange = (event, newValue) => {
    setValue(newValue);
    const response = getData(listOfTrades[newValue], getFmi)

  };

  return (
    <div
        style={{minHeight: '90vh'}}
    >
        { listOfTrades?.length > 0 ?  <Box
        sx={{display: 'flex', height: "auto", border: '1px solid #0474ac', borderRadius: '10px' }}
        >
           <div style={{borderRight: '1px solid #0474ac'}}>
                <h4 style={{ margin: '1rem 0'}}>List of Trades</h4>
                <Tabs
                    orientation="vertical"
                    value={value}
                    onChange={handleChange}
                    aria-label="Vertical tabs example"
                    sx={{ borderRight: 1, borderColor: 'divider', minWidth: '200px', minHeight: '80%' }}
                    textColor="primary"
                    style={{backgroundColor: '#0474ac28'}}
                >
                {listOfTrades?.map((trade, i)=> <Tab label={trade.tradeId} {...a11yProps(i)}/> )}
                </Tabs>
            </div>
            
               {listOfTrades.map((trade, i)=> <TabPanel value={value} index={i}>
            <TradeDetails workflowStatus={workflowStatus} tradeId={trade.tradeId} id={id} i={i}/>
            </TabPanel>)}
            
        </Box> : <h4>You haven't create a trade yet.</h4>}
    </div>
  );
}