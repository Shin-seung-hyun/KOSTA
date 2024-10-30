import './App.css';
import { Title } from './css/MyTitle';
import Footer from './components/commons/Footer';
import Header from './components/commons/Header';
import Login from './components/login/Login';
import LoginPage from './pages/LoginPage';
import HomePage from './pages/HomePage';
import {BrowserRouter, Link, NavLink, Route, Routes} from 'react-router-dom';
import BoardPage from './pages/BoardPage';

function App() {
  return (
    <div className="App">
      {/* <Title>스타일 컴포넌트 적용 리액트</Title> */}
      
      {/* 방법2. */}
      {/* <LoginPage /> */}

      {/* 방법1.  */}
      {/* <Header /> */}
      {/* 이 사이에 body에 해당하는 컴포넌트가 연결되면 된다.
          이런 컴포넌트는 공용이 아닌 특정한 기능의 컴포넌트가 된다.

          컴포넌트는 2가지가 있다.
          1. 공통된  컴포넌트
          2. 특정 페이지에서만 쓰이는 컴포넌트

          <Header>, <Footer> : Commons한 성향의 컴포넌트
           : Common의 특징이 아닌  
      */}
      {/* <Login /> */}
      {/* <Footer />  */}


      {/* [10/30] passing props */}
      {/* <HomePage/> */}
      

      {/* [10/30] Routing */}
      <BrowserRouter>

        {/* 화면에 보이는 부분은 Link로 표시한다. */}
        <nav>
          <Link to="/">Home</Link>
          <NavLink to ="/loginPage">Login</NavLink>
          <Link to="/board">Board</Link>
          {/* <a href="/board">Board</a> */}
        
        </nav>

        {/* 페이지 라우팅 문법 */}
        <Routes>
            <Route path='/' element = { <HomePage /> } />

            {/* http://localhost:3000/login/kosta 이런 요청을 :id로 요청해야 함. */}
            <Route path='/login/:id' element = { <Login /> } />
            <Route path='/loginPage' element = { <LoginPage /> } />
            <Route path='/board' element = { <BoardPage /> } />

        </Routes>
      </BrowserRouter>

    </div>
  );
}

export default App;
