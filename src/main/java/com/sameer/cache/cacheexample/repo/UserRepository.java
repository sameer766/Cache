package com.sameer.cache.cacheexample.repo;

import com.sameer.cache.cacheexample.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

