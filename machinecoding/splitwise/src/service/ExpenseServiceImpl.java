package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Expense;
import model.ExpenseType;
import model.ExpenseUser;
import model.ExpenseUserType;
import model.Group;
import model.SplitType;
import model.User;
import repo.ExpenseRepo;
import repo.GroupRepo;
import repo.UserRepo;

public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepo expenseRepo;
    private GroupRepo groupRepo;
    private UserRepo userRepo;

    public ExpenseServiceImpl(ExpenseRepo expenseRepo, GroupRepo groupRepo, UserRepo userRepo) {
        this.expenseRepo = expenseRepo;
        this.groupRepo = groupRepo;
        this.userRepo = userRepo;
    }



    @Override
    public Expense createExpense(String description, List<Long> userIds, Double totalAmount, SplitType splitType,
            Long createdByUserId, Long groupId) {
        /**
         * Todo: validate the Input.
         */
        // 1.
        Group group = groupRepo.get(groupId);
        // 2. 
        User user = userRepo.getExpense(createdByUserId);

        // 3. 
        List<ExpenseUser> expenseUsers = getExpenseUsers(userIds, totalAmount, user);

        // 4. 
        Expense expense = new Expense();
        expense.setCreatedAt(new Date());
        expense.setCreatedBy(user);
        expense.setDescription(description);
        expense.setExpenseType(ExpenseType.NORMAL);
        expense.setExpenseUsers(expenseUsers);
        expense.setGroup(group);
        expense.setLastModifiedAt(new Date());
        expense.setTotalAmount(totalAmount);

        // 5.
        Expense createdExpense =  expenseRepo.saveExpense(expense);

        System.out.print("Expense was created with id:" + createdExpense.getId());
        return createdExpense;
    }



    private List<ExpenseUser> getExpenseUsers(List<Long> userIds, Double totalAmount, User user) {
        List<ExpenseUser> expenseUsers = new ArrayList<>();
        for(Long userId: userIds){
            // User currentUser =  userRepo.getExpense(userId);
            // users.add(currentUser);
            ExpenseUser expenseUser = new ExpenseUser();
            expenseUser.setAmount(totalAmount/userIds.size());
            /**
             * Later: you will need a strategy here to get the proper amount depending on the SplitType.
             */
            expenseUser.setCreatedAt(new Date());
            expenseUser.setExpenseUserType(ExpenseUserType.HAD_TO_PAY);
            expenseUser.setLastModifiedAt(new Date());
            expenseUser.setUser(user);
            expenseUser.setExpense(null);
            expenseUsers.add(expenseUser);
        }
        return expenseUsers;
    }
    
}
