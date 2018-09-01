package com.iphayao.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> searchCustomerByName(String name) {
        return customerRepository.findByFirstName(name);
    }

    public Customer addCustomer(Customer customer) {
        if(customerRepository.existsById(customer.getId())) {
            return null;
        }
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer customer) {
        if(!customerRepository.existsById(id)) {
            return null;
        }
        return customerRepository.save(customer);
    }

    public boolean deleteCustomer(Long id) {
        if(!customerRepository.existsById(id)) {
            return false;
        }
        customerRepository.deleteById(id);
        return true;
    }
}
