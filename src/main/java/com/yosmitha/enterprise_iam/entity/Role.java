package com.yosmitha.enterprise_iam.entity;
import jakarta.persistence.*;import java.util.*;
@Entity @Table(name="roles")
public class Role {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String name; private String description;
 @ManyToMany(fetch=FetchType.EAGER) @JoinTable(name="role_permissions",joinColumns=@JoinColumn(name="role_id"),inverseJoinColumns=@JoinColumn(name="permission_id")) private Set<Permission> permissions=new HashSet<>();
 public Role(){} public Role(String n,String d){name=n;description=d;}
 public Long getId(){return id;} public String getName(){return name;} public Set<Permission> getPermissions(){return permissions;}
}
