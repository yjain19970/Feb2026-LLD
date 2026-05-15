package controller;

import dto.CreateExpenseRequestDTO;
import dto.CreateExpenseResponseDTO;
import model.Expense;
import service.ExpenseServiceImpl;

/**
 * SUPPORT CRUD OPERATIONS....
 */
public class ExpenseController {
    private ExpenseServiceImpl expenseServiceImpl;
    

    public ExpenseController(ExpenseServiceImpl expenseServiceImpl) {
        this.expenseServiceImpl = expenseServiceImpl;
    }


    public CreateExpenseResponseDTO createExpense(CreateExpenseRequestDTO requestDTO){
        CreateExpenseResponseDTO responseDTO = new CreateExpenseResponseDTO();
        try{
            Expense createdExpense =  expenseServiceImpl.createExpense(requestDTO.getDescription(), requestDTO.getTotalAmount(), 
            requestDTO.getCreatedByUserId(), requestDTO.getExpenseUsers());
            responseDTO.setExpenseId(createdExpense.getId());
        }catch(Exception e){
            System.out.println("InvalidRequestException.");
            // Throw some better UI facing exception from here. 
        }
        return responseDTO;
    }

    /**
     * Implement the GET functionality.
     */
}
