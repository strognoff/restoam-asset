# Resto Asset Management
Repository for RestoAM, Asset Management made in a scalable and cool way.

This is the Asset module, where:
- You can save an asset
- Retrieve it from the database
- Update the Asset name and description
- Delete an Asset from the database

## API

### Asset fields
- name
- description
- location
- createdDate (ISO-8601)
- valueAmount
- valueCurrency (USD, GBP, BRL)

### Endpoints
- GET /restoam/assets/{id}
- GET /restoam/assets?page=0&size=10&sortBy=createdDate&sortDir=desc&name=&location=&description=&currency=
- POST /restoam/assets
- PUT /restoam/assets/{id}
- DELETE /restoam/assets/{id}

### OpenAPI
- /v3/api-docs
- /swagger-ui.html

## Running the Application with Docker

You can package and run the application in a Docker container by following these steps:

### 1. Build the Docker Image
First, ensure the application JAR file is built. Then, build the Docker image using the provided `Dockerfile`.

**Command:**
```bash
docker build -t restoam-asset:latest .

#redirect the port
docker run -d -p 8080:8080 --name restoam-asset-container restoam-asset:latest