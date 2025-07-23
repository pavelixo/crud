package io.github.pavelixo.Crud.service;

import org.springframework.stereotype.Service;

import io.github.pavelixo.Crud.model.Role;
import io.github.pavelixo.Crud.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    
    public Role createRole(String name) {
        return roleRepository
        		.save(initializeRole(name));
    }
    
    private Role initializeRole(String name) {
        return Role
        		.builder()
        		.name(name)
        		.build();
    }
}
