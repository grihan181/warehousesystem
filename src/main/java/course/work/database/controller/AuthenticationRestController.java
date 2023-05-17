package course.work.database.controller;

import course.work.database.exception.NoSuchCountExeption;
import course.work.database.model.CompanyEmployee;
import course.work.database.model.Role;
import course.work.database.model.Status;
import course.work.database.repository.CompanyEmployeeRepo;
import course.work.database.security.jwts.AuthService;
import course.work.database.security.jwts.JwtTokenProvider;
import course.work.database.security.jwts.RefreshJwtRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.message.AuthException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {

    private final AuthService authService;

    private CompanyEmployeeRepo userRepo;
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<String> create(@RequestBody CompanyEmployee user) {
        user.setPassword(String.valueOf(new BCryptPasswordEncoder(12).encode(user.getPassword())));
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        userRepo.save(user);
        return new ResponseEntity<>("пользователь создан", HttpStatus.OK);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO authRequest) {
        Map<Object, Object> response = new HashMap<>();
        try {
            final JwtResponse token = authService.login(authRequest);
            return ResponseEntity.ok(token);
        } catch (AuthenticationException | AuthException e) {
            throw new NoSuchCountExeption("Invalid email/password combination");
        }
    }

    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }
}
