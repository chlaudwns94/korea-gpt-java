function TextInput({id, text}) {


    return <div>
        <label htmlFor={id}>{text}</label>
        <input type="text" id={id} />
    </div>
}

export default TextInput;