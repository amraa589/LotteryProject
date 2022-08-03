package mn.edu.num.lotteryProject.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

public interface ExcelService {

    public ByteArrayInputStream load();
    public void save(MultipartFile file);

}
