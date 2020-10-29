# app-mysql-composition
Setup of app with MySQL-database (including phpMyAdmin) using Docker Compose. Useful for running projects locally on your computer.

The example app is a small JavaEE/JakartaEE 8 app that connects to the database, but does nothing particularly meaningful. The runtime used is Payara Micro. Feel free to swap it out :-)

The specifics for the database is set up in setenv. Put any init-scripts for the database in the `dbinit`-directory and they will run when the container starts up.

Build with:

    ./build.sh

Then run with:

    ./run.sh

This starts the app at [http://localhost:8080](URL) while the MySQL-database runs on port 3306 and you'll find phpMyAdmin at [http://localhost:9080](URL).
