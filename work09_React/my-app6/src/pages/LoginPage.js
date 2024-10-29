import React from 'react';
import Header from '../components/commons/Header';
import Footer from '../components/commons/Footer';
import Login from '../components/login/Login';

//페이지는 컴포넌트들의 결합이다.
//React에서는 컴포넌트 설계가 중요하다.
    //App.js에 바로 조합할수도 Page를 사용할 수 도 있다.
const LoginPage = (props) => {
    return (
        <div>
            <Header id ="Header입니다."/>
            <Login id ="kosta" pwd ="1234"  />
            <Footer />
        </div>
    );
};

export default LoginPage;