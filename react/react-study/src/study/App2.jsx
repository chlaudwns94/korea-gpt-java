import { useState } from "react";

/**
 * useState 상태관리
 * 
 */


function App2() {
    const [ num, setNum ] = useState(0);

    let number = 0;

    console.log(num);
    console.log(number);

    const handleIncreaseOnClick = () => {
        setNum(num + 1);
    }

    const handledecreaseOnClick = () => {
        setNum(num - 1);
        
    }

    return <>
        <h1>{num}</h1>
        <button onClick={handleIncreaseOnClick}>1증가</button>
        <button onClick={handledecreaseOnClick}>1감소</button>
    </>
}

export default App2;