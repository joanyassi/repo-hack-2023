import { Container, Box } from '@mui/material';
import { useLocation,useParams } from 'react-router-dom'

const Dashboard = () => {
    const location = useLocation();
    const {id} = useParams();
    console.log({ id })
    return (
        <Container
        >
         <Box
    //   onSubmit={e => handleSubmit(e)}
    //   component="form"
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

        {`Welcome to ${id.toUpperCase()} Dashboard`}
    </Box>
        
        </Container>
    )
}

export default Dashboard;