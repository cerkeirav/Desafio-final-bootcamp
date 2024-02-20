package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(
		Long id,
		String nome,
		String cpf, 
		String email,
		Endereco endereco) {
	
	public DadosDetalhamentoPaciente(Paciente dados) {
		this(dados.getId(), dados.getNome(), dados.getCpf(), dados.getEmail(), dados.getEndereco());
	}

}
