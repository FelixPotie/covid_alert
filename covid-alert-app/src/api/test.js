import axios from 'axios'
import { buildOrganizationApiUrl } from './configuration'
import keycloak from './keycloak'

export const postTest = (data) => axios.post(buildOrganizationApiUrl('test'), {
    headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${keycloak.instance.token}`
    },
    data
})      
.then((response) => {
    console.log("test enregistré")
})
.catch((error) => {
    console.log('error : '+error.error)
})