package br.com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String error;
    private String descricao;
    private Map<String, String> detalhes;

}
