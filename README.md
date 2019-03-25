# MyRetail
This project is all about consuming a rest api.
It will take product title from the given URI and add the price and product from database.
I have used mongodb database to store the values.

# Endpoints and their usage
http://localhost:8080/: it will display the info of the application by redirecting to the URL http://localhost:8080/actuator/info.   
http://localhost:8080/products: It will return all the products information that are saved.   
http://localhost:8080/products/{id}: It will return product information of the particular id that is given.  
http://localhost:8080/products?price=value: It is a put method used to update the price of the product of given id.  


