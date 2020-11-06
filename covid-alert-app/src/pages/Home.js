import React from "react";
import InfoPart from "../commonComponents/InfoPart";
import {Grid} from "@material-ui/core";
import styled from "styled-components";
import Box from "@material-ui/core/Box";
import {blueLight, grey5} from "../commonComponents/Colors";

const StyledGrid = styled(Grid)`
 justify-content:center;
 text-align:center;
`;

function Home(){
    return(
        <Grid container>
            <Grid item xs={4}>
                <InfoPart/>
            </Grid>
            <Grid item xs={8}>
                <StyledGrid item xs={12}>
                    <h1>Covid Alert</h1>
                </StyledGrid>
            </Grid>
        </Grid>


)
}

export default Home;