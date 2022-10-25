package com.piinalpin.redissentinel.controller;

import com.piinalpin.redissentinel.dto.DataCacheDto;
import com.piinalpin.redissentinel.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "")
public class DemoController {

    @Autowired
    private DemoService service;

    @PostMapping(value = "/hash-operations")
    public ResponseEntity<Map<String, Object>> storeCacheHash(@RequestBody DataCacheDto request) {
        return ResponseEntity.ok(service.putHash(request));
    }

    @GetMapping(value = "/hash-operations/{key}")
    public ResponseEntity<DataCacheDto> getCacheHash(@PathVariable String key) {
        return ResponseEntity.ok(service.getFromHash(key));
    }

    @PostMapping(value = "/value-operations")
    public ResponseEntity<Map<String, Object>> storeCacheValue(@RequestBody DataCacheDto request) {
        return ResponseEntity.ok(service.putValue(request));
    }

    @GetMapping(value = "/value-operations/{key}")
    public ResponseEntity<DataCacheDto> getCacheValue(@PathVariable String key) {
        return ResponseEntity.ok(service.getFromValue(key));
    }

}
