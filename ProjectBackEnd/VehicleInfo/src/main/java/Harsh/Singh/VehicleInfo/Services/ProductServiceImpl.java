package Harsh.Singh.VehicleInfo.Services;
import Harsh.Singh.VehicleInfo.Domain.Product;
import Harsh.Singh.VehicleInfo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProductDetail(Product product) throws Exception {
        if(productRepository.findById(product.getTitle()).isPresent())
        {
            throw new Exception();
        }
        else
        {
            productRepository.save(product);
        }
        return product;
    }

    @Override
    public List<Product> getAllProductDetail() {
        return productRepository.findAll();
    }



    @Override
    public Product updateProduct(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if (productOptional.isPresent()) {
            Product productResult = productOptional.get();
            productResult.setDescription(product.getDescription());
            productResult.setPrice(product.getPrice());
            productResult.setImageUrl(product.getImageUrl());
            productResult.setBrand(product.getBrand());
            productResult.setTitle(product.getTitle());
            productResult.setColor(product.getColor());
            productResult.setDiscountedPrice(product.getDiscountedPrice());
            productResult.setDiscountPercent(product.getDiscountPercent());
            productResult.setCategory(product.getCategory());
            productResult.setSecondCategory(product.getSecondCategory());
            productResult.setThirdCategory(product.getThirdCategory());
            return productRepository.save(productResult);
        }
        return null;
    }

    @Override
    public Product deleteProduct(Product product, byte[] bytes) {
        if(productRepository.findById(product.getTitle()).isPresent())
        {
            product.setImageUrl(bytes);
            productRepository.delete(product);
        }

        return null;
    }


    @Override
    public Product registerProduct(Product product) {
        if(productRepository.findById(product.getTitle()).isPresent())
        {
            return null;
        }

        return productRepository.save(product);

    }
    @Override
    public Product findByProductName(String title)
    {
        Optional<Product> product=productRepository.findById(title);
        return product.get();
    }

}