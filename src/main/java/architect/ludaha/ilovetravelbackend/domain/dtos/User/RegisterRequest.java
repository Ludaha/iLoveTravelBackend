package architect.ludaha.ilovetravelbackend.domain.dtos.User;

import java.time.LocalDate;

public record RegisterRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDate birthDate,
        String nationality
) {
}
