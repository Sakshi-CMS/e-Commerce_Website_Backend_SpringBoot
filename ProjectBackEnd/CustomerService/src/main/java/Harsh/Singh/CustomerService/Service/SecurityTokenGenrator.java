package Harsh.Singh.CustomerService.Service;

import Harsh.Singh.CustomerService.Domain.Customer;

import java.util.Map;

public interface SecurityTokenGenrator {
    Map<String,String> generateToken(Customer customer);
}
