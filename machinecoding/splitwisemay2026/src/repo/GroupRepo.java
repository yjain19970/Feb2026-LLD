package repo;

import java.util.Map;

import model.Group;


public class GroupRepo {
    private Map<Long, Group> expenseRepo;
    private static Long lastId = 1L;

    public GroupRepo(Map<Long, Group> groupRepo) {
        this.expenseRepo = groupRepo;
    }

    


    public Group saveGroup(Group expense){
        if(expenseRepo.get(lastId) ==null){
            expense.setId(lastId);
            expenseRepo.put(lastId, expense);
        }
        Group createdExpense = expenseRepo.get(lastId); 
        lastId++;
        return createdExpense;
    }


    public Group get(long id){
        if(expenseRepo.get(id) ==null){
            throw new IllegalStateException();
        }
        return expenseRepo.get(id);
    }
     
}
