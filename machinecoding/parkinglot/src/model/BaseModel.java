package parkinglot.src.model;


public class BaseModel {
    private Long id; // PRIMARY_KEY
    private long createdAt;
    private long lastModifiedAt;
    private boolean isDeleted; // this is for soft-delete.

    public BaseModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(long lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    
}
