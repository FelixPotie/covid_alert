import './App.css';
import React  from 'react';
import Home from "./pages/Home";
import {BrowserRouter as Router, Route,Switch} from "react-router-dom";
import Registration from "./pages/Registration";
import Page404 from "./pages/Page404";
import Test from "./pages/Test";
import Location from "./pages/Location";
import { useKeycloak } from '@react-keycloak/web';

function App() {
    const {keycloak} = useKeycloak();
    if (!keycloak.authenticated) {
        return <div>loading</div>;
    }
    return (

        <Router>
            <Switch>
                <Route path="/" exact component={Location}/>
                <Route path="/home"  component={Home}/>
                <Route path="/registration"  component={Registration}/>
                <Route path="/location"  component={Location}/>
                <Route path="/test"  component={Test}/>
                <Route path="/"  component={Page404}/>
            </Switch>

        </Router>
    );
}

export default App;
