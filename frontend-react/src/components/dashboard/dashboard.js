import { useNavigate, useParams } from 'react-router-dom'
import { useEffect, useState } from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import { Formik, Form, Field } from 'formik';
import Button from '@mui/material/Button';
import { v4 as uuidv4 } from 'uuid';
import moment from 'moment'
import { fetchData, getStatus, getTradeStatus, fetchNoHeaders } from '../../utils/utils';

const workflowEventLabelStyled = {
    fontStyle: 'Italic',
    fontWeight: 'bold'
}

const workflowEventDisplay = {
    display: 'block',
    padding: '.4rem',
    backgroundColor: 'white'
}

const listOfTrades = [
    'UC2Q0EKXFH6260', 'UC2Q0EKXFH6264', 'UC2Q0EKXFH6232'
]

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


const fmisArr = [{TRADE_MATCHING_SERVICE: "TRADE MATCHING SERVICE" }, {TRADE_CLEARING_SERVICE: 'TRADE CLEARING SERVICE'}, {TRADE_SETTLEMENT_SERVICE: 'TRADE SETTLEMENT SERVICE'}]

const TradeIdForm = ({handleSelect, fmi}) => {
    // const handleChange = (e) => {
    //     console.log(e.target)
    //     // handleSelect()
    // }
    return (
        <Formik
        enableReinitialize="true"
       initialValues={{fmi: 'TRADE MATCHING SERVICE'}}
       validate={values => {
       }}
    //    onSubmit={(values, setSubmitting) => handleSubmit(values, setSubmitting)}
     >
       {(props) => {
        return (
            <Form
                style={{    display: 'flex',
                margin: 'auto',
                width: '40%',
                justifyContent: 'space-around', alignItems: 'end', marginBottom: '2rem'}}
            >
          <div
            style={{display: 'flex', flexDirection: 'column', marginBottom: '1rem'}}
          >
            <label htmlFor="fmi" style={{paddingBottom: '.4rem'}}>Select a Financial Market Infrastructure</label>
            <Field
              as='select'
              id="fmi" 
              name="fmi"
              value={fmi}
            //   onChange={handleChange}
              style={{textAlign: 'center', padding: '.3rem 0', borderRadius: '5px'}}
              onChange={(e) => handleSelect(e.target.value)}
              >
                {fmisArr.map(fmi =><option value={Object.keys(fmi)[0]}>{Object.values(fmi)[0]}</option>)}
              </Field>
          </div>
     {/* <Button style={{background: 'red', height: '2rem'}}
        type='submit'
        // disabled={props.isSubmitting}
         variant="contained">Submit</Button> */}

     </Form>
        )
       }}
        </Formik>
       
    )
}

const TradeDetails = ({workflowEvent, tradeId}) => {
  const navigate = useNavigate()
  console.log({ tradeId, workflowEvent })
const date = new Date(workflowEvent.eventTimeStamp)
    return (
        <Box>
    <h4 style={{marginBottom: '2rem'}}>Workflow Event Details</h4>
    <Box
        style={{display: 'flex', justifyContent: 'space-around', paddingBottom: '2rem'}}
    >
        <div style={{display: 'inline-block'}}>
            <span style={workflowEventLabelStyled}>Event Sequence</span>
            <span style={workflowEventDisplay}>{workflowEvent.eventSequence}</span>
        </div>
        <div  style={{display: 'inline-block'}}>
            <span style={workflowEventLabelStyled}>Trade Status</span>
            <span style={workflowEventDisplay}>{getTradeStatus(workflowEvent.tradeStatus)}</span>
        </div>
        <div  style={{display: 'inline-block'}}>
            <span style={workflowEventLabelStyled}>Trade Matching Status</span>
            <span style={workflowEventDisplay}>{getStatus(workflowEvent.tradeMatchingStatus)}</span>
        </div>
        <div  style={{display: 'inline-block'}}>
            <span style={workflowEventLabelStyled}>Event Time</span>
            <span style={workflowEventDisplay}>{moment(date).format('MMMM Do YYYY, h:mm:ss a')}</span>
        </div>

    </Box>
    <Box 
        style={{width: '40%', margin: 'auto'}}
    >
        <h4 style={{marginBottom: '2rem'}}>Trades Actions</h4>
        <Button style={{background: 'red', color: 'white', padding: '.5rem', marginRight: '1rem', width: '40%'}} onClick={() => navigate(`/clearTrades/${tradeId}`)}>Clear</Button>
        <Button style={{background: 'green', color: 'white', padding: '.5rem', marginLeft: '1rem', width: '40%'}} onClick={() => navigate(`/settleTrades/${tradeId}`)} >Settle</Button>
    </Box>
</Box>
    )
}

export default function Dashboard(props) {
  const [value, setValue] = useState(0);
  const [fmi, setFmi] = useState('TRADE_MATCHING_SERVICE')
  // const [listOfTrades, setListOfTrades] = useState([])
  
  const getTradeList = async () => {
    const response = await fetchNoHeaders('/repoTrades/tradesList/')
    console.log({ response })
  }

  useEffect(() => {
    const term = setInterval(() => {
      // getTradeList()
    }, 5000)

    console.log({ term })

    return () => clearInterval(term)
  }, [])

  const getData = () => {
    const headers = {
        "Accept": "application/json",
        'x-api-key': process.env.REACT_APP_X_API_KEY,
        'x-participant-id': process.env.REACT_APP_X_PARTICIPANT_ID,
        'x-api-request-id': uuidv4(),
        'x-financial-member-id': id.toUpperCase(),
        'tradeId': listOfTrades[value] ,
        fmi
      }

      console.log({ headers })

      const response = fetchData( headers, '/repoTrades/tradeWorkflowStatus/')
      console.log({ response })
  }

  useEffect(() => {
    getData()
  }, [value])

  const handleChange = (event, newValue) => {
    setValue(newValue);
    // getData()
  };

  const {id} = useParams()

  const workflowEvent = {
    eventSequence: 1,
    requestId: "5e970526-6ebe-4d9f-bab5-9f05fa07dcfd",
    tradeStatus: "TRADE_ACCEPTED",
    tradeMatchingStatus: "TRADE_MATCH_SUCCESS",
    eventTimeStamp: "2023-08-25T10:26:24.441Z"
  }

  const workflowEventFailed = {
    eventSequence: 1,
    requestId: "5e970526-6ebe-4d9f-bab5-9f05fa07dcfd",
    tradeStatus: "TRADE_REJECTED",
    tradeMatchingStatus: "TRADE_MATCH_FAILURE",
    eventTimeStamp: "2023-08-25T10:26:24.441Z"
  }

// const handleSubmit = ({fmi}, setSubmitting) => {
//     const headers = {
//         "Accept": "application/json",
//         'x-api-key': process.env.REACT_APP_X_API_KEY,
//         'x-participant-id': process.env.REACT_APP_X_PARTICIPANT_ID,
//         'x-api-request-id': uuidv4(),
//         'x-financial-member-id': id.toUpperCase(),
//         'tradeId': listOfTrades[value] ,
//         fmi
//       }

//       console.log({ headers })

//       const response = fetchData( headers, '/repoTrades/execution')
//       console.log({ response })
//       setSubmitting(false);

// }


  return (
    <div
        style={{minHeight: '90vh'}}
    >
        <TradeIdForm handleSelect={setFmi} fmi={fmi}/>

        <Box
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
                {listOfTrades.map((trade, i)=> <Tab label={trade} {...a11yProps(i)}/> )}
                </Tabs>
            </div>

        <TabPanel value={value} index={0}>
            <TradeDetails workflowEvent={workflowEvent} tradeId={listOfTrades[0]}/>
        </TabPanel>
        <TabPanel value={value} index={1}>
        <TradeDetails workflowEvent={workflowEventFailed} tradeId={listOfTrades[1]}/>

        </TabPanel>
        <TabPanel value={value} index={2}>
        <TradeDetails workflowEvent={workflowEvent} tradeId={listOfTrades[2]}/>
        </TabPanel>
        </Box>
    </div>
  );
}