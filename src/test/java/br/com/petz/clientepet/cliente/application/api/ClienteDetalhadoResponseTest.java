package br.com.petz.clientepet.cliente.application.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.cliente.domain.Sexo;

class ClienteDetalhadoResponseTest {

	@Test
	void deveraCriarCliente() {
		var cliente = ClienteDetalhadoResponse.builder().nomeCompleto("Danilo Silva").build();
		UUID idCliente = UUID.randomUUID();
		String cpf = "03063118524";
		String email = "danilofoxlog@gmail.com";
		String celular = "73981978258";
		String telefone = "7331662450";
		Sexo sexo = Sexo.MASCULINO;
		Boolean aceitaTermos = true;
		LocalDateTime data = LocalDateTime.now();
		
		var clienteDetalhado = buildClienteDetalhado(cliente, idCliente, cpf, email, celular, telefone, sexo, aceitaTermos, data);
		
		assertEquals(clienteDetalhado.getIdCliente(), idCliente);
		assertEquals(clienteDetalhado.getCpf(), cpf);
		assertEquals(clienteDetalhado.getSexo(), sexo);
	}

	private ClienteDetalhadoResponse buildClienteDetalhado(ClienteDetalhadoResponse cliente, UUID idCliente, String cpf,
			String email, String celular, String telefone, Sexo sexo, Boolean aceitaTermos, LocalDateTime data) {
		
		Cliente clienteNovo = Cliente.builder()
				.idCliente(idCliente)
				.cpf(cpf)
				.email(email)
				.celular(celular)
				.telefone(telefone)
				.sexo(sexo)
				.aceitaTermos(aceitaTermos)
				.dataHoraDoCadastro(data)
				.build();
				var clienteDetalhado = new ClienteDetalhadoResponse(clienteNovo);
				return clienteDetalhado;
	}
}
