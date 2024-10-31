import React, { useState } from 'react';
import Footer from '../components/commons/Footer';
import styled from 'styled-components';

const StyeldList = styled.div`
    border: 3px solid darkgreen;
    width: 600px;
    margin: 0 auto;
    height: 80px;
    padding: 10px;
    display: flex;
    justify-content: space-between;
    align-items: center;

`

const ListPage = () => {

    const handleWrite = (e)=>{
        
        e.preventDefault(); //action에 걸린 페이지로 이동하는 것을 일단 막는다.

        //게시글 생성
        // 전개 연산자 사용됨 spread
        // React는 깊은 복사를 사용해야 한다.

        /*
            ...boards --> 기존 배열의 모든 boards를 복사해서 새로운 배열을 하나 생성한다.
            {...board, id:newid} --> 현재 새롭게 입력된 게시글 board 모든 속성값 (title, content)를 새로운 배열에 추가한다.
            이때 추가되는 객체는 title : board.title, content : board.content, id : newid로 추가된다.
        
        */

        //새로운 아이디 생성
        let newid = boards[boards.length-1].id + 1;

        // 현재 board 싱태 그대로 복사하여 id:0, tiitle : "", content : "" 인 새로운 board 생성
        setBoards([...boards, {...board, id:newid} ]);

    }

    /*
        사용자가 제목 또는 내용을 입력할 때마다 호출되늖 ㅏㅁ수
        ...board  -->  현재의 board를 그대로 복사하는 전개연산자이다.
                        현재의 board는 id : 0,title : "",content : "",이다.
                        이걸 가져와서 새로운 board를 생성한다.
        [e.target.name] : e.target.value} --> 현재 name에 해당하는 폼의 속성값 title, value 값을 가져와서 이 값으로 board를 업데이트 한다.
    */

    const handleForm = (e) =>{
        console.log(e.target.name);
        console.log(e.target.value);

        //!!! 동적으로 키값을 할당하는 방법 !!!
        setBoard( { ...board, [e.target.name] : e.target.value});
    }
    
    const [boards, setBoards] = useState([
        { id : 1, title : "제목1", content : '내용1'},
        { id : 2, title : "제목2", content : '내용2'},
        { id : 3, title : "제목3", content : '내용3'},
        { id : 4, title : "제목4", content : '내용4'},
        { id : 5, title : "제목5", content : '내용5'},
    
    ]);

    const [board, setBoard] = useState( {
        id : 0,
        title : "",
        content : "",
    });


    return (
        <div>
            <h1 >List Page ...</h1>
            <form onSubmit={handleWrite}>
                <input type='text' placeholder='제목 입력..' 
                  onChange={handleForm} value={board.title} name ="title"
                />
                <input type='text' placeholder='글 내용 입력..' 
                  onChange={handleForm} value={board.content} name = "content"
                />                

                <button type='submit'>글쓰기</button>
            </form>

            <p></p>
            <hr />
            <p></p>

            {
                boards.map( (board) => 
                
                <StyeldList>
                    <div>
                        ID : {board.id} &nbsp;&nbsp;
                        Title : {board.title} &nbsp;&nbsp;
                    </div>
                    <div>
                        <button> 삭제</button>
                    </div>
                </StyeldList>
                
                )
            }
            <Footer />
        </div>
    );
};

export default ListPage;