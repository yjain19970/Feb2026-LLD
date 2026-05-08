import java.util.HashMap;

import repo.ExpenseRepo;
import repo.UserExpenseRepo;
import repo.UserRepo;
import service.SettleUpServiceImpl;
import strategy.MinMaxHeapSettleUpStrategyImpl;
import strategy.iSettleUpStrategy;

public class App {
    
    public static void main(String[] args) throws Exception {
        ExpenseRepo expenseRepo = new ExpenseRepo(new HashMap<>());
        UserRepo userRepo = new UserRepo(new HashMap<>());
        UserExpenseRepo userExpenseRep = new UserExpenseRepo(new HashMap<>());
        iSettleUpStrategy settleUpStrategy = new MinMaxHeapSettleUpStrategyImpl();



        SettleUpServiceImpl serviceImpl = new SettleUpServiceImpl(expenseRepo, userRepo, 
                userExpenseRep, settleUpStrategy);
        // object of controller and call it from here.
        


        System.out.println("Hello, World!");
    }
}
