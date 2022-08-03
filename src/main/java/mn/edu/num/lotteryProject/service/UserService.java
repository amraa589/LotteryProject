package mn.edu.num.lotteryProject.service;

import mn.edu.num.lotteryProject.dto.LoginRequest;
import mn.edu.num.lotteryProject.dto.UserRequest;
import mn.edu.num.lotteryProject.dto.UserResponse;
import mn.edu.num.lotteryProject.entity.User;
import mn.edu.num.lotteryProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;


public interface UserService {
    List<UserResponse> fetchUserList();
    UserResponse createUser(UserRequest request) throws Exception;

    UserResponse deleteUser(String id) throws Exception;

    UserResponse login(LoginRequest dto) throws Exception;

    User getUserDetails(String username) throws Exception;
}
