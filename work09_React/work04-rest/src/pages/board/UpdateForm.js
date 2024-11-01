import React, { useState, useEffect } from 'react';
import {Button,Form,Container } from 'react-bootstrap/';
import axios from 'axios';
import {useNavigate, useParams } from 'react-router-dom';

const UpdateForm = () => {

    const {id} = useParams();
    const [board, setBoard]= useState({
        "id" :0,
        "title":"",
        "author" : "",
    });

    useEffect(()=>{
        axios({
            url : "http://localhost:9000/boards/" + id,
            method : "get",

        })
        .then( (res) =>{
            console.log("res.data", res.data);
            setBoard(res.data); 
        })
    },[])

    const changeForm = (e)=>{
        
        //setBoard.. board를 새로 만들고 폼에 입력된 값으로 그 객체를 채운다.
        setBoard({
            ...board,
            [e.target.name]:e.target.value
        });

    }

    const navigate = useNavigate();
    const submitBoard = (e) => {
        e.preventDefault(); // 액션으로 못가고 Axios를 타도록

        axios({
            url : "http://localhost:9000/boards/" + id,
            method : "put",
            data : board,
        })
        .then((res)=>{
            if(res.status ===200){
                navigate("/board/" + id);
            }
            else{
                alert("게시글 쓰기 실패")
            }
        })

    }

    return (
        <div>
            <h1>글 수정하기</h1>
            <Container style={{ marginTop : '100px'}}>
                <Form onSubmit={submitBoard} >
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Title</Form.Label>
                        <Form.Control type="text" name ="title" value = {board.title} onChange={changeForm}/>
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Author</Form.Label>
                        <Form.Control type="text" name = "author" alue = {board.author} onChange={changeForm}/>
                    </Form.Group>
                    
                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>  
            </Container>          
        </div>
    );
};

export default UpdateForm;