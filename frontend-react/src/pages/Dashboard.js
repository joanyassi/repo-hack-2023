import * as React from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import StartHere from '../components/start-here'
import TradeExecution from '../components/execution/tradeExecution'
import Dashboard from '../components/dashboard/dashboard';

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


export default function VerticalTabs() {
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Box
      sx={{display: 'flex', height: "auto", background: '#0474ac13' }}
    >
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
        <Tab label="Dashboard" {...a11yProps(0)}/>
        <Tab label="Trade Execution" {...a11yProps(1)} />
        {/* <Tab label="Trade Clearing" {...a11yProps(2)} />
        <Tab label="Trade Settlement" {...a11yProps(3)} /> */}
        <Tab label="Business Event Query" {...a11yProps(2)} />
        <Tab label="Workflow Status" {...a11yProps(3)} />
        <Tab label="Testing Connection" {...a11yProps(4)} />
      </Tabs>
      <TabPanel value={value} index={0}>
        <Dashboard handleSetValue={handleChange}/>
      </TabPanel>
      <TabPanel value={value} index={1}>
        <TradeExecution />
      </TabPanel>
      {/* <TabPanel value={value} index={2}>
        Trade Clearing
      </TabPanel>
      <TabPanel value={value} index={3}>
        Trade Settlement
      </TabPanel> */}
      <TabPanel value={value} index={2}>
        Business Event Query
      </TabPanel>
      <TabPanel value={value} index={3}>
        Workflow Status
      </TabPanel>
      <TabPanel value={value} index={4}>
        <StartHere />
      </TabPanel>
    </Box>
  );
}