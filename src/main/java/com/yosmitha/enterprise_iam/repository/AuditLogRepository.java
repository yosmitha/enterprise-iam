package com.yosmitha.enterprise_iam.repository;
import com.yosmitha.enterprise_iam.entity.AuditLog;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface AuditLogRepository extends JpaRepository<AuditLog,Long>{}
