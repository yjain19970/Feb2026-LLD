package service;

import java.util.ArrayList;
import java.util.List;

import model.Expense;
import model.ExpenseUser;
import model.User;
import repo.ExpenseRepo;
import repo.UserExpenseRepo;
import repo.UserRepo;
import strategy.iSettleUpStrategy;

public class SettleUpServiceImpl implements SettleUpService {
    private ExpenseRepo expenseRepo;
    private UserRepo userRepo;
    private UserExpenseRepo userExpenseRepo;
    private iSettleUpStrategy settleUpStrategy;
    

    public SettleUpServiceImpl(ExpenseRepo expenseRepo, UserRepo userRepo, UserExpenseRepo userExpenseRepo,
            iSettleUpStrategy settleUpStrategy) {
        this.expenseRepo = expenseRepo;
        this.userRepo = userRepo;
        this.userExpenseRepo = userExpenseRepo;
        this.settleUpStrategy = settleUpStrategy;
    }


    @Override
    public List<Expense> settleUpUser(Long userId) {
        List<Expense> transactionsToBeMade = new ArrayList<>();

        User user = userRepo.getExpense(userId);
        if(user==null){
            // throw an exception from here
        }

        List<ExpenseUser> expenseUsers = userExpenseRepo.getExpensesByUserId(userId);
        List<Expense> expenses = new ArrayList<>();
        for(ExpenseUser expenseUser : expenseUsers){
            expenses.add(expenseUser.getExpense());
        }
        // Now I have all the expenses for a user with me.
        
        transactionsToBeMade = settleUpStrategy.calculateTransactionsToBeMade(expenses);
        return transactionsToBeMade;
    }
    
}
