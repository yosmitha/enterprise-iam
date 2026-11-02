package com.yosmitha.enterprise_iam.repository;
import com.yosmitha.enterprise_iam.entity.Permission;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface PermissionRepository extends JpaRepository<Permission,Long>{Optional<Permission> findByName(String name);}
