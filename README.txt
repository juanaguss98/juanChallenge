Welcome!

On this ReadMe, i'll briefly explain some aspects of this challenge.

----------------------
PREREQUISITES
----------------------

	. Java 11
	. Whatever IDE you like (I used IntelliJ)
	. Whatever browser you like

----------------------
FIRST STEPS
----------------------

	1) Clone the repository on a folder.

	2) Once cloned, open 'pom.xml' with an IDE.

	3) Build and run the application.

----------------------
DESCRIPTION
----------------------

	This application is composed by three parts: 
	. The source code per se.
	. A local volatile database (h2 db).
	. Swagger UI implementation and documentation.

	
	[THE SOURCE CODE]
		The source code was made using java 11 on spring boot framework with some Maven dependencies (you can check pom.xml to see in detail which are used) 
		and contains the entire project. Altough is not accurate to refer on this as a separate component, I think is necessary to explain how the backend works.
		About the structure, you can see is composed of different packages and a main class called "JuanApplication". I'll explain briefly what is inside every package:
			
			audit: Contains the audit classes from hibernate-envers, which allow us to track every transaction and movement on the database.

			config: Contains different configuration classes to manage the persistance of audit, tha correct work of swagger and the CORS configuration for the API.

			controller: Contains the only controller of the application, that is responsible of reciving request from the client and answering.

			dto: Contains a lone Data Transfer Object. It's not used on the application because is not necessary, but I added it there because DTOs are an essential
			tool on other situations (mainly when the client-side data structure is not the same to the server-side structure)

			exception: Contains the handler of exceptions and a custom error model.

			model: Contains the datamodels of the application. In this case is only Trainer, which is persisted on a database using JPA.

			repository: Contains the repositorys of the application. Again in this case is only used to manage all querys which involve the Trainer object.

			service: Contains the services and interfaces of the application. 


	[THE DATABASE]
		The database used in this application is h2 database, which is a local volatile database. However, this can be changed in the future just by modifying the 
		application.properties file, where the connection, credentials, and other stuff are defined. Below there are some instructions on how to open the database.
			
			1) Run the application.

			2) While it's running, open a tab in a browser and type 'http://localhost:8080/h2-console' (without quotes).

			3) On the window that popped, fill the JDBC URL field with 'jdbc:h2:./data/db' (without quotes) if its the first time you open it, username is 'sa' 
			and password is 'password' and click 'Connect'. Credentials can be changed on application.properties.

		Once in the database, you will see three tables:

			REVINFO contains a registry of every movement on the base with a timestamp. The movements are definde by a numerical code (see more on https://docs.jboss.org/envers/docs/)

			TRAINER contains all the trainers with some additional information.

			TRAINER_AUD contains a combination of REVINFO and TRAINER to check how Trainers have been modified.

	[SWAGGER]
		Swagger is used in the application to graphically see the endpoints with a brief documentation and test said endpoints. Access to swagger is quite simple:

			1) Run the application.

			2) While it's running, open a new tab and type 'http://localhost:8080/swagger-ui.html#'.

		Once in the UI, you can check the datamodel and the behavior of the APIs

------------------------
WHAT I WOULD HAVE ADDED
------------------------

	Given resources and time, this is truly the best I could've done. However, there are some things that I would've liked to add (I never used most of them):

	.Docker: I tried my best to implement it, but as I'm using Windows to make this application it suddenly became a huge problem and a waste of time, mainly because of the Linux 
	kernel I had to use.

	.A cloud database: Another thing that I tried was to call an Azure database, but the problem was that I would have to manually whitelist your IP adress in order for you to connect to it, 
	which for security reasons is a no-no.

	.Security: Altoug it's essential, when I tried to implement security dependencies which I never used it became a fact that it would bring more problems than answers. 
	I also decided to let it aside because in a real-world situation it's something that needs to be done only once (at least from my experience).

	.Testing: To be honest, I really wanted to implement some unitary testing but I used time in other features that I touht were more important.

	.Angular FrontEnd: I really like Angular and I was tempted to use it, but the task was to only produce two REST API endpoints, so it became something secondary to the objective.

---------------
CONCLUSSION
---------------
	To be honest, I learnt a lot during this challenge, and I also realized that the work I've been doing during the last year on my current company could be gratly improved by some practices, 
	so besides the result of this challenge is, I do appreciate the opportunity to do this, as it makes me a better developer.

	Best, 
	Juan.


			
		



