## Concurrency Issues

example solution - 1:

```
map.lock("score");

Integer score = map.get("score");
...
...
score = score + 2000;
map.put("score", score);

map.unlock("score");
```

example solution - 2:

```
map.replace(key, oldValue, newValue);
```
