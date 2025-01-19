# Simple Bank Application

This project is a Java-based banking application built using the Spring Boot framework and Maven for dependency management. It provides a robust structure for developing web applications with a focus on RESTful services.

## Project Motivation

The motivation behind this project is to create a simple yet effective banking application that allows users to manage their accounts and transactions securely.

## Features

- User account management (signup, login, account retrieval, update, and deletion)
- Transaction management (recording and retrieving transactions)
- Secure authentication and authorization

## Technologies Used

- Java
- Spring Boot
- Maven
- RESTful APIs

## Installation Instructions

To set up the project locally, clone the repository and run the following command to install dependencies:

```
mvn install
```

## Usage Instructions

To run the application, use the following command:

```
mvn spring-boot:run
```

You can interact with the API using tools like Postman or cURL.

## Usage Examples

### Signup

- **Endpoint**: POST /accounts/signup
- **Request Body**:

```json
{
  "accountId": "12345",
  "accountHolderName": "John Doe",
  "balance": 1000.0
}
```

### Login

- **Endpoint**: POST /accounts/login
- **Request Body**:

```json
{
  "accountId": "12345"
}
```

## Contributing

Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License

This project is licensed under the MIT License.

## Developer Information

Developer: Veeresh Hanni
