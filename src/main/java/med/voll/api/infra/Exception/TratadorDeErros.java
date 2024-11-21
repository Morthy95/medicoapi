package med.voll.api.infra.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity TratadorDeErros404() {
        
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErros400(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();
        
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
        
    }


    public record DadosErroValidacao(String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
           
        }
    }
}
