package com.igti.apialuno.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Aluno {
    private String id;
    private String nome;
    private String sobrenome;
    private String genero;
    private int idade;
}
