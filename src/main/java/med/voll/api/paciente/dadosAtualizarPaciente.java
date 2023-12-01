package med.voll.api.paciente;


import jakarta.validation.constraints.NotNull;

import med.voll.api.endereco.DadosEndereco;

public record dadosAtualizarPaciente(
String nome,
@NotNull
Long id,          
String telefone,
DadosEndereco endereco
) {

}
