# Learning Navigator



## Introduction

This is a RESTful API service using Spring Boot to manage the exam enrollment process for a Learning Management System (LMS). It uses MySQL to persist the data.



## Features

- CRUD operations in RDBMS table
- Enrollment of Students in Subjects and Exams
- Handling various exceptions
- Basic testing through Mockito


## Installation



### 1. Add repository
```
git clone [repository]
```


### 2. Add dependencies
```
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.mysql:mysql-connector-j'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
```

### 3. Configuration 
```
spring.application.name=navigator
spring.datasource.url=jdbc:mysql://localhost:3306/navigator
spring.datasource.username=<userid>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
```


### 4. Run softwares
```
- Java 21
- MySQL
- Gradle
``` 


### 5. Execute
```
./gradlew test
./gradlew build
./gradlew bootrun
```


**The server will start and be accessible at http://localhost:8080**

___