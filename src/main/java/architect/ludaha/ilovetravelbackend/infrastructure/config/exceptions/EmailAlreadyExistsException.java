package architect.ludaha.ilovetravelbackend.infrastructure.config.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
