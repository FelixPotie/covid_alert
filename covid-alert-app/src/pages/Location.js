import React, { useState, useEffect } from "react";
import { Grid } from "@material-ui/core";
import InfoPart from "../commonComponents/InfoPart";
import VerticalSpacer from "../commonComponents/VerticalSpacer";
import Typography from "@material-ui/core/Typography";
import styled from "styled-components";
import CaSwitch from "../commonComponents/CaSwitch";
import Box from "@material-ui/core/Box";
import { blue, red } from "../commonComponents/Colors";
import HomeOutlinedIcon from '@material-ui/icons/HomeOutlined';
import { useHistory } from "react-router-dom";
import CaButton from "../commonComponents/CaButton";
import { postLocation } from "./../api/location"
import schedule from "node-schedule"

const StyledGrid = styled(Grid)`
 justify-content:center;
 text-align:center;
`;

const StyledBox = styled(Box)`
justify-content:center;
display:flex;
`;

const StyledBox2 = styled(Box)`
justify-content:center;
display:inline-grid;
`;

const HomeBox = styled(Box)`
display:table-caption;
padding:10px
`;

const TrueTypo = styled(Typography)`
padding-left:32px;
font-weight: bold;
color:${blue};
`;
const FalseTypo = styled(Typography)`
padding-left:32px;
font-weight: bold;
color:${red};
`;

function Location() {
    let history = useHistory();
    const [locationActivate, setLocationActivate] = useState(false);

    useEffect(() => {
        const locationActivation = setInterval(() => locationActivate && sendLocation(), 300 * 1e3)
        return () => clearInterval(locationActivation)
    })

    function onToggle() {
        setLocationActivate(!locationActivate)
        if (!locationActivate) sendLocation()
    }

    function sendLocation() {
        navigator.geolocation.getCurrentPosition(function (position) {
            postLocation({
                timestamp: position.timestamp,
                latitude: position.coords.latitude,
                longitude: position.coords.longitude
            })
        });
    }

    return (
        <Grid container>
            <Grid item xs={4}>
                <InfoPart />
            </Grid>
            <StyledGrid container item xs={8}>
                <Grid item xs={12}>
                    <HomeBox>
                        <HomeOutlinedIcon style={{ fontSize: 50 }} onClick={() => { history.push('/home') }} />
                    </HomeBox>

                    <h1>Location</h1>
                    {/* <div>{count}</div> */}
                    <VerticalSpacer spacing={8} />
                    <StyledBox>
                        <CaSwitch checked={locationActivate} onToggle={() => onToggle()} />
                        {!locationActivate ? (<FalseTypo variant={'h6'}>Location DISABLED </FalseTypo>) : (<TrueTypo variant={'h6'}>Location ENABLED </TrueTypo>)}
                    </StyledBox>
                    <VerticalSpacer spacing={3} />

                </Grid>
            </StyledGrid>
        </Grid>
    )
}

export default Location;
