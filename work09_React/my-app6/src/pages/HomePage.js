import React from 'react';
import Header from '../components/commons/Header';
import Home from '../components/home/Home';
import Footer from '../components/commons/Footer';
import {useEffect, useState} from 'react';

const HomePage = (props) => {

    const [boards, setBoards] = useState([]);    

    useEffect(()=>{
        //1. [비동기 통신] DB에서 데이터 받아오는 비동기 통신이 일어난다.
        // 받았다 치고,

        let datas =[
            {id : 1, title : "첫번째 글", content : "첫번째 내용"},
            {id : 2, title : "두번째 글", content : "두번째 내용"},
            {id : 3, title : "세번째 글", content : "세번째 내용"},
        ]

        setBoards(datas);

    }, []);


    return (
        <div>
            <Header />

            {/*  boards라는이름으로 {boards}를 넘김 */}
            <Home boards={boards} setBoards = {setBoards}/>
            <Footer />
        </div>
    );
};

export default HomePage;