# swproject

//To make the program work on your PC :
// - download Spring boot tool suite.
// - create a maven project
// - include these dependancies in the pom.xml file 
  <parent> 
  	<groupId>org.springframework.boot</groupId> 
  	<artifactId>spring-boot-starter-parent</artifactId> 
  	<version>2.0.5.RELEASE</version> 
  </parent>
  	
  <dependencies> 
  
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
        
  </dependencies>
  
  
  <build> 
  	<plugins> 
  		<plugin> 
  			<groupId>org.springframework.boot</groupId> 
  			<artifactId>spring-boot-maven-plugin</artifactId>
  		</plugin> 
   	</plugins> 
   </build>
   <properties> 
   		<java.version>1.8</java.version> 
   </properties>
 - include this jar file to the library C:\Users\MOHAMED\Downloads\lib\lib\json-20180813.jar as referanced library
 -create classes with the same name in this git repo.
 -excecute the program by launching the buttom in spring boot prog.

//to use the functionality of the recommender

//get all recommended users for specific company :http://localhost:8080/users 

//get all recommended companies for specific user :http://localhost:8080/company

//get all recommended quizes for specific user :http://localhost:8080/quiz

//get all recommended candidates for specific company acording
 //to a formula :	http://localhost:8080/sortedcandidates
