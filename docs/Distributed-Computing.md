## Distributed Computing

Distributed computing is the process of running computational tasks on different cluster members. With distributed
computing, computations are faster thanks to the following advantages:

* Leveraging the combined processing power of a cluster.
* Reducing network hops by running computations on the cluster that owns the data

(from https://docs.hazelcast.com/hazelcast/5.3/computing/distributed-computing)

------------------------------------------------------------

Distributed computing works more easily in embedded mode, because standalone mode requires to provide a runner class.
Steps:

* Write a Executor that implements Callable or Runnable.
* Create an instance of executor from hazelcastInstance and submit the Callable/Runnable.

e.g.

executor:

```java

@AllArgsConstructor
public class EchoTask implements Runnable, Serializable {

    private Integer taskNumber;

    @Override
    public void run() {
        System.out.println("Execution taks: " + taskNumber);
    }

}
```

executing:

```java
public class SampleController {

    private final HazelcastInstance hazelcastInstance;

    @PostMapping("/v1/sample/executor")
    public ResponseEntity<String> makeSampleExecutor() {
        IExecutorService executor = hazelcastInstance.getExecutorService("executor");
        IntStream.range(1, 1000).forEach(i -> executor.submit(new EchoTask(i)));
        return ResponseEntity.ok("TestExecutor");
    }
}
```
