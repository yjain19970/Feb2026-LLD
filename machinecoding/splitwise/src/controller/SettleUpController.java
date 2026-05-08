package controller;

import java.util.List;

import dto.SettleUpRequestDTO;
import dto.SettleUpResponseDTO;
import model.Expense;
import service.SettleUpService;

public class SettleUpController {
    private SettleUpService settleUpService;
    
    public SettleUpResponseDTO settleUp(SettleUpRequestDTO requestDTO){
        List<Expense> transactionsToBeMade =  settleUpService.settleUpUser(requestDTO.getUserId());
        // ToDo: do the translation here.
        return new SettleUpResponseDTO();
    }
}
