var mongoose = require('mongoose');
var schema = mongoose.Schema;
var paginate = require('mongoose-paginate');

var counterSchema = new schema({
  _id:{type:String, required:true},
  seq:{type:Number, default:0}
});

var counterModel = mongoose.model('counter',counterSchema );

var doctorSchema = new schema({
     
   first_name: {type:String, required: true},
   last_name: {type:String, required: true},
   regNumber: {type:String},
   state:{type:String},
   pincode:{type:Number},
   password:{type:String}
});

/*
doctorSchema.pre('save', function(next){
    console.log("Line 26")
    var doc = this;
    console.log(counterModel);
    counterModel.findByIdAndUpdate({_id:'user_count'}, {$inc: {seq : 1}}, function(error, counter){
      if(error)
      {
         console.log("Error updating counter" + error);
         return next(error);
      }

      doc._id = counter.seq;
      next();
  });

    var input_id = doc.id;
    doc._id = input_id;
    next();


});
*/
var doctor = mongoose.model('doctors', doctorSchema);
module.exports = doctor;
