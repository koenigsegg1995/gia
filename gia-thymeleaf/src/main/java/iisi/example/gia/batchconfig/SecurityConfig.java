package iisi.example.gia.batchconfig;

import iisi.example.gia.service.GiaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private GiaUserDetailsService giaUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                // 1. 基本安全配置
                .csrf(csrf -> csrf.disable())
                // 2. 請求授權規則
                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/").permitAll()// 允許不必登入的頁面
                        .anyRequest().authenticated() // 允許不必認證的請求
                )
                // 3. 登入相關配置
                .formLogin(form -> form
                        .defaultSuccessUrl("/") // 登入成功跳轉頁面
                        .permitAll()
                )
                // 4. 登出相關配置
                .logout(logout -> logout // 登出
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll()
                )
                // 5. 其他身份驗證配置
                .userDetailsService(giaUserDetailsService)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
