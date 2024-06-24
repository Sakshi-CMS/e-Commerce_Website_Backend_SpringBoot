package Harsh.Singh.CustomerService.Service;

import Harsh.Singh.CustomerService.Domain.Customer;
import Harsh.Singh.CustomerService.Exception.UserExist;

public interface CustomerService {


    Customer saveUser(Customer customer);
    Customer findByUsernameAndPassword(String customerName, long phoneNo) throws UserExist;

}
