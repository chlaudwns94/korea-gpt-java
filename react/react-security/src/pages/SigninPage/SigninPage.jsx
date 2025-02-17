import { Box, Button, Card, CardContent, TextField, Typography } from '@mui/material';
import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { api } from '../../api/config/axiosConfig';

/**
 * 로그인 요구사항
 * 각 필드가 공백인지만 체크(공백이면 아래 오류 메세지로 출력)
 * 로그인 버튼 클릭시 /api/auth/signin 요청 
 * -> 응답받은 accessToken을 localstorage에 AccessToken이라는 키값을 저장
 * Index페이지로 이동
 */

function SigninPage(props) {
    const navigate = useNavigate();

    const [ signinInput, setSigninInput ] = useState({
        username: "",
        password: "",
    })

    const [ errors, setErrors ] = useState({
            username: "",
            password: "",
        });

    const handleSignInputOnChange = (e) => {
        setSigninInput({
            ...signinInput,
            [e.target.name]: e.target.value,
        })
    }

    const handleInputOnBlur = (e) => {
        const { name, value } = e.target;
        let message = "";
        
        if (name === "username" && value.trim() === "") {
            message = "공백입니다";  
        }

        if (name === "password" && value.trim() === "") {
            message = "공백입니다";  
        }
    
        if (message) {
            console.log(message); 
        }
    };


    const handleSigninButtonOnClick = async () => {
        try {
            const response = await api.post("/api/auth/signin", signinInput);
            localStorage.setItem("AccessToken", response.data.accessToken);
            alert("로그인 성공!");
            navigate("/");
        } catch (error) {
            alert("로그인 실패");
        }
    }

    return (
        <>
            <Card variant='outlined'>
                <CardContent>
                    <Typography variant='h4' textAlign={'center'}>
                        로그인
                    </Typography>
                    <Box display={"flex"} flexDirection={'column'} gap={2} >
                        <TextField type='text' label="username" name="username" onBlur={handleInputOnBlur} onChange={handleSignInputOnChange} value={signinInput.username} />
                        <TextField type="password" label= "password" name='password' onBlur={handleInputOnBlur} onChange={handleSignInputOnChange} value={signinInput.password} />
                        <Button variant='contained'onClick={handleSigninButtonOnClick} >로그인</Button>
                    </Box>
                    <Typography variant='h4' textAlign={'center'}>
                        계정이없으신가요? <Link to="/signup">회원가입</Link>
                    </Typography>
                </CardContent>
            </Card> 
        </>
    );
}

export default SigninPage;