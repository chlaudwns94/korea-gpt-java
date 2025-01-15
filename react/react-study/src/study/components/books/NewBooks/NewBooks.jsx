import React, { useState } from 'react';

function NewBooks({ booksList, setBooksList }) {
    const [inputBooks, setInputBooks] = useState({
        bookName: "",
        isbn: "",
        publisher: "",
        category: "",
    });

    const handleInputOnChange = (e) => {
        const { name, value } = e.target;
        
        setInputBooks ({
            ...inputBooks,
            [name]: value,
        });
    }

    const handleBookOnClick = () => {
        setBooksList ({
            ...booksList,
                inputBooks,
        });
        
        alert("등록되엇습니다.")
       
        setInputBooks ({
            ...inputBooks,
            bookName: "",
            isbn: "",
            publisher: "",
            category: "",
        })
    }

    

    return (
        <div>
            <h1>도서 등록</h1>
            <input type="text" placeholder='도서명' name='bookName' onChange={handleInputOnChange}  value={inputBooks.bookName}/>
            <input type="text" placeholder='isbn' name='isbn' onChange={handleInputOnChange}  value={inputBooks.isbn}/>
            <input type="text" placeholder='출판사' name='publisher' onChange={handleInputOnChange}  value={inputBooks.publisher}/>
            <input type="text" placeholder='카테고리' name='category' onChange={handleInputOnChange}  value={inputBooks.category}/>
            <div>
            <button onClick={handleBookOnClick}>등록</button>
            </div>
        </div>
    );
}

export default NewBooks;