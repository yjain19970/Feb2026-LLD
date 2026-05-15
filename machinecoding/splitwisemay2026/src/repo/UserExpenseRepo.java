package repo;

import java.util.List;
import java.util.Map;

import model.ExpenseUser;

public class UserExpenseRepo {
    private Map<Long, ExpenseUser> expenseRepo;
    private static Long lastId = 1L;

    public UserExpenseRepo(Map<Long, ExpenseUser> expenseUserRepo) {
        this.expenseRepo = expenseUserRepo;
    }

    
    public ExpenseUser save(ExpenseUser expense){
        if(expenseRepo.get(lastId) ==null){
            expense.setId(lastId);
            expenseRepo.put(lastId, expense);
        }
        ExpenseUser createdExpense = expenseRepo.get(lastId); 
        lastId++;
        return createdExpense;
    }


    public ExpenseUser get(long id){
        if(expenseRepo.get(id) ==null){
            throw new IllegalStateException();
        }
        return expenseRepo.get(id);
    }
     

    public List<ExpenseUser> getExpensesByUserId(Long userId){
        return expenseRepo.values().stream()
            .filter(expenseUser -> expenseUser.getUser().getId().equals(userId))
                .toList();
    }
}
