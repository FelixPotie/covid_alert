import axios from 'axios'
import { buildOrganizationApiUrl } from './configuration'
import {keycloak} from './../keycloak'

date = Date()
export const postTest = (date) => axios.post(buildOrganizationApiUrl(`test`), {
    headers: {
        'Authorization': `Bearer ${keycloak.instance.token}`
    }
})      
.then((response) => {
    console.log("test enregistré")
})
.catch((error) => {
    console.log('error : '+error.error)
})