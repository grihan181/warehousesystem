package course.work.database.controller;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AuthenticationRequestDTO {
    private String login;
    private String password;
}
