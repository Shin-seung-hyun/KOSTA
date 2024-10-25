
import Img1 from "./assets/1.jpg"
import Img3 from "./assets/3.jpg"
import Img5 from "./assets/5.jpg"

import "./App.css";

function Trip(){

    return (
        <div className="body">
            <img src ={Img1} width={300} height ={300}/>
            <img src ={Img3} width={300} height ={300}/>
            <img src ={Img5} width={300} height ={300}/>
        </div>
    );
}

export default Trip;