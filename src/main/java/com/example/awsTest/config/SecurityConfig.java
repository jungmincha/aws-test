package com.example.awsTest.config;


import com.example.awsTest.jwt.JwtAccessDeniedHandler;
import com.example.awsTest.jwt.JwtAuthenticationEntryPoint;
import com.example.awsTest.jwt.JwtSecurityConfig;
import com.example.awsTest.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {//패스워드 인코더더
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        "/favicon.ico", "/vue/**"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()//토큰을 사용하기 때문에 csrf 설정은 꺼준다. Exception을 핸들링 할 때 직접 만들었던 JwtAuthenticationEntryPoint, JwtAccessDeniedHandler클래스들을 추가해준다.

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//세션을 사용하지 않기 때문에 세션 설정을 꺼준다.

                .and()
                .authorizeRequests()//HttpServletRequest를 사용하는 요청들에 대한 접근 제한을 설정 한다.
//                .antMatchers("/").permitAll()
                .antMatchers("/api/native-query/board").permitAll()//게시판 목록 조회
                .antMatchers("/api/authenticate").permitAll()//로그인
//                .antMatchers("/view/login").permitAll()
//                .antMatchers("/api/authenticate").permitAll()
//                .antMatchers("/api/test/members").permitAll()
//                .antMatchers("/api/signup").permitAll()
                .anyRequest().authenticated() //그 외의 나머지 요청들에 대해서는 모두 인증되어야 한다.

                .and()
                .apply(new JwtSecurityConfig(tokenProvider));//JwtSecurityConfig 적용
    }
}
