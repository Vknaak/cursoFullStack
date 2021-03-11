package io.github.vknaak.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.vknaak.entity.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
