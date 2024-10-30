import React from 'react';
import styled from 'styled-components';

const StyledFooter = styled.div`
    border: 1px solid black;
    height: 100px;
    width: 800px;
    margin-left: 400px;
    list-style: none;
    padding-top : 40px;
    margin-top: 30px;

`

const Footer = () => {
    return (
        <div>
            <StyledFooter>
                <li>오시는 길 : 서울 종로구 대왕빌딩 7층</li>
                <li>전화번호 : 02-111-5555</li>
            </StyledFooter>
            
        </div>
    );
};

export default Footer;