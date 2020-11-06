import './App.css';
import React  from 'react';
import Login from './pages/Login'
import Home from "./pages/Home";
import {BrowserRouter as Router, Route,Switch} from "react-router-dom";
import Registration from "./pages/Registration";
import Page404 from "./pages/Page404";

function App() {

    return (

        <Router>
            <Switch>
                <Route path="/" exact component={Login}/>
                <Route path="/home"  component={Home}/>
                <Route path="/registration"  component={Registration}/>
                <Route path="/"  component={Page404}/>
            </Switch>

        </Router>
    );
}

export default App;
