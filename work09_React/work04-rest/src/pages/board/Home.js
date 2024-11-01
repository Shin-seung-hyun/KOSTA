import React, { useEffect, useState } from 'react';
import BoardItem from './BoardItem';
import axios from 'axios';

const Home = (pros) => {
    const [boards, setBoards] = useState([]);

    //이번에는 userEffect 안에 Axios를 써야 한다.
        // Axios는 Hook함수 내에서 쓰던지, 어떤 이벤트 안에 써야한다.
    useEffect(()=>{

        //DB연결 .. Axios가 호출됨
        axios({
            url : "http://localhost:9000/boards",
            method : "get",
        })
        .then((res) =>{ //res.data로 써야 한다. res의 data를 받기
            console.log("res--> ", res);
            console.log("res.data--> ", res.data);

            setBoards(res.data);
        })
        .catch( (err) =>{
            console.log(err);
        })

    },[]);

    return (
        <div>
            <p>Home.js</p>
            <h1>글 목록 보기- BoardList</h1>
            {
                boards.map( (board) => 
                    <BoardItem key={board.id} board ={board} />
                )
            }
        </div>
    );
};

export default Home;