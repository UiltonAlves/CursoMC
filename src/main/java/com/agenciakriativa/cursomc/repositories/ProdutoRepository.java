package com.agenciakriativa.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.agenciakriativa.cursomc.domain.Categoria;
import com.agenciakriativa.cursomc.domain.Produto;

@Repository
@Transactional(readOnly=true)
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
	
//Usa este ou o de baixa e a mesma coisa
//	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias ")
//	Page<Produto> seach(
//			@Param("nome") String nome,
//			@Param("categorias") List<Categoria> categorias,
//			Pageable pageRequest);
	
	@Transactional(readOnly = true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(
			@Param("nome") String nome,
			@Param("categorias") List<Categoria> categorias,
			Pageable pageRequest);
	
}
