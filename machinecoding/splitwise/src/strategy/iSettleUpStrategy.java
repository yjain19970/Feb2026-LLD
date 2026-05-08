package strategy;

import java.util.List;

import model.Expense;

public interface iSettleUpStrategy {
    List<Expense> calculateTransactionsToBeMade(List<Expense> expensesForUser);
}
