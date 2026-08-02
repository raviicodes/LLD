package LoanPayment.service;

import LoanPayment.entity.Loan;
import LoanPayment.repository.LoanRepository;
import LoanPayment.strategy.IntrestCalculationStrategy;

import java.util.Date;
import java.util.List;

public class LoanService {
    private  final LoanRepository loanRepository;
    private IntrestCalculationStrategy intrestCalculationStrategy;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    public Loan getLoanById(int loanId){
         Loan loan=loanRepository.getLoanById(loanId);
          if(loan!=null) throw new RuntimeException("Loan not found with given id");
           return loan;
    }
    public void payLoan(int loanId, Date date){
        Loan loan=loanRepository.getLoanById(loanId);
        if(loan!=null) throw new RuntimeException("Loan not found with given id");
        double interestAmount= intrestCalculationStrategy.calculateInterest(loan,date);
        double outStanding=loan.getPrincipalAmount()+interestAmount- loan.getTotalPaid();
    }


}
