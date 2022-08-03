package mn.edu.num.lotteryProject.controller;

import mn.edu.num.lotteryProject.dto.LoginRequest;
import mn.edu.num.lotteryProject.dto.ResponseMessage;
import mn.edu.num.lotteryProject.dto.UserRequest;
import mn.edu.num.lotteryProject.dto.UserResponse;
import mn.edu.num.lotteryProject.service.ExcelService;
import mn.edu.num.lotteryProject.service.UserService;
import mn.edu.num.lotteryProject.utils.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ExcelService fileService;

    @GetMapping("/list")
    public List<UserResponse> fetchUserList() {
        List<UserResponse> response = userService.fetchUserList();
        return response;
    }

//    @GetMapping("/log-in")
//    public void configure (){
//
//    }

    @DeleteMapping("/{id}")
    public UserResponse fetchUserList(@PathVariable String id) {
        try {
            return userService.deleteUser(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest dto) throws ValidationException {
        try {
            return userService.login(dto);
        } catch (ValidationException e) {
            throw new ValidationException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/create")
    public UserResponse createUser(@RequestBody UserRequest userRequest, HttpServletRequest req) throws Exception {
        UserResponse response;
        response = userService.createUser(userRequest);
        return response;
    }

    @PostMapping("/upload-users")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                fileService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }
}
