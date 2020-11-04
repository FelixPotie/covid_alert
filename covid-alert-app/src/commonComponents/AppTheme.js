import React from 'react';
import { createMuiTheme } from '@material-ui/core/styles';
import {
    red, blue, blueLight, blueMedium, white, redLight
} from './Colors'

export const appTheme = createMuiTheme({
    palette: {
        primary: { main: blue, light: blueLight },
        secondary: { main: red, light: redLight },
        background: { default: white },
        info: { main: blueMedium },
        warning: { main: red },
        error: { main: red }
    },
    typography: {
        fontFamily: 'MaisonNeue-Book',
        h1: {
            fontWeight: 'bold',
            fontFamily: 'Alegreya',
            fontSize: '96px',
            lineHeight: '104px',
            '@media (max-width:600px)': {
                fontSize: '48px',
                lineHeight: '56px'
            },
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        },
        h2: {
            fontWeight: 'bold',
            fontFamily: '',
            fontSize: '64px',
            lineHeight: '72px',
            '@media (max-width:600px)': {
                fontSize: '40px',
                lineHeight: '44px'
            },
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        },
        h3: {
            fontWeight: 'bold',
            fontFamily: 'Alegreya',
            fontSize: '32px',
            lineHeight: '40px',
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        },
        h4: {
            fontWeight: 'bold',
            fontFamily: 'Alegreya',
            fontSize: '24px',
            lineHeight: '32px',
            '@media (max-width:600px)': {
                fontSize: '22px',
                lineHeight: '28px'
            },
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        },
        subtitle1: {
            fontWeight: 'normal',
            fontFamily: 'MaisonNeue-book',
            fontSize: '24px',
            lineHeight: '32px',
            '@media (max-width:600px)': {
                fontSize: '22px',
                lineHeight: '28px'
            },
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        },
        h5: {
            fontWeight: 'bold',
            fontFamily: 'Alegreya',
            fontSize: '16px',
            lineHeight: '24px',
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        },
        body1: {
            fontWeight: 'normal',
            fontFamily: 'MaisonNeue-Book',
            fontSize: '18px',
            lineHeight: '24px',
            '@media (max-width:600px)': {
                fontSize: '16px',
                lineHeight: '24px'
            },
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        },
        body2: {
            fontWeight: 'normal',
            fontFamily: 'MaisonNeue-Book',
            fontSize: '16px',
            lineHeight: '24px',
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        },
        caption: {
            fontWeight: 'normal',
            fontFamily: 'MaisonNeue-Book',
            fontSize: '12px',
            lineHeight: '20px',
            '&.elipsis': {
                display: '-webkit-box',
                maxWidth: '100%',
                margin: '0 auto',
                '-webkit-line-clamp': '2',
                '-webkit-box-orient': 'vertical',
                overflow: 'hidden',
                textOverflow: 'ellipsis'
            }
        }
    },

});
