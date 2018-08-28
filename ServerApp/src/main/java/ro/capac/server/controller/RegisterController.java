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
            @RequestParam(value="name", defaultValue = "name") String name,
            @RequestParam(value="email", defaultValue = "email") String email,
            @RequestParam(value="phone", defaultValue = "phone") String phone,
            @RequestParam(value="password", defaultValue = "passwd") String password
    ) {
        log.info("registerUser - called");
        User user = new User();
        user.setUserEmail(email);
        user.setUserName(name);
        user.setPhone(phone);
        user.setPassword(password);
        User savedUser = userRepo.save(user);
        log.info("saved user: {}", savedUser);
        //TODO save user
        RegisterUserResponse response= new RegisterUserResponse();
        response.setMessage("Bunaa, " + name + " cu ID=" + savedUser.getId());
        response.setStatusCode("success");
        return response;
    }

}
