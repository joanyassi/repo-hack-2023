import { useState} from 'react';
import { useNavigate, useLocation } from 'react-router-dom';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';

import Users from '../data/user.json'

const LoginForm = () => {
    const [loginData, setLoginData] = useState({
        username: '',
        password: ''
    })
    const location = useLocation()
    const navigate = useNavigate()
    // console.log({ location })
    const [err, setErr] = useState('')

    const { username, password }  = loginData
    const handleChange = e => {
        const { value, name } = e.target
        setLoginData((prevState) => ({
            ...prevState,
            [name]: value
        }))
    }

    const handleSubmit = (e) => {
      e.preventDefault()
      const result = Object.values(Users).filter(user => user.username.toLowerCase() === loginData.username.toLowerCase())
      if (result.length < 1) {
        setErr({username: 'Wrong Username'})
      } else if (result[0].password !== loginData.password){
        setErr({password: 'Wrong Password'})
      } else {
        setErr('')
        navigate(`/dashboard/${username}`)
      }
      console.log({ err })
      console.log('form submitted', Object.values(Users), { result })
    }

  return (
    <Box
      onSubmit={e => handleSubmit(e)}
      component="form"
      sx={{
        '& .MuiTextField-root': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
      // border='2px solid red'
      minHeight='80vh'
      display='flex'
      justifyContent='center'
      alignItems='center'
      flexDirection='column'
    >
      <div>
        <TextField
          error={err?.username?.length > 0}
          id="filled-error-helper-text"
          label="Username"
          value={username}
          name="username"
          onChange={(e) => {handleChange(e)}}
        //   defaultValue="Hello World"
          helperText={err?.username}
          variant="filled"
        />
         <TextField
          error={err?.password?.length > 0}
          id="filled-error-helper-text"
          label="Password"
          value={password}
          name="password"
          onChange={(e) => {handleChange(e)}}
        //   defaultValue="Hello World"
          helperText={err?.password}
          variant="filled"
        />
      </div>
      <Button disabled={password.length === 0 || username.length < 3} type="submit" variant="contained">Login</Button>
    </Box>
  );
}

export default LoginForm;