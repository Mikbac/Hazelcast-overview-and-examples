# Hazelcast overview and examples

## Theory

[Base.md](docs%2FBase.md)
[Installation.md](docs%2FInstallation.md)
[Memory-Grid.md](docs%2FMemory-Grid.md)

## Sample apps

### [Sample-Embedded-Mode-app](Sample-Embedded-Mode-app)

A sample application with embedded Hazelcast and MySQL database as an example of using Spring Cache.

Docker env:

```shell
docker compose -f ./docker/mysql.yaml up
```

Starters:

* [SampleApplication-Instance-1.run.xml](.run%2FSampleApplication-Instance-1.run.xml)
* [SampleApplication-Instance-2.run.xml](.run%2FSampleApplication-Instance-2.run.xml)

Addresses:

* App-instance-1 - http://localhost:8080
* App-instance-2 - http://localhost:8081
* MySQL DB - mysql://localhost:3306

### [Sample-Standalone-Mode-app](Sample-Standalone-Mode-app)

A sample application with a standalone Hazelcast cluster.

Docker env:

```shell
docker compose -f ./docker/hazelcast-and-management-center.yaml up
```

Starters:

* [SampleApplication-Standalone-Mode-Instance-1.run.xml](.run%2FSampleApplication-Standalone-Mode-Instance-1.run.xml)
* [SampleApplication-Standalone-Mode-Instance-2.run.xml](.run%2FSampleApplication-Standalone-Mode-Instance-2.run.xml)

Addresses:

* App-instance-1 - http://localhost:8080
* App-instance-2 - http://localhost:8081
* Hazelcast management center - http://localhost:5700/
* Hazelcast instance-1 - localhost:5701
* Hazelcast instance-2 - localhost:5702
