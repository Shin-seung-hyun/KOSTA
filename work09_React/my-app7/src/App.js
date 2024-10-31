import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import ListPage from './pages/ListPage';
import WritePage from './pages/WritePage';
import Navigate from './Navigate';
import axios from 'axios'; // 자동완성이 되는 reat-axios 말고 axios 사용

function App() {

  const selectAll =() =>{

    //요청
    axios.get( "https://jsonplaceholder.typicode.com/posts") //요청을 보내고,
    
    //응답
    .then( (result) => {    //성공했다면, 이곳으로 데이터가 반환된다.
      //console.log(result);
      //console.log(result.data)
      result.data.map( (item) => {
        console.log(item.id + "," + item.title);
      });

    })
    .catch( (err) => { // 실패했다면,
      console.error(err);
    })

  }

  const selectById = () =>{
    axios({
      //요청을 진행함
      url : "https://jsonplaceholder.typicode.com/posts/1",
      method : "get",
      //data : 
    })
    .then( (result) => {
      console.log(result.data);
    })
    .then( () => {

      //이런 부분이 CallBakc hell을 만나지 않게 하는 중요한 부분이 된다.
       console.log("성공한 후의 할 일은 여기서도 계속 됩니다.")
    })
    .catch( (err) => {
      console.error(err);
    })
  }


  return (
    <div className="App">

      {/* Router */}
      <BrowserRouter>
        <Navigate />
        <Routes>
          <Route path = "/" element ={ <ListPage /> } />
          <Route path = "/write" element ={ <WritePage /> } />
        </Routes>
      </BrowserRouter> 
      {/* <ListPage /> */}

      {/* Axios */}
      {/* <button onClick={selectAll}>get-selectAll</button>
      <button onClick={selectById}>get-selectById</button> */}

      
    </div>
  );
}

export default App;
