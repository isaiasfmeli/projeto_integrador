package br.com.dh.meli.projeto_integrador.service;

import br.com.dh.meli.projeto_integrador.model.Customer;

public interface ICustomerService {
    Customer getCustomerById(Long id);
}
