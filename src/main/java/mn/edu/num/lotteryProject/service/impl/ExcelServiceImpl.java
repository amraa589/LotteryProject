package mn.edu.num.lotteryProject.service.impl;

import mn.edu.num.lotteryProject.entity.User;
import mn.edu.num.lotteryProject.repository.UserRepository;
import mn.edu.num.lotteryProject.service.ExcelService;
import mn.edu.num.lotteryProject.utils.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    UserRepository userRepository;

    public ByteArrayInputStream load() {
        List<User> users = userRepository.findAll();
        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(users);
        return in;
    }

    public void save(MultipartFile file) {
        try {
            List<User> users = ExcelHelper.excelToTutorials(file.getInputStream());
            userRepository.saveAll(users);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
    public List<User> getAllTutorials() {
        return userRepository.findAll();
    }
}