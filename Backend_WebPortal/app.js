var express = require('express');
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var config = require('./config');
var validate = require("./validator.js");
var fs = require("fs");
var Excel = require("exceljs");

var docUser = require('./Models/doctor.js');

var app = new express();

var ThingSpeakClient = require('thingspeakclient');

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));

mongoose.connect('mongodb://' + config.db.host + "/" + config.db.name);


app.get("/api/doctors/setUp", function(request, response) {
  fs.readFile("doctors.json", function(err, data) {
    var array = JSON.parse(data);
    for (var i = 0; i < array.length; i++) {

      var new_doctor = new docUser(array[i]);

      new_doctor.save(function(err) {
        if (err)
          console.log(err);
      });
    }
});

app.get('/api/doctors/dataAnalytics', function(req, res) {
	console.log("Flow reaching!!");
  res.sendFile("../FrontEnd/try1.html");
});

app.get('/api/doctors/singlePage', function(req, res) {
	console.log("Flow reaching!!");
  res.sendFile("../FrontEnd/pat.html");
});

app.get('/api/doctors/bulkPage', function(req, res) {
	console.log("Flow reaching!!");
  res.sendFile("../FrontEnd/pat1.html");
});

app.get('/api/doctors/home', function(req, res) {
	console.log("Flow reaching!!");
  res.sendFile("../FrontEnd/index.html");
});

app.post("/api/doctors/signup", function(req, res) {
   console.log("Call reaching!");
   var obj = req.body;
   console.log(obj);
   delete obj['contactNo'];
   delete obj['CnfPassword'];
   console.log(obj);		
   var new_doctor = new docUser(obj);
   new_doctor.save(function(err)
   {
   		if(err)
   		{
   			console.log(err);
   		}
   });
   res.end("Data Added!");

});
	
app.post("/api/doctors/signin", function(req, res)
{
	console.log('Sign In Request');	
	var obj = req.body;
	var reg_number = obj.Username;
	console.log(obj);
	var input_password = obj.Password;

	
	console.log("Creating filters");
	var filter = {regNumber: reg_number}; 
	console.log(filter);
	docUser.findOne(filter, 'password', function function_name(err, docs) {
		console.log(docs);
		

		if (docs && docs.password == input_password)
		{
			//res.writeHead(200);
			res.redirect("/api/doctors/singlePage");
		}else
		{
			res.writeHead(400);
			res.end("Bad Credentials");
		}
	});

});

app.post("/api/doctors/uploadXL", function(req, res){
	console.log("Call reaching uploadXL!!");
	var workbook = new Excel.Workbook();
	console.log(workbook);
	workbook.xlsx.readFile("673001.xlsx").then(function() {
		var worksheet = workbook.getWorksheet('Sheet6');
		var row = worksheet.getRow(1);
		console.log("worksheet opened!");
		console.log("Row 1 = " + row.values);

		var client = new ThingSpeakClient();
		var channelId = 717702;
		//var input= {'field1':2, 'field2':100, 'field3':"Female", 'field4':"TN", 'field5':"Dengue"};


		client.attachChannel(channelId,{writeKey:"L7ZNPRXCYVWMMV6S"});

		worksheet.eachRow({
			includeEmpty : false
		}, function(row, rowNumber)
		{	
			var array = row.values;
			array = array.slice(3);
			//console.log("Array " + 	array);
			var json = {}
			

			json["field1"]=array[0];
			json["field2"]=array[1];
			json["field3"]=array[2];
			json["field4"]=array[3];
			//console.log(json);
			//console.log(util.inspect(row, {showHidden: false, depth: null}));
			
					
			client.updateChannel(channelId, json, function(err, resp) {
			    if (err)
			    {
			    	console.log("Error : " + err);
			    }
			    if (!err && resp > 0) 
			    {
			        console.log('update successfully. Entry number was: ' + resp);
			    }
			});

		});
	});
	res.end("Done!");
});

app.post("/api/doctors/updateChannelSingle", function(req, res) {
	console.log("Call reaching");
	var client = new ThingSpeakClient();
	var channelId = 717702;
	var input = {};
	input["field1"] = req.body.field1;
	input["field2"] = req.body.field2;
	input["field3"] = req.body.field3;
	input["field4"] = req.body.field4;
	console.log(input);
	client.attachChannel(channelId,{writeKey:"L7ZNPRXCYVWMMV6S"});
	client.updateChannel(channelId, input, function(err, resp) {
	    if (err)
	    {
	    	console.log("Error : " + err);
	    }
	    if (!err && resp > 0) 
	    {
	        console.log('update successfully. Entry number was: ' + resp);
	    	res.writeHead(200)
	    	res.end("Data Uploaded successful");
	    }
	});
});

app.listen(config.server.port, function() {
  console.log("Server listening on " + config.server.port);
});