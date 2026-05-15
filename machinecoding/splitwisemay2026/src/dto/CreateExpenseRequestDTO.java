package dto;

import java.util.List;

import model.ExpenseUser;
import model.User;

public class CreateExpenseRequestDTO {
    private String description;
    private double totalAmount;
    private Long createdByUserId;
    private List<Long> expenseUserIDs;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
   
    
    public Long getCreatedByUserId() {
        return createdByUserId;
    }
    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }
    public List<Long> getExpenseUsers() {
        return expenseUserIDs;
    }
    public void setExpenseUsers(List<Long> expenseUsers) {
        this.expenseUserIDs = expenseUsers;
    }  
    
}
