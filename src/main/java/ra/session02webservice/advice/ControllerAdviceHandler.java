package ra.session02webservice.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.session02webservice.dto.NotFoundResponse;
import ra.session02webservice.exception.ResourceNotFoundException;

@RestControllerAdvice // nhận các ngoại lệ
public class ControllerAdviceHandler {
    @ExceptionHandler(ResourceNotFoundException.class) // mapping exception
    public ResponseEntity<?> handlerNotFound(ResourceNotFoundException e){
        NotFoundResponse notFoundResponse = new NotFoundResponse(e.getMessage(),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(notFoundResponse, HttpStatus.NOT_FOUND);
    }

}
