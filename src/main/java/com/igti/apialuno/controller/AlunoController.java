package com.igti.apialuno.controller;

import com.igti.apialuno.entity.Aluno;
import com.igti.apialuno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Aluno>> listarAlunos() {

        List<Aluno> alunos = alunoRepository.findAll();

        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Aluno> obterById(@PathVariable String id) {

        Optional<Aluno> aluno = alunoRepository.findById(id);

        if(!aluno.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(aluno.get(), HttpStatus.OK);
    }

}
