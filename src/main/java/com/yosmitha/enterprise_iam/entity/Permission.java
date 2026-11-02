package com.yosmitha.enterprise_iam.entity;
import jakarta.persistence.*;
@Entity @Table(name="permissions")
public class Permission {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String name; private String description;
 public Permission(){} public Permission(String n,String d){name=n;description=d;}
 public Long getId(){return id;} public String getName(){return name;} public String getDescription(){return description;}
}
