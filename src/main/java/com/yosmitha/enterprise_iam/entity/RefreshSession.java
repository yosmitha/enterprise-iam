package com.yosmitha.enterprise_iam.entity;
import jakarta.persistence.*;import java.time.Instant;
@Entity @Table(name="refresh_sessions")
public class RefreshSession {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private User user;
 @Column(nullable=false,unique=true) private String tokenHash;
 @Column(nullable=false) private Instant expiresAt; private Instant revokedAt; private String userAgent,ipAddress;
 public RefreshSession(){} public RefreshSession(User u,String h,Instant e,String ua,String ip){user=u;tokenHash=h;expiresAt=e;userAgent=ua;ipAddress=ip;}
 public User getUser(){return user;} public Instant getExpiresAt(){return expiresAt;} public Instant getRevokedAt(){return revokedAt;} public void setRevokedAt(Instant v){revokedAt=v;}
}
