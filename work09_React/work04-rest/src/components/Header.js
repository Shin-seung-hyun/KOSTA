import React from 'react';
import {Navbar, Container, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';

const Header = () => {
    return (
        <div>
            {/* <h1>Header.js : header</h1> */}
            <Navbar bg="primary" data-bs-theme="dark">
                <Container>
                    {/* . 을 -로 바꾸고, 전부 소문자로 변경해야 한다. -> className이 */}
                    <Link to = "/" className='navbar-brand'>Home</Link>
                    <Nav className="me-auto">
                        <Link to ="/saveForm" className='nav-link'>글쓰기(SavForm)</Link>
                        <Link to ="/joinForm" className='nav-link'>회원가입(joinForm)</Link>
                        <Link to ="/loginForm" className='nav-link'>로그인(loginForm)</Link>
                    </Nav>
                    
                </Container>
            </Navbar>
        </div>
    );
};

export default Header;