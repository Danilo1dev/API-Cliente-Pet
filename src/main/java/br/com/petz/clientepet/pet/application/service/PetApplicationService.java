package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetAlteracaoRequest;
import br.com.petz.clientepet.pet.application.api.PetClienteDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	private final ClienteService clienteService;
	private final PetRepository petRepository;

	@Override
	public PetResponse criaPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetApplicationService - criaPet");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[finaliza] PetApplicationService - criaPet");
		return new PetResponse(pet.getIdPet());
	}

	@Override
	public List<PetClienteListResponse> buscaPetDoClienteComId(UUID idCliente) {
		log.info("[inicia] PetApplicationService - buscaPetDoClienteComId");
		clienteService.buscaClienteAtravesId(idCliente);
		List<Pet> petDoCliente = petRepository.buscaPetDoClienteComId(idCliente);
		log.info("[finaliza] PetApplicationService - buscaPetDoClienteComId");
		return PetClienteListResponse.converte(petDoCliente);
	}

	@Override
	public PetClienteDetalhadoResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - buscaPetDoClienteComId");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		log.info("[inicia] PetApplicationService - buscaPetDoClienteComId");
		return new PetClienteDetalhadoResponse(pet);
	}

	@Override
	public void deletaPetDoClienteComID(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetApplicationService - deletaPetDoClienteComID");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		petRepository.deletaPet(pet);
		log.info("[finaliza] PetApplicationService - deletaPetDoClienteComID");
	}

	@Override
	public void alteraPetDoClienteComId(UUID idCliente, UUID idPet, @Valid PetAlteracaoRequest petAlteracaoRequest) {
		log.info("[inicia] PetApplicationService - alteraPetDoClienteComId");
		clienteService.buscaClienteAtravesId(idCliente);
		Pet pet = petRepository.buscaPetPeloId(idPet);
		pet.altera(petAlteracaoRequest);
		petRepository.salvaPet(pet);
		log.info("[finaliza] PetApplicationService - alteraPetDoClienteComId");
	}
}
