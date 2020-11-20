import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {keycloak} from './keycloak'
import { ReactKeycloakProvider } from "@react-keycloak/web";

const rootElement = document.getElementById("root");

ReactDOM.render(
  <React.StrictMode>
    <ReactKeycloakProvider authClient={keycloak.instance} initOptions={keycloak.initConfig}>
      <App />
    </ReactKeycloakProvider>
  </React.StrictMode>,
  rootElement
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
