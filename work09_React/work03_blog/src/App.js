import './App.css';
import {useState} from 'react';

//1. 
// 비동기 통신으로 받아왔다 치고,서버에서 받아온 데이터라고 생각하기 <h3>{location} 여행 Blog 작성</h3>
//let location = "인도";


//2. 함수로 데이터 바인딩
function location(){
  return "인도";
}

const styles = {color : 'crimson', fontSize : '30px'};
function App() {

  // 상태값 변경
  // 여행지가 변경되면 그때마다 화면의 내용이 변경된다. -> 상태값으로 처리한다. useState()
  let locations = ["인도", "라오스", "마다가스카르","스페인", "하와이"];
  let [loc, setLoc] = useState(["Best Like Trip ~~", locations])
  let [likes, setLikes] = useState(Array(locations.length).fill(0));
  

  return (
    <div className="App">
      <div className="nav">
        태어난 김에 세계일주
      </div>
      {/* getElementById("h3").innerHTML = location;로 Html, JS는  받아온다. */}
      {/* <h3>{location()} 여행 Blog 작성</h3> */}
      {/* <h3 style ={{color : 'crimson', fontSize : '30px'}}>{location()} 여행 Blog 작성</h3>*/}
      {/* <h3 style ={styles}>{location()} 여행 Blog 작성</h3> */}

      {
        locations.map( (location, idx) => (
          <div className='list' key ={idx}>
            <h3>{location} 
              <span onClick={()=>{
                const newLikes = [...likes];
                newLikes[idx] += 1;
                setLikes(newLikes);
              }}>👍</span> 
            </h3>
            <p>{loc[0]} {likes[idx]}</p> 
            <hr/>
          </div>
        ))
      }
    
    </div> 
  );
}

export default App;
