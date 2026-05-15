package model;

import java.util.List;

public class Expense extends BaseModel {
    private String description;
    private double totalAmount;
    private User createdBy;
    private ExpenseType expenseType;
    private List<ExpenseUser> expenseUsers;
    
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
    public User getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
    public ExpenseType getExpenseType() {
        return expenseType;
    }
    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
    public List<ExpenseUser> getExpenseUsers() {
        return expenseUsers;
    }
    public void setExpenseUsers(List<ExpenseUser> expenseUsers) {
        this.expenseUsers = expenseUsers;
    }

    
    
}
