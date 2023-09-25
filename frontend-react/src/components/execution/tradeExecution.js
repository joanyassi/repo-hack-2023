import { useParams } from 'react-router-dom'
import { useState, useEffect } from 'react';
import { Box, Container } from "@mui/material"
import { Formik, Form, Field, ErrorMessage } from 'formik';
import Button from '@mui/material/Button';
import Users from '../../data/user.json'

const fieldStyle = {
  padding: '.5rem'
}

const labelStyeled = {
  paddingBottom: 0,
  fontStyle: 'italic',
  fontWeight: 'bold',
  fontSize: '.9rem'
}

const divStyled = {
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'flex-start',
  width: '30%',
  // border: '2px solid'
}

const TradeExecution = () => {
  const [userDetails, setUserDetails] = useState({})
  const [userRole, setUserRole] = useState('seller')

  const {id} = useParams()
  useEffect(() => {
    const result = Object.values(Users).filter(user => user.username.toLowerCase() === id.toLowerCase())[0]
    setUserDetails(result)
    console.log({ result })
  }, [])

  console.log({ userDetails })

  const getInitialValues = (userDetails) => {
    return {
      buyer_name: userRole === 'buyer' ? userDetails.username : '',
      buyer_lei: userRole === 'buyer' ? userDetails.buyer_lei : '',
      buyer_account: userRole === 'buyer' ? userDetails.buyer_account : '',
      seller_name: userRole === 'seller' ? userDetails.username : '',
      seller_lei: userRole === 'seller' ? userDetails.buyer_lei : '',
      seller_account: userRole === 'seller' ? userDetails.buyer_account : '',
      trade_date: '',
      effective_date: '',
      maturity_date: '',
      repo_rate: '',
      rate_daycount_convention: '',
      collateral_id: '',
      collateral_notional: '',
      collateral_dirty_price: '',
      collateral_haircut: '',
      trade_ccy: '',
      cash_amount: '',
      termination_cash_amount: ''
     }
  }

  const handleSubmit = ({
    buyer_name,
    buyer_lei,
    buyer_account,
    seller_name,
    seller_lei,
    seller_account,
    trade_date,
    effective_date,
    maturity_date,
    repo_rate,
    rate_daycount_convention,
    collateral_id,
    collateral_notional,
    collateral_dirty_price,
    collateral_haircut,
    trade_ccy,
    cash_amount,
    termination_cash_amount
   }, { setSubmitting }) => {
    const fomrValues = {
      buyer: {
        buyer_name,
        buyer_lei,
        buyer_account
      },
      seller: {
        seller_name,
        seller_lei,
        seller_account,
      },
      tradeDetails: {
        trade_date,
        effective_date,
        maturity_date,
        repo_rate,
        rate_daycount_convention,
        collateral_id,
        collateral_notional,
        collateral_dirty_price,
        collateral_haircut,
        trade_ccy,
        cash_amount,
        termination_cash_amount
      }
    }
     console.log({ fomrValues })
       setSubmitting(false);
  }
    return (
        <Box>
 <Formik
        enableReinitialize="true"
       initialValues={getInitialValues(userDetails)}
       validate={values => {
        
        //  const errors = {};
        //  if (!values.email) {
        //    errors.email = 'Required';
        //  } else if (
        //    !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
        //  ) {
        //    errors.email = 'Invalid email address';
        //  }
        //  return errors;
       }}
       onSubmit={(values, setSubmitting) => handleSubmit(values, setSubmitting)}
     >
       {(props) => {
        console.log({props})
        return (
         <Form
         style={{ width: '70%', margin: 'auto'}}
         >
         <h1>{`New ${userRole === 'seller' ? 'Sell' : 'Buy'} Trade`}</h1>
         <div>

         </div>
         <Container
          sx={{ display: 'flex', justifyContent: 'space-between', padding: '1rem 0'}}
         >
            <Box
              sx={{ width: '40%'}}
            >
         <Button style={{margin: '1rem 0', background: 'red'}} disabled={props.isSubmitting} onClick={(()=> setUserRole('seller'))} variant="contained">Sell</Button>

              <h4>Seller Details</h4>
              <div
                style={{...divStyled, width: '100%'}}
              >
                <label htmlFor="seller_name" style={{...labelStyeled, paddingTop: '1rem'}}>Name</label>
                <Field 
                  id="seller_name" 
                  name="seller_name"
                  placeholder="DEALER01"
                  style={{...fieldStyle, width: '90%'}}
                  defaultValue='LexyKing'
                  />
                <ErrorMessage name="seller_name" component="div" />
              </div>
              <div
                style={{...divStyled, width: '100%'}}
              >
                <label htmlFor="seller_lei" style={{...labelStyeled, paddingTop: '1rem'}}>Lei</label>
                <Field id="seller_lei" name="seller_lei" placeholder="DEALER01-LEI01" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="seller_lei" component="div" />
              </div>
              <div
                style={{...divStyled, width: '100%'}}
              >
                <label htmlFor="seller_account" style={{...labelStyeled, paddingTop: '1rem'}}>Account</label>
                <Field id="seller_account" name="seller_account" placeholder="DEALER01-ACCOUNT01" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="seller_account" component="div" />
              </div>
            </Box>
            <Box
              sx={{ width: '40%'}}
            
            >
         <Button style={{margin: '1rem 0', background: 'green'}} disabled={props.isSubmitting} onClick={(()=> setUserRole('buyer'))} variant="contained">Buy</Button>

            <h4>Buyer Details</h4>
              <div
                style={{...divStyled, width: '100%'}}
              >
                <label htmlFor="buyer_name" style={{...labelStyeled, paddingTop: '1rem'}}>Name</label>
                <Field id="buyer_name" name="buyer_name" placeholder="DEALER01" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="buyer_name" component="div" />
              </div>
              <div
                style={{...divStyled, width: '100%'}}
              >
                <label htmlFor="buyer_lei" style={{...labelStyeled, paddingTop: '1rem'}}>Lei</label>
                <Field id="buyer_lei" name="buyer_lei" placeholder="DEALER01-LEI01" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="buyer_lei" component="div" />
              </div>
              <div
                style={{...divStyled, width: '100%'}}
              >
                <label htmlFor="buyer_account" style={{...labelStyeled, paddingTop: '1rem'}}>Account</label>
                <Field id="buyer_account" name="buyer_account" placeholder="DEALER01-ACCOUNT01" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="buyer_account" component="div" />
              </div>
            </Box>
         </Container>
         <div 
          style={{width: '60%', borderTop: '.5px solid #0474ac', margin: '1rem auto'}}
         />
         <Container>
            <Box>
            <h4>Trade Details</h4>
              <div
                style={{ display: 'flex', justifyContent: 'space-between'}}
              >
                <div
                  style={divStyled}
                >
                  <label htmlFor="trade_date" style={labelStyeled}>Trade Date</label>
                  <Field id="trade_date" name="trade_date" placeholder="2023-09-20" style={{...fieldStyle, width: '90%'}} type="date" min="2018-01-01"/>
                  <ErrorMessage name="trade_date" component="div" />
                </div>
                <div
                  style={divStyled}
                >
                  <label htmlFor="effective_date" style={labelStyeled}>Effective Date</label>
                  <Field id="effective_date" name="effective_date" placeholder="2023-09-20" style={{...fieldStyle, width: '90%'}} type="date"/>
                  <ErrorMessage name="effective_date" component="div" />
                </div>
                <div
                  style={divStyled}
                >
                  <label htmlFor="maturity_date" style={labelStyeled}>Maturity Date</label>
                  <Field id="maturity_date" name="maturity_date" placeholder="2023-09-20" style={{...fieldStyle, width: '90%'}} type="date"/>
                  <ErrorMessage name="maturity_date" component="div" />
                </div>
              </div>
              <div
               style={{ display: 'flex', flexWrap: 'wrap', columnGap: '2.6rem', rowGap: '2rem', paddingTop: '2rem'}}
              >
              <div
                style={{...divStyled}}
              >
                <label htmlFor="repo_rate" style={labelStyeled}>Repo Rate</label>
                <Field id="repo_rate" name="repo_rate" placeholder="0.05" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="repo_rate" component="div" />
              </div>
              <div
                style={divStyled}
              >
                <label htmlFor="rate_daycount_convention" style={labelStyeled}>Rate Daycount convention</label>
                <Field id="rate_daycount_convention" name="rate_daycount_convention" placeholder="ACT_360" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="rate_daycount_convention" component="div" />
              </div>
              <div
                style={divStyled}
              >
                <label htmlFor="collateral_id" style={labelStyeled}>Collateral Id</label>
                <Field id="collateral_id" name="collateral_id" placeholder="GBX3U42BMJ1" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="collateral_id" component="div" />
              </div>
              <div
                style={divStyled}
              >
                <label htmlFor="collateral_notional" style={labelStyeled}>Collateral Notional</label>
                <Field id="collateral_notional" name="collateral_notional" placeholder="7000000" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="collateral_notional" component="div" />
              </div>
              <div
                style={divStyled}
              >
                <label htmlFor="collateral_dirty_price" style={labelStyeled}>Collateral Dirty Price</label>
                <Field id="collateral_dirty_price" type="number" name="collateral_dirty_price" placeholder="93.9" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="collateral_dirty_price" component="div" />
              </div>
              <div
                style={divStyled}
              >
                <label htmlFor="collateral_haircut" style={labelStyeled}>Collateral Haircut</label>
                <Field id="collateral_haircut" type="number" name="collateral_haircut" placeholder="0.02" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="collateral_haircut" component="div" />
              </div>
              <div
                style={divStyled}
              >
                <label htmlFor="trade_ccy" style={labelStyeled}>Trade Currency</label>
                <Field id="trade_ccy" name="trade_ccy" placeholder="GBP" style={{...fieldStyle, width: '90%'}}/>
                <ErrorMessage name="trade_ccy" component="div" />
              </div>
              <div
                style={divStyled}
              >
                <label htmlFor="cash_amount" style={labelStyeled}>Cash Amount</label>
                <Field id="cash_amount" name="cash_amount" placeholder="GBP" style={{...fieldStyle, width: '90%'}} type='number'/>
                <ErrorMessage name="cash_amount" component="div" />
              </div>
              <div
                style={divStyled}
              >
                <label htmlFor="termination_cash_amount" style={labelStyeled}>Termination Cash Amount</label>
                <Field id="termination_cash_amount" name="termination_cash_amount" placeholder="6444187.21" style={{...fieldStyle, width: '90%'}} type='number'/>
                <ErrorMessage name="termination_cash_amount" component="div" />
              </div>
              </div>
            </Box>
         </Container>
           <Button style={{margin: '1rem 0'}} disabled={props.isSubmitting} type="submit" variant="contained">Submit</Button>
         </Form>
        )
       }}
     </Formik>
        </Box>
    )
}

export default TradeExecution;