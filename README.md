# Tempest
Team Git Good's Sky Software Engineering Academy group project. "GetYourWay.com" travel web app.

to clone the repo, use the following command:

````
git clone git@github.com:glp02/tempest
````

Make sure start branch names and commits with the code of the ticket you're working on, e.g. for ticket TMP-4:

````
git checkout -b TMP-4-login-research
````

or 

````
git commit -m "TMP-4 <message>"
````

Make sure you download <a href = https://dev.mysql.com/downloads/mysql/> MySQL</a> with the ARM MacOS 12 dmg. 

<h3>Database setup instructions</h3>
Open up terminal and type in ````mysql -u root -p````. 
MySQL will ask for the password you created at startup, which you should input.
In the terminal you should be in an interface:

````
mysql>
````

Type in ````SHOW DATABASES;```` to see a list of databases.
(Don't forget the semicolon).
Add a users database with ````CREATE DATABASE users;````
Check that it's been added, then type ````exit````. 


<p> </p>

To delete the database when you're done - log into MySQL on terminal as before and run the command:

````
DROP DATABASE users;
````

