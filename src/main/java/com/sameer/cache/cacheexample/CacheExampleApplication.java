package com.sameer.cache.cacheexample;

import com.sameer.cache.cacheexample.entity.UserEntity;
import com.sameer.cache.cacheexample.service.UserEntityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableScheduling
public class CacheExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(CacheExampleApplication.class, args);
  }

}
