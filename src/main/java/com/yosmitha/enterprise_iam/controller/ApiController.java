package com.yosmitha.enterprise_iam.controller;
import com.yosmitha.enterprise_iam.dto.ApiDtos.*;import com.yosmitha.enterprise_iam.service.IamService;import jakarta.servlet.http.HttpServletRequest;import jakarta.validation.Valid;import org.springframework.security.core.annotation.AuthenticationPrincipal;import org.springframework.security.oauth2.jwt.Jwt;import org.springframework.web.bind.annotation.*;import java.util.*;
@RestController public class ApiController{
 final IamService iam;public ApiController(IamService i){iam=i;}
 String ua(HttpServletRequest r){return r.getHeader("User-Agent");}
 @PostMapping("/api/auth/register") public Object register(@Valid @RequestBody Register x){return iam.register(x);}
 @PostMapping("/api/auth/verify-email") public Object verify(@Valid @RequestBody Token x){return iam.verify(x);}
 @PostMapping("/api/auth/login") public Object login(@Valid @RequestBody Login x,HttpServletRequest r){return iam.login(x,ua(r),r.getRemoteAddr());}
 @PostMapping("/api/auth/refresh") public Object refresh(@Valid @RequestBody Refresh x,HttpServletRequest r){return iam.refresh(x,ua(r),r.getRemoteAddr());}
 @PostMapping("/api/auth/logout") public Object logout(@Valid @RequestBody Refresh x){return iam.logout(x);}
 @PostMapping("/api/auth/forgot-password") public Object forgot(@Valid @RequestBody Forgot x){return iam.forgot(x);}
 @PostMapping("/api/auth/reset-password") public Object reset(@Valid @RequestBody Reset x){return iam.reset(x);}
 @GetMapping("/api/users/me") public Object me(@AuthenticationPrincipal Jwt j){return iam.profile(j.getSubject(),null);}
 @PutMapping("/api/users/me") public Object update(@AuthenticationPrincipal Jwt j,@Valid @RequestBody Profile p){return iam.profile(j.getSubject(),p);}
 @PostMapping("/api/users/me/mfa/setup") public Object setup(@AuthenticationPrincipal Jwt j){return iam.setupMfa(j.getSubject());}
 @PostMapping("/api/users/me/mfa/enable") public Object enableMfa(@AuthenticationPrincipal Jwt j,@Valid @RequestBody MfaCode x){return iam.enableMfa(j.getSubject(),x);}
 @DeleteMapping("/api/users/me/mfa") public Object disableMfa(@AuthenticationPrincipal Jwt j){return iam.disableMfa(j.getSubject());}
 @PostMapping("/api/admin/roles") public Object role(@Valid @RequestBody RoleInput x){return iam.addRole(x.name(),x.description());}
 @PostMapping("/api/admin/permissions") public Object permission(@Valid @RequestBody PermissionInput x){return iam.addPermission(x.name(),x.description());}
 @PostMapping("/api/admin/users/{uid}/roles/{rid}") public Object assign(@PathVariable Long uid,@PathVariable Long rid){iam.assignRole(uid,rid);return Map.of("message","Role assigned");}
 @PostMapping("/api/admin/roles/{rid}/permissions/{pid}") public Object grant(@PathVariable Long rid,@PathVariable Long pid){iam.grant(rid,pid);return Map.of("message","Permission granted");}
 @PatchMapping("/api/admin/users/{id}/enabled") public Object enabled(@PathVariable Long id,@RequestParam boolean value){iam.enable(id,value);return Map.of("message","User status updated");}
}
