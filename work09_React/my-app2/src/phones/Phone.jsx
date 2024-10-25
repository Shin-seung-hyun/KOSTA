
//props 인자 값을 통해서 컴포넌트의 상태값을 전달한다.
function Phone(props){
    return(
        <div>
            <h2>{`Phone Modle - ${props.model}`}</h2>
            <h2>{`Phone Made - ${props.made}`}</h2>
        </div>
    );
}

export default Phone;