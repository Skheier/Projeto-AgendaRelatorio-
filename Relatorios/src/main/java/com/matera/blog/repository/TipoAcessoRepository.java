package com.matera.blog.repository;
import com.matera.blog.model.TipoAcesso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAcessoRepository extends JpaRepository<TipoAcesso, Long> {
}
