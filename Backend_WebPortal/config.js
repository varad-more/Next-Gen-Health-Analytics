var config = {};


//Config file with 

config.server = {};
config.server.port = 3000;


config.fields = {};

config.fields.id = "id";
config.fields.FirstName = "first_name";
config.fields.LastName = "last_name";
config.fields.age = "age";
config.fields.gender = "gender";
config.fields.state = "state";
config.fields.email = "email";
config.fields.password = "password";
config.fields.pincode = "pinCode";
config.fields.RegNumber = "RegNumber";

config.error = {};

config.error.DuplicateKeyError = "BulkWriteError";
config.error.DuplicateKeyErrorCode = 11000;
config.error.ValidationError = "ValidationError";

config.responseHead = {};

config.responseHead.ContentType = "Content-Type";
config.responseHead.applicationJSON = "application/JSON";

config.default = {};

config.default.sort = "id";
config.default.page = 1;
config.default.limit = 5;
config.default.findAll = {};

config.db = {};
config.db.host = "localhost";
config.db.name = "docUsers";

module.exports = config;

var responseHead = {}
