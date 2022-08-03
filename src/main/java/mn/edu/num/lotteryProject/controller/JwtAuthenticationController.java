package mn.edu.num.lotteryProject.controller;

import java.util.Objects;

import mn.edu.num.lotteryProject.config.JwtTokenUtil;
import mn.edu.num.lotteryProject.dto.JwtRequest;
import mn.edu.num.lotteryProject.dto.JwtResponse;
import mn.edu.num.lotteryProject.dto.LoginRequest;
import mn.edu.num.lotteryProject.dto.UserResponse;
import mn.edu.num.lotteryProject.service.JwtUserDetailsService;
import mn.edu.num.lotteryProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/auth")
public class JwtAuthenticationController {

    @Autowired
    UserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public UserResponse createAuthenticationToken(@RequestBody LoginRequest dto) throws Exception {
        UserResponse response = userService.login(dto);
        return response;
    }
}