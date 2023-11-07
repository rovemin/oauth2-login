package efub.seminar.oauth2.config.auth.dto;

import efub.seminar.oauth2.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoogleLoginResponseDto {
    private String name;
    private String email;

    @Builder
    public GoogleLoginResponseDto(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
    }
}
