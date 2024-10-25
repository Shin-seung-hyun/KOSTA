import logo from './logo.svg';
import './App.css'; // css라서 from 절이 없다.

//let 아니면 const를 사용할 것
// react에서는 bar를 거의 사용하지 않는다.
const a = "Hello";
let b = 3;

function App() {
  return (
    <>
      <div>
        {/* 
          if 문이 없다. 삼항 연산자를 써야한다.
          == 과 === 은 다르다.
        */}
        <h1 className = "box-style">{a === "Hi" || "Hello" } React~~!</h1>
        <h2> React 공부한지 {b === 100 ? "100일" : "3일"} 되는 날</h2>
        
      </div>
    </>
  );
}

export default App;
