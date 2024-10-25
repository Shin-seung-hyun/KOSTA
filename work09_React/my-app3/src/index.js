import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Form from './form/Form';
import Movie from './reservation/Movie';

const element = <h1>안녕 리액트</h1>;

//render 함수의 인자값으로 전달되는 객체
// React가 html로 랜더링한다.
// 화면을 구성하는 핵심적인 요소
// 이를 만드는 문법이 JSX이다.
console.log("element", element); //$$typeof: Symbol(react.element)

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  //HTML의 div 영역에 들어가는 UI 내용이 들어간다.
  //1. JSX 문법으로 
  //element
  //<Form /> // 컴포넌트 문법으로 안에 컴포넌트만 나오기
  <Movie/>

  //<App />


);
