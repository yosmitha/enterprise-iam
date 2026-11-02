package com.yosmitha.enterprise_iam.repository;
import com.yosmitha.enterprise_iam.entity.Role;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface RoleRepository extends JpaRepository<Role,Long>{Optional<Role> findByName(String name);}
