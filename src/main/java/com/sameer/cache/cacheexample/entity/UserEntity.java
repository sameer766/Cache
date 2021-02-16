package com.sameer.cache.cacheexample.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity implements Serializable {

  @Setter(AccessLevel.NONE)
  @Getter(AccessLevel.NONE)
  private static final long serialVersionUID=45554938948938498L;
  @Id
  @GeneratedValue
  private long id;
  @Column(nullable = false)
  private String userId;
  @Column(nullable = false,length = 50)
  private String firstName;
  @Column(nullable = false,length = 50)
  private String lastName;
  @Column(nullable = false,length = 120,unique = true)
  private String email;
  @Column(nullable = false)
  private String encryptedPassword;
  private String emailVerificationToken;
  @Column(nullable = false)
  private Boolean emailVerificationStatus=false;
}
