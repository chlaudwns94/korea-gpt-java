import "./style.css";
import React, { useState } from 'react';
function BookRegister({ bookList, setBookList }) {

    const [ registerInputValue, setRegisterInputValue ] = useState({
        bookName: "",
        author: "",
        publisher: "",
    });

    const handleRegisterInputOnChange = (e) => {
        setRegisterInputValue({
            ...registerInputValue,
            [e.target.name]: e.target.value,
        });
    }

    const handleRegisterButtonOnClick = () => {
        setBookList([
            ...bookList,
            registerInputValue,
        ]);

        alert("등록 완료.");

        setRegisterInputValue({
            bookName: "",
            author: "",
            publisher: "",
        });
    }
    

    return (
        <div>
            <h1>도서정보 등록</h1>
            <div className='register-input'>
            <input type="text" 
                    name="bookName" 
                    onChange={handleRegisterInputOnChange} 
                    value={registerInputValue.bookName} 
                    placeholder="도서명" />
            <input type="text" 
                    name="author" 
                    onChange={handleRegisterInputOnChange} 
                    value={registerInputValue.author} 
                    placeholder="저자명" />
            <input type="text" 
                    name="publisher" 
                    onChange={handleRegisterInputOnChange} 
                    value={registerInputValue.publisher} 
                    placeholder="출판사" />
                <button onClick={handleRegisterButtonOnClick}>등록</button>
        </div>
        </div>
    );
}

export default BookRegister;