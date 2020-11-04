import { useTheme } from '@material-ui/core';
import * as React from 'react';
import styled from 'styled-components';
import PropTypes from 'prop-types';

const StyledDiv = styled.div`
    height: ${(props) => useTheme().spacing(props.spacing) + 'px'};
    @media (max-width: 960px) {
        height: ${(props) =>
    props.spacingXs ? useTheme().spacing(props.spacingXs) + 'px' : useTheme().spacing(props.spacing) + 'px'};
    }
`;

const VerticalSpacer = (props) => {
    return <StyledDiv {...props} />;
};

VerticalSpacer.propTypes = {
    spacing: PropTypes.number.isRequired,
    spacingXs: PropTypes.number
};

export default VerticalSpacer;