# swproject

//Steps to allow this project work on your PC:
//download spring tool suite 
//create a maven project 
//include these dependancies in your pom.xml
  <parent> 
  	<groupId>org.springframework.boot</groupId> 
  	<artifactId>spring-boot-starter-parent</artifactId> 
  	<version>2.0.5.RELEASE</version> 
  </parent>
  	
 // <dependencies> 
  
  	<dependency> 
  		<groupId>org.springframework.boot</groupId> 
  		<artifactId>spring-boot-starter-web</artifactId> 
  	</dependency> 
  	<dependency>
    	<groupId>org.springframework.boot</groupId>
    	<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
	<dependency>
    	<groupId>org.apache.tomcat.embed</groupId>
    	<artifactId>tomcat-embed-jasper</artifactId>
    	<scope>provided</scope>
	</dependency>
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>
    <dependency>
    	<groupId>org.apache.tomcat.embed</groupId>
    	<artifactId>tomcat-embed-jasper</artifactId>
    	<scope>provided</scope>
	</dependency>
	<dependency>
    	<groupId>javax.servlet</groupId>
    	<artifactId>jstl</artifactId>
	</dependency>
        
 // </dependencies>
  
  
 // -include this library to your referanced library
//C:\Users\MOHAMED\Downloads\lib\lib\json-20180813.jar

//to use the functionality of the recommender

//get all recommended users for specific company :http://localhost:8080/users 

//get all recommended companies for specific user :http://localhost:8080/company

//get all recommended quizes for specific user :http://localhost:8080/quiz

//get all recommended candidates for specific company acording
 //to a formula :	http://localhost:8080/sortedcandidates
