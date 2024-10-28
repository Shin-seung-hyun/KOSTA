import { useEffect, useState } from "react";
import User, { id, name } from "./user/User";


function App() {

/* 1.  */
//   //let count = 0;

// //변수 저장 vs 상태값 저장
//   // let [a,b] = [100, 200]; 
//   // let [a,b] = [100];
//   // console.log("a ==>", a, "b==>", b);

//   //useState(1) 이 count의 초기값이다.
//   // count가 변경되면 setCount가 
//   const [count, setCount] = useState(1);

//   const add = ()=>{
//     setCount(count+1);
//     console.log("count --> " +  count);
//   }


/* 2.  */
  // const [count, setCount] = useState(0);
  // useEffect(() => {
  //   console.log("useEffect App 실행됨 ...");
  // });


/* 3. 서버에서 클라이언트의 요청을 수행한 후, 데이터 10을 return 받았다고 치자. 
      2번에서는 버튼을 클릭해서 상태값을 변경했지만 
      실제로는 서버에서 받은 데이터를 할당 해야한다. 이를 연습해보자

      userEffect가 2번 호출되는 것을 알 수 있다.

      useEffect( ()=>{}, []) 의 []는 어떤 상태값에도 의존하지 않겠다는 의미이다.

*/  
  // const ajaxData = ()=>{
  //   let serverCount = 10;
  //   setCount(serverCount);
  // }

  // const [count, setCount] = useState(0);
  // useEffect(() => {
  //   console.log("useEffect App 실행됨 ...");
  //   ajaxData(); // 화면이 먼저 랜더링된 후 서버의 데이터를 받아온다.
  // },[]);


/* 4.  */  
  const ajaxData = ()=>{
    let serverCount = 10;
    setCount(serverCount);
  }
  const [count, setCount] = useState(0);
  const [search, setSearch] = useState("");
  useEffect(() => {
    console.log("useEffect App 실행됨 ...");
    ajaxData();
  },[setSearch]);

  return (
    <>
      {/* 1. 증가된 조회수가 화면에 반영되려면 변수를 상태값 state로 변경해야 한다.  useState()를 사용
      <h2> 조회수 : {count} </h2>
      <User />
      Member ID : {id} <br/>
      Member Name : {name} <br/>

      <b>----------------------------------</b><br/><br/>
      <button onClick={add}>조회수 증가하기</button> */}


    {/* 2. 버튼 누를 때마다 useEffect 가 실행된다.
          상태값이 바뀔 때(setCount가 호출될 때), App의 return이 동작하는데
          React 엔진은 이전 화면과 비교해서 변경된 부분만을 다시 랜더링한다.
    */}
      <h2> Hello React ... useEffect!! </h2>
      <h2>조회수 증가하기 {count} </h2>
      <h2>검색 아이디 :  {search} </h2>

      <button onClick={()=>{
        setCount(count + 1)
      }}>증가하기</button> 

      <button onClick={()=>{
        setSearch("Kosta")
      }}>조회하기</button> 

    </>
  
  );
}

export default App;
