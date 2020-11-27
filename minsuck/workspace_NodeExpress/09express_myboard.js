var express = require('express');
var mongoose = require('mongoose');

var Board = require('./myboard');
var app = express();

var cors = require('cors');

app.use(express.json());
app.use(express.urlencoded());
app.use(cors());
mongoose.connect("mongodb://localhost:27017", function(err) {
    if(err) {
        console.error(err);
        return;
    }
    console.log("mongodb connect success");
});

app.get('/list', function(req, res){

    Board.find(function(err, result){

        if(err){
            console.error(err);
            return res.status(500).json({success:false});

        }
        res.json({success:true, list:result});
    });
});


app.get('/detail/:seq', function(req, res){


    Board.findOne({seq:req.params.seq}, function(err, result){

        if(err){
            console.error(err);
            return res.status(500).json({success:false});
        }
        res.json({success:true,data:result});
    });

 
});


app.post('/insert', function(req, res){

    var newBaord = new Board({

        name:req.body.name,
        title:req.body.title, 
        content:req.body.content,

    });

    newBaord.save(function(err, product){

        if(err){
            console.error(err);
            return res.status(500).json({success:false});
        }

        res.json({success:true, seq:product.seq});

    });
});

app.put('/update', function(req, res){

    Board.updateOne({seq:req.body.seq}, 
        {title:req.body.title, content:req.body.content}, 
        function(err, raw){
            if(err){a
                console.error(err);
                return res.status(500).json({success:false});
            }

            res.json({success:true});
        });
});

//delete method 가 따로 body를 갖지 않기 때문에 이렇게 보내줘야함
app.delete('/delete/:seq', function(req, res){

    Board.deleteOne({seq:req.params.seq},
        function(err){
            if(err){
            console.error(err);
            return res.status(500).json({success:false});
            }
            res.json({success:true});
        });


});

app.listen(3001, function() {
    console.log("server started");
});


