import React, {useState} from "react";
import {Grid} from "@material-ui/core";
import InfoPart from "../commonComponents/InfoPart";
import styled from "styled-components";
import HomeOutlinedIcon from "@material-ui/icons/HomeOutlined";
import Box from "@material-ui/core/Box";
import {useHistory} from "react-router-dom";
import Typography from "@material-ui/core/Typography";
import VerticalSpacer from "../commonComponents/VerticalSpacer";
import CaButton from "../commonComponents/CaButton";
import TextField from "@material-ui/core/TextField";
import { postTest } from "../api/test";

const StyledGrid = styled(Grid)`
 justify-content:center;
 text-align:center;
`;
const HomeBox= styled(Box)`
display:table-caption;
padding:10px
`;

const DateBox= styled(Box)`
display:inline-flex;
`;



function Test(){
    let history=useHistory();
    const [date, setDate] = useState("2020-11-27")
    function addTest() {
        postTest({date: date})
        
    }
    return(
        <Grid container>
            <Grid item xs={4}>
                <InfoPart/>
            </Grid>
            <StyledGrid container item xs={8}>
                <Grid item xs={12}>
                    <HomeBox>
                        <HomeOutlinedIcon style={{ fontSize: 50}} onClick={()=>{history.push('/home')}}/>
                    </HomeBox>
                    <h1>Test</h1>
                    <VerticalSpacer spacing={4}/>
                    <Typography variant={"h6"}>
                        Add a test only if the test has been positive.
                    </Typography>

                    <VerticalSpacer spacing={6}/>
                    <DateBox>
                        <Typography variant={"h6"}>
                            Pick the date of the test :
                        </Typography>
                        <form noValidate>
                            <TextField
                                onChange={(event) => {
                                    setDate(event.target.value);
                                }}
                                id="date"
                                type="date"
                                defaultValue= "2020-11-27"
                                InputLabelProps={{
                                    shrink: true,
                                }}
                            />
                        </form>
                    </DateBox>

                    <VerticalSpacer spacing={6}/>

                    <CaButton color={"red"} kind={"primary"} onClick={()=>addTest()} >Add the test</CaButton>
                </Grid>
            </StyledGrid>
        </Grid>
    )
}

export default Test;