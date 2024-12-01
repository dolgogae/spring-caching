package com.example.caching.service;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "baseCache")
public class BaseCacheService {

    @Cacheable(key = "#id")
    public String getItemById(Long id) {
        System.out.println("Fetching item from database with ID: " + id);
        return "Item-" + id;
    }

    @CachePut(key = "#id")
    public String updateItem(Long id, String updatedItem) {
        System.out.println("Updating item in database with ID: " + id);
        return updatedItem; 
    }

    @CacheEvict(key = "#id")
    public void deleteItem(Long id) {
        System.out.println("Deleting item from database and cache with ID: " + id);
    }

    @Caching(
            cacheable = @Cacheable(key = "#id"),
            put = @CachePut(key = "#id"),
            evict = @CacheEvict(key = "#id")
    )
    public String complexCachingLogic(Long id, String value) {
        System.out.println("Performing complex caching logic for ID: " + id);
        return value;
    }
}
