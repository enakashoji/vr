package br.com.nk.vr.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.nk.vr.model.Cartao;

public interface CartaoRepository extends CrudRepository<Cartao, String>{

	Optional<Cartao> findById(String numeroCartao); 
}
