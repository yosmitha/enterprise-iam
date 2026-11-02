package com.yosmitha.enterprise_iam.entity;
import jakarta.persistence.*;import java.time.Instant;
@Entity @Table(name="audit_logs")
public class AuditLog {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Long actorUserId;@Column(nullable=false) private String action;private String target;private String details;
 @Column(nullable=false) private Instant createdAt=Instant.now();
 public AuditLog(){} public AuditLog(Long a,String x,String t,String d){actorUserId=a;action=x;target=t;details=d;}
 public Long getId(){return id;} public Long getActorUserId(){return actorUserId;} public String getAction(){return action;} public String getTarget(){return target;} public String getDetails(){return details;} public Instant getCreatedAt(){return createdAt;}
}
