# Microservices Architecture with Spring Cloud

This repository contains the implementation of a microservices architecture using Spring Cloud. The project includes the following components:

1. **Config Service** - Centralized configuration management using Spring Cloud Config Server.
2. **Eureka Server** - Service registry for dynamically registering and discovering microservices.
3. **Employee Management Service** - Manages employee data and registers with Eureka Server.
4. **Performance Review Service** - Manages employee performance reviews and feedback.
5. **API Gateway** - A centralized entry point for routing requests.

## Components

### 1. **Config Service (Spring Cloud Config Server)**

The Config Service is responsible for managing the centralized configuration of all microservices in the architecture. 

#### Features:
- **Centralized Configuration**: The configuration for microservices is stored in a GitHub repository.
- **Dynamic Configuration**: The configuration is provided dynamically to microservices using Spring Cloud Config Server.

#### Configuration:
- Runs on port `8888`.
- The configuration is fetched from a GitHub repository.

### 2. **Eureka Server (Service Registry)**

Eureka Server is used as the service registry where all microservices can register and discover each other dynamically.

#### Features:
- **Service Registry**: Microservices register with Eureka Server to become discoverable.
- **Dynamic Service Discovery**: Allows microservices to locate and communicate with each other.

#### Configuration:
- Runs on port `8761`.
- All microservices register with Eureka Server to enable dynamic discovery.

### 3. **Employee Management Service**

This is an existing service that manages employee data. It registers with Eureka Server and fetches configuration from the Config Service.

#### Features:
- **Employee Management**: Stores employee details.
- **Eureka Registration**: Registers with Eureka Server for service discovery.
- **Config Fetching**: Fetches configuration from the Config Service to dynamically adjust configurations.

### 4. **Performance Review Service**

The Performance Review Service is responsible for managing employee performance reviews and feedback.

#### Features:
- **Performance Ratings**: Stores employee ratings and feedback.
- **Feign Client**: Uses a Feign client to fetch employee details from the Employee Management Service.
- **Fault Tolerance**: Implements Circuit Breaker for fault tolerance, ensuring that the system can handle failures gracefully.

#### Configuration:
- Registers with Eureka Server for dynamic service discovery.
- Can be scaled independently of other services.

### 5. **API Gateway (Spring Cloud Gateway)**

The API Gateway serves as a centralized entry point for routing requests to the appropriate microservices.

#### Features:
- **Request Routing**: Routes requests to the appropriate microservices.
- **Rate Limiting**: Implements rate limiting using Resilience4j to prevent overloading microservices.

#### Configuration:
- Registers with Eureka Server for dynamic service discovery.

### Dependencies and Technologies Used:
- **Spring Boot**: For building the microservices.
- **Spring Cloud**: For providing Cloud-native features like configuration, service discovery, and routing.
- **Eureka Server**: For service discovery and registration.
- **Spring Cloud Config Server**: For managing centralized configurations.
- **Spring Cloud Gateway**: For routing API requests and implementing rate limiting.
- **Feign Client**: For service-to-service communication.
- **Resilience4j**: For implementing rate limiting and fault tolerance (Circuit Breaker).
- **GitHub**: For storing configuration files used by the Config Service.

## Setup and Configuration

### 1. **Config Service**

- Create a Spring Boot project with the `spring-cloud-config-server` dependency.
- Enable the Config Server by adding the `@EnableConfigServer` annotation.
- Configure the service to fetch configuration files from a GitHub repository.
- Run the service on port `8888`.

### 2. **Eureka Server**

- Create a Spring Boot project with the `spring-cloud-starter-netflix-eureka-server` dependency.
- Enable Eureka Server by adding the `@EnableEurekaServer` annotation.
- Run the service on port `8761`.

### 3. **Employee Management Service**

- This service registers with Eureka Server and fetches its configuration from the Config Service.
- It handles employee-related data, including storing employee details.
  
### 4. **Performance Review Service**

- Create a Spring Boot project with the necessary dependencies to handle employee performance reviews.
- Register the service with Eureka Server.
- Use a Feign Client to fetch employee details from the Employee Management Service.
- Implement a Circuit Breaker pattern for fault tolerance.
  
### 5. **API Gateway**

- Use Spring Cloud Gateway for routing the requests.
- Implement rate limiting using Resilience4j to prevent overloading the services.

## Running the Project

1. **Start Config Service**: Run the Config Service on port `8888` to serve configurations to all microservices.
2. **Start Eureka Server**: Run the Eureka Server on port `8761` to enable service discovery.
3. **Start Employee Management Service**: This service registers with Eureka Server and fetches configurations from the Config Service.
4. **Start Performance Review Service**: This service registers with Eureka Server, uses Feign Client to communicate with the Employee Management Service, and implements Circuit Breaker for fault tolerance.
5. **Start API Gateway**: The API Gateway will route incoming requests to the appropriate microservices.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
