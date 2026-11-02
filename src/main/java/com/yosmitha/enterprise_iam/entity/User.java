package com.yosmitha.enterprise_iam.entity;
import jakarta.persistence.*;import java.time.Instant;import java.util.*;
@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String firstName,lastName;
 @Column(nullable=false,unique=true) private String email;
 @Column(nullable=false) private String passwordHash;
 private boolean enabled=true,emailVerified=false,accountNonLocked=true,mfaEnabled=false;
 private int failedLoginAttempts=0; private Instant lockedUntil; private String mfaSecret;
 @ManyToMany(fetch=FetchType.EAGER) @JoinTable(name="user_roles",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id")) private Set<Role> roles=new HashSet<>();
 public Long getId(){return id;} public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v.trim().toLowerCase(Locale.ROOT);}
 public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;}
 public boolean isEnabled(){return enabled;} public void setEnabled(boolean v){enabled=v;}
 public boolean isEmailVerified(){return emailVerified;} public void setEmailVerified(boolean v){emailVerified=v;}
 public boolean isAccountNonLocked(){return accountNonLocked;} public void setAccountNonLocked(boolean v){accountNonLocked=v;}
 public int getFailedLoginAttempts(){return failedLoginAttempts;} public void setFailedLoginAttempts(int v){failedLoginAttempts=v;}
 public Instant getLockedUntil(){return lockedUntil;} public void setLockedUntil(Instant v){lockedUntil=v;}
 public boolean isMfaEnabled(){return mfaEnabled;} public void setMfaEnabled(boolean v){mfaEnabled=v;}
 public String getMfaSecret(){return mfaSecret;} public void setMfaSecret(String v){mfaSecret=v;}
 public Set<Role> getRoles(){return roles;}
}
