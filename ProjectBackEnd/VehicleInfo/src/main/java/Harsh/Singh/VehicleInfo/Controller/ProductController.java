package Harsh.Singh.VehicleInfo.Controller;
import Harsh.Singh.VehicleInfo.Domain.Product;
import Harsh.Singh.VehicleInfo.Domain.UserDTO;
import Harsh.Singh.VehicleInfo.Services.ProductService;
import Harsh.Singh.VehicleInfo.Services.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
    Gson gson=new Gson();
    private ResponseEntity responseEntity;
    private ProductService productService;
    private UserService userService;
    @Autowired
    public ProductController(ProductService productService,UserService userService) {
        this.productService=productService;
        this.userService=userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(
            @RequestParam("id") String id,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("imageUrl") MultipartFile imageUrl,
            @RequestParam("brand") String brand,
            @RequestParam("title") String title,
            @RequestParam("color") String color,
            @RequestParam("discountedPrice") double discountedPrice,
            @RequestParam("discountPercent") int discountPercent,
            @RequestParam("category") String category,
            @RequestParam("secondCategory") String secondCategory,
            @RequestParam("thirdCategory") String thirdCategory) {

        ResponseEntity<?> responseEntity;

        try {
            byte[] imageBytes = imageUrl.getBytes();
            Product product = new Product(id, description, price, imageBytes, brand, title, color, discountedPrice, discountPercent, category, secondCategory, thirdCategory);
            productService.registerProduct(product);
            responseEntity = new ResponseEntity<>("Product registered successfully", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            responseEntity = new ResponseEntity<>("Error !!! Try again later", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    @GetMapping("/showAll")
    public ResponseEntity<?> getAllCustomer() {
        try {
            responseEntity = new ResponseEntity<>(productService.getAllProductDetail(),HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>("Error !!! Try After Sometime.",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestParam("file")MultipartFile file, @RequestParam("details") String details)
    {
        try{
            Product product=gson.fromJson(details,Product.class);
            product.setImageUrl(file.getBytes());
            responseEntity = new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);

        }
        catch (Exception e)
        {
            System.out.println(e);
            responseEntity = new ResponseEntity<>("Error !!! Try again later" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam("file")MultipartFile file, @RequestParam("details") String details)
    {
        try{
            Product product=gson.fromJson(details,Product.class);
            responseEntity = new ResponseEntity<>(productService.deleteProduct(product,file.getBytes()), HttpStatus.OK);

        }
        catch (Exception e)
        {
            System.out.println(e);
            responseEntity = new ResponseEntity<>("Error !!! Try again later" , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    @PostMapping("/addCart")
    public ResponseEntity<?> addCart(@RequestBody UserDTO user)
    {
        System.out.println(user);
        return new ResponseEntity<>(  userService.addCart(user), HttpStatus.OK);
    }
    @GetMapping("/getProduct/{title}")
    public ResponseEntity<?> findCart(@PathVariable String title)
    {
        return new ResponseEntity<>(productService.findByProductName(title),HttpStatus.OK);
    }
    @GetMapping("/getCart/{userName}")
    public ResponseEntity<?> findCartlist(@PathVariable String userName)
    {
        return new ResponseEntity<>(userService.findUserList(userName),HttpStatus.OK);
    }
}

