package com.yosmitha.enterprise_iam.entity;
import jakarta.persistence.*;import java.time.Instant;
@Entity @Table(name="one_time_tokens")
public class OneTimeToken {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String token;
 @ManyToOne(optional=false) private User user;
 @Column(nullable=false) private Instant expiresAt;
 @Column(nullable=false) private String purpose;
 public OneTimeToken(){} public OneTimeToken(String t,User u,Instant e,String p){token=t;user=u;expiresAt=e;purpose=p;}
 public String getToken(){return token;} public User getUser(){return user;} public Instant getExpiresAt(){return expiresAt;} public String getPurpose(){return purpose;}
}
