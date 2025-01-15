import React, { useState } from 'react';

function App5(props) {
        /**
         * 회원정보를 입력받아 userList에 user객체들을 가입하기 버튼을 누를 떄마다 저장한다.
         * 로그인 정보를 입력받아 userList에 해당 username이 있는지 확인하고
         * 없으면 '사용자 정보를 다시 확인하세요.' 메세지 출력(alert)
         * 있으면 비밀번호가 일치 하는지 검사
         * 비밀번호가 일치하지 않으면 ;'사용자 정보를 다시 확인하세요.' 메세지 출력(alert)
         * 일치하면 이름(이메일)님 환영합니다. 출력(alert)
         */

        const [userList, setUserList ] = useState([]);

        const [userInput, setUserInputList ] = useState({
            username: "",
            password: "",
            name: "",
            email: "",
        });

        const [ loginInput, setLoginInput ] = useState({
            username: "",
            password: "",
        });

        console.log(userList);

        const handleInputOnChange = (e) => {
            const { name, value } = e.target;

            setUserInputList({
                ...userInput,
                [name]: value,
            });
        };

        const handleLoginOnChange = (e) => {
            const { name, value } = e.target;

            setLoginInput({
                ...loginInput,
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
            <h1>로그인</h1>
            <input type="text" name="username" onChange={handleLoginOnChange}  value={loginInput.username} />
            <input type="password" name="password" onChange={handleLoginOnChange}  placeholder="password" value={loginInput.password} />
            <div>
                <button onClick={handleLoginOnclick}>로그인</button>
            </div>
        </div>
    );
}

export default App5;