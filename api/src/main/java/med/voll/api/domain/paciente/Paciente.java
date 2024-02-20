package med.voll.api.domain.paciente;

import jakarta.persistence.Embedded;
import lombok.Getter;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Table(name= "pacientes")
@Entity(name= "Pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Paciente {
	
	public Paciente(DadosCadastrosPaciente dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.email = dados.email();
		this.endereco = new Endereco(dados.endereco());
		this.ativo = true;
	}
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;
	private String telefone;
	private String email;
	private boolean ativo;
	
	@Embedded
	private Endereco endereco;

	public void atualizarInformacoes(DadosAtualizacaoPacientes dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco() != null) {
			this.endereco.atualizarInformacao(dados.endereco());
		}
		
	}

	public void excluir() {
		this.ativo = false;
	}
	
}
