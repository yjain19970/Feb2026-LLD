package repo;

import java.util.Map;

import model.User;

public class UserRepo {
    private Map<Long, User> userRepo;
    private static Long lastId = 1L;

    public UserRepo(Map<Long, User> userRepo) {
        this.userRepo = userRepo;
    }

    


    public User saveUser(User expense){
        if(userRepo.get(lastId) ==null){
            userRepo.put(lastId, expense);
        }
        User createdExpense = userRepo.get(lastId); 
        lastId++;
        return createdExpense;
    }


    public User getExpense(long id){
        if(userRepo.get(id) ==null){
            throw new IllegalStateException();
        }
        return userRepo.get(id);
    }
     
}

