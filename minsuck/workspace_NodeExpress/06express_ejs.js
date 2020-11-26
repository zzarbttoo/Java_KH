var express = require('express');

var app = express();

// ejs 사용하도록 설정하기
app.set('views' , __dirname + "/views");
app.set('view engine', 'ejs');
app.engine('html', require('ejs').renderFile);

app.get('/' , function(req, res){
    res.render('ejstest',{

        name : '이름',
        length : 10,

    });
});

app.listen(3000, function(){

    console.log('포트 3000에서 서버가 열렸습니다');

});