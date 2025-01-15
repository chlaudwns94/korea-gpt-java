import React, { useState } from 'react';

function Signin({userList}) {
    const [ loginInput, setLoginInput ] = useState({
        username: "",
        password: "",
    });

    const handleLoginOnChange = (e) => {
        const { name, value } = e.target;

        setLoginInput({
            ...loginInput,
            [name]: value,
        });
    };

    const handleLoginOnclick = () => {
        const foundUser = userList.find(user => user.username === loginInput.username);
        if(!foundUser) {
            alert("사용자 정보를 다시 확인하세요.");
            return;
        }
        if(foundUser.password !== loginInput.password) {
            alert("비밀번호를 다시 확인하세요.")
            return;
        }
        alert(`${foundUser.name}(${foundUser.email})님 환영합니다.`);
    };
    

    return (
        <div>
            <h1>로그인</h1>
            <input type="text" name="username" onChange={handleLoginOnChange} placeholder='username' value={loginInput.username} />
            <input type="password" name="password" onChange={handleLoginOnChange}  placeholder="password" value={loginInput.password} />
            <div>
                <button onClick={handleLoginOnclick}>로그인</button>
            </div>
        </div>
    );
}

export default Signin;