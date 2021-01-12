package com.nelioalves.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.dto.ClienteDTO;
import com.nelioalves.cursomc.repositories.ClienteRepository;
import com.nelioalves.cursomc.services.exceptions.DataIntegrityException;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
//	public Product find(Long id) {
//    return this.productRepository.findById(id).orElse(null);
//	}
	
	public Cliente find(Integer id) {
		//return this.repo.findById(id).orElse(null);
		Cliente obj = repo.findById(id).orElse(null);
		if (obj == null) {
			 throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
			 + ", Tipo: " + Cliente.class.getName());
			 }
			return obj;
		}
//	
//	public Cliente update(Cliente obj) {
//		find(obj.getId());
//		return repo.save(obj);
//		}
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj); 
		return repo.save(newObj);
		}
	public void delete(Integer id) {
		find(id);
		try {
		 repo.deleteById(id);
		}catch(DataIntegrityViolationException e){
			 throw new DataIntegrityException("Não é possivel excluir porque não há entidades relacionadas");
		}
		}
	public List<Cliente> findAll(){
		return repo.findAll();
	}
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	public Cliente fromDTO(ClienteDTO objDto) {
//		throw new UnsupportedOperationException();
		return new Cliente(objDto.getId(),objDto.getNome(),objDto.getEmail(),null,null);
	}
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
