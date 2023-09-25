import { useParams } from 'react-router-dom'
import { useState } from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import { Formik, Form, Field } from 'formik';
import Button from '@mui/material/Button';
import { v4 as uuidv4 } from 'uuid';
import { fetchData } from '../../utils/utils';


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


const fmisArr = ['--Select--', 'TRADE_MATCHING_SERVICE', 'TRADE_CLEARING_SERVICE', 'TRADE_SETTLEMENT_SERVICE']


export default function Dashboard() {
  const [value, setValue] = useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const {id} = useParams()

const handleSubmit = ({fmi}, setSubmitting) => {
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

      const response = fetchData( headers, '/repoTrades/execution')
      console.log({ response })
      setSubmitting(false);

}

  return (
    <Box
      sx={{display: 'flex', height: "auto", border: '1px solid #0474ac' }}
    >
        <div style={{borderRight: '1px solid #0474ac'}}>
            <h4>Trade Ids</h4>

            <Tabs
                orientation="vertical"
                value={value}
                onChange={handleChange}
                aria-label="Vertical tabs example"
                sx={{ borderRight: 1, borderColor: 'divider', minWidth: '200px', }}
                textColor="primary"
                // indicatorColor="secondary"
                style={{backgroundColor: '#0474ac28'}}
            >
            {listOfTrades.map((trade, i)=> <Tab label={trade} {...a11yProps(i)}/> )}
            </Tabs>
        </div>
      <TabPanel value={value} index={0}>
      <Formik
        enableReinitialize="true"
       initialValues={{fmi: ''}}
       validate={values => {
       }}
       onSubmit={(values, setSubmitting) => handleSubmit(values, setSubmitting)}
     >
       {(props) => {
        return (
         <Form
            style={{    display: 'flex',
            margin: 'auto',
            width: '40%',
            justifyContent: 'space-around', alignItems: 'end'}}
         >
              <div
                style={{display: 'flex', flexDirection: 'column'}}
              >
                <label htmlFor="fmi" style={{paddingBottom: '.4rem'}}>Select a Financial Market Infrastructure</label>
                <Field
                  as='select'
                  id="fmi" 
                  name="fmi"
                  style={{textAlign: 'center', padding: '.3rem 0'}}
                //   onChange={handleSelect}
                  >
                    {fmisArr.map(fmi =><option value={fmi}>{fmi}</option>)}
                  </Field>
              </div>
         <Button style={{background: 'red', height: '2rem'}} 
            type='submit'
            disabled={props.isSubmitting} variant="contained">Submit</Button>

         </Form>
        )
       }}
        </Formik>
      </TabPanel>
      <TabPanel value={value} index={1}>
        <p></p>
      </TabPanel>
      <TabPanel value={value} index={2}>
        Trade Clearing
      </TabPanel>
    </Box>
  );
}