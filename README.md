# Library Management System

> What can you do in this application
* Add/View Students
* Add/View Books
* Return Borrowed Books
* Borrow Books
>Admin is basically librarian !

> Table Structure
* Tables
    * TBL_BOOKS
        * id (pk)
        * name
        * isbn
        * edition
        * price
        * pages
    * TBL_STUDENTS
        * id (pk)
        * name
        * course
        * branch
        * year
        * semester
    * TBL_BORROW_HISTORIES
      * id (pk)
      * student_id (fk)
      * book_id (fk)
      * issue_date
      * return_date
    * TBL_ADMINS
        * id (pk)
        * name
        * email
        * password

> How to start the application ?
* Begin with Configuring your database username and password in DbConfig.java File 
* Fire all the queries in schema.sql
* mvn clean install or build the project using your ide
* run the Main.java file to proceed