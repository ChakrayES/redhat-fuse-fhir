
# Red Hat Fuse Micro Integration

A basic example with Red Hat Fuse to create a micro integration that connect with a FHIR Server

## Configuration

- Fuse Boom Version: 7.6.0.fuse-sb2-760028-redhat-00001

## Installation

```
mvn clean package -Pfuse7-generate-imagen
docker run -p 8080:8080 chakray/redhat-fuse-fhir:1.0.0
```

## Test

In *src/test/resources/samples* there is an example file. Put the file in the folder indicate in *dir.in* in application.properties.  
The FHIR can be mocked with the *src/test/resources/wiremock*. 

## Links

