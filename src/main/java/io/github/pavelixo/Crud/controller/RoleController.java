package io.github.pavelixo.Crud.controller;

import java.util.List;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.pavelixo.Crud.dto.CreateRoleDTO;
import io.github.pavelixo.Crud.model.Role;
import io.github.pavelixo.Crud.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
	private final RoleService roleService;
	
	@GetMapping
	public List<Role> listRoles() {
		return roleService.listRoles();
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> createRole(@Valid @RequestBody CreateRoleDTO request, BindingResult result) {
		if (!result.hasErrors())
			return ResponseEntity
					.ok(roleService
							.createRole(request.getName())
					);
		
        List<String> errors = result
        		.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        
        return ResponseEntity.badRequest().body(errors);
	}
}
