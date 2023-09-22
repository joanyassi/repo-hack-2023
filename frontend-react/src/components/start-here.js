import { useState, useEffect } from 'react';
import PropTypes from 'prop-types';
import axios from 'axios';
import SwipeableViews from 'react-swipeable-views';
import { useTheme } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import { Container } from '@mui/material';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import CircularProgress from '@mui/material/CircularProgress';

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`full-width-tabpanel-${index}`}
      aria-labelledby={`full-width-tab-${index}`}
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
    id: `full-width-tab-${index}`,
    'aria-controls': `full-width-tabpanel-${index}`,
  };
}

export default function FullWidthTabs() {
  const [authDetails, setAuthDetails] = useState({
    xApiKey: process.env.REACT_APP_X_API_KEY,
    xParticipantId: process.env.REACT_APP_X_PARTICIPANT_ID
  })
  const [loading, setLoading] = useState(false)

  useEffect(() => {
    setLoading(false)
  }, [])

  const theme = useTheme();
  const [value, setValue] = useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  const handleAuthDetails = (e) => {
    const [name, value] = e.target
    setAuthDetails(prevState => ({
      ...prevState,
      [name]: value
    }))
  }

  const handleChangeIndex = (index) => {
    setValue(index);
  };

  const getData = async (e) => {
    e.preventDefault()
     const response = await axios.get(`http://localhost:8080/repohack/start-here/public-ping`, {
        headers: {
            'Accept': 'application/json',
        }
     })
     setAuthDetails(prevState => ({
      ...prevState,
      publicMessage: response.data.message
    }))

    setLoading(true)
}

const getDataWithAuth = async (e) => {
  e.preventDefault()
    try {
    const response = await axios.get("http://localhost:8080/repohack/start-here/auth-ping", {
        headers: {
          "Accept": "application/json",
          'x-api-key': 'TEAM014_nbbkjbkjBJKBKBUIGIUYGUYrifiuehrfiuuyfuu4t487t8_014',
         'x-participant-id': 'TEAM014',
        }})

    setAuthDetails(prevState => ({
      ...prevState,
      authMessage: response.data.message
    }))
    setLoading(true)
    } catch (error) {
    }
    
  }

  return (
    <Box sx={{ bgcolor: 'background.paper' }}>
      <AppBar position="static">
        <Tabs
          value={value}
          onChange={handleChange}
          indicatorColor="secondary"
          textColor="inherit"
          variant="fullWidth"
          aria-label="full width tabs example"
        >
          <Tab label="Public Ping" {...a11yProps(0)} />
          <Tab label="Auth Ping" {...a11yProps(1)} />
        </Tabs>
      </AppBar>
      <SwipeableViews
        axis={theme.direction === 'rtl' ? 'x-reverse' : 'x'}
        index={value}
        onChangeIndex={handleChangeIndex}
        classname='king'
      >
        <TabPanel value={value} index={0} dir={theme.direction}>
        <Container
            sx={{display: 'flex', padding: '0', justifyContent: 'space-between'}}
            classname='lexy'
          >
            <Box
              onSubmit={e => getData(e)}
              component="form"
              sx={{
                  '& .MuiTextField-root': { m: 1},
              }}
              noValidate
              autoComplete="off"
              // border='2px solid red'
              minHeight='80vh'
              width='40%'
              display='flex'
              justifyContent='center'
              alignItems='center'
              flexDirection='column'
            >
                <div style={{display: 'flex', flexDirection: 'column', width: '100%'}}>
                </div>
                <Button type="submit" variant="contained">Go</Button>
            </Box>
            <Box
              width="55%"
              border="1px solid #0474ac36"
              sx={{display: 'flex', alignItems:'center', justifyContent: 'center'}}
              boxShadow="0 0 0 0 #0474ac36, 0 2px 20px 0 rgba(0, 0, 0, 0.19)"

            >
            {loading ? <p>{authDetails?.publicMessage}</p> : <CircularProgress color="inherit" />}

            </Box>
          </Container>
          
        </TabPanel>
        <TabPanel value={value} index={1} dir={theme.direction}>
        <Container
            sx={{display: 'flex', padding: '0', justifyContent: 'space-between'}}
            classname='lexy'
          >
            <Box
              onSubmit={e => getDataWithAuth(e)}
              component="form"
              sx={{
                  '& .MuiTextField-root': { m: 1},
              }}
              noValidate
              autoComplete="off"
              // border='2px solid red'
              minHeight='80vh'
              width='40%'
              display='flex'
              justifyContent='center'
              alignItems='center'
              flexDirection='column'
            >
                <div style={{display: 'flex', flexDirection: 'column', width: '100%'}}>
                  <TextField
                    id="outlined-helperText"
                    label="x-participant-id"
                    value={authDetails.xParticipantId}
                    name="xParticipantId"
                    onChange={(e) => {handleAuthDetails(e)}}
                    defaultValue='lexy king'
                    variant="filled"

                  />
                  <TextField
                    id="filled-error-helper-text"
                    label="x-api-key"
                    value={authDetails.xApiKey}
                    name="xApiKey"
                    onChange={(e) => {handleAuthDetails(e)}}
                    defaultValue={authDetails.xApiKey}
                    variant="filled"
                  />
                </div>
                <Button type="submit" variant="contained">Go</Button>
            </Box>
            <Box
              width="55%"
              border="1px solid #0474ac36"
              sx={{display: 'flex', alignItems:'center', justifyContent: 'center'}}
              boxShadow="0 0 0 0 #0474ac36, 0 2px 20px 0 rgba(0, 0, 0, 0.19)"
            >
              {loading ? <p>{authDetails?.authMessage}</p> : <CircularProgress color="inherit" />}
            </Box>
          </Container>
        </TabPanel>
      </SwipeableViews>
    </Box>
  );
}