package service;

import java.util.List;

import model.Expense;

public interface SettleUpService {
    
    public List<Expense> settleUpUser(Long userId);
}
