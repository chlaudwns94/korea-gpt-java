import React, { useState } from 'react';

function FindBooks({ booksList }) {
    const [ findBooks, setFindBooks ] = useState({
        bookName: "",
        isbn: "",
        publisher: "",
        category: "",
    })

    const handleFindBooksOnChange = (e) => {
        setFindBooks({
            ...findBooks,
            [e.target.name]: e.target.value
        })
    }

    const handleFindBooksOnClick = () => {
        const findbook = booksList.find(book => book.bookName === findBooks.bookName);
        if(findbook) {
            setFindBooks({
                ...findBooks,
                booksList,
            });
        }else {
            alert("일치하지않습니다.")
        }
    }

    return (
        <div>
            <h1>도서 조회</h1>
            <input type="text" name='bookName' value={findBooks.bookName} onChange={handleFindBooksOnChange}/>
            <button onClick={handleFindBooksOnClick}>조회</button>
            {findBooks}
        </div>
    );
}

export default FindBooks;