/**
 * 객체
 */

const obj = {
    name: "최명준",
    age: 31,
    print: () => console.log(`이름: ${obj.name} 나이: ${obj.age}`),
}

obj.print();

const obj2 = {
    name: "최명준",
    age: 31,
    print: () => console.log(`이름: ${obj.name} 나이: ${obj.age}`),
}

console.log(obj === obj2);
console.log(JSON.stringify(obj) === JSON.stringify(obj2));
console.log(typeof JSON.stringify(obj));

/** 
 * object -> Json  JSON.stringfy(object)
 * Json -> object JSON.parse(json문자열)
 * User 객체 생성
 * username, password, name, email
 */

const user = {
    username: "123",
    password: "",
    name: "",
    email: "",
    hobby: ["축구", "농구", "배구"],
    address: {
        si: "부산시",
        gungu: "부산진구",
    },
    printUserInfo: () => console.log("사용자 정보 출력"), //JSON으로 변환시 함수는 변환 불가
}
 
user.username
user.password
user.name
user.email

const userJson = JSON.stringify(user);
console.log(user);
console.log(userJson);
const convertUser = JSON.parse(userJson);
console.log(convertUser);

const student = {
    name: "최명준",
    age: 31,
    address: "부산진구",
}

const key = "age";
const valie = 32;


const student2 = {
    ...student,
    name: "준이",
}
console.log(student2);