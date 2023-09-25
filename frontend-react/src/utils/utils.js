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
