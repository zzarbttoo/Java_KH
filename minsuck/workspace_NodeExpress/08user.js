//스키마

var mongoose = require('mongoose');

var userSchema = new mongoose.Schema({

    //이름을 지정해주지 않으면 자동으로 테스트로 설정
    name : {type:String, default:'테스트'},
    kor : Number ,
    eng : Number, 
    math : Number,

});

module.exports = mongoose.model('score', userSchema);
