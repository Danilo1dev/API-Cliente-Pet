package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import br.com.petz.clientepet.pet.application.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;

public interface PetService {
	PetResponse criaPet(UUID idCliente, @Valid PetRequest petRquest);
	List<PetClienteListResponse> buscaPetDoClienteComId(UUID idCliente);
	PetClienteDetalhadoResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet);
	void deletaPetDoClienteComID(UUID idCliente, UUID idPet);
	void alteraPetDoClienteComId(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petAlteracaoRequest);
}
