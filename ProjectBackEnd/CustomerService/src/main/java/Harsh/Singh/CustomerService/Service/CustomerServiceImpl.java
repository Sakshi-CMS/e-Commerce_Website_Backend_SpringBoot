package Harsh.Singh.CustomerService.Service;

import Harsh.Singh.CustomerService.Domain.Customer;
import Harsh.Singh.CustomerService.Exception.UserExist;
import Harsh.Singh.CustomerService.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {
 private CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveUser(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findByUsernameAndPassword(String customerName, long phoneNo) throws UserExist {
        Customer cust=customerRepository.findByCustomerNameAndPhoneNo(customerName,phoneNo);
        if(cust==null)
        {
            throw new UserExist();
        }

        return cust;
    }
}
