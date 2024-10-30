import React from 'react';
import styled from 'styled-components';

const StyledHeader = styled.div`
    border: 1px solid black;
    width: 800px;
    margin-left: 400px;
    padding-top: 20px;
    margin-top: 50px;

    //10/29
    //height: 50px;
    //display: flex;
    //justify-content: space-around;
    //list-style: none;

`

const Header = (props) => {
    return (
        <div>
            {/* <h3>{props.id}</h3> */}
            <StyledHeader>
                {/* 10/29 */}
                {/* <li>HOME</li>
                <li>Sign UP</li>
                <li>Sign IN</li> */}

                {/* 10/30 */}
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book</p>

            </StyledHeader>
        </div>
    );
};

export default Header;