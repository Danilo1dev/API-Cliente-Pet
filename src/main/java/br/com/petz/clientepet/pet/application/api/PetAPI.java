package br.com.petz.clientepet.pet.application.api;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PetResponse postPet(@PathVariable UUID idCliente, @Valid @RequestBody PetRequest petRquest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<PetClienteListResponse> getPetDoClienteComId(@PathVariable UUID idCliente);
	
	@GetMapping(value = "/{idPet}")
	@ResponseStatus(code = HttpStatus.OK)
	PetClienteDetalhadoResponse getPetDoClienteComId(@PathVariable UUID idCliente,@PathVariable UUID idPet);
	
	@DeleteMapping(value = "/{idPet}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void detelePetDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idPet);
}
