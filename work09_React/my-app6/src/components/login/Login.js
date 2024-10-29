import React from 'react';
import styled from 'styled-components';

const StyledLogin = styled.div`
    color: saddlebrown;
    padding: 30px 0px 30px;
    
`
const Login = (props) => {
    
    return (
        <div>
            <StyledLogin>
                <h1>로그인 페이지 입니다.</h1>
                <h3>ID : {props.id}</h3>
                <h3>PWD : {props.pwd}</h3>
            </StyledLogin>
        </div>
    );
}


export default Login;