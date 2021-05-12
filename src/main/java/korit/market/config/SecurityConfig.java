package korit.market.config;

import korit.market.entity.Role;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;



@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//            .antMatchers("/sample/all").permitAll()
//            .antMatchers("/sample/member").hasRole("USER");
//        http.formLogin();
//        http.csrf().disable();
//        http.logout();

        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                   .authorizeRequests()
                   .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                   .antMatchers("/api/v1/**").hasRole(Role.MEMBER.name())
                   .anyRequest().authenticated()
                .and()
                   .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                           .userService(customOAuth2UserService);
    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        //사용자 계정은 user1
//        auth.inMemoryAuthentication().withUser("user1")
//                //1111패스워드 인코딩 결과
//                .password("$2a$10$CN2xoyvGVjoy2xrAUkts5uneMdSF31ZIuEsKKmBAPFK/A5119dSKi")
//                .roles("USER");
//    }
}




