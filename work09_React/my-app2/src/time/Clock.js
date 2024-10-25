
function Clock(props){
    return (
        <div>
            <h1>Good Morning~~!</h1>
            <h3>현재 날짜 : {new Date().toLocaleDateString()}</h3>
        </div>
    );
}

export default Clock;