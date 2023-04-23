
# Product Catalog
A product catalog is a website where users can log in to view product details and check the delivery status of their orders.

# Steps to run project
Clone project

1. Steps to run product-catalog backend
- install JDK
- install Maven
- Maven -> Update Project
- install MySQL server and MySql workbench
- Using MySQL, create database "productdb"
- Run as Spring Boot Project (Running at PORT - 9099)

2. Steps to run Products-Catalog Frontend
- install nodeJs
- open in vs code or your editor
- run command "npm install"
- run command "ng server"


# API'S
- SignUp http://127.0.0.1:9099/user/
- Login(Geneate Token) http://127.0.0.1:9099/token
- Product http://127.0.0.1:9099/token/products/
- Product Details http://127.0.0.1:9099/products/detail/{id}
- Product Delivery http://127.0.0.1:9099/deliverable/{productId}/{pincode}
- Search http://127.0.0.1:9099/products/{keyword}
- Logout http://127.0.0.1:9099/products/{keyword}
