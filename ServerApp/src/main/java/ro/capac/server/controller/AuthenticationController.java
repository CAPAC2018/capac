package ro.capac.server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import ro.capac.server.entity.User;
import ro.capac.server.model.AuthenticationResponse;
import ro.capac.server.repository.UserRepository;

public class AuthenticationController {
    @RestController
    public static class RegisterController {

        private final Logger log = LoggerFactory.getLogger(RegisterController.class);
        @Autowired
        private UserRepository userRepo;

        @RequestMapping("/registerUser")
        public AuthenticationResponse.RegisterUserResponse serverRegisterUser(
                @RequestParam(value="user_name") String name,
                @RequestParam(value="user_email") String email,
                @RequestParam(value="user_phone_number") String phone,
                @RequestParam(value="user_password") String password
        ) {
            AuthenticationResponse.RegisterUserResponse response= new AuthenticationResponse.RegisterUserResponse();
            log.info("registerUser - called");
            if(userRepo.findByUserEmail(email).isPresent()){
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

    @RestController
    public static class LoginLogOutController {

        private final Logger log = LoggerFactory.getLogger(LoginLogOutController.class);

        @Autowired
        private UserRepository userRepo;

        @RequestMapping("/serverLogin")
        public AuthenticationResponse.LoginResponse serverLogin(
                @RequestParam(value="email") String email,
                @RequestParam(value="password") String password
        ) {
            log.info("serverLogin: email={}", email);
            AuthenticationResponse.LoginResponse resp = new AuthenticationResponse.LoginResponse();
            Optional<User> userOpt = userRepo.findByUserEmailAndPassword(email, password);
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                resp.setUserId(user.getId());
                resp.setUserName(user.getUserName());
                resp.setUserEmail(user.getUserEmail());
                resp.setStatusCode("success");
                resp.setAccessToken("dummy.access.token." + System.currentTimeMillis());
                resp.setMessage("Login Success!");
            } else {
                resp.setStatusCode("error");
                resp.setMessage("User with email '" + email + "' and specified password could not be found");
            }
            return resp;
        }

        @RequestMapping("/serverLogout")
        public AuthenticationResponse.LogoutResponse serverLogout() {
            log.info("serverLogout");
            AuthenticationResponse.LogoutResponse resp = new AuthenticationResponse.LogoutResponse();
            resp.setStatusCode("success");
            resp.setMessage("Logout success");
            return resp;
        }
    }
}
