import React from "react";
import {Grid} from "@material-ui/core";
import styled from "styled-components";
import {blueDark, blueLight, grey5} from "./Colors";
import PersonRoundedIcon from '@material-ui/icons/PersonRounded';
import Box from "@material-ui/core/Box";
import VerticalSpacer from "./VerticalSpacer";
import Typography from "@material-ui/core/Typography";
import CaButton from "./CaButton";


const StyledGrid = styled(Grid)`
 justify-content:center;
  background: ${blueLight};
  box-shadow: 4px 0px 4px ${grey5};
`;
const StyledBox = styled(Box)`
   justify-content:center;
    text-align:center;
`;
const StyledBox2 = styled(Box)`
      display:grid;
`;
function InfoPart(){
    return(
        <StyledGrid container>
            <Grid item xs={2}>
            </Grid>
            <Grid item xs={8}>
                <StyledBox>
                    <VerticalSpacer spacing={12}/>
                    <PersonRoundedIcon style={{ fontSize: 120 }}/>
                    <h2>Your informations </h2>
                </StyledBox>
                <StyledBox2>
                    <VerticalSpacer spacing={4}/>
                    <Typography variant={'h6'}>Name :</Typography>
                    <VerticalSpacer spacing={4}/>
                    <Typography variant={'h6'}>Email :</Typography>
                    <VerticalSpacer spacing={4}/>
                    <Typography variant={'h6'}>Phone :</Typography>
                    <VerticalSpacer spacing={4}/>
                </StyledBox2>
                <StyledBox>
                    <CaButton color={"blue"} kind={"primary"} >Update Infos</CaButton>
                </StyledBox>
                <VerticalSpacer spacing={"15"}/>
                <StyledBox>
                    <CaButton color={"red"} kind={"primary"} >Disconnect</CaButton>
                </StyledBox>
                <VerticalSpacer spacing={"2"}/>

            </Grid>
            <Grid item xs={2}>

            </Grid>


        </StyledGrid>)
}

export default InfoPart;