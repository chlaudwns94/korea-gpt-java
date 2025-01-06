let boardInputDatas = {
    id: 0,
    title: "",
    content: "",
    writer: "",
};

function setInputsEvent() {
    const titleInput = document.querySelector(".title");
    const contentInput = document.querySelector(".content");
    const writerInput = document.querySelector(".writer");
    titleInput.onkeyup = handleBoardInputOnChange;
    contentInput.onkeyup = handleBoardInputOnChange;
    writerInput.onkeyup = handleBoardInputOnChange;
}

function submitButtonEvent() {
    const submitButton = document.querySelector(".write-submit-button");
    submitButton.onclick = handleSubmitOnClick;
}




function handleBoardInputOnChange(e) {
    boardInputDatas = {
        ...boardInputDatas,
        [e.target.name]: e.target.value,
    };
} 

function handleSubmitOnClick() {
    saveBoard();
    clear();
}

function saveBoard() {
    let boardDatas = !!localStorage.getItem("boardDatas") 
    ? JSON.parse(localStorage.getItem("boardDatas"))
    : [];

    if(boardDatas.length > 0 ) {
        boardInputDatas.id = boardDatas[boardDatas.length - 1].id + 1;
    }

    boardDatas = [
        ...boardDatas,
        boardInputDatas,
    ]
    
     localStorage.setItem("boardDatas",JSON.stringify(boardDatas));

     alert("게시글 작성 완료.")
     location.href = "./list.html";
}

function clear() {
    const titleInput = document.querySelector(".title");
    const contentInput = document.querySelector(".content");
    const writerInput = document.querySelector(".writer");
    const inputs = [titleInput, contentInput, writerInput];
    inputs.forEach(input => input.value = "");
    boardInputDatas = {
        title: "",
        content: "",
        writer: "",
    };
}
setInputsEvent();
submitButtonEvent();