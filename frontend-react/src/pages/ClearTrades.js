import { Container, Box, Button } from '@mui/material';
import { useLocation,useParams } from 'react-router-dom'
import axios from 'axios'

const Dashboard = () => {
    // const {id} = useParams();

    const getData = async () => {
        console.log('get Data')
         const result = await axios.get(`http://localhost:8080/repohack/start-here/public-ping`, {
            headers: {
                'Accept': 'application/json',
            }
         })
        console.log({ result})
    }

    const getDataWithAuth = async () => {
        try {
        const response = await axios.get("http://localhost:8080/repohack/start-here/auth-ping", {
            headers: {
              "Accept": "application/json",
              'x-api-key': 'TEAM014_nbbkjbkjBJKBKBUIGIUYGUYrifiuehrfiuuyfuu4t487t8_014',
             'x-participant-id': 'TEAM014',
            }})
          console.log({ response })
        } catch (error) {
          console.log(error)
        }
        
      }

    const handleClick = () => {
        getData()
    }
    return (
        <Container
        >
         <Box
      sx={{
        '& .MuiTextField-root': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
      minHeight='80vh'
      display='flex'
      justifyContent='center'
      alignItems='center'
      flexDirection='column'
    >

        <div>
         <Button onClick={() => handleClick()} variant="contained">Public Ping</Button>
         <div>
         <Button onClick={() => getDataWithAuth()} variant="contained">Auth Ping</Button>

         </div>
        </div>
    </Box>
        
        </Container>
    )
}

export default Dashboard;