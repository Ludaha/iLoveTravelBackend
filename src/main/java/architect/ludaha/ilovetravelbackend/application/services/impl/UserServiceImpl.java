package architect.ludaha.ilovetravelbackend.application.services.impl;

import architect.ludaha.ilovetravelbackend.application.mappers.UserMapper;
import architect.ludaha.ilovetravelbackend.application.services.UserService;
import architect.ludaha.ilovetravelbackend.domain.dtos.User.RegisterRequest;
import architect.ludaha.ilovetravelbackend.domain.dtos.User.RegisterResponse;
import architect.ludaha.ilovetravelbackend.domain.models.User;
import architect.ludaha.ilovetravelbackend.domain.ports.out.UserRepository;
import architect.ludaha.ilovetravelbackend.infrastructure.config.exceptions.EmailAlreadyExistsException;
import architect.ludaha.ilovetravelbackend.infrastructure.config.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserMapper userMapper;

    public RegisterResponse registerUser(RegisterRequest request){
        if (userRepository.findByEmail(request.email()).isPresent()){
            throw new EmailAlreadyExistsException("El correo electrónico ya está registrado");
        }
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);

        String token = jwtService.getToken(user, user);

        return new RegisterResponse(token, "Usuario registrado exitosamente");
    }
}
