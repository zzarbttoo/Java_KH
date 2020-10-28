var express = require('express');
var app = express();
var http = require('http').Server(app);

var request = require('request');
const convert = require('xml-js');
var bodyparser = require('body-parser');

//app.use(bodyparser.json());
//app.unsubscribe(bodyparser.urlencoded());

var xmlTojson = null;
var jsonToObject = null;

var cowwhere = {};
var pigwhere = {};
var chickenwhere = {};
var keyname= '';
var last = 0;
for(var j = 1; j < 15; j++){


    var url = 'http://apis.data.go.kr/1543000/FarmService/getFarmCategoryStatInfo';
    var queryParams = '?' + encodeURIComponent('ServiceKey') + '=Cs%2B%2FttyigCPsJ%2FJlwnLzps%2B2XP1Ol4EQmpZ2Jzt5S0B%2Fne4ZOYKUem1dtcO%2BOyBKXoouQTWwvxgl2rwpxf9xvA%3D%3D'; /* Service Key*/
    //페이지는 14(693)이 max
    queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent(j); 
    queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('1000'); 
    parseApi();

}


function parseApi(){
request({
    url: url + queryParams,
    method: 'GET'
}, function (error, response, body) {

    xmlTojson = convert.xml2json(body, {compact : true, spaces : 4});
    jsonToObject = JSON.parse(xmlTojson);
    //console.log(jsonToObject.response.body.items.item[0].farm_co);
    last += 1;
    for(var i = 0; i <jsonToObject.response.body.items.item.length; i++){
    
        whereleave = jsonToObject.response.body.items.item[i].ctprvn_nm._text + ' ' + jsonToObject.response.body.items.item[i].sigungu_nm._text +' ' + jsonToObject.response.body.items.item[i].emd_nm._text;
        howmany = jsonToObject.response.body.items.item[i].farm_co._text;
        
        //json String에 연결
        //소
        if(jsonToObject.response.body.items.item[i].lvstck_nm._text == '소'){

            //주소 출력
            //console.log(whereleave);
            //console.log(jsonToObject.response.body.items.item[i].farm_co._text);
            cowwhere[keyname + whereleave] = howmany;


        }else if(jsonToObject.response.body.items.item[i].lvstck_nm._text == '닭'){

            //console.log(whereleave);
            //console.log(jsonToObject.response.body.items.item[i].farm_co._text);
            chickenwhere[keyname + whereleave] = howmany;

        }else if(jsonToObject.response.body.items.item[i].lvstck_nm._text == '돼지'){
            //console.log(whereleave);
            //console.log(jsonToObject.response.body.items.item[i].farm_co._text);
            pigwhere[keyname + whereleave] = howmany;

        }

    }

    if(last == 14){

        console.log(cowwhere);
        console.log(Object.keys(cowwhere).length);
        console.log(pigwhere);
        console.log(Object.keys(pigwhere).length);
        console.log(chickenwhere);
        console.log(Object.keys(chickenwhere).length);

    }

    
});
}



app.post('/aaa', function(req, res){

    res.send(chickenwhere);
    //res.send(cowwhere);
    //res.send(pigwhere);
});


http.listen(3000, function(){

    console.log('listening...');
});
