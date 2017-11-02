package br.com.api.utils;

import br.com.api.dto.ErrorDTO;

import java.util.Map;

public class ErrorDTOBuilder {
    private ErrorDTO error = new ErrorDTO();

    public static ErrorDTOBuilder get() {
        return new ErrorDTOBuilder();
    }

    public ErrorDTO build() {
        return error;
    }

    public ErrorDTOBuilder comErro(String erro) {
        error.setError(erro);
        return this;
    }

    public ErrorDTOBuilder comDescricao(String descricao) {
        error.setDescricao(descricao);
        return this;
    }

    public ErrorDTOBuilder comDetalhes(Map<String, String> detalhe) {
        error.setDetalhes(detalhe);
        return this;
    }
}
