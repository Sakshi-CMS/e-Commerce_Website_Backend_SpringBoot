package Harsh.Singh.CustomerService.Controller;

import Harsh.Singh.CustomerService.Domain.Customer;
import Harsh.Singh.CustomerService.Exception.UserExist;
import Harsh.Singh.CustomerService.Service.CustomerService;
import Harsh.Singh.CustomerService.Service.SecurityTokenGenrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class controller {
    private CustomerService customerService;
    private ResponseEntity responseEntity;

    @Autowired
    public controller(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Autowired
    private SecurityTokenGenrator securityTokenGenrator;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Customer customer){
        Customer userCreated=customerService.saveUser(customer);
            return responseEntity=new ResponseEntity<>(userCreated, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody Customer customer) throws UserExist {
        Map<String,String> map = null;
        try{
           Customer userobj = customerService.findByUsernameAndPassword(customer.getCustomerName(), customer.getPhoneNo());
            if(userobj.getCustomerName().equals(customer.getCustomerName()))
            {

                map = securityTokenGenrator.generateToken(customer);
                System.out.println(map);
            }
            responseEntity = new ResponseEntity<>(map, HttpStatus.OK);}
        catch(UserExist e){
            throw  new UserExist();}
        catch(Exception e){
            responseEntity  = new ResponseEntity("Try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);}
        return responseEntity;}
}
