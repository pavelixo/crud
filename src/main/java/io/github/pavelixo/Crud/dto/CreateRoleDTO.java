package io.github.pavelixo.Crud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateRoleDTO {
	@NotBlank(message = "Nome não pode estar vazio")
	private String name;
}
