import { useTheme } from '@material-ui/core';
import * as React from 'react';
import styled from 'styled-components';
import PropTypes from 'prop-types';

const StyledDiv = styled.div`
    width: ${(props) => useTheme().spacing(props.spacing) + 'px'};
`;

const HorizontalSpacer = (props) => {
    return <StyledDiv {...props} />;
};

HorizontalSpacer.propTypes = {
    spacing: PropTypes.number.isRequired
};

export default HorizontalSpacer;
