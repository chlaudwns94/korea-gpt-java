/**
 *          useRef()
 */

import React, { useRef } from 'react';
import { useState } from 'react';

function App9(props) {
    const aRef = useRef();
    const bRef = useRef();
    const cRef = useRef();
    const dRef = useRef();
    const [ inputRefs, setInputRefs ] = useState([ aRef, bRef, cRef, dRef ]);

    const handleOnKeyDown = (e) => {
        if(e.keyCode !== 13) {
            return;
        }

        let currentIndex = 0;
        let nextIndex = 0;
        for( let i = 0; i < inputRefs.length; i++) {
            if(inputRefs[i].current === e.target) {
                currentIndex = i;
                break;
            }
        }

        nextIndex = currentIndex + 1 === inputRefs.length ? 0 : currentIndex + 1;

        inputRefs[nextIndex].current.focus();
        
        console.log(e.target);
        console.log(inputRefs[0].current === e.target)
        console.log(inputRefs[1].current === e.target)
        console.log(inputRefs[2].current === e.target)
        console.log(inputRefs[3].current === e.target)
    }

    return (    
        <div>   
            <input type="text" onKeyDown={handleOnKeyDown} ref={aRef} />
            <input type="text" onKeyDown={handleOnKeyDown} ref={bRef} />
            <input type="text" onKeyDown={handleOnKeyDown} ref={cRef} />
            <input type="text" onKeyDown={handleOnKeyDown} ref={dRef} />
        </div>
    );
}

export default App9;