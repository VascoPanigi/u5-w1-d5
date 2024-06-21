package vascopanigi.u5_w1_d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vascopanigi.u5_w1_d5.entities.User;
import vascopanigi.u5_w1_d5.repositories.UserRepository;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User searchUser(String username){
        return userRepository.findByUsername(username);
    }
}
