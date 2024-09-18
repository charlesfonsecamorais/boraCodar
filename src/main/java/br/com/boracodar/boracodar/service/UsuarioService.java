package br.com.boracodar.boracodar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.boracodar.boracodar.dto.UsuarioDto;
import br.com.boracodar.boracodar.entity.UsuarioEntity;
import br.com.boracodar.boracodar.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDto>listarTodos() {
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDto::new).toList();
	}
	
	public void inserir(UsuarioDto usuarioDto) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDto);
		usuarioRepository.save(usuarioEntity);
	}
	
	public UsuarioDto alterar(UsuarioDto usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDto(usuarioRepository.save(usuarioEntity));
	}
	
	public void excluir(Long id) {
		UsuarioEntity usuario = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuario);
	}
	
	public UsuarioDto buscarPorId(Long id) {
		return new UsuarioDto(usuarioRepository.findById(id).get());
		
	}
}
