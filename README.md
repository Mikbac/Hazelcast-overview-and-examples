# Hazelcast overview and examples

## Theory

* [Base.md](docs/Base.md)
* [Installation.md](docs/Installation.md)
* [Data-Structures.md](docs/Data-Structures.md)
* [Memory-Grid.md](docs/Memory-Grid.md)
* [Distributed-Locks.md](docs/Distributed-Locks.md)
* [Distributed-Computing.md](docs/Distributed-Computing.md)
* [Concurrency-Issues.md](docs/Concurrency-Issues.md)

----------------------------------------------------------------------

## Sample apps

### [Sample-Embedded-Mode-app](Sample-Embedded-Mode-app)

A sample application with embedded Hazelcast, MySQL database as an example of using Spring Cache and distributed
computing.

Docker env:

```shell
docker compose -f ./docker/mysql.yaml up
```

Starters:

* [SampleApplication-Instance-1.run.xml](.run/SampleApplication-Instance-1.run.xml)
* [SampleApplication-Instance-2.run.xml](.run/SampleApplication-Instance-2.run.xml)

Addresses:

* App-instance-1 - http://localhost:8080
* App-instance-2 - http://localhost:8081
* MySQL DB - mysql://localhost:3306

### [Sample-Standalone-Mode-app](Sample-Standalone-Mode-app)

A sample application with a standalone Hazelcast cluster and distributed lock.

Docker env:

```shell
docker compose -f ./docker/hazelcast-and-management-center.yaml up
```

Starters:

* [SampleApplication-Standalone-Mode-Instance-1.run.xml](.run/SampleApplication-Standalone-Mode-Instance-1.run.xml)
* [SampleApplication-Standalone-Mode-Instance-2.run.xml](.run/SampleApplication-Standalone-Mode-Instance-2.run.xml)

Addresses:

* App-instance-1 - http://localhost:8080
* App-instance-2 - http://localhost:8081
* Hazelcast management center - http://localhost:5700/
* Hazelcast instance-1 - localhost:5701
* Hazelcast instance-2 - localhost:5702
