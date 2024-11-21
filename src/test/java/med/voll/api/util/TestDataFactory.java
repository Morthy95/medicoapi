package med.voll.api.util;

import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

public class TestDataFactory {

    public static Paciente criarPaciente() {
        Endereco endereco = new Endereco(
                "Casa do Arvoreiro",
                "Parque das Arvores",
                "04824010",
                "160",
                "Casa",
                "São Paulo",
                "SP");

        return new Paciente(
                null, // ID será gerado pelo banco
                "Gabriel Peter",
                "gabriel_peter@hotmail.com",
                "11976854335",
                "42243671816",
                endereco,
                true);
    }
    
    public static Medico criarMedico() {
        Endereco endereco = new Endereco(
            "Rua",
            "Rene Risco",
            "04824015",
            "44",
            "Casa",
            "São Paulo",
            "SP"
        );

        return new Medico(
            null, // ID será gerado pelo banco
            "Bruna Moura",
            "bruna_moura@hotmail.com",
            "2820-SP",
            "42243671816",
            Especialidade.ORTOPEDIA,
            endereco,
            true
        );
    }
}
