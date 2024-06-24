package Harsh.Singh.VehicleInfo.Repository;


import Harsh.Singh.VehicleInfo.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
