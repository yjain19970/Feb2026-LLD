import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import controller.ExpenseController;
import dto.CreateExpenseRequestDTO;
import dto.CreateExpenseResponseDTO;
import model.User;
import repo.ExpenseRepo;
import repo.UserExpenseRepo;
import repo.UserRepo;
import service.ExpenseServiceImpl;

public class App {
    public static void main(String[] args) throws Exception {
        ExpenseRepo expenseRepo = new ExpenseRepo(new HashMap<>());
        UserRepo userRepo = new UserRepo(new HashMap<>());
        UserExpenseRepo userExpenseRep = new UserExpenseRepo(new HashMap<>());
        
        ExpenseServiceImpl expenseServiceImpl = new ExpenseServiceImpl(expenseRepo, userRepo, userExpenseRep);
        ExpenseController expenseController = new ExpenseController(expenseServiceImpl);

        User user1 = new User();
        user1.setCreatedAt(new Date());
        user1.setLastModifiedAt(new Date());
        user1.setName("Yash");
        user1.setPassword("12345");
        user1.setPhoneNumber("9999999999");
        
        userRepo.saveUser(user1);

        CreateExpenseRequestDTO requestDTO = new CreateExpenseRequestDTO();
        requestDTO.setCreatedByUserId(1L);
        requestDTO.setDescription("First expense");
        requestDTO.setExpenseUsers(new ArrayList<>());
        requestDTO.setTotalAmount(100.0);
        CreateExpenseResponseDTO responseDTO =  expenseController.createExpense(requestDTO);

        System.out.println("Hello, World! "+ responseDTO.getExpenseId());
    }
}
