
# Cake Store Project

This is a Spring Boot project for managing a cake store. It includes features for managing cakes, categories, and user authentication. The project uses Java, Spring Boot, PostgreSQL, and Thymeleaf for rendering HTML pages.

## Technologies Used
- **Java**: The core programming language used for backend development.
- **Spring Boot**: Framework for building the application.
- **PostgreSQL**: Database used for storing data.
- **Thymeleaf**: Template engine for rendering HTML pages.
- **Bootstrap**: CSS framework for styling the frontend.

## Project Structure
The project is structured as follows:

### Controllers
- **AdminController.java**: Handles admin-related requests.
- **CakeController.java**: Handles cake-related requests.
- **CategoryController.java**: Handles category-related requests.
- **AuthController.java**: Handles authentication-related requests.
- **RegistrationController.java**: Handles user registration.

### Services
- **CakeService.java & CakeServiceImpl.java**: Business logic for cakes.
- **CategoryService.java & CategoryServiceImpl.java**: Business logic for categories.
- **ImageService.java & ImageServiceImpl.java**: Handles image processing.
- **UserService.java**: Manages user-related operations.

### Entities
- **Cake.java**: Represents a cake entity.
- **Image.java**: Represents an image entity.
- **Categories.java**: Represents a category entity.
- **Role.java**: Represents a user role.
- **User.java**: Represents a user entity.

### Configuration
- **SecurityConfig.java**: Configures Spring Security.
- **CakeApplication.java**: Main application class.

### HTML Pages
- **admin.html**: Admin panel for managing cakes and categories.
- **cake.html**: Displays details of a single cake.
- **cakes.html**: Lists all cakes.
- **categories.html**: Lists all categories.
- **create-cake.html**: Form for creating a new cake.
- **edit-cake.html**: Form for editing an existing cake.
- **edit-category.html**: Form for editing an existing category.
- **login.html**: Login page for users.

## How to Run the Project

### Clone the Repository:

git clone https://github.com/yourusername/cake-store.git

cd cake-store

### Set Up PostgreSQL:
1. Ensure PostgreSQL is installed and running.
2. Create a database named cake.
3. Update the application.yml file with your PostgreSQL credentials.

### Run the Application:
./mvnw spring-boot:run

### Access the Application:
Open your browser and go to [http://localhost:8081](http://localhost:8081).

## Admin Panel
The admin panel allows administrators to manage cakes and categories. It includes features for creating, editing, and deleting cakes and categories.
