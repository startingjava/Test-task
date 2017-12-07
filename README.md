Stack of technologies:
- Java 8
- Gradle
- Spring boot
- Spring data + hibernate
- Spring security
- MySQL
- JUnit/Mockito

The application is launched from the Main class. The database is automatically created and filled with data.
GET requests do not require authorization. PUT and POST requests require authorization 
(via postman: Authorization tab - Basic Auth. Username: admin, Password: admin).
Request examples:
For Authors

Get all authors
Postman: GET localhost:8080/authors/  
    
Get author by id
Postman: GET localhost:8080/authors/1

Endpoint short info
Postman: GET localhost:8080/authors/info/short/3
          
Create author
Postman: POST localhost:8080/authors/
  {
          "lastName": "Perry",
          "firstName": "Alex",
          "sex": "male",
          "birthDate": "1990-11-11",
          "books": [],
          "rewards": []
  }  

                   
Update author
Postman: PUT localhost:8080/authors/
 {
        "lastName": "Carter",
        "id": 1,
        "firstName": "John",
        "sex": "male",
        "birthDate": "1966-11-11",
        "books": [],
        "rewards": []
 }

                                    
For Books

Get all Books
Postman: GET localhost:8080/books/  

Get book by id
Postman: GET localhost:8080/books/1
             
Create book
Postman: POST localhost:8080/books/
{
        "title": "War and Peace",
        "isbn": "123456789",
        "genre": "scientific",
        "authors": []
}  

Update book
Postman: PUT localhost:8080/book/
 {
         "title": "War and War",
         "id": 1,
         "isbn": "123456789",
         "genre": "scientific",
         "authors": []
 }              

    