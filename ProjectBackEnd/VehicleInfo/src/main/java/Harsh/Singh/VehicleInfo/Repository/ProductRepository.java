package Harsh.Singh.VehicleInfo.Repository;

import Harsh.Singh.VehicleInfo.Domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

    }

