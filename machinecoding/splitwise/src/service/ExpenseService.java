package service;

import java.util.List;

import model.Expense;
import model.SplitType;

public interface ExpenseService {

    public Expense createExpense(String description, List<Long> userIds, Double totalAmount, SplitType splitType,
            Long createdByUserId, Long groupId);
            
}
