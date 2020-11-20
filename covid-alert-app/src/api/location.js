import axios from 'axios'
import { buildOrganizationApiUrl } from './configuration'
import keycloak from './keycloak'


export const postLocation = (data) => axios.post(buildOrganizationApiUrl('location'), {
    headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${keycloak.instance.token}`
    },
    data
})      
.then((response) => {
    console.log("localisation enregistré")
})
.catch((error) => {
    console.log('error : '+error.error)
})