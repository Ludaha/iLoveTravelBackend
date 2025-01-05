package architect.ludaha.ilovetravelbackend.application.services;

import architect.ludaha.ilovetravelbackend.domain.dtos.User.RegisterRequest;
import architect.ludaha.ilovetravelbackend.domain.dtos.User.RegisterResponse;

public interface UserService {
    RegisterResponse registerUser(RegisterRequest request);
}
