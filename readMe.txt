I did this project in Intelij idea.

The whole logic of the project was done in com.passangerapp.demo package. In that package i have created several more which all of them have some function.

Classes:
PassangerController-> That's a API controller class which task is to handle incoming HTTP requests(get,post,put,delete).
SQLiteDialect-> Class which defines our database.
Passanger -> Our model class which contains attributes,getters,setters,constructors and toString method.
PassangerRepository-> Its a JPARepository class where we pass our Passanger class and primary key. Through this class we can get do all the manipulation with the database.
PassangerService-> Service class which contains the implementation logic of http requests.

Application was tested in Postman.

Logic was implmeneted in the next way:
-For retrieving all passangers(GET) and for adding a new one(Post), a route that is defined for it is: api/passanger. Since this is ran locally, the whole route is: http://localhost:8080/api/passanger.
-For delete request(DELETE) or retrieving specific passanger, a route that is defined for it is: api/passanger/passportId, where passportId is some number of our attribute passportId.
-If a PUT request(update) is being made then it should be done by adding attributes in Body and in json format in Postman. The attribute required is passportId of existing passanger and some other or all parameters we want to change. 
-If adding is being requested and if there is already a passanger with the same passportId in database, then the adding wont be executed.
-If deleting/updating unexisting passanger is being requested, then an error will appear.

