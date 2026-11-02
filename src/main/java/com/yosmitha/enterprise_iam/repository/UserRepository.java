package com.yosmitha.enterprise_iam.repository;
import com.yosmitha.enterprise_iam.entity.User;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface UserRepository extends JpaRepository<User,Long>{Optional<User> findByEmail(String email); boolean existsByEmail(String email);}
