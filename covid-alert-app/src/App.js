import './App.css';
import React  from 'react';
import Button from '@material-ui/core/Button';
import { Typography,StylesProvider } from '@material-ui/core';
import styled, {ThemeProvider} from 'styled-components';
import {appTheme} from './commonComponents/AppTheme';
import Grid from "@material-ui/core/Grid";
import {blueDark, redDark} from "./commonComponents/Colors";
import VerticalSpacer from "./commonComponents/VerticalSpacer";
import TextField from "@material-ui/core/TextField";
import Box from "@material-ui/core/Box";

const Title = styled.h1`
  font-size: 50px;
  text-align: center;
  color: ${redDark};
`;
const SubTitle = styled.h2`
  font-size: 40px;
  text-align: center;
  color: ${blueDark};
`;
const StyledBox = styled(Box)`
    display:flex;
    justify-content:center;
`;

const Caption = styled.h2`
  font-size: 10px;
  font-weight: normal;
  text-align: center;
  color: ${blueDark};
`;

const Styleda = styled.a`
  font-size: 10px;
   text-decoration: none;
  font-weight: bold;
  text-align: center;
  color: ${blueDark};
`;


function App() {
    return (<div>
        <ThemeProvider theme={appTheme}>
            <StylesProvider injectFirst>
                <Grid container >
                    <Grid item xs={2}>
                    </Grid>
                    <Grid item xs={8}>
                        <Title>Welcome To CovidAlert</Title>
                    </Grid>
                    <Grid item xs={2}>
                    </Grid>
                </Grid>
                <Grid container>
                    <Grid item xs={4}>
                    </Grid>
                    <Grid item xs={4}>
                        <SubTitle>Login</SubTitle>
                        <VerticalSpacer spacing={6} />
                        <TextField
                            id="email-input"
                            label="Email"
                            type="email"
                            variant="outlined"
                            fullWidth
                        />
                        <VerticalSpacer spacing={6} />
                        <TextField
                            id="password-input"
                            label="Password"
                            type="password"
                            variant="outlined"
                            fullWidth
                        />
                        <VerticalSpacer spacing={6} />
                        <StyledBox>
                            <Button variant="outlined" color="primary">
                                Login
                            </Button>

                        </StyledBox>
                        <VerticalSpacer spacing={2} />
                        <StyledBox>
                            <Caption>Don’t have an account yet ?  <Styleda href="/">Create an account </Styleda> </Caption>
                        </StyledBox>

                    </Grid>
                    <Grid item xs={4}>
                    </Grid>

                </Grid>
            </StylesProvider>
        </ThemeProvider>



</div>
    );
}

export default App;
