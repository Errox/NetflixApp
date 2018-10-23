
# Netflix Statistix

## Made by:
Netflix statistx is a program made by Students of the Avans Hogeschool.: 
 * Ryan Groenewold (Student nummer 2128772)
 * Dennis Blokland (Student nummer 2136934)
 * Sjoerd Teunisse (Student nummer 2138921)

## Assignment documents:
* UML: Assignment/Netflix App (Final).pdf
* DB Diagram: Assignment/DatabaseDiagram.png
* DB script: Assignment/CreateDBSQL.txt (Used by auto provision as shown below)
* Reflection: Assignment/Netflixstatistix_Toelichting_Reflectie.docx

## Requirements
 * Microsoft SQL Server 2017 (not yet tested with other versions)
 * IntelliJ IDEA

## Prerequisite

In Netflix Statistix\NetflixApp\src\DataStorageLayer\SqlServer\connectionString.txt set the first line to:

	jdbc:sqlserver://SERVERNAME;integratedSecurity=true

Where SERVERNAME is your DB Server host.
[PDF explainig connection Java with Microsoft SQL server ](https://avans-my.sharepoint.com/:b:/g/personal/r_groenewold3_student_avans_nl/EQGWuDLZJSlAoZN0zU8sDJQBiRcLf3lDYRpmMhBhqtVYRA?e=0aFcf0)

## Instructions

Don't worry about the red IDE error lines in the gif! They are for decoration purposes only.
(They where a previous error of the last session. Don't worry) (Click image to extend) 

![Alt Text](https://imgur.com/pln7wL0.gif)

Steps we took
 - Make sure you've edited connectionString.txt like asked in the prerequisite.
 - Open the project in InteliJ IDEA.
 - Make sure your SQL server is turned on. 
 - Setup mssql-jdbc-6.2.2.jre.jar as shown in pdf above. (pdf explaining connection with mssql)
 - Run the program from within InteliJ IDEA. 
 - The program will detect if there is a database available the application can use.
 - If the program detected there isn't a database available. It'll ask if you want the program to automaticlly generate the tables.
 - If the program detected there isn't any data available in the database, it'll ask if you want some dummy data inserted. 
 - Enjoy.

