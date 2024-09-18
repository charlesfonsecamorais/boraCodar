package br.com.boracodar.boracodar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.boracodar.boracodar.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
