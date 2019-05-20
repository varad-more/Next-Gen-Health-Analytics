# Smart India Hackathon
## Set-Up

```
npm install mongoose
npm install express
npm install body-parser
```
Bring up a MongoDB server instance using the following command:

```
mongod
```
Switch to the directory where you cloned the project and run the following:

```
nodejs app.js
```

This will bring up the server on port 3000 of your localhost.

Make the following GET request **only once** to intialize the database with the entry of doctors given in **doctors.json** file:

```
http://localhost:3000/api/doctors/setUp
```
It'll create a new doctor with Username "12345" and password "password".
### Users Schema
The below schema is used for the users collection
```
var doctorSchema = new schema({
     
   first_name: {type:String, required: true},
   last_name: {type:String, required: true},
   regNumber: {type:String},
   state:{type:String},
   pincode:{type:Number},
   password:{type:String}
});


```
The APIs in the specification adhere to the constraints posed by this schema.
Eg:
A post request to add an document without any of the *required: true* fields will not be accepted.

Now you can make request to this server using any REst client!
Please make sure that in the PUT and POST request the body contains the document as a JSON.f therequired: true fields will not be accepted.

Now you can make request to this server using any REst client! Please make sure that in the POST request the body contains the document as a JSON.

Appropriate Success and Error codes are sent from the API.

for any correspondence send a mail:
tomarshubham@gmail.com