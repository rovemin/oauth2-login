package efub.seminar.oauth2.config.auth.dto;

import efub.seminar.oauth2.domain.user.entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;

    public SessionUser(User member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
