
//java 에서는 false, js 에서는 true
if(123 == '123'){
    console.log('123 == "123"');
}

if(123 === '123'){

    console.log('같음');
}

//자동으로 number 형태로 형변환이 된다
console.log(typeof + "1234");
console.log(typeof + true);