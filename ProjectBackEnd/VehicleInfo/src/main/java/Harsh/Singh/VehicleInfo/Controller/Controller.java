//package Harsh.Singh.VehicleInfo.Controller;
//
//import Harsh.Singh.VehicleInfo.Domain.User;
//import Harsh.Singh.VehicleInfo.Domain.UserDTO;
//import Harsh.Singh.VehicleInfo.Domain.Vehicle;
//import Harsh.Singh.VehicleInfo.Services.UserService;
//import Harsh.Singh.VehicleInfo.Services.VehicleService;
//import com.google.gson.Gson;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/vehicle")
//@CrossOrigin("*")
//public class Controller {
//    Gson gson=new Gson();
//    private ResponseEntity responseEntity;
//    private VehicleService vehicleService;
//    private UserService userService;
//    @Autowired
//    public Controller(VehicleService vehicleService,UserService userService) {
//        this.vehicleService=vehicleService;
//        this.userService=userService;
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<?> saveVehicle(
//            @RequestParam("vehicleName") String vehicleName,
//            @RequestParam("vehicleModel") String vehicleModel,
//            @RequestParam("vehiclePrice") long vehiclePrice,
//            @RequestParam("image") MultipartFile image) {
//
//        ResponseEntity<?> responseEntity;
//
//        try {
//            byte[] imageBytes = image.getBytes();
//            Vehicle vehicle = new Vehicle(vehicleName, vehicleModel, vehiclePrice, imageBytes);
//            vehicleService.registervehicle(vehicle);
//            responseEntity = new ResponseEntity<>("Vehicle registered successfully", HttpStatus.OK);
//        } catch (Exception e) {
//            System.out.println(e);
//            responseEntity = new ResponseEntity<>("Error !!! Try again later", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return responseEntity;
//    }
//
//    @GetMapping("/showAll")
//    public ResponseEntity<?> getAllCustomer() {
//        try {
//            responseEntity = new ResponseEntity<>(vehicleService.getAllVehicleDetail(),HttpStatus.OK);
//        }
//        catch (Exception e)
//        {
//            responseEntity = new ResponseEntity<>("Error !!! Try After Sometime.",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return responseEntity;
//    }
//    @PutMapping("/update")
//    public ResponseEntity<?> updateVehicle(@RequestParam("file")MultipartFile file, @RequestParam("details") String details)
//    {
//        try{
//            Vehicle vehicle=gson.fromJson(details,Vehicle.class);
//            vehicle.setImage(file.getBytes());
//            responseEntity = new ResponseEntity<>(vehicleService.updateVehicle(vehicle), HttpStatus.OK);
//
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//            responseEntity = new ResponseEntity<>("Error !!! Try again later" , HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return responseEntity;
//    }
//    @DeleteMapping("/delete")
//    public ResponseEntity<?> deleteVehicle(@RequestParam("file")MultipartFile file, @RequestParam("details") String details)
//    {
//        try{
//            Vehicle vehicle=gson.fromJson(details,Vehicle.class);
//            responseEntity = new ResponseEntity<>(vehicleService.deleteVehicle(vehicle,file.getBytes()), HttpStatus.OK);
//
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//            responseEntity = new ResponseEntity<>("Error !!! Try again later" , HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return responseEntity;
//    }
//    @PostMapping("/addCart")
//    public ResponseEntity<?> addCart(@RequestBody UserDTO user)
//    {
//        System.out.println(user);
//        return new ResponseEntity<>(  userService.addCart(user), HttpStatus.OK);
//    }
//    @GetMapping("/getVehicle/{vehicleName}")
//    public ResponseEntity<?> findCart(@PathVariable String vehicleName)
//    {
//        return new ResponseEntity<>(vehicleService.findByVehicleName(vehicleName),HttpStatus.OK);
//    }
//    @GetMapping("/getCart/{userName}")
//    public ResponseEntity<?> findCartlist(@PathVariable String userName)
//    {
//        return new ResponseEntity<>(userService.findUserList(userName),HttpStatus.OK);
//    }
//}