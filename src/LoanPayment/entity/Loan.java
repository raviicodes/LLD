package LoanPayment.entity;

import LoanPayment.enums.LoanStatus;
import bookmyshow.entities.Payment;

import java.util.ArrayList;
import java.util.List;

public class Loan {
    private final int loanId;
    private final double principalAmount;
    private double totalPaid;
    private  LoanStatus loanStatus;
    private int userId;
    List<Payment>payments;

    public Loan(int loanId, double principalAmount, LoanStatus loanStatus, int userId) {
        this.loanId = loanId;
        this.principalAmount = principalAmount;
        this.loanStatus = loanStatus;
        this.userId = userId;
         this.totalPaid=0;
         this.payments=new ArrayList<>();
    }

    public int getLoanId() {
        return loanId;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public int getUserId() {
        return userId;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }
    public void addPayment(Payment payment){payments.add(payment);}

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
