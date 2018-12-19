1. Steps to create Database and table name through console:

	Step 1.1: Create database. 
		create database glaucus_db;
	Step 2.1: Connect to created database to create table and initialize value for one of column 
		use glaucus_db;
		create table Number(id integer);
		insert into Number values(0);
	
2. Steps to specify database and table name in YAML file by opening WAR / JAR file
	
	1. Step if wants to run this App using JAr file (here no need to deploy jar in web server)
		
			Step 1.1 : Open "GlaucusRest_BootProject-0.0.1-SNAPSHOT.jar" through open archive option by clicking right.
			Step 1.2 : Open "BOOT-INF -> classes -> application.yml"
					Step 1.2.1 : After opening "application.yml" in an editor, if you are using Postgresql as database, 
					   		then change name of database of dev->db hierarchy from springdb (given by default last part of url) to glaucus_db (newly created db as above).
					   		and change username, password and table name (above we created Number table).
					Step 1.2.2 :If you are you using MySQL as database
							1.2.2.1 : Under prod->db->url, changes glaucus (default MySql database in my project) to glaucus_db (above created).
							1.2.2.2 : Change username, password and table name (Number has been created above) accordingly.

			
	2. Steps if wants to deploy WAR file.
			Step 2.1 : Open "GlaucusRest_BootProject-0.0.1-SNAPSHOT.jar" through open archive option by clicking right.
			Step 2.2 : Open "WEB-INF -> classes -> application.yml"
				Step 1.2.1 : After opening "application.yml" in an editor, if you are using Postgresql as database, 
					   		then change name of database of dev->db hierarchy from springdb (given by default last part of url) to glaucus_db (newly created db as above).
					   		and change username, password and table name (above we created Number table).
					Step 1.2.2 :If you are you using MySQL as database
							1.2.2.1 : Under prod->db->url, changes glaucus (default MySql database in my project) to glaucus_db (above created).
							1.2.2.2 : Change username, password and table name (Number has been created above) accordingly.

							
							
							
							
3. To run JAR file :
	Step 1: Execute following command in the terminal
			java -jar path/of/Jar/file, then press enter
	Step 2: Point your browser to "localhost:8080/glaucus", it will show current number, whenever user will request for localhost:8080, number will get increase.
	
	
4. To run WAR :
	Step 1 : deploy given WAR into Web server.
	Step 2 : point your browser to "localhost:8080/glaucus", it will show current number, whenever user will request for localhost:8080, number will get increase.
	
							
That's it... Thanks :)
							
							
							
														