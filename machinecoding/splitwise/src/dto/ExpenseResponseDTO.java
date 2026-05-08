package dto;

public class ExpenseResponseDTO {
    private Long expenseId;
    private String description;
    
    public Long getExpenseId() {
        return expenseId;
    }
    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
}
