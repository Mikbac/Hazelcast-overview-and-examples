## Distributed Locks

Distributed Locks are used if you want a block of code to be executed strictly by one single node in a cluster.

e.g.

```java
public class SampleController {

    private final HazelcastInstance hazelcastInstance;

    @PostMapping("/v1/sample/lock")
    public ResponseEntity<String> makeSampleLock() throws InterruptedException {
        FencedLock lock = hazelcastInstance.getCPSubsystem().getLock("myLock");
        lock.lock();
        try {
            // do something here, e.g.
            Thread.sleep(1000);
        } finally {
            lock.unlock();
        }
        return ResponseEntity.ok("TestLock");
    }
}
```
