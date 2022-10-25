# Spring Boot Redis Sentinel Example
An example implementation of **Redis Sentinel** usage with Spring Boot

![Redis Sentinel Topology with Application Client](img/redis-sentinel-topology-client.png)

### Run as Container
- Build project `mvn clean package -Dmaven.test.skip=true`
- `docker compose up -d --build`
- `docker compose down -v`

### Reference
- [High Availability with Redis Sentinel and Spring Lettuce Client](https://medium.com/trendyol-tech/high-availability-with-redis-sentinel-and-spring-lettuce-client-9da40525fc82)
- [Redis — Using master node to save and replicas nodes to read with Springboot.](https://filipemunhoz.medium.com/redis-using-master-node-to-save-and-replicas-nodes-to-read-with-springboot-b86a0dbb3baf)
- [How to use **cacheDefaults** method](https://www.tabnine.com/code/java/methods/org.springframework.data.redis.cache.RedisCacheManager$RedisCacheManagerBuilder/cacheDefaults)
- [Spring Boot Caching with Redis Sentinel always connects to master node](https://stackoverflow.com/questions/64809960/spring-boot-caching-with-redis-sentinel-always-connects-to-master-node)
- [Class ReadFrom - Lettuce Docs](https://lettuce.io/core/release/api/io/lettuce/core/ReadFrom.html)