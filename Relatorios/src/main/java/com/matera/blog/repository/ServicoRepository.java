package com.matera.blog.repository;
import com.matera.blog.model.Servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Define a classe como um bean do Spring
public interface ServicoRepository extends JpaRepository<Servico, Long> { }