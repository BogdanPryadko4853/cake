# Cake Store Project

This is a Spring Boot project for managing a cake store, providing features for managing cakes, categories, and user authentication. The project leverages Java, Spring Boot, PostgreSQL, Thymeleaf, and Bootstrap for a user-friendly experience.

## Project Overview

This project is a robust cake store management application. Users can browse cakes, view details, and (for authenticated users) create accounts and manage their orders.  Administrators have a dedicated panel for managing cakes, categories, and user accounts.

## Key Features

*   **Cake Management:** Create, edit, and delete cakes, including their descriptions, prices, and images.
*   **Category Management:** Create, edit, and delete cake categories.
*   **User Authentication:** Secure user accounts with login/registration.
*   **Admin Panel:**  A dedicated admin interface for managing the entire cake store.


## Technologies Used

*   **Java**: Core programming language.
*   **Spring Boot**: Framework for rapid application development.
*   **PostgreSQL**: Relational database for data persistence.
*   **Thymeleaf**: Templating engine for dynamic HTML generation.
*   **Bootstrap**: CSS framework for styling the front-end.
*    (Optional) **Spring Security**: For user authentication (highly recommended).


## Project Structure

*   **Controllers:** Handle HTTP requests (e.g., `CakeController`, `UserController`).
*   **Services:** Implement business logic (e.g., `CakeService`, `UserService`).
*   **Entities:** Represent database tables (e.g., `Cake`, `User`, `Category`).
*   **Configuration:** Spring Boot configuration files (e.g., `SecurityConfig`, `Application.properties`).
*   **HTML Pages:** Templates for the user interface (e.g., `admin.html`, `cakes.html`).


## How to Run the Project

### Prerequisites

1.  Java Development Kit (JDK) 17 or higher.
2.  Maven.
3.  PostgreSQL database server installed and running.

### Project Setup

1.  Clone the repository:
    ```bash
    git clone https://github.com/BogdanPryadko4853/cake
    cd cake-store
    ```

2.  Set Up PostgreSQL:
    *   Create a database named `cakestore` (or whatever you chose in your `application.properties`).
    *   Configure your `application.properties` or `application.yml` with the PostgreSQL connection details.

### Running the Application

```bash
mvn spring-boot:run
