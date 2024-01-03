# Online Game Shop
Project for Database course at [FCSE](https://finki.ukim.mk/).

Welcome to the Online Game Shop project repository! This project is a web application developed using PostgreSQL for the database, Java Spring for the backend, and Angular for the frontend.
The purpose of this application is to provide a platform for users to browse, and order online games.

## Table of Contents
[Faza 0](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza0)

The beginning phase is the ER diagram and a PDF document on what my project will be about.

[Faza 1](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza1/Mapiracka%20Tranformacija)

This phase is to transform from the ER diagram to the Relation model using the algorithm of Mapping transformation.

[Faza 2](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza2/DDL)

This is the phase where from the Relation model we go to DDL

[Faza 3](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza3)

In this step, we came up with ideas for three views in SQL and made three forms for the web app. These forms help with adding or updating data(they need to be transactions).

[Faza 4](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza4)

Then, we made those ideas happen. We included the views and forms in the database, using procedures/functions for the forms.

[Faze 5](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza5)

In this phase, we crafted three insightful SQL queries to generate detailed reports:
- Weekly Sales Report with User Details
* Monthly Revenue and Review Count by Genre and Publisher Report
+ Annual Sales, Average Rating, and Platform Count Report

[Faza 6](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza6)

We made changes to the [SQL](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza6/SQL) and used [Java Spring](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza6/OnlineGamesShop) for the backend and [Angular](https://github.com/Fazlibeqir/Baza-na-Podatoci/tree/main/Faza6/FrontEnd/Angular) for the frontend to complete the web app.

## Setup
Follow these steps to set up the Online Game Shop project locally:

1. Clone the repository:
   
Start by cloning the repository to your desired location. For example, on Windows: C:\User\Name\Desktop\New folder
```bash
git clone  https://github.com/Fazlibeqir/Baza-na-Podatoci.git
```
 Or download the ZIP file from the GitHub page and extract it.
 
2. Set up the database:

- Install PostgreSQL and create a database for the project.
* Update the database configuration in the backend application properties(btw  port: 9091).

3. Build and run the backend:
```bash
cd "C:/User/Name/Desktop/New folder/Faza6/OnlineGamesShop"
./mvnw clean install
./mvnw spring-boot:run
```

4. Build and run the frontend:
```bash
cd "C:/User/Name/Desktop/New folder/Faza6/FrontEnd/Angular" 
npm install
ng serve
```

5. Access the application at [http://localhost:4200](http://localhost:4200) in your web browser.



