import React from "react";
import { Switch, useTheme } from '@material-ui/core';
import styled from 'styled-components';
import {white,blue,red} from "./Colors";


const StyledSwitch = styled(Switch)`
    width: 52px;
    height: 32px;
    padding: 0;
    display: flex;
    & > .MuiSwitch-track {
        border-radius: ${() => useTheme().spacing(2) + 'px'};
        border: 1px solid ${red};
        background-color: ${red};
        opacity: 1;
        width: 100%;
        height: 30px;
    }

    & > .Mui-checked + .MuiSwitch-track {
        background-color: ${blue};
        border: 1px solid ${blue};
        opacity: 1;
    }

    & > .MuiSwitch-switchBase {
        top: 3px;
        left: 3px;
        position: absolute;
        padding: 0;
        & > .MuiIconButton-label > .MuiSwitch-thumb {
            background-color: ${white};
            box-shadow: none;
            height: 26px;
            width: 26px;
        }
    }
`;

const CaSwitch = (props: CaSwitchProps) => {
    return (<StyledSwitch checked={props.checked} onChange={props.onToggle}></StyledSwitch>)
};

interface CaSwitchProps {
    checked: boolean;
    onToggle: () => void;
}

export default CaSwitch;