# Web Project

## Objective
The primary objective of this project is to create a web interface that interacts with the core project, demonstrating various technologies used for database communications within the Spring framework. The technologies being compared in the core project are:
- Spring JDBC
- Spring Data JDBC
- Spring Data JPA

## Project Overview
This web project is designed to work in conjunction with the core project, providing a user-friendly interface to interact with the data models implemented in the core. The project showcases two distinct data models:

1. Simple Model : This model represents a straightforward structure with basic relationships between entities. It includes entities such as Invoice and Customer with simple references.
2. Complex Model : This model is designed to showcase more advanced relationships between entities. It includes more intricate connections, such as linking customers and products to invoices through additional entities.

## Technologies Compared

### Spring JDBC
- Description: Spring JDBC provides a straightforward approach to interact with the database using raw SQL queries.
- Pros:
  - Greater control over SQL queries.
  - Performance can be optimized by writing specific queries.
- Cons:
  - More boilerplate code.
  - Increased risk of SQL injection if queries are not handled properly.

### Spring Data JDBC
- Description: Spring Data JDBC simplifies the development process by providing a more object-oriented approach to database interactions, while still maintaining control over the SQL.
- Pros:
  - Easier to use compared to Spring JDBC.
  - Less boilerplate code.
  - Still allows direct SQL queries.
- Cons:
  - Less flexible compared to Spring JDBC.
  - Limited support for complex relationships and custom queries.

### Spring Data JPA
- Description: Spring Data JPA uses the Java Persistence API (JPA) to interact with the database, offering a higher level of abstraction and more powerful ORM capabilities.
- Pros:
  - Powerful ORM capabilities.
  - Simplifies data access layers.
  - Handles complex relationships well.
- Cons:
  - Can have a steeper learning curve.
  - Performance overhead due to the abstraction layer.

## Project Structure
- Core Project: Contains the business logic and database interaction layers using the different Spring technologies.
- Web Layer Project: A separate project that handles the web interactions and interfaces with the core project.

## Integration with Core Project
This web project is tightly integrated with the core project to provide a seamless experience. The core project handles the business logic and database interactions, while this web project focuses on presenting the data and interactions to the end-user.

## Technologies Used
- Spring MVC: Used to create web applications and handle HTTP requests.
- Thymeleaf: A modern server-side Java template engine for web and standalone environments.
- JavaScript: For client-side scripting and dynamic content updates.
- HTML/CSS: For structuring and styling the web pages.

## Features
- Dynamic Data Display: Showcases data from both simple and complex models.
- Form Handling: Allows users to add and update data through forms.
- Client-Side Validation: Ensures data integrity before submission.

## Setup and Execution

1. Clone the Repository:
- git clone <repository-url>
- cd web-project

2. Configure Core Project : Ensure the core project is set up and running. Refer to the Core Project Setup for detailed instructions.

3. Configure Web Project : Update the application.properties file to point to the core project’s API endpoints.

4. Build and Run:
- Using Maven:
  - mvn clean install
  - mvn spring-boot:run

## Usage
The project provides a web interface to interact with the different data models. It demonstrates how to:
- List invoices and related entities.
- Add new invoices and customers.
- View detailed information about invoices, customers, and products.

## Differences Highlighted
### Spring MVC with Thymeleaf
- Description: Spring MVC combined with Thymeleaf provides a powerful way to create dynamic web pages.
- Pros:
  - Tight integration with Spring.
  - Easy to use and well-documented.
  - Supports natural templating, making it easy to create and maintain views.
- Cons:
  - Can be complex for beginners.
  - Requires a good understanding of both Spring MVC and Thymeleaf.

## Correlation with Core Project
This web project complements the core project by providing the necessary user interface to interact with the core functionalities. It leverages the business logic and database interactions implemented in the core project to present a comprehensive application. Ensure to check out the Core Project for the full backend implementation.
https://github.com/MathEyraud/Java-Learn-Spring-Data-Core

## Conclusion
This web project, in conjunction with the core project, serves as a comprehensive demonstration of various Spring technologies. It provides insights into the strengths and weaknesses of different database communication methods and showcases how to integrate them into a full-fledged web application.
