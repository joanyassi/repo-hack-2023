import { useParams } from 'react-router-dom'
import { useState, useEffect } from 'react';
import { Box, Container } from "@mui/material"
import { Formik, Form, Field, ErrorMessage } from 'formik';
import Button from '@mui/material/Button';
import Users from '../../data/user.json'

const fieldStyle = {
  padding: '.5rem'
}
const TradeExecution = () => {
  const [userDetails, setUserDetails] = useState({})

  const {id} = useParams()
  useEffect(() => {
    const result = Object.values(Users).filter(user => user.username.toLowerCase() === id.toLowerCase())[0]
    setUserDetails(result)
    console.log({ result })
  }, [])

  console.log({ userDetails })
    return (
        <Box>
 <Formik
       initialValues={{ email: '', password: '' }}
       validate={values => {
         const errors = {};
         if (!values.email) {
           errors.email = 'Required';
         } else if (
           !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
         ) {
           errors.email = 'Invalid email address';
         }
         return errors;
       }}
       onSubmit={(values, { setSubmitting }) => {
         setTimeout(() => {
           alert(JSON.stringify(values, null, 2));
           setSubmitting(false);
         }, 400);
       }}
     >
       {({ isSubmitting }) => (
         <Form>
         <Container
          sx={{ display: 'flex', justifyContent: 'space-between', padding: '1rem 0'}}
         >
            <Box>
              <h4>Seller Details</h4>
              <div
                style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-start'}}
              >
                <label htmlFor="firstName" style={fieldStyle}>Name</label>
                <Field id="firstName" name="firstName" placeholder="DEALER01" style={fieldStyle}/>
                <ErrorMessage name="email" component="div" />
              </div>
              <div
                style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-start'}}
              >
                <label htmlFor="firstName" style={fieldStyle}>Lei</label>
                <Field id="firstName" name="firstName" placeholder="DEALER01-LEI01" style={fieldStyle}/>
                <ErrorMessage name="email" component="div" />
              </div>
              <div
                style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-start'}}
              >
                <label htmlFor="firstName" style={fieldStyle}>Account</label>
                <Field id="firstName" name="firstName" placeholder="DEALER01-ACCOUNT01" style={fieldStyle}/>
                <ErrorMessage name="email" component="div" />
              </div>
            </Box>
            <Box>
            <h4>Buyer Details</h4>
              <div
                style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-start'}}
              >
                <label htmlFor="firstName" style={fieldStyle}>Name</label>
                <Field id="firstName" name="firstName" placeholder="DEALER01" style={fieldStyle}/>
                <ErrorMessage name="email" component="div" />
              </div>
              <div
                style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-start'}}
              >
                <label htmlFor="firstName" style={fieldStyle}>Lei</label>
                <Field id="firstName" name="firstName" placeholder="DEALER01-LEI01" style={fieldStyle}/>
                <ErrorMessage name="email" component="div" />
              </div>
              <div
                style={{ display: 'flex', flexDirection: 'column', alignItems: 'flex-start'}}
              >
                <label htmlFor="firstName" style={fieldStyle}>Account</label>
                <Field id="firstName" name="firstName" placeholder="DEALER01-ACCOUNT01" style={fieldStyle}/>
                <ErrorMessage name="email" component="div" />
              </div>
            </Box>
         </Container>
         <Container>
            <Box>
              <Field type="password" name="password" />
              <ErrorMessage name="password" component="div" />
            </Box>
         </Container>

           {/* <button type="submit" disabled={isSubmitting}>
             Submit
           </button> */}
           <Button disabled={isSubmitting} type="submit" variant="contained">Submit</Button>
         </Form>
       )}
     </Formik>
        </Box>
    )
}

export default TradeExecution;