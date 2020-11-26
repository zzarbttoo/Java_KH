const { publicDecrypt } = require('crypto');
var express = require('express');
const { get } = require('http');
var app = express();


var data = {name : 'Rest API'};

app.get('/', function(req, res){

    //res.end('');
    // response.json : 인수로 받은 javascript object를 
    // 자동으로 json으로 반환해서 response 해준다
    res.json({data : data});
    
});

//Insert
app.post('/', function(req, res){

});

//update
app.put('/', function(req, res){
    
});

//delete
app.delete('/', function(req, res){
    
});

app.listen(3000, function(){
    console.log('server started');

});