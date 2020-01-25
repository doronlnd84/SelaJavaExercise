# SelaJavaExercise
Java exercise for Sela - restApi 

1.  The teplate types are Birthday and NewYear. Both are classes inverit from 'Template' abstract class
2.  Validation and creation was implemented by 'reflection'  for reuse code. 
3.  The code was tested by Postman app
4. examples-
    POST/PUT: http://localhost:8080/greetingCard/create/newyear?recipient=dani&content=sdfsdf&year=2020
              http://localhost:8080/greetingCard/create/birthday?recipient=dani&content=sdfsdf&age=20
   catalog GET:           http://localhost:8080//greetingCard/catalog
