package br.com.api.exception;

public class ErroInternoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ErroInternoException(String mensagem) {
        super(mensagem);
    }
}
