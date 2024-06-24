package Harsh.Singh.VehicleInfo.Services;

import Harsh.Singh.VehicleInfo.Domain.Product;

import java.util.List;

public interface ProductService {

    Product saveProductDetail(Product product) throws  Exception;
    List<Product> getAllProductDetail();
    Product registerProduct(Product product);
    Product updateProduct(Product product);
    Product deleteProduct(Product product, byte[] bytes);
    Product findByProductName(String title);
}
