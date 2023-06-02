# Vendor Management Application

This repository contains a full-stack application for vendor management, developed using Angular, Bootstrap, Spring Boot, and MySQL. The application provides a comprehensive solution for managing vendors and their related information.

## Features

- User-friendly interface for seamless vendor management
- Authentication and authorization mechanisms to secure access
- Create, read, update, and delete vendors
- Create, read, update, and delete restaurants under vendors
- Create, read, update, and delete dishes under restaurants
- Track vendor details such as name, contact information, and services provided
- Integration with MySQL database for data storage

## Technologies Used

- Angular: A popular JavaScript framework for building user interfaces
- Bootstrap: A CSS framework for creating responsive and visually appealing web applications
- Spring Boot: A Java-based framework for developing robust and scalable web applications
- MySQL: A widely-used relational database management system

## Prerequisites

Before running the application, ensure you have the following prerequisites installed on your system:

- Node.js: Version 12.x or higher
- Angular CLI: Version 12.x or higher
- Java Development Kit (JDK): Version 17 or higher

## Usage

Follow the steps below to set up and run the application:

1. Clone this repository to your local machine.

```bash
git clone https://github.com/your-username/vendor-management.git
```

2. Change into the frontend directory.

```bash
cd vendor-management/frontend
```

3. Install the Angular dependencies.

```bash
npm install
```

4. Launch the Angular application.

```bash
ng serve
```

5. Open your web browser and navigate to `http://localhost:4200` to access the vendor management application.

6. Change into the backend directory.

```bash
cd ../backend
```

7. Configure the application properties.

   - Open the `src/main/resources/application.properties` file.
   - Update the database connection details according to your MySQL configuration.

8. Build and run the Spring Boot application.

```bash
./mvnw spring-boot:run
```

## Contributing

If you wish to contribute to this project, please follow the guidelines below:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes with descriptive commit messages.
4. Push your changes to your forked repository.
5. Submit a pull request, explaining the changes you have made.

## Acknowledgments

- [Angular](https://angular.io/)
- [Bootstrap](https://getbootstrap.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)

Feel free to reach out to the project maintainers for any questions or feedback. Thank you for your interest in the Vendor Management Application!
