package com.igti.apialuno.vo;

import lombok.Data;

@Data
public class AlunoRequest {
    private String nome;
    private String sobrenome;
    private String genero;
    private int idade;
}
