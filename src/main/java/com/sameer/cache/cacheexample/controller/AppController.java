package com.sameer.cache.cacheexample.controller;

import com.sameer.cache.cacheexample.entity.UserEntity;
import com.sameer.cache.cacheexample.service.UserEntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @Autowired
  UserEntityService userEntityService;

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public void save() {
    userEntityService.saveUser();
  }

  @RequestMapping(value = "/usersCachePut", method = RequestMethod.GET)
  public List<UserEntity> getUser() throws InterruptedException {
    return userEntityService.getUserCachePut();
  }
  @RequestMapping(value = "/usersCacheable", method = RequestMethod.GET)
  public List<UserEntity> getUsers() throws InterruptedException {
    return userEntityService.getUserCacheable();
  }

  @RequestMapping(value = "/clear", method = RequestMethod.GET)
  public void clear() {
    userEntityService.clear();
  }
}
