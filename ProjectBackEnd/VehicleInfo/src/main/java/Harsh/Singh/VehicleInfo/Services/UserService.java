package Harsh.Singh.VehicleInfo.Services;

import Harsh.Singh.VehicleInfo.Domain.User;
import Harsh.Singh.VehicleInfo.Domain.UserDTO;


public interface UserService {
    User addCart(UserDTO userdto);
    public User findUserList(String userName);
}
