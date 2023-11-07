package efub.seminar.oauth2.config.auth;

import efub.seminar.oauth2.config.auth.dto.GoogleLoginResponseDto;
import efub.seminar.oauth2.config.auth.dto.SessionUser;
import efub.seminar.oauth2.domain.member.entity.Member;
import efub.seminar.oauth2.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final HttpSession httpSession;
    private final MemberRepository memberRepository;

    @GetMapping("/google/login")
    public GoogleLoginResponseDto googleLogin() {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");

        if (sessionUser == null) {
            return null;
        }

        Member member = Member.builder()
                .name(sessionUser.getName())
                .email(sessionUser.getEmail())
                .build();
        memberRepository.save(member);

        return new GoogleLoginResponseDto(member);
    }

}
