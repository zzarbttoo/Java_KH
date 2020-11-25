class Student{
    //var 생략
    name = '';

    //function 생략
    setName(name){
        this.name = name;
    }

    print(){
        //this를 붙이지 않으면 스코프 내에 포함되지 않기 때문에 에러가 난다
        //클래스 객체 안의 멤버 변수에 접근하려면 반드시 this.을 붙여줘야한다
        //React에서 좀 자주 당할 것 같음?
        console.log('my name is ' + this.name) ;
    }
}

var student = new Student();

student.setName('이름');
student.print();


