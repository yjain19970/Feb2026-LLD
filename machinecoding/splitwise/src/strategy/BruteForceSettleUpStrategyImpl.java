package strategy;

import java.util.ArrayList;
import java.util.List;

import model.Expense;

public class BruteForceSettleUpStrategyImpl implements iSettleUpStrategy  {

    @Override
    public List<Expense> calculateTransactionsToBeMade(List<Expense> expensesForUser) {

        return new ArrayList<>();
    }
    
}
