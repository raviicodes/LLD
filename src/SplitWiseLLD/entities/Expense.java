package SplitWiseLLD.entities;

import SplitWiseLLD.enums.SplitType;

import java.util.List;
import java.util.UUID;

public class Expense {
    private UUID expenseId;
    private double amount;
    private User paidBy;
    private SplitType splitType;
    private List<Split> splits;

    public Expense(double amount, User paidBy, SplitType splitType, List<Split> splits) {
        this.expenseId=UUID.randomUUID();
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitType = splitType;
        this.splits = splits;
    }

    public UUID getExpenseId() {
        return expenseId;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Split> getSplits() {
        return splits;
    }
}
