# tempest
Team Git Good's Sky Software Engineering Academy group project. "GetYourWay.com" travel web app.

to clone the repo, use the following command:

````
git clone git@github.com:glp02/tempest
````

Make sure start branch names with the Jira code of the ticket you're working on, e.g. for ticket TMP-4:

````
git checkout -b TMP-4-login-research
````

***

<h3>Setting up your database connection</h3>

Make sure you download <a href = https://dev.mysql.com/downloads/mysql/> MySQL</a> with the ARM MacOS 12 dmg.

Open up a terminal and type in `mysql -u root -p`, and type in your password (should be blank by default, in which case you can drop the `-p`). You should have started up a terminal interface for mysql that looks like: 

````
mysql>
````

Type in `SHOW DATABASES;` to see a list of databases.
(Don't forget the semicolon).
Add a developer environment database with `CREATE DATABASE tempest_dev;`
Add a production database with `CREATE DATABASE tempest_prod;`
Check that it's been added, then type `exit;`.


When you run the application (see below) now, the console should output a lot of text and no "application failed" or exceptions should be thrown. 
If there are `java.sql.SQLException: Access denied for user 'root'@'localhost (using password: YES)` exceptions thrown 
then you may have to change the `spring.datasource.password` variable in the `application.properties` file.

The application should stay running unless you manually shut it down now, and you can interact with it on terminal.

You can see changes to the databases with MySQL Workbench. 
The application is configured so that the tables in the dev database will be created on startup and destroyed on shutdown, while the prod db will persist.

To delete a database manually go into mysql and use:
`DROP DATABASE <database_name>`



***

<h3>Running the application</h3>

To run the application, go into `src/main/java/com.sky.tempest/TempestApplication.java` and run the class.

To shut down, there should be a red stop button at the top of your IDE.
