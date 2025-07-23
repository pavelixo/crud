package io.github.pavelixo.Crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.pavelixo.Crud.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
