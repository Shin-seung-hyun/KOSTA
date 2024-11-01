import React, { useState , useEffect} from 'react';
import {Button,Form,Container } from 'react-bootstrap/';
import axios from 'axios';
import {useNavigate } from 'react-router-dom';

const SaveForm = () => {
    const navigate = useNavigate();

    const[board, setBoard] = useState({
        title : "",
        author : "",

    }) 

    const changeForm = (e)=>{
        
        //setBoard.. board를 새로 만들고 폼에 입력된 값으로 그 객체를 채운다.
        setBoard({
            ...board,
            [e.target.name]:e.target.value
        })

    }
    
    const submitBoard = (e) =>{
        e.preventDefault(); // form의 걸린 액션으로 가는 걸 막고, axios 비동기 통신을 탄다.

        //axios 비동기 통신으로 폼에 입력된 값으로 전개연사자를 통해 board를 생성
        // 이걸 서버에 전달 -> DB에 입력
        axios({
            url :  "http://localhost:9000/boards",
            method : "post",
            data : board, // 객체 값 그자체를 보냄
        })
        .then( (res) => {
            console.log("res==>", res);
            if(res.status === 201){
                navigate("/");
            }
            else{
                alert("게시글 쓰기 실패")
            }

        }).catch( (err) =>{
            console.log("err ==>" ,err);
        })
        
    }

    return (
        <div>
            <Container style={{ marginTop : '100px'}}>
                <Form onSubmit={submitBoard} >
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Title</Form.Label>
                        <Form.Control type="text" name ="title" onChange={changeForm}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Author</Form.Label>
                        <Form.Control type="text" name = "author" onChange={changeForm}/>
                    </Form.Group>
                    
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>  
            </Container>          
        </div>
    );
};

export default SaveForm;