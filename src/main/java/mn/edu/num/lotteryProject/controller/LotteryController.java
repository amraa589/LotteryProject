package mn.edu.num.lotteryProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/lottery")
public class LotteryController {

    @GetMapping("/")
    public String fetchLotteryList(){
        return "Goodbye!";
    }
}
