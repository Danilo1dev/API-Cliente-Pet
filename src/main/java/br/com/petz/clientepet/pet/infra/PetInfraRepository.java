package br.com.petz.clientepet.pet.infra;

import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARepository petSpringDataJPARepository;

	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[inicia] PetInfraRepository - salvaPet");
		petSpringDataJPARepository.save(pet);
		log.info("[finaliza] PetInfraRepository - salvaPet");
		return pet;
	}

	@Override
	public List<Pet> buscaPetDoClienteComId(UUID idCliente) {
		log.info("[inicia] PetInfraRepository - buscaPetDoClienteComId");
		var pet = petSpringDataJPARepository.findByIdClienteTutor(idCliente);
		log.info("[finaliza] PetInfraRepository - buscaPetDoClienteComId");
		return pet;
	}

	@Override
	public Pet buscaPetPeloId(UUID idPet) {
		log.info("[inicia] PetInfraRepository - buscaPetPeloId");
		var pet = petSpringDataJPARepository.findById(idPet)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado para o idPet = " + idPet));
		log.info("[finaliza] PetInfraRepository - buscaPetPeloId");
		return pet;
	}

	@Override
	public void deletaPet(Pet pet) {
		log.info("[inicia] PetInfraRepository - buscaPetDoClienteComId");
		petSpringDataJPARepository.delete(pet);
		log.info("[finaliza] PetInfraRepository - buscaPetDoClienteComId");
	}
}
