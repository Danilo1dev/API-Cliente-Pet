package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import br.com.petz.clientepet.pet.domain.Porte;
import br.com.petz.clientepet.pet.domain.SexoPet;
import br.com.petz.clientepet.pet.domain.TipoPet;
import lombok.Value;

@Value
public class PetRequest {
	private UUID idPet;
	@NotBlank
	private String nomePet;
	@Enumerated(EnumType.STRING)
	private Porte porte;
	@NotNull
	private TipoPet tipo;
	private String microchip;
	@NotBlank
	private String raca;
	@NotNull
	private SexoPet sexo;
	private String pelagemCor;
	@NotNull
	private LocalDate dataNascimento;
	private String rga;
	private Integer peso;
}
