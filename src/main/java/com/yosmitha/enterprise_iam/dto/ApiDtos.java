package com.yosmitha.enterprise_iam.dto;
import jakarta.validation.constraints.*;
public final class ApiDtos {private ApiDtos(){}
 public record Register(@NotBlank String firstName,@NotBlank String lastName,@NotBlank @Email String email,@NotBlank @Size(min=8,max=72) String password){}
 public record Login(@NotBlank @Email String email,@NotBlank String password,String otp){}
 public record Refresh(@NotBlank String refreshToken){}
 public record TokenPair(String accessToken,String refreshToken,String tokenType,long expiresInSeconds){}
 public record Message(String message){}
 public record Token(@NotBlank String token){}
 public record Forgot(@NotBlank @Email String email){}
 public record Reset(@NotBlank String token,@NotBlank @Size(min=8,max=72) String newPassword){}
 public record Profile(@NotBlank String firstName,@NotBlank String lastName){}
 public record MfaCode(@NotBlank String code){}
 public record RoleInput(@NotBlank String name,String description){}
 public record PermissionInput(@NotBlank String name,String description){}
}
