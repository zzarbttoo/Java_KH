const {default : Axios} = require('axios');

Axios.get('/http://localhost:3000/list').then(function(value){
    console.log(value);
});

