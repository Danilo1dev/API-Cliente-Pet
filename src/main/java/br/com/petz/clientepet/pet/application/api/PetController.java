package br.com.petz.clientepet.pet.application.api;

import java.util.UUID;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class PetController implements PetAPI {

	@Override
	public PetResponde postPet(UUID idCliente, @Valid PetRequest petRquest) {
		log.info("[inicia] PetController - postPet");
		log.info("[idClient] {}", idCliente);
		log.info("[finaliza] PetController - postPet");
		return null;
	}
}
