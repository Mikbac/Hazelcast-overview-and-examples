# Installation

## Standard

Download zip from: https://hazelcast.com/open-source-projects/downloads/

## Docker

### Management center

Run:

```shell
docker compose -f ./docker/management-center.yaml up
```

Open: http://localhost:5700/

* Cluster Name: `Sample-cluster`
* Member Addresses: `host.docker.internal`

### Hazelcast with management center

Run:

```shell
docker compose -f ./docker/hazelcast-and-management-center.yaml up
```

Open: http://localhost:5700/

Add new cluster with:

* Cluster Name: `hello-world`
* Member Addresses: `hazelcast-node-1:5701,hazelcast-node-2:5701`