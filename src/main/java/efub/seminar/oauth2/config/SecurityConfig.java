package efub.seminar.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()       // csrf 보안 설정 사용 X
                .authorizeRequests()    // 사용자가 보내는 요청에 인증 절차 수행 필요
                .antMatchers("/**").permitAll()   // 해당 URL은 인증 절차 수행 생략 가능
                .anyRequest().authenticated()   // 나머지 요청들은 모두 인증 절차 수행 필요
                .and().build();
    }
}
