package com.igti.apialuno.repository;

import com.igti.apialuno.entity.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
