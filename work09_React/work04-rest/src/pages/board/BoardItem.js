import React from 'react';
import Card from 'react-bootstrap/Card';
import { Link } from 'react-router-dom';
import Button from 'react-bootstrap/Button';

const BoardItem = (pros) => { //Home에서 Board가 넘어옴 {id, titile, author}

    const {id, title, author} = pros.board; // {id, titile, author}  구조분할 할당
    
    return (
        <Card>
            <Card.Body>
                <p>BoardItem.js</p>
                <Card.Title>{title}</Card.Title>
                {/* <Link to = {"board/" + id} className='btn btn-primary'> 상세보기</Link> */}
                <Link to = {`board/${id}`} className='btn btn-primary'> 상세보기</Link>
            </Card.Body>
        </Card>
    );
};

export default BoardItem;