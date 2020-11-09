import React from "react";
import InfoPart from "../commonComponents/InfoPart";
import {Grid} from "@material-ui/core";
import styled from "styled-components";
import Box from "@material-ui/core/Box";
import { grey5, white} from "../commonComponents/Colors";
import Typography from "@material-ui/core/Typography";
import CaButton from "../commonComponents/CaButton";
import VerticalSpacer from "../commonComponents/VerticalSpacer";
import {useHistory} from "react-router-dom";

const StyledGrid = styled(Grid)`
 justify-content:center;
 text-align:center;
`;

const StyledBox= styled(Box)`
border: 1px solid ${grey5};
box-sizing: border-box;
border-radius: 8px;
background-color:${white};
justify-content:center;
padding:1em;
`;

const BoxList= styled(Box)`
display:flex;
`;


const StyledList= styled.ul`
margin-block-start: 0em;
margin-block-end: 0em;

`;


function Home(){
    let history=useHistory();
    function goToLocation() {
        //add login verification etc...
        history.push('/location')
    }

    function goToTest() {
        //add login verification etc...
        history.push('/test')
    }
    return(
        <Grid container>
            <Grid item xs={4}>
                <InfoPart/>
            </Grid>
            <StyledGrid container item xs={8}>
                <Grid item xs={12}>
                    <h1>Covid Alert</h1>
                </Grid>
                <Grid item xs={8}>
                    <StyledBox>
                        <CaButton color={"red"} kind={"secondary"} margin={"0px 20px 0px 20px"} onClick={()=>goToLocation()} >Activate Location</CaButton>
                        <CaButton color={"blue"} kind={"secondary"} margin={"0px 20px 0px 20px"} onClick={()=>goToTest()}>Add a positive test</CaButton>
                    </StyledBox>
                    <VerticalSpacer spacing={8}/>
                    <StyledBox display="flex">
                        <Typography variant={'h6'}>Your dates of risky contact : </Typography>
                        <BoxList>
                            <StyledList >
                                <li>23/09/2020</li>
                                <li>23/09/2020</li>
                            </StyledList>
                        </BoxList>
                    </StyledBox>
                    <VerticalSpacer spacing={8}/>
                    <StyledBox display="flex">
                        <Typography variant={'h6'}>Your positive tests: </Typography>
                        <BoxList>
                            <StyledList >
                                <li>23/09/2020</li>
                                <li>23/09/2020</li>
                            </StyledList>
                        </BoxList>
                    </StyledBox>
                </Grid>
            </StyledGrid>

        </Grid>


)
}

export default Home;