import axios from 'axios'

const xApiKey = process.env.REACT_APP_X_API_KEY
const xParticipantId = process.env.REACT_APP_X_PARTICIPANT_ID
const URLBase = 'http://localhost:8080/repohack'

export const fetchData = async (headers, url) => {
    try {
           const response = await axios.get(`${URLBase}${url}`, {
               headers
            })
      
      return response.data
    } catch (error) {
      console.log({ error })
    }
}

export const fetchNoHeaders = async (url) => {
    const response = await axios.get(`${URLBase}${url}`)
    return response.data
}

export const postData = async (headers, url, body) => {
    try {
        const response = await axios.post(`${URLBase}${url}`, body, {
           headers
        })
        
        return response
      } catch (error) {
        console.log({ error })
      }
}

export const getStatus = val => {
    switch (val) {
        case 'TRADE_MATCH_SUCCESS':
            return 'SUCCESS'
        case 'TRADE_MATCH_FAILURE':
            return 'FAILED'
        default:
    }
}

export const getTradeStatus = val => {
    switch (val) {
        case 'TRADE_ACCEPTED':
            return 'ACCEPTED'
        case 'TRADE_REJECTED':
            return 'REJECTED'
        default:
    }
}
