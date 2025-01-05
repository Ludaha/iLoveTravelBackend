package architect.ludaha.ilovetravelbackend.application.mappers;

import architect.ludaha.ilovetravelbackend.domain.dtos.User.RegisterRequest;
import architect.ludaha.ilovetravelbackend.domain.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User toUser(RegisterRequest request) {
        return new User(
                0, // El ID se generará automáticamente
                request.firstName(),
                request.lastName(),
                request.email(),
                request.birthDate(),
                request.nationality(),
                null, // La contraseña será codificada posteriormente
                LocalDateTime.now(),
                true,
                false
        );
    }
}
