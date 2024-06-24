package Harsh.Singh.CustomerService.Repository;

import Harsh.Singh.CustomerService.Domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {

    Customer findByCustomerNameAndPhoneNo(String customerName, long phoneNo);
}
