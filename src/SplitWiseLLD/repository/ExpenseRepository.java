package SplitWiseLLD.repository;

import SplitWiseLLD.entities.Expense;

import java.util.*;

public class ExpenseRepository {
    private final Map<Integer,List<Expense>>groupExpenseMap;
    public ExpenseRepository(){
         this.groupExpenseMap=new HashMap<>();
    }
    public List<Expense> getExpenseByGroupId(Integer id){
         return groupExpenseMap.getOrDefault(id, new ArrayList<>());
    }
    public void addExpense(int id,Expense expense){
         groupExpenseMap.computeIfAbsent(id,k->new ArrayList<>()).add(expense);
    }
}
