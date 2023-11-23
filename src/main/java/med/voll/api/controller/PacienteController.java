package med.voll.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.dadosCadastroPaciente;
import med.voll.api.paciente.pacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private pacienteRepository repository;

    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid dadosCadastroPaciente dados) {

        repository.save(new Paciente(dados));
    }

    @GetMapping()
    public Page<Object> Listar(@PageableDefault(size = 2, sort = { "cpf" }) Pageable paginacao) {

        return repository.findAll(paginacao).map(DadosListagemPaciente::new);

    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public void Deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
    
    @GetMapping("/buscarid/{id}")
    public Optional<Paciente> Listar(@PathVariable Long id) {

        return repository.findById(id);

    }
    
}


