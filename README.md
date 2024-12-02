# Custom Operation in Hapi

This project is an example of implementing a custom operation for hapi fhir and deploying it as part of a docker compose.

The operation is found in org.example.DummyOperation.
This was built based on hapi 7.6, though the docker

Follow the following steps to try out the example:

1. Build the jar
```shell
mvn package
```
2. Copy the generated jar into the hapi-extra-classes directory
```shell
mkdir -p hapi-extra-classes
cp target/hapi-custom-operation-demo-1.0-SNAPSHOT.jar hapi-extra-classes
```
3. Start the docker container
```shell
docker compose up -d
```
4. Monitor the docker logs until hapi has started. (press ctr-C to exit)
```shell
docker logs -f fhir
```
5. Check the end point
```shell
curl -X POST 'http://localhost:8080/fhir/$manualInputAndOutput'
```

This should output `hello` with no new line.
```shell
hapi-custom-operation-demo$ curl -X POST 'http://localhost:8080/fhir/$manualInputAndOutput'
hellohapi-custom-operation-demo$
```