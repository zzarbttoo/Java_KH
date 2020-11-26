var express = require('express');
var mongoose = require('mongoose');
//만든 스키마를 이용해 만든 모델 require을 이용해 들고 옴
var User = require('./08user');

var app = express();

//req.body를 사용하기 위해 bodyParser 사용
app.use(express.json());
app.use(express.urlencoded());

mongoose.connect('mongodb://127.0.0.1:27017', function(err){
    if(err){
        console.error(err);
        return;
    }
    console.log('mongodb connected');
});

app.get('/list', function(req, res){

    User.find(function(err, result){

        if(err){

            console.error(err);
            return res.status(500).json({success:false});
        }

        res.json({success:true, list:result});

    });
});

//http://localhost:3000/insert/Test/10/10/10
//데이터를 추가할 때는 반드시 post를 사용하자!!
app.get('/insert/:name/:kor/:eng/:math', function(req, res){
    //req.params.name === TEST

    //post의 경우
    //req.body.넣어준값 이렇게 넣어준다
    //insert를 해줌
    var newUser = new User({

        name:req.params.name,
        kor:req.params.kor,
        eng:req.params.eng,
        math:req.params.math,
    });



    newUser.save(function(err, product){
        if(err){
            console.error(err);
            return res.status(500).json({success:false});
        }
        res.json({success:true});

    });


});

app.post('/insert', function(req, res){

    var newUser = new User({
        name : req.body.name,
        kor : req.body.kor, 
        eng : req.body.eng,
        math : req.body.math,

    });

    //save 결과가 callback 함수 안으로 들어옴
    newUser.save(function(err, product){

        //에러가 난 경우 
        if (err){

            console.error(err);
            return res.status(500).json({success:false});
        }
        
        //에러가 나지 않은 경우
        res.json({success:true});

    });
});

app.listen(3000, function(){

    console.log('server started');
});