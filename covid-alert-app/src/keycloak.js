import Keycloak from 'keycloak-js'

const instance = new Keycloak('./keycloak.json')

const initConfig = {
    onLoad: "login-required"
}
// const getUserId = {
//     userId: instance.tokenParsed.userId
// }

function getUserId() {
    return instance.tokenParsed.userId
}

export const keycloak = {
    instance: instance,
    initConfig: initConfig,
    userId: getUserId
};