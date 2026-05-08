package strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import model.Expense;
import model.ExpenseType;
import model.ExpenseUser;
import model.ExpenseUserType;
import model.User;
import utils.Pair;

public class MinMaxHeapSettleUpStrategyImpl implements iSettleUpStrategy {

    /**
     * S1. Divide the Expense into two parts : P1: userPaid ; P2: hadToPay the amount
     * S2. Two PriorityQueues here (MaxHeap and MinHeap)
     * S3. Untill both of them are present:
     *      - get Max value from max heap
     *      - get Min value from min heap
     *      
     *      - Check which is smaller between both of them. Whoever is smaller, that person
     *      - is Done. Remove that from the queue and put the pending amount back to the queue.
     * 
     */
    @Override
    public List<Expense> calculateTransactionsToBeMade(List<Expense> expensesForUser) {
        Map<User, Double> userExpensePaid = new HashMap<>();
        Map<User, Double> userExpenseHadToPay = new HashMap<>();

        for(Expense expense : expensesForUser){
            List<ExpenseUser> expenseUsers = expense.getExpenseUsers();
            for(ExpenseUser expenseUser: expenseUsers){
                if(expenseUser.getExpenseUserType().equals(ExpenseUserType.PAID)){
                    Double existingAmt = userExpensePaid.getOrDefault(expenseUser.getUser(), 0.0);
                    userExpensePaid.put(expenseUser.getUser(), existingAmt + expenseUser.getAmount());
                }else if(expenseUser.getExpenseUserType().equals(ExpenseUserType.HAD_TO_PAY)){
                    Double existingAmt = userExpenseHadToPay.getOrDefault(expenseUser.getUser(), 0.0);
                    userExpenseHadToPay.put(expenseUser.getUser(), existingAmt + expenseUser.getAmount());      
                }
            }
        }

        /**
         * 
         * Two hashmaps with me
         * 1. user-1 has all expenses where he has paid the money
         * 2. user-2 has all expenses where he owed the amount
         * 
         */
        PriorityQueue<Pair<User,Double>> negativeBalanceQueue = new PriorityQueue<>((p1,p2) -> Double.compare(p1.getRight(), p2.getRight()));
        PriorityQueue<Pair<User,Double>> positiveBalanceQueue = new PriorityQueue<>((p1,p2) -> Double.compare(p2.getRight(), p1.getRight()));

        for(Map.Entry<User,Double> entry: userExpenseHadToPay.entrySet()){
            negativeBalanceQueue.add(new Pair<User,Double>(entry.getKey(), entry.getValue()));
        }
        for(Map.Entry<User,Double> entry: userExpensePaid.entrySet()){
            positiveBalanceQueue.add(new Pair<User,Double>(entry.getKey(), entry.getValue()));
        }


        List<Expense> transactions = new ArrayList<>();

        while(!positiveBalanceQueue.isEmpty() &&  !negativeBalanceQueue.isEmpty()){
            Pair<User,Double> negativeMin = negativeBalanceQueue.poll();
            Pair<User,Double> positiveMax = positiveBalanceQueue.poll();

            if(negativeMin.getRight() < positiveMax.getRight()){
                Expense newExp = new Expense();
                newExp.setDescription("UserID-1 needs to pay back to <User-2>");
                newExp.setExpenseType(ExpenseType.DUMMY);
                newExp.setTotalAmount(negativeMin.getRight());
                transactions.add(newExp); // ToDo: this expense will be basically the higher person paying to the lower person here.

                // Adding remaining back to the queue.
                positiveMax = new Pair<User,Double>(positiveMax.getLeft(), positiveMax.getRight() - negativeMin.getRight());
                positiveBalanceQueue.add(positiveMax);
            }else{
                Expense newExp = new Expense();
                newExp.setDescription("User-2 needs to pay back to User-1");
                newExp.setExpenseType(ExpenseType.DUMMY);
                newExp.setTotalAmount(positiveMax.getRight());
                transactions.add(new Expense()); // ToDo: this expense will be basically the higher person paying to the lower person here.

                // Adding remaining back to the queue.
                negativeMin = new Pair<User,Double>(negativeMin.getLeft(), negativeMin.getRight() - positiveMax.getRight());
                negativeBalanceQueue.add(negativeMin);
            }
        }


        return transactions;
    }
    
}
