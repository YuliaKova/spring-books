package tacos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import tacos.domain.entity.User;
import tacos.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(
//            PasswordEncoder passwordEncoder) {
//        List<UserDetails> users = new ArrayList<>();
//        users.add(new User(
//                "buzz",
//                passwordEncoder.encode("pass"),
//                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//        users.add(new User(
//                "woody",
//                passwordEncoder.encode("pass"),
//                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//
//        return new InMemoryUserDetailsManager(users);
//    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository repo) {
        return username -> {
            User user = repo.findByUsername(username);
            if (user != null) {
                return user;
            }

            throw new UsernameNotFoundException("User not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .antMatchers("/design",
                        "/orders").hasRole("USER")
                .antMatchers("/", "/**").permitAll()
                .and()
                .formLogin().loginPage("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .build();
    }
}
