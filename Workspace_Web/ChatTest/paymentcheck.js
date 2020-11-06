
const { Iamporter, IamporterError } = require('iamporter');
// For Production
const iamporter = new Iamporter({
  apiKey: '6694523600738736',
  secret: '0UvFDeDhRzHpP43Q9Nd1wyHZSn7CwwhwrNc41PmTp3je8n5hajjGR0GJoOmUlErMrDQttdmSgF7o3cGd'
});


var cors = require('cors');
var express = require('express');
var bodyParser = require('body-parser');
var app = express();
var imp_uid = null;
var amount = null;
var isRight = 'R';
var confirmObject = null;
var serveramount = null;

app.use(bodyParser.urlencoded({extended: true}));
app.use(bodyParser.json());

// post 방식으로 받는 라우터
app.post('/aaa' , (req, res) => {
	
	// request
	console.log(req.body);
	imp_uid = req.body.imp_uid;
	console.log('imp_uid req' + imp_uid);
	amount = req.body.amount;
	
	// imp_uid를 집어넣어 서버로부터 값을 읽어옴
	findbyimpuid(imp_uid);
	
	res.send(isRight);
	
});


iamporter.getToken().
then(function(response){
	console.log('gettoken');
	console.log(response);
});


function findbyimpuid(Imp_uid){
	iamporter.findByImpUid(Imp_uid).
	then(function(response){
		confirmObject = eval(response);
		console.log(confirmObject);
		console.log(typeof(confirmObject));
		
		console.log(confirmObject.data.amount);
		serveramount = confirmObject.data.amount;
		
		isRight = isTrue(serveramount, amount);
	});
}

function isTrue(serveramount, realamount){
	
console.log('serveramount' + serveramount);
console.log('amount'  + realamount);
	if(realamount != serveramount){
		isRight = 'W';
	}
	console.log(isRight);
}

var server = app.listen(9999, function() {
	console.log('Experss server started a port 9999');
});