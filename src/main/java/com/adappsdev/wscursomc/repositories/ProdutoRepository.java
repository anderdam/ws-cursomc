package com.adappsdev.wscursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adappsdev.wscursomc.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
