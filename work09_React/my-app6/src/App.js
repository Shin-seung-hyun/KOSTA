import './App.css';
import { Title } from './css/MyTitle';
import Footer from './components/commons/Footer';
import Header from './components/commons/Header';
import Login from './components/login/Login';
import LoginPage from './pages/LoginPage';

function App() {
  return (
    <div className="App">
      <Title>스타일 컴포넌트 적용 리액트</Title>
      
      {/* 방법2. */}
      <LoginPage />

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
    </div>
  );
}

export default App;
