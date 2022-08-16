package br.com.dh.meli.projeto_integrador.util;

import br.com.dh.meli.projeto_integrador.model.Customer;

public class CustomerUtil {

    public static Customer customerGenerator() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Lucas");
        return customer;
    }
}
