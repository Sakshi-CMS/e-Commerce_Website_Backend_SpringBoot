package Harsh.Singh.CustomerService.config;

//import Harsh.Singh.CustomerService.Domain.Customer;
//import Harsh.Singh.CustomerService.RabbitMq.DTO;
//import Harsh.Singh.CustomerService.Service.CustomerService;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Consumer {
//    @Autowired
//    private CustomerService customerService;
//
//    @RabbitListener(queues="Customer_queue")
//    public void getDataFromRabbitMq(DTO dto)
//    {
//        Customer customer= new Customer();
//        customer.setCustomerName(dto.getCustomerName());
//        customer.setPhoneNo(dto.getPhoneNo());
//        System.out.println(" SAVING DATA IN MYSQL");
//        customerService.saveUser(customer);
//    }
//}
