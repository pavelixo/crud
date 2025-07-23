package io.github.pavelixo.Crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEmployeeDTO {
	@NotBlank(message = "Nome não pode estar vazio")
	private String name;
	
	@NotNull(message = "Cargo é obrigatório")
	private Long roleId;
}
