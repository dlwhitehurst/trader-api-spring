# trade-tx
Slimboot-starter that captures and manages securities trade transactions.
 
Build Restful lightweight APIs for a microservices system/application using Spring Boot, Web Starter, JPA and MySQL.
This API template uses no Spring security however, it does provide HATEOAS. This project is one of several that will
provide design elements for microservices that will make up a larger system and be managed behind an API Gateway.

## Configuration

### Clone Project

```bash
git clone https://github.com/dlwhitehurst/trade-tx.git
```

### Configure Persistence
This API uses JPA/Hibernate for application persistence. Use the docker-compose file in the 
project directory to run a local instance of MySQL for testing. 
```bash
docker-compose up
```
Next, run the sql at `data/slimboot.sql` on the command-line or using a database client tool.
Your database is now created and some play data has been added.

### Review Application Properties
Take a look at `src/main/resources/application.properties`

### Run
```bash
mvn spring-boot:run
```
The app is now hosted at <http://localhost:8080>

## Rest API

The app provides the following CRUD APIs.

### Contact

| Method | Url               | Decription                  | Sample Valid Request Body   | 
| ------ |-------------------|-----------------------------|-----------------------------|
| GET    | /api/transactions | Get All Transactions        | [JSON]($getalltransactions) |
| POST   | /api/contacts     | POST a Transaction          |                             |
| PUT    | /api/contacts     | PUT (Replace) a Transaction |                             |


## Sample JSON 

##### <a id="getallcontacts">GET Contacts -> /api/contacts</a>
```json
{
  "content": [
    {
      "id": 2,
      "entity": "Sally Smith",
      "phone": "919-633-9345",
      "email": "sallys@gmail.com"
    },
    {
      "id": 1,
      "entity": "David L Whitehurst",
      "phone": "919-605-6529",
      "email": "dlwhitehurst@gmail.com"
    }
  ],
  "page": 0,
  "size": 30,
  "totalElements": 2,
  "totalPages": 1,
  "last": true
}
```

