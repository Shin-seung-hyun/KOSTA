import React from 'react';
import styled from 'styled-components';

const StyledHeader = styled.div`
    border: 1px solid black;
    height: 50px;
    display: flex;
    justify-content: space-around;
    width: 800px;
    margin-left: 400px;
    list-style: none;

`

const Header = (props) => {
    return (
        <div>
            <h3>{props.id}</h3>
            <StyledHeader>
                <li>HOME</li>
                <li>Sign UP</li>
                <li>Sign IN</li>
            </StyledHeader>
        </div>
    );
};

export default Header;