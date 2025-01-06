class User {
    username;
    password;
    name;
    email;

    constructor(username = null, password = null, name = null, email = null) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }


    toString() {
        return `User = {username: ${this.username}, password: ${this.password}}`;
    }
}

const user = new User("aa", "1234");
console.log(user.toString());