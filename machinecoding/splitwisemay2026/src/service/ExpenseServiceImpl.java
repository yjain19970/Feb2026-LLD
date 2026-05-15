package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import exception.InvalidRequestException;
import model.Expense;
import model.ExpenseType;
import model.ExpenseUser;
import model.User;
import repo.ExpenseRepo;
import repo.UserExpenseRepo;
import repo.UserRepo;

public class ExpenseServiceImpl {
    private ExpenseRepo expenseRepo;
    private UserRepo userRepo;
    private UserExpenseRepo userExpenseRepo;
    
    
    public ExpenseServiceImpl(ExpenseRepo expenseRepo, UserRepo userRepo, UserExpenseRepo userExpenseRepo) {
        this.expenseRepo = expenseRepo;
        this.userRepo = userRepo;
        this.userExpenseRepo = userExpenseRepo;
    }


    public Expense createExpense(String description, double totalAmount, Long createdByUserId, List<Long> expenseUserIds) throws InvalidRequestException{
        // validations.
        User existingUser =  userRepo.getUserById(createdByUserId);
        if(invalidRequest(existingUser)){
            throw new InvalidRequestException("RequestParams are not correct!");
        }

        List<ExpenseUser> expenseUsers = getExpenseUsers(createdByUserId);

        //Create an Expense
        Expense expenseToBeCreated = new Expense();
        expenseToBeCreated.setCreatedAt(new Date());
        expenseToBeCreated.setCreatedBy(existingUser);
        expenseToBeCreated.setDescription(description);
        expenseToBeCreated.setExpenseType(ExpenseType.NORMAL);
        expenseToBeCreated.setExpenseUsers(expenseUsers);
        expenseToBeCreated.setLastModifiedAt(new Date());
        expenseToBeCreated.setTotalAmount(totalAmount);

        Expense createdExpense= expenseRepo.saveExpense(expenseToBeCreated);
        System.out.println("Expense is created successfully!" +createdExpense.getId());

        return createdExpense;
    }


    private List<ExpenseUser> getExpenseUsers(Long createdByUserId) {
        return userExpenseRepo.getExpensesByUserId(createdByUserId);
    }


    private boolean invalidRequest(User existingUser) {
        return false;
    }
}
