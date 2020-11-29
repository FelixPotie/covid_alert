import axios from 'axios'
import { buildOrganizationApiUrl } from './configuration'
import {keycloak} from './../keycloak'


export const postTest = (data) => axios.post(buildOrganizationApiUrl(`tests`), data, {
    headers: {
        'Authorization': `Bearer ${keycloak.instance.token}`
    }
})      
.then((response) => {
    if(response.status === 201) console.log("Test enregistré")
    else console.log(`error code ${response.status}`)
})
.catch((error) => {
    console.log('error : '+error.error)
})