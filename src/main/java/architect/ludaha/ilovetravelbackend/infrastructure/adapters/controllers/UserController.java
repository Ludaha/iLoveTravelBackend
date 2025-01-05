package architect.ludaha.ilovetravelbackend.infrastructure.adapters.controllers;

import architect.ludaha.ilovetravelbackend.application.services.UserService;
import architect.ludaha.ilovetravelbackend.domain.dtos.User.RegisterRequest;
import architect.ludaha.ilovetravelbackend.domain.dtos.User.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Registro del usuario
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        RegisterResponse response = userService.registerUser(request);
        return ResponseEntity.ok(response);
    }
}
