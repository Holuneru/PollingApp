# Polling App API

This document provides a description of all the available API endpoints for the Polling App.

## Technology Stack

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **MapStruct**
- **Springdoc OpenAPI (Swagger)**
- **Docker**

## Running with Docker

To run the application and a PostgreSQL database using Docker, you can use the provided `docker-compose.yml` file.

From the root of the project, run the following command:

```sh
docker-compose up --build
```

The application will be available at `http://localhost:8080`.

## Polls API

- **Get all polls with options and votes**
  - **GET** `/api/polls/all`
  - **Description:** Retrieves a list of all polls, including their options and vote counts.
  - **Response:** Returns a list of all polls.

- **Create a new poll**
  - **POST** `/api/polls/create`
  - **Description:** Creates a new poll.
  - **Request Body:**
    ```json
    {
      "question": "Your poll question",
      "usernameCreator": "your_username"
    }
    ```
  - **Response:** Returns the created poll object.

- **Close a poll**
  - **PUT** `/api/polls/close/poll/{pollId}/owner/{ownerId}`
  - **Description:** Closes an existing poll. Only the owner of the poll can close it.
  - **URL Parameters:**
    - `pollId`: The ID of the poll to close.
    - `ownerId`: The ID of the poll owner.
  - **Response:** Returns a success message.

## Users API

- **Get user's poll list**
  - **GET** `/api/users/{id}/polls`
  - **Description:** Retrieves a list of all polls created by a specific user.
  - **URL Parameters:**
    - `id`: The ID of the user.
  - **Response:** Returns a list of the user's polls.

- **Register a new user**
  - **POST** `/api/users/register`
  - **Description:** Registers a new user.
  - **Request Body:**
    ```json
    {
      "username": "your_username",
      "email": "your_email@example.com",
      "password": "your_password"
    }
    ```
  - **Response:** Returns the created user object.

- **Update user information**
  - **POST** `/api/users/updateInfo`
  - **Description:** Updates a user's information (username, email, or password).
  - **Request Body:**
    ```json
    {
      "oldUserName": "current_username",
      "password": "current_password",
      "new_username": "new_username",
      "new_email": "new_email@example.com",
      "new_password": "new_password"
    }
    ```
  - **Response:** Returns the updated user object.

## Votes API

- **Get user's vote list**
  - **GET** `/api/votes/user/{userId}/list`
  - **Description:** Retrieves a list of all votes cast by a specific user.
  - **URL Parameters:**
    - `userId`: The ID of the user.
  - **Response:** Returns a list of the user's votes.

- **Get option values for a poll**
  - **GET** `/api/votes/poll/{pollId}/options/values`
  - **Description:** Retrieves the values of options for a specific poll.
  - **URL Parameters:**
    - `pollId`: The ID of the poll.
  - **Response:** Returns a list of option values.

- **Get vote count for a poll**
  - **GET** `/api/votes/poll/{pollId}/count`
  - **Description:** Retrieves the total number of votes for a specific poll.
  - **URL Parameters:**
    - `pollId`: The ID of the poll.
  - **Response:** Returns the total vote count.

- **Create a new vote**
  - **POST** `/api/votes/create`
  - **Description:** Registers a new vote for a specific poll option.
  - **Request Parameters:**
    - `userId`: The ID of the user casting the vote.
    - `optionId`: The ID of the option to vote for.
  - **Response:** Returns a success message.

- **Cancel a vote**
  - **DELETE** `/api/votes/user/{userId}/option/{optionId}/cancelVote`
  - **Description:** Cancels a user's vote for a specific poll option.
  - **URL Parameters:**
    - `userId`: The ID of the user.
    - `optionId`: The ID of the option.
  - **Response:** Returns a success message.

## Options API

- **Add a new option to a poll**
  - **POST** `/api/options/add`
  - **Description:** Adds a new option to an existing poll.
  - **Request Body:**
    ```json
    {
      "pollId": 123,
      "text": "Your option text"
    }
    ```
  - **Response:** Returns a success message.

- **Get all options for a poll**
  - **GET** `/api/options/poll/{pollId}`
  - **Description:** Retrieves all options for a specific poll.
  - **URL Parameters:**
    - `pollId`: The ID of the poll.
  - **Response:** Returns a list of poll options.
