import React, { useState } from 'react';

function Signup({userList, setUserList}) {
    const [userInput, setUserInputList ] = useState({
        username: "",
        password: "",
        name: "",
        email: "",
    });

    
    const handleInputOnChange = (e) => {
        const { name, value } = e.target;

        setUserInputList({
            ...userInput,
            [name]: value,
        });
    };

    
    const handleSignOnclick = () => {
        setUserList([
            ...userList,
                userInput,
        ]);

        alert("가입완료")

        setUserInputList({
            ...userInput,
            username: "",
            password: "",
            name: "",
            email: "",
        })
        
    };


    return (
        <div>
            <h1>회원가입</h1>
            <input type="text" 
                    name="username" 
                    onChange={handleInputOnChange} 
                    value={userInput.username} 
                    placeholder="username" />
            <input type="password" 
                    name="password" 
                    onChange={handleInputOnChange} 
                    value={userInput.password} 
                    placeholder="password" />
            <input type="text" 
                    name="name" 
                    onChange={handleInputOnChange} 
                    value={userInput.name} 
                    placeholder="name" />
            <input type="text" 
                    name="email" 
                    onChange={handleInputOnChange}
                    value={userInput.email} 
                    placeholder="email" />
            <div>
                <button onClick={handleSignOnclick}>가입하기</button>
            </div>
        </div>
    );
}

export default Signup;