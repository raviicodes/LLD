package LoanPayment.strategy;

import LoanPayment.entity.Loan;

import java.util.Date;

public interface IntrestCalculationStrategy {

    double calculateInterest(Loan loan, Date paymentDate);
}
