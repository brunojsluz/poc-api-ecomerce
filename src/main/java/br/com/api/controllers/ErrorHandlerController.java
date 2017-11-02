package br.com.api.controllers;

import br.com.api.dto.ErrorDTO;
import br.com.api.exception.ErroInternoException;
import br.com.api.utils.ErrorDTOBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandlerController {


    public ResponseEntity<ErrorDTO> handleException(ErroInternoException exception) {
        ErrorDTO error = ErrorDTOBuilder.get()
                .comErro(exception.getMessage())
                .build();

        return new ResponseEntity<ErrorDTO>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDTO> handleException(MethodArgumentNotValidException exception) {
        Map<String, String> detalhes = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
            detalhes.put(fieldError.getField(), obterDetalhe(fieldError))
        );

        ErrorDTO error = ErrorDTOBuilder.get()
                .comErro(exception.getMessage())
                .comDescricao("Foi informado parâmetros inválidos")
                .comDetalhes(detalhes)
                .build();

        return new ResponseEntity<ErrorDTO>(error, HttpStatus.BAD_REQUEST);
    }

    private String obterDetalhe(FieldError fieldError) {
        String valorInformado = fieldError.getRejectedValue() != null ? fieldError.getRejectedValue().toString() : null;

        StringBuilder builder = new StringBuilder();
        builder.append("O valor informado foi: [");
        builder.append(valorInformado);
        builder.append("] - ");
        builder.append(fieldError.getDefaultMessage());

        return builder.toString();
    }

}
