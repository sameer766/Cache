package com.sameer.cache.cacheexample.service;

import com.sameer.cache.cacheexample.entity.UserEntity;
import com.sameer.cache.cacheexample.repo.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"user"})
public class UserEntityService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  CacheManager cacheManager;


  public void saveUser() {
    for (int i = 0; i < 1000000; i++) {
      userRepository.save(new UserEntity(i, "a", "b", "c", "d" + i, "e", "f", Boolean.FALSE));
    }
  }

  @Cacheable(value = "cacheUserCacheable", key = "#root.methodName")
  public List<UserEntity> getUserCacheable() throws InterruptedException {
    return userRepository.findAll();
  }
  @CachePut(value = "cacheUserCachePut", key = "#root.methodName")
  public List<UserEntity> getUserCachePut() throws InterruptedException {
    return userRepository.findAll();
  }

  @CacheEvict(allEntries = true)
  public void clear() {
    cacheManager.getCacheNames().stream()
        .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
  }

  //  @Scheduled(fixedRate = 9000)
  public void evictAllcachesAtIntervals() {
    clear();
  }
}
