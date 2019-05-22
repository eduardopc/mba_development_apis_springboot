package com.igti.apialuno.controller;

import com.igti.apialuno.entity.Aluno;
import com.igti.apialuno.repository.AlunoRepository;
import com.igti.apialuno.vo.AlunoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> criarAluno(@RequestBody @Valid AlunoRequest request){
        Aluno aluno = new Aluno();

        aluno.setNome(request.getNome());
        aluno.setSobrenome(request.getSobrenome());
        aluno.setGenero(request.getGenero());
        aluno.setIdade(request.getIdade());

        alunoRepository.save(aluno);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterarAluno(@PathVariable String id, @RequestBody @Valid AlunoRequest request){
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if(!aluno.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        aluno.get().setNome(request.getNome());
        aluno.get().setSobrenome(request.getSobrenome());
        aluno.get().setGenero(request.getGenero());
        aluno.get().setIdade(request.getIdade());

        alunoRepository.save(aluno.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Void> alterarCampo(@PathVariable String id, @RequestBody @Valid AlunoRequest request) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if(!aluno.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        if(request.getNome() != null) {
            aluno.get().setNome(request.getNome());
        }

        if(request.getSobrenome() != null) {
            aluno.get().setSobrenome(request.getSobrenome());
        }

        if(request.getGenero() != null) {
            aluno.get().setGenero(request.getGenero());
        }

        if(request.getIdade() > 0) {
            aluno.get().setIdade(request.getIdade());
        }

        alunoRepository.save(aluno.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Aluno> removerAlunoById(@PathVariable String id) {

        Optional<Aluno> aluno = alunoRepository.findById(id);

        if(!aluno.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        alunoRepository.delete(aluno.get());
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
