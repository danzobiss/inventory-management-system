
<h1 align="center">
  <br>
  Inventory Management System
  <br>
</h1>

<h4 align="center">A CRUD RESTFul API created for managing products in inventory.</h4>

<p align="center">
  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/danzobiss/inventory-management-system?color=%23b70ac7">
  <img alt="Repository size" src="https://img.shields.io/github/repo-size/danzobiss/inventory-management-system">
  <a href="https://github.com/danzobiss/inventory-management-system/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/danzobiss/inventory-management-system?color=%23ff1c1c">
  </a>
   <a href="https://github.com/danzobiss/inventory-management-system/stargazers">
    <img alt="Stargazers" src="https://img.shields.io/github/stars/danzobiss/inventory-management-system?style=social&color=%23ff1c1c">
  </a>
</p>
<p align="center">
  <img alt="Java badge" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
  <img alt="Spring badge" src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
  <img alt="Spring Boot badge" src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
  <img alt="Hibernate badge" src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white">
  <img alt="Apache Maven badge" src="https://img.shields.io/badge/Apache Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white">
  <img alt="Swagger badge" src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white">
</p>

<p align="center">
  <a href="#-key-features">Key Features</a> •
  <a href="#-how-to-use">How To Use</a> •
  <a href="#-endpoints">Endpoints</a> •
  <a href="#-project-structure">Project Structure</a>
</p>

## 🔑 Key Features

* Products
  - Create, Read, Update and Delete products in database
  - Filters products based on the specified category
* Category
  - Create, Read, Update and Delete categorys in database
* Validates sent request body
* Uses the Template Method design pattern to organize the code
* It uses the Adapter design pattern to adapt the entity according to the request body and vice versa
* Error handling for 
* Swagger UI for documentation

## ⚙ How To Use

To clone and run this application, you'll need [Git](https://git-scm.com) and [Apache Maven](https://maven.apache.org/download.cgi) (which comes with [mvn](https://mvnrepository.com)) installed on your computer. From your command line:

```bash
# Clone this repository
$ git clone https://github.com/danzobiss/inventory-management-system.git

# Go into the repository
$ cd inventory-management-system

# Install dependencies
$ mvn clean install

# Run the app
$ mvn spring-boot:run

# The application will be started at [http://localhost:8080]
```

> **Note**
> If you're using Linux Bash for Windows, [see this guide](https://www.howtogeek.com/261575/how-to-run-graphical-linux-desktop-applications-from-windows-10s-bash-shell/) or use `maven` from the command prompt.


## 📡 Endpoints

### Products
```http
// Gets all products and can be filtered by category
GET /api/products?categoryId=
```
```http
// Gets product specified by id
GET /api/products/{id}
```
```http
// Creates product
POST /api/products
```
```http
// Updates product specified by id
PUT /api/products/{id}
```
```http
// Deletes product specified by id
DELETE /api/products/{id}
```

### Categories
```http
// Gets all categories
GET /api/categories
```
```http
// Gets category specified by id
GET /api/categories/{id}
```
```http
// Creates category
POST /api/categories
```
```http
// Updates category specified by id
PUT /api/categories/{id}
```
```http
// Deletes category specified by id
DELETE /api/categories/{id}
```

## 🗂️ Project Structure

The project is structured as follows:

```output
src/
└── main/
    ├── java/
    │   └── com/
    │       └── danzobiss/
    │           ├── config/ # Contains the project configuration classes
    │           ├── controller/ # Contains the controller classes (REST endpoints)
    │           ├── entity/ # Contains JPA entities
    │           ├── exception/ # Contains custom exception classes
    │           ├── repository/ # Contains the repository interfaces
    │           ├── request/ # Contains DTO (Data Transfer Objects) classes for request
    │           ├── service/ # Contains the service classes
    │           └── util/ # Contains the util classes
    └── resources/
        ├── application.properties # Application properties file
        └── data.sql # SQL scripts for database initialization
```
