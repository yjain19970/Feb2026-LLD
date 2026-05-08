package translator;

import dto.ExpenseResponseDTO;
import model.Expense;

public class ExpenseTranslator {

    public static ExpenseResponseDTO transform(Expense createdExpense) {
        ExpenseResponseDTO response = new ExpenseResponseDTO();
        response.setDescription(createdExpense.getDescription());
        response.setExpenseId(createdExpense.getId());
        return response;
    }
    
}
