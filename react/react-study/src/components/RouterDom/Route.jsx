import React from 'react';
import { useEffect } from 'react';

function Route({ path, element }) {
    

    return (
        <div>
            {
                window.location.pathname === path && element       
            }
        </div>
    );
}

export default Route;