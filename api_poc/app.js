// BASE SETUP
// =============================================================================

// call the packages we need
var express = require('express'); // call express
var app = express(); // define our app using express
var bodyParser = require('body-parser');
var mongoose   = require('mongoose');
mongoose.connect('mongodb://:@localhost:27017/testApiFile'); // connect to our database
var File = require('./models/file');

// configure app to use bodyParser()
// this will let us get the data from a POST
app.use(bodyParser());

var port = process.env.PORT || 8080; // set our port

// ROUTES FOR OUR API
// =============================================================================
var router = express.Router(); // get an instance of the express Router

// middleware to use for all requests
router.use(function(req, res, next) {
	// do logging
	console.log('Something is happening.');
	next(); // make sure we go to the next routes and don't stop here
});

// test route to make sure everything is working (accessed at GET
// http://localhost:8080/api)
router.get('/', function(req, res, next) {
	res.json({
		message : 'hooray! welcome to our api!'
	});
});

// more routes for our API will happen here

// on routes that end in /files
// ----------------------------------------------------
router.route('/files')
// create a file (accessed at POST http://localhost:8080/api/files)
		.post(function(req, res) {		
			var file = new File(); // create a new instance of the File model
			file.name = req.body.name; // set the files name (comes from the request)
		
			// save the file and check for errors
			file.save(function(err) {
				if (err)
					res.send(err);
		
				res.json({
					message : 'File created!'
				});
			});
		})
		//get all the files (accessed at GET http://localhost:8080/api/files)
		.get(function(req, res) {
			File.find(function(err, files) {
				if (err)
					res.send(err);
		
				res.json(files);
			});
		});

//on routes that end in /files/:file_id
//----------------------------------------------------
router.route('/files/:file_id')
	// get the file with that id (accessed at GET http://localhost:8080/api/files/:file_id)
	.get(function(req, res) {
		File.findById(req.params.file_id, function(err, file) {
			if (err)
				res.send(err);
			res.json(file);
		});
	})
	// update the file with this id (accessed at PUT http://localhost:8080/api/files/:file_id)
	.put(function(req, res) {

		// use our file model to find the file we want
		File.findById(req.params.file_id, function(err, file) {

			if (err)
				res.send(err);

			file.name = req.body.name; 	// update the files info

			// save the file
			file.save(function(err) {
				if (err)
					res.send(err);

				res.json({ message: 'File updated!' });
			});

		});
	})
	
	// delete the file with this id (accessed at DELETE http://localhost:8080/api/files/:file_id)
	.delete(function(req, res) {
		File.remove({
			_id: req.params.file_id
		}, function(err, file) {
			if (err)
				res.send(err);

			res.json({ message: 'Successfully deleted' });
		});
	});

// REGISTER OUR ROUTES -------------------------------
// all of our routes will be prefixed with /api
app.use('/api', router);

// START THE SERVER
// =============================================================================
app.listen(port);
console.log('Magic happens on port ' + port);