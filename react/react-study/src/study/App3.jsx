import React, { useState } from 'react';

function App3(props) {

    const [ name, setName ] = useState("");
    const [ gender, setgender ] = useState("");
    const [ nameInputValue, setNameInputValue ] = useState("");
    const [ genderInputValue, setGenderInputValue ] = useState("male");


    console.log(nameInputValue); 

    const handleNameInputOnChange = (e) => {
        setNameInputValue(e.target.value);
    } 
    
    const handleGenderInputOnChange = (e) => {
        setGenderInputValue(e.target.value);
    }

    const handleNameOnClick = () => {
        setName(nameInputValue);
        setNameInputValue("");
        setgender(setGenderInputValue === "male" ? "남" : "여" );
    }


    return (
        <div>
            <h1>이름: {name} ({gender})</h1>
            <input type="text" onChange={handleNameInputOnChange} value={nameInputValue}/>
            <input type="radio" id="male" name="gender" onChange={handleGenderInputOnChange} checked={genderInputValue === "male"} value={"male"} />
            <label htmlFor="male">남</label>
            <input type="radio" id="female" name="gender" onChange={handleGenderInputOnChange} checked={genderInputValue === "female"} value={"female"} />
            <label htmlFor="female">여</label>
            <button onClick={handleNameOnClick}>확인</button>
        </div>
    );
}

export default App3;
