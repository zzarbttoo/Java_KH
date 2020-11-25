//기본 타입은 다 객체
var num = 1;
var bool  = false;
var str = "Hello";
var temp = null; // 기본 타입이 아니다
var temp2 = undefined;

console.log(typeof num);
console.log(typeof bool);
console.log(typeof str);
console.log(typeof temp);
console.log(typeof temp2);

//형 변환 
//String to Int
console.log(parseInt('999.123'));

//String to Float(to Number)
console.log(parseFloat('999.123'))
// to Number 
console.log(typeof Number('123'));
//to String 
console.log(typeof String(999.123))
// n진법(2진법, 8진법, 16진법)
console.log(Number(7).toString(2));
console.log(Number(63).toString(16));

// + 경우 STring concat 실행
console.log(typeof 1 + "23");
// - 경우 String을 Number 형변환 후 실행
console.log(typeof ("12"- 3)); //9

//boolean | 문자열
//문자열 === false
console.log(true | 'false'); //true
console.log('true' | 'true'); // false

console.log(typeof('23' * 12));
console.log(typeof(123 + ''));

var obj = {'a':'value', 12:'test', true:false};
var obj2 = new Object();

//타입 제한이 없다
console.log(obj['a']);
console.log(obj[12]);
console.log(obj[true]);

var array = [213, '123', true];
//var array = new Array();


for(var i = 0; i <array.length; i++){
    console.log(array[i]);
}

function test(a, b){

    return a+b;

}

var test2 = function(){

    console.log('hello, javascript');
    return null;
}

test = 123;

console.log(test(1,2));
console.log(typeof test2());

