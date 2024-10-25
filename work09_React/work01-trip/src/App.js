import logo from './logo.svg';
import './App.css';

// 컴포넌트란 ? React Element를 리턴하는 것
function Header(props){
  
  console.log(props);

  return (
    //React Element를 리턴
      <header>
        <h1>Best Top 3 {props.title}</h1>
      </header>
  );
}

function Nav(){
  return(
    <nav>
      <ol>
          <li>산티아고</li>
          <li>아씨씨</li>
          <li>칸쿤</li>
      </ol>
    </nav>
  );
}

function Article(props){
  
  return (
    <article>
      <h2>태어난 김에 {props.title}</h2>
      <h4><b>{props.content}</b></h4>
    </article>
  );
}


function App() {
  return(
    <>
      <div class = "appBody">
        <Header title ="TRIPS"  className = "header" />
        <Nav />
        <Article title ="유럽 일주" content ="올 겨울 최고의 찬스"/>
      </div>
    </>
  );
}

//export는 여러개가 아닌 하나만 할 수 있다.
export default App;
