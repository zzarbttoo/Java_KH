var mongoose = require('mongoose');
var autoIncrement = require('mongoose-auto-increment');

//initialize를 해줌
autoIncrement.initialize(mongoose.connection);

var boardSchema = new mongoose.Schema({
    seq:{type:Number, unique:true, required:true},
    name:String,
    title:String,
    content:String,
    data:{type:Date, default:Date.now}

});

boardSchema.plugin(autoIncrement.plugin, {

    //mongodb - db.myboard.find(), myboard = 모델 이름
    model: 'myboard',
    //어느 필드에서 값이 올라갈지
    field:'seq',
    //첫숫자
    startAt : 1,
    //얼마씩 올라갈 건지 
    increment : 1,

});


module.exports = mongoose.model('myboard', boardSchema);