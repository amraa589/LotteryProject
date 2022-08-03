package mn.edu.num.lotteryProject.service;

import mn.edu.num.lotteryProject.dto.LotteryRequest;
import mn.edu.num.lotteryProject.dto.LotteryResponse;
import mn.edu.num.lotteryProject.entity.Lottery;

import java.util.List;

public interface LotteryService {

    List<LotteryResponse> fetchLotteryList();

    LotteryResponse createLottery(LotteryRequest lotteryRequest);

    LotteryResponse deleteLottery(String id);

    Lottery getLotteryDetails(String id);

}
