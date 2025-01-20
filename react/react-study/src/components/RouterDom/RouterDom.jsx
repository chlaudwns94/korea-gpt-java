import React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';

function RouterDom({ children }) {
    const [ pathname, setPathname ] = useState(window.location.pathname);

    console.log(pathname)

    useEffect(() => {
        setPathname(window.location.pathname);
    }, [window.location.pathname])
   
    return (
        <div>
            {children}
        </div>
    );
}

export default RouterDom;