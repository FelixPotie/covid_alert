import * as React from 'react';
import { MouseEventHandler } from 'react';
import styled from 'styled-components';
import { Button, useTheme } from '@material-ui/core';
import {
    white,
    blueLight,
    blue,
    blueDark,
    red,
    redLight,
    redDark,
} from "./Colors";



interface CaButtonProps {
    onClick?: MouseEventHandler;
    color?:String;
    kind?: String;

}

const StyledButton = styled(
    ({
         forwardRef,
         hasFocusBorder,
         hoverBackgroundColor,
         hoverBorderColor,
         neutralBackgroundColor,
         neutralBorderColor,
         textColor,
         ...otherProps
     }) => <Button ref={forwardRef} {...otherProps} />
)`

    background-color: ${(props) => props.neutralBackgroundColor};
    border-radius: ${() => useTheme().spacing(1) + 'px'};
    border: 1px solid ${(props) => props.neutralBorderColor};
    box-shadow: none;
    color: ${(props) => props.textColor};
    font-size: 16px;
    text-transform: none;

    :hover,
    &.hover {
        background-color: ${(props) => props.hoverBackgroundColor};
        border: 1px solid ${(props) => props.hoverBorderColor};
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.15);
    }

   

    padding: ${() => useTheme().spacing(0.5) + 'px'} ${() => useTheme().spacing(2) + 'px'};



   
`;


const CaButton: React.FunctionComponent<CaButtonProps> = React.forwardRef((props, ref) => {
    let hasFocusBorder = true;
    let hoverBackgroundColor = '';
    let hoverBorderColor = '';
    let neutralBackgroundColor = '';
    let neutralBorderColor = '';
    let textColor = '';

    const kind = props.kind? props.kind  :"primary" ;

    switch (kind) {
        case "primary": {
            const color = props.color ? props.color : "blue";

            switch (color) {
                case "blue": {
                    neutralBackgroundColor = white;
                    neutralBorderColor = blue;
                    hoverBackgroundColor = blueLight;
                    hoverBorderColor = blue;
                    textColor = blueDark;
                    break;
                }
                case "red": {
                    neutralBackgroundColor = white;
                    neutralBorderColor = red;
                    hoverBackgroundColor = redLight;
                    hoverBorderColor = red;
                    textColor = red;
                    break;
                }

            }

            break;
        }
        case "secondary": {
            const color = props.color ?props.color : "blue";

            switch (color) {
                case "blue": {
                    neutralBackgroundColor = blue;
                    neutralBorderColor = blue;
                    hoverBackgroundColor = blueDark;
                    hoverBorderColor = blueDark;
                    textColor = white;
                    break;
                }
                case "red": {
                    neutralBackgroundColor = redDark;
                    neutralBorderColor = redDark;
                    hoverBackgroundColor = red;
                    hoverBorderColor = red;
                    textColor = white;
                    break;
                }

            }

            break;
        }

    }

    return (
        <StyledButton
            forwardRef={ref}
            variant="contained"
            onClick={props.onClick}
            hasFocusBorder={hasFocusBorder}
            hoverBackgroundColor={hoverBackgroundColor}
            hoverBorderColor={hoverBorderColor}
            neutralBackgroundColor={neutralBackgroundColor}
            neutralBorderColor={neutralBorderColor}
            textColor={textColor}>
            {props.children ?props.children: ''}
        </StyledButton>


    );
});

export default CaButton;
