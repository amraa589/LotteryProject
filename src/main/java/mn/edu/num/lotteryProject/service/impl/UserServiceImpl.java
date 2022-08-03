package mn.edu.num.lotteryProject.service.impl;

import mn.edu.num.lotteryProject.config.JwtTokenUtil;
import mn.edu.num.lotteryProject.dto.LoginRequest;
import mn.edu.num.lotteryProject.dto.UserRequest;
import mn.edu.num.lotteryProject.dto.UserResponse;
import mn.edu.num.lotteryProject.entity.User;
import mn.edu.num.lotteryProject.repository.UserRepository;
import mn.edu.num.lotteryProject.service.JwtUserDetailsService;
import mn.edu.num.lotteryProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Override
    public List<UserResponse> fetchUserList() {
        List<User> list = userRepository.findAll();
        List<UserResponse> response = new ArrayList<>();
        for (User user : list) {
            UserResponse tmp = new UserResponse();
            tmp.setEmail(user.getEmail());
            tmp.setFirstName(user.getFirstName());
            tmp.setLastName(user.getLastName());
            tmp.setUsername(user.getUserName());
            tmp.setId(user.getId());
            response.add(tmp);
        }

        return response;
    }

    @Override
    public UserResponse createUser(UserRequest request) throws Exception {

        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setUserName(request.getUsername());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user = userRepository.save(user);

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setUsername(user.getUserName());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());

        return response;
    }

    @Override
    public UserResponse deleteUser(String id) throws Exception {
        try {
            UserResponse response = new UserResponse();

            Optional<User> user = userRepository.findById(Long.parseLong(id));
            if (user.isPresent()) {
                userRepository.delete(user.get());
                response.setId(user.get().getId());
                return response;
            } else {
                throw new Exception("User does not exist");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public UserResponse login(LoginRequest dto) throws ValidationException {

        User user = userRepository.findByUserName(dto.getUsername()).orElseThrow(
                () -> new ValidationException("user not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword()))
            throw new ValidationException("password not match");

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setUsername(user.getUserName());
        response.setJwt(jwtTokenUtil.generateToken(user.getUserName()));

        return response;

    }

    @Override
    public User getUserDetails(String username) throws Exception {
        Optional<User> optional = userRepository.findByUserName(username);
        if (optional.isPresent())
            return optional.get();
        throw new Exception("User doesn't found");
    }
}
