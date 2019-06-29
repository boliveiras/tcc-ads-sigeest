package br.com.sigeest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigeest.model.Grupo;
import br.com.sigeest.repository.Grupos;

@Service
public class GrupoService {
	
	@Autowired
	private Grupos grupos;
	
	public List<Grupo> retornarTodos(){
		return grupos.findAll();
	}

}
