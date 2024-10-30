import React from 'react';
import Header from '../components/commons/Header';
import Footer from '../components/commons/Footer';
import Login from '../components/login/Login';
import { Link, useNavigate } from 'react-router-dom';

//페이지는 컴포넌트들의 결합이다.
//React에서는 컴포넌트 설계가 중요하다.
    //App.js에 바로 조합할수도 Page를 사용할 수 도 있다.


//비동기 통신으로 서버에서 로그인된 모든 정보를 받아왔다고 치자
const users=[
    {id : "kosta", pwd : "1234", name :"홍종각"},
    {id : "spring", pwd : "qwer", name :"김종각"},
    {id : "admin", pwd : "admin", name :"관리자"},
]

const LoginPage = (props) => {

    const navigate= useNavigate();// 페이지를 이동하는 기능
    const goBack = ()=>{
        navigate(-1); // 현재 페이지에서 이전 페이지로 간다.
    }

    const goHome = ()=>{
        navigate("/");
    }

    return (
        <div>
            <Header id ="Header입니다."/>
            <h3>Login Members</h3>
            <ul style ={ {'text-align' : "center" , "color" : "blue" , 'font-size' : "1.4em", 'list-style' : 'none'} }>
                {
                    users.map(user => (
                        <li>
                            {/* 주소창 뒤에 값이 아닌 객체 전달 방법 */}
                            {/* <Link to={`/login/${user.id}`} state={{ user }}>{user.name}</Link> */}
                            {/* <Link to ={`/login/${user.id}`}>{user.name}</Link> */}

                            {/* navigate 호출 */}
                            <span onClick={ ()=>{ navigate( `/login/${user.id}`,{state : {user}} ) } }>{user.name}</span>
                        </li>
                    ))
                }

            </ul>
            {/* <Login id ="kosta" pwd ="1234"  /> */}
            
            <div>
                <button onClick={goBack}>Back</button>
                <button onClick={goHome}>Home</button>

            </div>
            
            <Footer />

        </div>
    );
};

export default LoginPage;