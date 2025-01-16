import React, { useState } from 'react';
import "./styles/app7.css";

function App8(props) {


        const [bookList, setBookList ] = useState([]);
       

        const [ registerInputValue, setRegisterInputValue] =useState({
            bookName: "",
            author: "",
            publisher: "",
        });

        const handleRegisterInputOnChange = (e) => {
            setRegisterInputValue({
                ...registerInputValue,
                [e.target.name]: e.target.value,
            });
        };

         const handleRegisterButtonOnClick = () => {
        setBookList([
            ...bookList,
            registerInputValue,
        ]);
            alert("등록 완료");

            setRegisterInputValue({
                bookName: "",
                author: "",
                publisher: "",
            });
        }

       

        const [ bookTableList, setBookTableList ] = useState([]);

        const [ searchValue, setsearchValue ] = useState({
            select: "bookName",
            text: "",
        });

        const searchOptions = [
            {
                id: 1,
                label: "도서명",
                value: "bookName",
            },
            {
                id: 2,
                label: "저자명",
                value: "author",
            },
            {
                id: 3,
                label: "출판사",
                value: "publisher",
            },
        ]

        const handleSearchValueOnChange = (e) => {
            setsearchValue({
                ...searchValue,
                [e.target.name]: e.target.value,
            });
        }

        const handleSearchButtonOnClick = () => {

            if(!searchValue.text.trim()) {
                setBookTableList(bookList);
                return;
            }

            const FoundBooks = bookList.filter(book => book[searchValue.select].includes(searchValue.text))
            setBookTableList(FoundBooks);
        }

        return (
        <div className='container'>
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

            <div>
            <h1>도서정보 조회</h1>
            <div className='search-items'>
                <select name="select" value={searchValue.select} onChange={handleSearchValueOnChange}>
                    {
                        searchOptions.map(option => <option key={option.id} value={option.value}>{option.label}</option>)
                    }
                </select>
                <input type="text" name='text' value={searchValue.text} onChange={handleSearchValueOnChange} />
                <button onClick={handleSearchButtonOnClick}>검색</button>
            </div>
            <table className='book-table'>
                <thead>
                    <tr>
                        <th>도서명</th>
                        <th>저자명</th>
                        <th>출판사</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        bookTableList.map(book => 
                            <tr>
                                <td>{book.bookName}</td>
                                <td>{book.author}</td>
                                <td>{book.publisher}</td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
            </div>
        </div>
    );
}

export default App8;