import * as React from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import StartHere from '../components/start-here'

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
      sx={{display: 'flex', height: "auto", border: '1px solid #0474ac' }}
    >
      <Tabs
        orientation="vertical"
        value={value}
        onChange={handleChange}
        aria-label="Vertical tabs example"
        sx={{ borderRight: 1, borderColor: 'divider', minWidth: '200px', }}
        textColor="primary"
        indicatorColor="secondary"
      >
        <Tab label="Dashboard" {...a11yProps(0)}/>
        <Tab label="Trade Execution" {...a11yProps(1)} />
        <Tab label="Trade Clearing" {...a11yProps(2)} />
        <Tab label="Trade Settlement" {...a11yProps(3)} />
        <Tab label="Business Event Query" {...a11yProps(4)} />
        <Tab label="Workflow Status" {...a11yProps(5)} />
        <Tab label="Testing Connection" {...a11yProps(6)} />
      </Tabs>
      <TabPanel value={value} index={0}>
        <p>List of trades involving the current user + actions available</p>
        <p>If API allows it then potential history of trades</p>
      </TabPanel>
      <TabPanel value={value} index={1}>
        Trade Execution
      </TabPanel>
      <TabPanel value={value} index={2}>
        Trade Clearing
      </TabPanel>
      <TabPanel value={value} index={3}>
        Trade Settlement
      </TabPanel>
      <TabPanel value={value} index={4}>
        Business Event Query
      </TabPanel>
      <TabPanel value={value} index={5}>
        Workflow Status
      </TabPanel>
      <TabPanel value={value} index={6}>
        <StartHere />
      </TabPanel>
    </Box>
  );
}