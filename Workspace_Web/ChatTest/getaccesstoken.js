var axios = require('axios');

/*
axios({
    url: "https://api.iamport.kr/users/getToken",
    method: "post", // POST method
    headers: { "Content-Type": "application/json" }, // "Content-Type": "application/json"
    data: {
      imp_key: "6694523600738736", // REST API키
      imp_secret: "0UvFDeDhRzHpP43Q9Nd1wyHZSn7CwwhwrNc41PmTp3je8n5hajjGR0GJoOmUlErMrDQttdmSgF7o3cGd" // REST API Secret
    }
  }).then(function(response){
	
	  console.log(response);
	console.log(response.access_token);
	console.log(response.now);
	console.log(response.expired_at);
	
}); */
axios({
    url: "https://api.iamport.kr/payments/imp_448280090638",
    method: "get", // GET method
    headers: {
      "Content-Type": "application/json", // "Content-Type": "application/json"
      "Authorization": "Bearer e2453e29f4acc1109a4a727658a43c6db9ad1aea" // 발행된 액세스 토큰
    }
  }).then(function(response){
	  
	  console.log(response);
	  
  });

