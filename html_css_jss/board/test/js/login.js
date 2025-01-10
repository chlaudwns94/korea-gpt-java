let loginInputData = {
    username: "",
    password: "",
}

function setInputsEvent() {
    const usernameInput = document.querySelector(".input-box > input:nth-of-type(1)");
    const passwordInput = document.querySelector(".input-box > input:nth-of-type(2)");
    usernameInput.onkeyup = handleLoginChange;
    passwordInput.onkeyup = handleLoginChange;
}

function loginButtonEvent() {
    const loginButton = document.querySelector(".login-button");
    loginButton.onclick = loginOnclick;
}

function loginOnclick() {
    logIn();
}

function handleLoginChange(e) {
    loginInputData = {
        ...loginInputData,
        [e.target.name]: e.target.value,
    };
}



function logIn() {
    
    
    if ( checkId() && checkPassword()) {
        alert("로그인 성공")
    }else {
        alert("로그인 실패")
    }
    
    console.log(checkId())
}


function checkId(){
    const loginDatas = !!localStorage.getItem("userData")
    ? JSON.parse(localStorage.getItem("userData"))
     : [];
    
     const loginData = [loginInputData];
 
    const id1 = loginData.map(loginData => loginData.username)
    const id2 = loginDatas.map(loginData => loginData.username)
    
    return id1 === id2;
}

function checkPassword() {
    const loginDatas = !!localStorage.getItem("userData")
   ? JSON.parse(localStorage.getItem("userData"))
    : [];
   
   const loginData = [loginInputData];

   const password1 = loginData.map(loginData => `${loginData.password}`)
   const password2 = loginDatas.map(loginData => `${loginData.password}`)
    return password1 === password2
}


setInputsEvent();
loginButtonEvent();