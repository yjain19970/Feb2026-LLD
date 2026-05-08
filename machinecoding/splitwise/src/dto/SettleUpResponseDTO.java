package dto;

import java.util.List;

public class SettleUpResponseDTO {
    private List<ExpenseTransactionDTO> transactionsToBeMade;

    public List<ExpenseTransactionDTO> getTransactionsToBeMade() {
        return transactionsToBeMade;
    }

    public void setTransactionsToBeMade(List<ExpenseTransactionDTO> transactionsToBeMade) {
        this.transactionsToBeMade = transactionsToBeMade;
    }
    
}
