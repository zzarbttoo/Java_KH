var http = require('http');
//서버에서 요청을 받았을 때 할 일을 미리 정해준 것
//서버에서 요청을 받을 때 호출 될 함수
var server = http.createServer(function(require, response){
    response.end('hello world');
});

server.listen(3000);