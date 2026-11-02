package com.yosmitha.enterprise_iam.repository;
import com.yosmitha.enterprise_iam.entity.OneTimeToken;import org.springframework.data.jpa.repository.JpaRepository;import java.util.*;
public interface OneTimeTokenRepository extends JpaRepository<OneTimeToken,Long>{Optional<OneTimeToken> findByTokenAndPurpose(String token,String purpose);}
