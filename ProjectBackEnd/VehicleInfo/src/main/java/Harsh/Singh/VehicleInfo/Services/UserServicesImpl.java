package Harsh.Singh.VehicleInfo.Services;

import Harsh.Singh.VehicleInfo.Domain.User;
import Harsh.Singh.VehicleInfo.Domain.UserDTO;
import Harsh.Singh.VehicleInfo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServicesImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User addCart(UserDTO userdto) {
        System.out.println(userdto);
        Optional<User> userOptional = userRepository.findById(userdto.getUserName());

        if (userOptional.isEmpty()) {
            User newUser = new User();
            newUser.setUserName(userdto.getUserName());
            List<String> titles = new ArrayList<>();
            titles.add(userdto.getTitle());
            newUser.setTitles(titles);
            System.out.println("New User: " + newUser);
            return userRepository.save(newUser);
        } else {
            User existingUser = userOptional.get();
            List<String> titles = existingUser.getTitles();
            titles.add(userdto.getTitle());
            existingUser.setTitles(titles);
            System.out.println("Existing User: " + existingUser);
            return userRepository.save(existingUser);
        }
    }

    @Override
    public User findUserList(String userName) {
        Optional<User> userOptional = userRepository.findById(userName);
        return userOptional.orElse(null);  // Return null if user is not found
    }
}












