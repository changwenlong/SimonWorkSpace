//app.js文件
var express = require('express');
var app = express();

//指定更目录显示的内容
app.get('/', function(req, res){
  res.send('Hello World');
});

//指定监听端口
var server = app.listen(3000, function() {
    console.log('Listening on port %d', server.address().port);
});