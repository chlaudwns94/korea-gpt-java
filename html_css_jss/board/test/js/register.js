let userInputData = {
    userID: 1,
    username: "",
    password: "",
}

function setInputsEvent() {
    const usernameInput = document.querySelector(".input-box > input:nth-of-type(1)");
    const passwordInput = document.querySelector(".input-box > input:nth-of-type(2)");
    usernameInput.onkeyup = handleChange;
    passwordInput.onkeyup = handleChange;
}

function registerButtonEvent() {
    const registerButton = document.querySelector(".register-button");
    registerButton.onclick = handleRegisterOnclick;
}

function handleRegisterOnclick() {
    saveUser();
}

function handleChange(e) {
    userInputData = {
        ...userInputData,
        [e.target.name]: e.target.value,
    };
}

function saveUser() {
    let userData = !!localStorage.getItem("userData")
    ? JSON.parse(localStorage.getItem("userData"))
    : [];

    if(userData.length > 0 ) {
        userInputData.userID =userData[userData.length - 1].userID + 1;
    }

    userData = [
        ...userData,
        userInputData,
    ]

    localStorage.setItem("userData",JSON.stringify(userData));

    alert("회원가입 성공! 로그인 페이지로 이동합니다.")
    location.href = "./login.html";
}

setInputsEvent();
registerButtonEvent();




