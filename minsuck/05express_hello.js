var express=require('express');

var app = express();

//처음부터 받을 때 어떤 url을 받을 것인가 미리 지정
//get 방식에서 응답
app.get('/', function(req, res){

    res.send('Hello Express');
});

//post 방식에서 응답
app.post('/', function(req, res){
    res.send('hi hello');
});



app.listen(3000, function(){
    console.log('express server started at port 3000');
});