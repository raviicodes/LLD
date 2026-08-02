package SplitWiseLLD.controllers;

import SplitWiseLLD.entities.Expense;
import SplitWiseLLD.entities.ExpenseSplitValidationFactory;
import SplitWiseLLD.entities.Split;
import SplitWiseLLD.entities.User;
import SplitWiseLLD.enums.SplitType;
import SplitWiseLLD.repository.ExpenseRepository;


import java.util.List;

public class ExpenseController  {
    private final ExpenseSplitValidationFactory expenseSplitValidationFactory;

    private ExpenseRepository expenseRepository;
    public ExpenseController(){
         this.expenseSplitValidationFactory=new ExpenseSplitValidationFactory();
          this.expenseRepository=new ExpenseRepository();
    }
    public void addExpense(double totalAmount, SplitType splitType, List<Split> splits, User paidBy, Integer groupId) {
        List<Split> exactSplits = expenseSplitValidationFactory.getExpenseSplitValidator(splitType).validate(splits, totalAmount);
        // save it in repository
        Expense expense = new Expense(totalAmount, paidBy, splitType, exactSplits);
        expenseRepository.addExpense(groupId, expense);
        //balanceSheetController logic goes here
    }
}
