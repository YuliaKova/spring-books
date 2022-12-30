package tacos.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tacos.domain.entity.User;
import tacos.domain.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
