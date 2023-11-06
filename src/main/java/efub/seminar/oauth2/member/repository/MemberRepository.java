package efub.seminar.oauth2.member.repository;

import efub.seminar.oauth2.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
