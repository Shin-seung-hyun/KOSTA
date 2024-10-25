import React, { Fragment } from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';

// App.js 에서 받아옴
import App from './App'; // import 컴포넌트 함수 from App.js에서 
import reportWebVitals from './reportWebVitals';
import PMS from './phones/PMService';
import Clock from './time/Clock';
import Phone from './phones/Phone';

const root = ReactDOM.createRoot(document.getElementById('root'));
const name = "KOSTA"; // js 스크립트
const element = <h1>Hello, {name}</h1> // react에서는 js 변수,함수를 {} 안에 넣으면 된다.

//1. const, function 사용해서 UI의 내용을 구성
/*
const memeber = {
  id : "kosta",
  pwd : "1234",
  name : "홍종각",
  address : "종각", // react에서는 , 를 안해줘도 되지만 해주는 것이 문법이다. , 를 trial comma라고 부른다.
};

function getToken(member){ // 함수형 컴포넌트가 아니다. 대문자로 시작하지 않는다.
  return memeber.id + " " + member.name;
}

const uielement = (
  <h1>Hello, {getToken(memeber)}</h1>
)
*/

setInterval(() => {

  root.render(
    //3. Custom Tag
    <>
      <div>
      <Phone model={"IPhone-16"} made = {"Apple"} />
      <Phone model={"갤럭시-S23"} made = {"삼성"} />
      <Phone model={"갤럭시-S24"} made = {"삼성"} />
      </div>
      <Clock />
    </>
  );

}, 2000);


// root.render(
//   //element
//   //uielement
//   
//   //2.
//   <React.StrictMode>
//     <PMS />
//   </React.StrictMode>
// );

reportWebVitals();
