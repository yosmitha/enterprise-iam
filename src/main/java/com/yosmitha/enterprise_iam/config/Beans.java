package com.yosmitha.enterprise_iam.config;
import org.springframework.context.annotation.*;import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration public class Beans {@Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder(12);}}
