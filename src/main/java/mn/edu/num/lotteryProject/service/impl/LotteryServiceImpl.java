package mn.edu.num.lotteryProject.service.impl;

import mn.edu.num.lotteryProject.dto.LotteryRequest;
import mn.edu.num.lotteryProject.dto.LotteryResponse;
import mn.edu.num.lotteryProject.entity.Lottery;
import mn.edu.num.lotteryProject.service.LotteryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryServiceImpl implements LotteryService {

    @Override
    public List<LotteryResponse> fetchLotteryList() {
        return null;
    }

    @Override
    public LotteryResponse createLottery(LotteryRequest lotteryRequest) {
        return null;
    }

    @Override
    public LotteryResponse deleteLottery(String id) {
        return null;
    }

    @Override
    public Lottery getLotteryDetails(String id) {
        return null;
    }
}
