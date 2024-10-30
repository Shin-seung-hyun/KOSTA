import React from 'react';

const textColor = {
    color : 'magenta'    
}


const Home = (props) => {

    //const boards = props.boards;
    //const {boards} = props; // 상태값으로 바로 받는 것

    //구조 분할 할당 (덩어리에 있는 것을 분할해서 할당하는 것)
    // 이름을 a,b로 해도되는데  보낼 때 이름이랑 같은 것을 쓰자
    const {boards, setBoards} = props;


    return (
        <div>
            <h1 style={textColor}>Home Page</h1>

            {/* 버튼 클릭하면 전체 삭제 되도록 */}
            <button onClick={()=>setBoards([])}>전체 삭제 🚀</button> 
        
            {boards.map((board) => (
                <h3>
                    Title : {board.title} &nbsp;&nbsp;
                    Content : {board.content}
                </h3>
            ))}
            
        </div>
    );
};

export default Home;