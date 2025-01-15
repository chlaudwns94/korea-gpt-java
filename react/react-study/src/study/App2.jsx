import { useState } from "react";

/**
 * useState 상태관리
 * 
 */


function App2() {
    const [ num, setNum ] = useState(0);

    console.log(num);

    const handleIncreaseOnClick = () => {
        if(num < 10) {
            setNum(num + 1);
        } else {
            return num;
        }
    }

    const handledecreaseOnClick = () => {
        if(num < 1) {
            return
        } else {
        setNum(num - 1);
        }
    }

    const multiplyOnClick= () => {
        setNum(num * 2);
    }

    const devideOnClick = () => {
        setNum(num / 2);
    }


    return <>
        <h1>{num}</h1>
        <button onClick={handleIncreaseOnClick}>1증가</button>
        <button onClick={handledecreaseOnClick}>1감소</button>
        <button onClick={multiplyOnClick}>곱하기</button>
    <button onClick={devideOnClick}>나누기</button>
    </>
}

export default App2;