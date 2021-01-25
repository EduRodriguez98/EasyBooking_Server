Execution steps
1. mysqld --console for starting mysql
2. Copy the script on the db folder and paste it on mysql workbench
3. Execute the script for creating the database (initially without tables)
4. ant build for compilation
5. ant export for creating a jar file to hold the .class dependencies the client needs
6. Copy the EasyBooking.jar on the dist folder and paste it on the EasyBooking_Client project lib folder
7. ant runserver for launching the server

(If we check the workbench, we will see that the reservation table has been created and of course, it is empty)