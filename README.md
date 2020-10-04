# Resto Asset Management
Repository for RestoAM, Asset Management made in a scalable and cool way.

This is the Asset module, where:
- You can save an asset
- Retrieve it from the database
- Update the Asset name and description
- Delete an Asset from the database

Instructions for Cassandra:

Pulling the image:
docker pull cassandra:latest

Executing the image:
docker run -d — name <name_of_container> -p 9042:9042 cassandra

You will need to forward the port of the linux to your sysop if you are using a linux vm.

Executing the bash:
docker exec -it <name_of_container> bash

Then when the bash opens, you just need to execute: cqlsh