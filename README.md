# Enterprise IAM Platform

Java 21, Spring Boot 3.5, Spring Security OAuth2 Resource Server, JWT, PostgreSQL, Redis dependency/container, Spring Data JPA, Flyway, Swagger/OpenAPI, Docker Compose, Bean Validation, JUnit 5.

## Implemented baseline
- User registration with BCrypt hashing and email-verification token endpoint
- JWT access/refresh tokens, refresh-token rotation and persisted refresh-session revocation
- RBAC role/permission entities and administrator endpoints to create roles/permissions and assign/grant them
- Password-reset token flow; lock account after five failed logins for 15 minutes
- TOTP MFA setup/enable/disable and OTP check at login
- User profile GET/PUT; audit events for core security actions
- Validation and global exception handler; Flyway schema; Docker Compose; OpenAPI UI

## Important integration notes
This ZIP follows the assignment's PostgreSQL requirement. Redis is included as a dependency and Docker service; this baseline persists refresh-session state in PostgreSQL and does not yet use Redis as a cache.
Email delivery is not configured: development mode returns verification tokens in the registration response and reset-token issuance is intentionally generic. Integrate SMTP/provider delivery before production and never return tokens in responses.
MFA secret encryption-at-rest, secrets manager, rate limiting, production CORS, pagination, full audit coverage, and expanded integration/security tests remain production-hardening tasks. Do not represent this starter baseline as independently security-audited or production-ready.
No default admin credentials or JWT signing secret are committed. Supply them through environment variables before starting the application. Never commit your real `.env` file or production secrets.

## Start
Requires Docker Desktop and Java 21. Set local development values in your terminal before starting Docker Compose. Use a unique, randomly generated JWT secret (Base64-encoded 32+ random bytes) and a strong admin password.

PowerShell example (replace the example values; do not reuse them in production):
```powershell
$env:DB_PASSWORD = "local_db_password_change_me"
$env:JWT_SECRET = [Convert]::ToBase64String([Security.Cryptography.RandomNumberGenerator]::GetBytes(32))
$env:ADMIN_EMAIL = "admin@example.com"
$env:ADMIN_PASSWORD = "ChangeThisLocalPassword123!"
docker compose up --build
```
Swagger: http://localhost:8080/swagger-ui/index.html

Admin credentials are the values you set in `ADMIN_EMAIL` and `ADMIN_PASSWORD`.

## Build/test
```bash
mvn clean test
mvn spring-boot:run
```

## Endpoints
Auth: POST `/api/auth/register`, `/verify-email`, `/login`, `/refresh`, `/logout`, `/forgot-password`, `/reset-password`.
User: GET/PUT `/api/users/me`; POST `/api/users/me/mfa/setup`, `/mfa/enable`; DELETE `/api/users/me/mfa`.
Admin: POST `/api/admin/roles`, `/permissions`, `/users/{uid}/roles/{rid}`, `/roles/{rid}/permissions/{pid}`; PATCH `/api/admin/users/{id}/enabled`.
All admin endpoints require ROLE_ADMIN. Other protected endpoints require a bearer JWT.
