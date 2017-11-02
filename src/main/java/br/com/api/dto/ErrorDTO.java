package br.com.api.dto;

import java.io.Serializable;
import java.util.Map;

public class ErrorDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String error;
    private String descricao;
    private Map<String, String> detalhes;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public Map<String, String> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(Map<String, String> detalhes) {
        this.detalhes = detalhes;
    }
}
