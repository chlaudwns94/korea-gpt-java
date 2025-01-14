import { useState } from "react";


function App3() {
     
    const [num, setnum] = useState(2);

    const multiplyOnClick= () => {
        setnum(num * 2);
    }

    const devideOnClick = () => {
        setnum(num / 2);
    }


    return <>
    <h1>{num}</h1>
    <button onClick={multiplyOnClick}>곱하기</button>
    <button onClick={devideOnClick}>나누기</button>
    </>
}

export default App3;