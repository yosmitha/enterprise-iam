package com.yosmitha.enterprise_iam.repository;
import com.yosmitha.enterprise_iam.entity.RefreshSession;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface RefreshSessionRepository extends JpaRepository<RefreshSession,Long>{Optional<RefreshSession> findByTokenHash(String hash); List<RefreshSession> findByUser_IdAndRevokedAtIsNull(Long userId);}
