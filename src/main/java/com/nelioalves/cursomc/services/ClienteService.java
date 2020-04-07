package com.nelioalves.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Cliente;
import com.nelioalves.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

    public Cliente find(Integer id) {
		Cliente obj = repo.findById(id).orElse(null);
		return obj;
	}
}
//public Product find(Long id) {
//    return this.productRepository.findById(id).orElse(null);
//}