import {useState} from 'react';
import { useNavigate } from 'react-router-dom';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBIcon,
  MDBRow,
  MDBCol,
  MDBCheckbox
}
from 'mdb-react-ui-kit';
import TextField from '@mui/material/TextField';
import Logo from '../assets/CAPMF.png'

import Users from '../data/user.json'


function App() {
    const [loginData, setLoginData] = useState({
        username: '',
        password: ''
    })
    const navigate = useNavigate()
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
      }
  return (
    <MDBContainer fluid>

      <MDBRow className='g-0 align-items-center'>
        <MDBCol col='6'>

          <MDBCard className='my-5 cascading-right' style={{background: 'hsla(0, 0%, 100%, 0.55)',  backdropFilter: 'blur(30px)'}}>
            <MDBCardBody className='p-5 shadow-5 text-center'>

              {/* <h2 className="fw-bold mb-5">Sign in now</h2> */}
              <div style={{height: '3rem', width: "13rem", alignSelf: 'center', margin: "2rem auto"}}>
                  <img src={Logo} alt="" style={{height: '100%'}}/>
                </div>

              <MDBInput wrapperClass='mb-4' name="username" onChange={e => handleChange(e)} label='Username' id='form3' type='text' value={loginData.username}/>
              <MDBInput wrapperClass='mb-4' name="password" onChange={e => handleChange(e)} label='Password' id='form4' type='password' value={loginData.password}/>

              <MDBBtn className='w-50 mb-4' onClick={handleSubmit} size='md'>sign in</MDBBtn>

              <div className="text-center">

                <p>or sign in with:</p>

                <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                  <MDBIcon fab icon='facebook-f' size="sm"/>
                </MDBBtn>

                <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                  <MDBIcon fab icon='twitter' size="sm"/>
                </MDBBtn>

                <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                  <MDBIcon fab icon='google' size="sm"/>
                </MDBBtn>

                <MDBBtn tag='a' color='none' className='mx-3' style={{ color: '#1266f1' }}>
                  <MDBIcon fab icon='github' size="sm"/>
                </MDBBtn>
                

              </div>

            </MDBCardBody>
          </MDBCard>
        </MDBCol>

        <MDBCol col='6'>
          <img src="https://images.pexels.com/photos/3610042/pexels-photo-3610042.jpeg?auto=compress&cs=tinysrgb&w=600" class="w-100 rounded-4 shadow-4"
            alt="" fluid/>
        </MDBCol>

      </MDBRow>

    </MDBContainer>
  );
}

export default App;