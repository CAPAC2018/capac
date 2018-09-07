package ro.capac.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.capac.server.entity.User;
import ro.capac.server.model.RegisterUserResponse;
import ro.capac.server.repository.UserRepository;

@RestController
public class RegisterController {

    private final Logger log = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/registerUser")
    public RegisterUserResponse serverRegisterUser(
            @RequestParam(value="user_name") String name,
            @RequestParam(value="user_email") String email,
            @RequestParam(value="user_phone_number") String phone,
            @RequestParam(value="user_password") String password
    ) {
        RegisterUserResponse response= new RegisterUserResponse();
        log.info("registerUser - called");
        if(userRepo.findByEmail(email).isPresent()){
            response.setMessage("This email password is already in use.");
            response.setStatusCode("fail");
            return response;
        }
        if(userRepo.findByUserName(name).isPresent()){
            response.setMessage("This name is already in use.");
            response.setStatusCode("fail");
            return response;
        }
        User user = new User();
        user.setUserEmail(email);
        user.setUserName(name);
        user.setPhone(phone);
        user.setPassword(password);
        User savedUser = userRepo.save(user);
        log.info("saved user: {}", savedUser);
        response.setMessage("Bunaa, " + name + " cu ID=" + savedUser.getId());
        response.setStatusCode("success");
        return response;
    }

}
