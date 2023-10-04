# Installation

## Standard

Download zip from: https://hazelcast.com/open-source-projects/downloads/

## Docker

Run:

```shell
docker compose -f ./docker/hazelcast.yaml up
```

Open: http://localhost:5700/

Add new cluster with:

* Cluster Name: `hello-world`
* Member Addresses: `hazelcast-node-1:5701,hazelcast-node-2:5701`