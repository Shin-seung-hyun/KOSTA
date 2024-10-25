import Board from "./Board";


const comments = [
    {
        writer : "홍종각",
        comment : "금요일 쌀쌀한 아침입니다.",
    },
    {
        writer : "Tomas",
        comment : "여기는 시카고입니다.",
    },
    {
        writer : "제시",
        comment : "물의를 일으켜 죄송합니다.",
    },
]

function BoardList(props){
    return(
        <>
            {
                //React의 반복문
                comments.map((comment) =>{
                    return (
                        <Board writer={comment.writer} comment = {comment.comment} />
                    );
                })
            }
            
        </>

    )
}

export default BoardList;