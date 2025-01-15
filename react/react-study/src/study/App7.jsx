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
import FindBooks from './components/books/FindBooks/FindBooks';
import NewBooks from './components/books/NewBooks/NewBooks';

function App7(props) {
    const [ path, setPath ] = useState("findbooks");
    const { booksList, setBooksList } = useState([]);
    const handlePageChangeButtonOnClick = (e, path) => {
        setPath(path);
    };

 

    return (
        <div>
            <button onClick={(e) => handlePageChangeButtonOnClick(e, "findbooks")}>도서 조회</button>
            <button onClick={(e) => handlePageChangeButtonOnClick(e, "newbooks")}>도서 등록</button>
            {
                path === "findbooks" && <FindBooks booksList={booksList} />
            }
            {
                path === "newbooks" && <NewBooks booksList={booksList} setBooksList={setBooksList}/>
            }
        </div>
    );
}

export default App7;