import React from 'react';
import Footer from '../components/commons/Footer';

const WritePage = () => {
    
    const handleWrite = ()=>{
        //게시글 생성
        let board = {id:6, title:"폼에 입력된 값"}
    }
    
    return (
        <div>
            <h1 >Write Page ...</h1>

            <form>
                <input type='text' placeholder='제목 입력..' />
                <button type='button' onClick={handleWrite}>글쓰기</button>
            </form>
            <Footer />
        </div>
    );
};

export default WritePage;