/**
 * 도서정보 등록 및 조회
 * 
 * 도서명,isbn, 저자명, 출판사명, 카테고리
 * bookList에 저장
 * 
 * table
 * tbody
 * tr
 * td
 * 
 * conponent나누기
 * 
 * 
 */
import React, { useState } from 'react';
import BookRegister from './components/books/BookRegister/BookRegister';
import BookSearch from './components/books/BookSearch/BookSearch';
import "./styles/app8.css";

function App7(props) {
    const [bookList, setBookList ] = useState([]);


    return (
        <div className='container'>
            <BookRegister bookList={bookList} setBookList={setBookList}/>
            <BookSearch bookList={bookList}/>
            
        </div>
        
    );
}

export default App7;