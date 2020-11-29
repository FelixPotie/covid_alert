import React  from 'react';
import CaButton from "../commonComponents/CaButton";
import styled from 'styled-components';
import Grid from "@material-ui/core/Grid";
import { blueDark, redDark} from "../commonComponents/Colors";
import VerticalSpacer from "../commonComponents/VerticalSpacer";
import TextField from "@material-ui/core/TextField";
import Box from "@material-ui/core/Box";
import {Link} from "react-router-dom"
import covidAlertLogo from '../public/covidAlertLogo.png'
import {useHistory} from "react-router-dom"

const Title = styled.h1`
  font-size: 50px;
  text-align: center;
  color: ${redDark};
`;
const SubTitle = styled.h2`
  font-size: 40px;
  text-align: center;
  color: ${blueDark};
  margin-top:2px;
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

const StyledLink = styled(Link)`
  font-size: 10px;
  text-decoration: none;
  font-weight: bold;
  text-align: center;
  color: ${blueDark};
`;

const StyledImage = styled.img`
    height:150px
`;

const StyledTextField = styled(TextField)`
& label.Mui-focused {
    color: ${blueDark};
  }
  & .MuiOutlinedInput-root {
    &.Mui-focused fieldset {
      border-color: ${blueDark};
    }
  }
  
`;




function Login() {
    let history=useHistory();

    function login() {
        //add login verification etc...
       history.push('/home')
    }
    return (
        <Grid container >
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
                    <StyledBox>
                        <StyledImage src={covidAlertLogo} alt="Logo" />
                    </StyledBox>
                    <SubTitle>Login</SubTitle>
                    <StyledTextField
                        id="email-input"
                        label="Email"
                        type="email"
                        variant="outlined"
                        fullWidth
                    />
                    <VerticalSpacer spacing={6} />
                    <StyledTextField
                        id="password-input"
                        label="Password"
                        type="password"
                        variant="outlined"
                        fullWidth
                    />
                    <VerticalSpacer spacing={6} />
                    <StyledBox>
                        <CaButton color={"blue"} kind={"primary"} onClick={()=>login()}>Login

                        </CaButton>

                    </StyledBox>
                    <VerticalSpacer spacing={2} />
                    <StyledBox>
                        <Caption>Don’t have an account yet ?<StyledLink to="registration"> Create an account</StyledLink>  </Caption>
                    </StyledBox>

                </Grid>
                <Grid item xs={4}>
                </Grid>

            </Grid>
        </Grid>

    );
}


export default Login;