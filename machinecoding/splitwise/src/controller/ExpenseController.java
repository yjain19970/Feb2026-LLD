package controller;

import dto.ExpenseRequestDTO;
import dto.ExpenseResponseDTO;
import exception.InvalidRequestException;
import model.Expense;
import service.ExpenseService;
import translator.ExpenseTranslator;

public class ExpenseController {
    private ExpenseService expenseService;

    public ExpenseResponseDTO createExpense(ExpenseRequestDTO requestDTO) throws InvalidRequestException{
        /**
         * Validate the Input request.
         */
        if(isInvalidRequest(requestDTO)){
            throw new InvalidRequestException("Request body is Invalid");
        }
        Expense createdExpense =  expenseService.createExpense(requestDTO.getDescription(), requestDTO.getUserIds(), 
        requestDTO.getTotalAmount(), 
        requestDTO.getSplitType(), requestDTO.getCreatedByUserId(), null);
        
        return ExpenseTranslator.transform(createdExpense);
    }

    private boolean isInvalidRequest(ExpenseRequestDTO requestDTO) {
        // ToDo: Add the Impl.
        return false;
    }
    
}
