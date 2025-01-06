/**
 * 연산자
 * 
 *산술연산자
 *+,-,*,/,% , **(제곱)
 */
console.log(5**2);

/**
 * 증감연산자
 * ++, --
 * 
 * 비교연산자
 * <, <=, >, >=, ==, !=. ===, !==
 * javascript의 특징은 기본적으로 변수의 타입이 정해지지않음
 */

console.log(1==1);
console.log(1 == "1");      //타입 검사 x
console.log(1 === "1");     //타입 검사 o
console.log(1 != "1");      //타입 검사 x
console.log(1 !== "1");     //타입 검사 o

/**
 * 논리연산자
 * &&, ||
 * 단축 평가
 * 
 * 논리 자료 값 || anything
 * 논리 자료 값 === true  => true;
 * 논리 자료 값 === false  => anything
 * 논리 자료 값 & anything
 * 논리 자료 값 === true    =>  anything
 * 논리 자료 값 === false   =>  false 
 * 
 * null 병합 연산
 * anything1 ?? anything2
 * 좌항(anything1) === null || 좌항(anything1) === ubdefined    => 우항(anything2)
 * 좌항(anything1) !== null && 좌항(anything1) !== ubdefined    => 좌항(anything2)
 * 
 */

console.log(1 === 1 || "최명준")
console.log(1 !== 1 || "최명준")
console.log(1 === 1 && "최명준")
console.log(1 !== 1 && "최명준")

console.log(null ?? "최명준1")
console.log("최명준1" ?? "최명준2")
/*
 * Not 연산
 * !, !!
 */

console.log("----------------- Not 연산 -----------------")
console.log(!"");
console.log(!0);
console.log(!null);
console.log(!undefined);
console.log(![])    //배열은 내부에 값이 없더라도 배열의 주소는 존재하기 떄문에 true
console.log(typeof []);
console.log(![].length);

var name = "최명준";
if(!name) {
    console.log("이름이 비었습니다.")
}
if(!!name) {
    console.log("이름이 비어있지 않습니다.")
}