package dto;

import java.util.List;

import model.BaseModel;
import model.SplitType;

public class ExpenseRequestDTO {
    private String description;
    private List<Long> userIds;
    private Double totalAmount;
    private SplitType splitType;
    private Long createdByUserId;
    private Long groupId;

    

    
    public ExpenseRequestDTO(String description, List<Long> userIds, Double totalAmount, SplitType splitType,
            Long createdByUserId, Long groupId) {
        this.description = description;
        this.userIds = userIds;
        this.totalAmount = totalAmount;
        this.splitType = splitType;
        this.createdByUserId = createdByUserId;
        this.groupId = groupId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Long> getUserIds() {
        return userIds;
    }
    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public SplitType getSplitType() {
        return splitType;
    }
    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }
    public Long getCreatedByUserId() {
        return createdByUserId;
    }
    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }
    
}
