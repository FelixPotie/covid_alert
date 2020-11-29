import axios from 'axios'
import { buildOrganizationApiUrl } from './configuration'
import {keycloak} from './../keycloak'


export const postLocation = (data) => axios.post(buildOrganizationApiUrl(`location`),
data, {
    headers: {
        'Authorization': `Bearer ${keycloak.instance.token}`
    }
})      
.then((response) => {
    console.log(response)
})
.catch((error) => {
    console.log(`error : ${error}`)
})