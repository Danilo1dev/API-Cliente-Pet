package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import br.com.petz.clientepet.pet.application.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {
	private final PetService petService;

	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[inicia] PetController - postPet");
		log.info("[idCliente] {}", idCliente);
		PetResponse pet = petService.criaPet(idCliente, petRequest);
		log.info("[finaliza] PetController - postPet");
		return pet;
	}

	@Override
	public List<PetClienteListResponse> getPetDoClienteComId(UUID idCliente) {
		log.info("[inicia] PetController - getPetDoClienteComId");
		log.info("[idCliente] {}", idCliente);
		List<PetClienteListResponse> petDoCliente = petService.buscaPetDoClienteComId(idCliente);
		log.info("[finaliza] PetController - getPetDoClienteComId");
		return petDoCliente;
	}

	@Override
	public PetClienteDetalhadoResponse getPetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - getPetDoClienteComId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		PetClienteDetalhadoResponse pet = petService.buscaPetDoClienteComId(idCliente, idPet);
		log.info("[finaliza] PetController - getPetDoClienteComId");
		return pet;
	}

	@Override
	public void detelePetDoClienteComId(UUID idCliente, UUID idPet) {
		log.info("[inicia] PetController - detelePetDoClienteComId");
		log.info("[idCliente] {} - [idPet] {}", idCliente, idPet);
		petService.deletaPetDoClienteComID(idCliente,idPet);
		log.info("[finaliza] PetController - detelePetDoClienteComId");
	}
}
