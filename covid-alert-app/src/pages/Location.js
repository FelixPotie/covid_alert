import React, {useState} from "react";
import {Grid} from "@material-ui/core";
import InfoPart from "../commonComponents/InfoPart";
import VerticalSpacer from "../commonComponents/VerticalSpacer";
import Typography from "@material-ui/core/Typography";
import styled from "styled-components";
import CaSwitch from "../commonComponents/CaSwitch";
import Box from "@material-ui/core/Box";
import { blue,red} from "../commonComponents/Colors";
import HomeOutlinedIcon from '@material-ui/icons/HomeOutlined';
import {useHistory} from "react-router-dom";

const StyledGrid = styled(Grid)`
 justify-content:center;
 text-align:center;
`;

const StyledBox= styled(Box)`
justify-content:center;
display:flex;
`;

const StyledBox2= styled(Box)`
justify-content:center;
display:inline-grid;
`;

const HomeBox= styled(Box)`
display:table-caption;
padding:10px
`;

const TrueTypo= styled(Typography)`
padding-left:32px;
font-weight: bold;
color:${blue};
`;
const FalseTypo= styled(Typography)`
padding-left:32px;
font-weight: bold;
color:${red};
`;



function Location(){
    let history=useHistory();
    const [locationActivate, setLocationActivate] = useState(true);

    function onToggle() {
        setLocationActivate(!locationActivate);
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

                    <h1>Location</h1>
                    <VerticalSpacer spacing={8}/>
                    <StyledBox>
                        <CaSwitch checked={locationActivate} onToggle={()=>onToggle()}/>
                        {locationActivate?(<TrueTypo variant={'h6'}>Location ENABLED </TrueTypo>) :(<FalseTypo variant={'h6'}>Location DISABLED </FalseTypo>) }
                    </StyledBox>
                    <VerticalSpacer spacing={3}/>
                    <StyledBox2 >
                        <Typography variant={"body1"}>
                            <b>Since :</b> 5min54sec
                        </Typography>
                        <Typography variant={"body1"}>
                            <b>Current location :</b> 43.6260828,3.863519
                        </Typography>
                    </StyledBox2>



                </Grid>
            </StyledGrid>
        </Grid>
    )
}

export default Location;