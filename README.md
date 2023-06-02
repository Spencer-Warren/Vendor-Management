# Vendor Management Application

This repository contains a vendor management application developed using Angular, Bootstrap, Spring Boot, and MySQL. The application allows users to manage vendors and their associated information, such as restaurants and dishes.

## Features

- User-friendly interface for managing vendors, restaurants, and dishes
- Create, read, update, and delete vendors
- Create, read, update, and delete restaurants under vendors
- Create, read, update, and delete dishes under restaurants
- Track vendor details including name, contact information, and services provided
- Integration with MySQL database for data storage

## Technologies Used

- Angular: A JavaScript framework for building user interfaces
- Bootstrap: A CSS framework for creating responsive and visually appealing web applications
- Spring Boot: A Java-based framework for developing web applications
- MySQL: A widely-used relational database management system

## Prerequisites

Before running the application, ensure you have the following prerequisites installed on your system:

- Node.js: Version 12.x or higher
- Angular CLI: Version 12.x or higher
- Java Development Kit (JDK): Version 17 or higher
- MySQL: Version 8.x or higher

## Getting Started

To get started with the Vendor Management Application, follow these steps:

1. Clone the repository:

```bash
git clone https://github.com/Spencer-Warren/Vendor-Management.git
```

2. Change into the project directory:

```bash
cd Vendor-Management
```

3. Ensure you have a MySQL server set up and running.

4. Create a new database named `vendor_management` in MySQL.

5. Update the database connection details in `backend/src/main/resources/application-dev.properties` file according to your MySQL configuration.

6. Build and run the backend Spring Boot application:

```bash
cd backend
./mvnw spring-boot:run -Dspring.config.name=application-dev
```

7. Set up the frontend:

```bash
cd ../frontend
npm install
ng serve
```

8. Open your web browser and navigate to `http://localhost:4200` to access the application.

## Contributing

Contributions to the Vendor Management Application are welcome! To contribute, follow these steps:

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

## Contact

If you have any questions or feedback regarding the Vendor Management Application, please feel free to contact the project maintainer, Spencer Warren, through the [GitHub repository](https://github.com/Spencer-Warren/Vendor-Management).
