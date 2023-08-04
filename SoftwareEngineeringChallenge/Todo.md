# setup project

## task 0
- [x] setup git project

## task 1
- [x] setup springboot

<https://start.spring.io>

Rproject: maven
porject metadata:
    group: com.crud.SoftwareEngineeringChallenge
language: java 17
dependencies:
    lombok
    h2 databse
    spring jpa data
    spring web
    spring boot devtools
    swagger

# task 1

setup project structure

adapter/
- ItemAdapter.java
  - Converts an Item object to an ItemDto object.
  - Converts an ItemDto object to an Item object.

controller/
- ItemController.java
  - creates the end points for CRUD operations

dto/
- ItemDto.java
  - is a entiry container for transport from DB to UI
  - uses lombok to remove boilerplait

entity/
- Item.java
  - is the bluepring for an item in the databse
  - uses lombok to remove boilerplait

reposity/
- ItemRepositoy.java
  - uses jpa to do basic crud

service/
- ItemService.java
  - provides crud services

resources
- application.properties
  - spring.datasource.url=jdbc:h2:mem:crud
  - setup the BD


---

# testing endpoints


## testing
swagger:

<http://localhost:8080/swagger-ui/index.html>


### Create(HTTP POST):

- Endpoint: `/items`
- Description: Allows the user to create a new item by providing the `name` and `description` in the request body.
- Response: Returns the created item with its unique `id`.


---

- [x] takes all vales

---
sent
```json
{
  "id": 1,
  "name": "bob ross",
  "description": "happy trees"
}
```
Response: 200

---

- [x] takes `name` and `description`
- [x] creates unique `id`.

---
sent
```json
{
  "name": "vincent vango",
  "description": "can you hear what i mean"
}
```
Response: 200
receved
```json
{
    "id": 2,
    "name": "vincent vango",
    "description": "can you hear what i mean"
}
```
---

- [x] missing `name` fild

```json
{
  "description": "MIA"
}
```
Response: 200
```json
{
  "timestamp": "2023-08-04T01:03:08.926+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "trace": "org.springframework.dao...",
  "message": "not-null property references a null or transient value : com.crud.SoftwareEngineeringChallenge.entity.Item.name",
  "path": "/items"
}
```
---

- [x] missing `description` fild

---

```json
{
    "id": 3,
    "name": "mario",
}
```

response: 400

```json
{
"timestamp": "2023-08-04T01:06:23.685+00:00",
"status": 400,
"error": "Bad Request",
"trace": "org.springframework.http.converter.HttpMessageNotReadableException: ...",
"message": "JSON parse error: Unexpected character ('}' (code 125)): was expecting double-quote to start field name",
"path": "/items"
}
```

---

### Read (HTTP GET):

- Endpoint: `/items/:id`
- Description: Retrieves the details of a specific item by providing its unique `id`.
- Response: Returns the item's details (including `name`, `description`, and `id`) if it exists, or an appropriate error message if not found.

SQL table
| ID  | DESCRIPTION | NAME  |
| :-- | ----------- | ----- |
| 1   | barks       | dog   |
| 2   | honks       | hippo |
| 3   | meows       | cat   |

---

- [x] Returns the item's details (including `name`, `description`, and `id`)

http://localhost:8080/items/1

```json
{
  "id": 1,
  "name": "dog",
  "description": "barks"
}
```
response 200

---

- [x] Returns an appropriate error message if item not found.

---

```json
{
"timestamp": "2023-08-04T01:46:26.640+00:00",
"status": 500,
"error": "Internal Server Error",
"trace": "java.lang.RuntimeException: Item not found\n\tat com.crud.SoftwareEngineeringChallenge.service.ItemService.lambda$0(ItemService.java:35)...",
"message": "Item not found",
"path": "/items/4"
}
```

---

### Update (HTTP PUT or PATCH):

  - Endpoint: `/items/:id`
  - Description: Allows the user to update an existing item's `name` and/or `description` by providing the updated values in the request body. The `id` should remain unchanged.
  - Response: Returns the updated item.

</br>

- [x] update `name` and `description`

changed name from hippo to mouse
changed desciption from honk to squeek

<http://localhost:8080/items/2>

```json
{
  "name": "mouse",
  "description": "squeek"
}

```
response 200
```json
{
"id": 2,
"name": "mouse",
"description": "squeek"
}
```
---

### Delete (HTTP DELETE)

- Endpoint: `/items/:id`
- Description: Deletes an item with the provided `id`.
- Response: Returns a success message or an appropriate error message if the item doesn't exist.

<http://localhost:8080/items/2>

- [x] delte item based on id

response 200

Item deleted successfully

table now 

SQL table
| ID  | DESCRIPTION | NAME  |
| :-- | ----------- | ----- |
| 1   | barks       | dog   |
| 3   | meows       | cat   |

---
