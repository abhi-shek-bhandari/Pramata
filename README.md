# Pramata

# To Run the Project Open IntelliJ and your system must have mysql and jdk 17 installed

# Now after opening the Project open the application.properties file which is inside the resources named folder and change the username and password 

spring.datasource.url=jdbc:mysql://localhost:3306/community <- change the community to the database base name your system has or you can create one 
spring.datasource.username=root <- change this
spring.datasource.password=root  <- change this

# now open the java folder file name CommunityApplication.java will be present open it and there will be a green arrow button on top and the project will be up and running

# now open the browser and type in the url section "http://localhost:5000/swagger-ui/index.html" and now you will be able to use the app with gui of swagger.