package LoanPayment.repository;

import LoanPayment.entity.Loan;

import java.util.List;

public class LoanRepository {
    private List<Loan>loans;

    public LoanRepository(List<Loan> loans) {
        this.loans = loans;
    }
    public void addLoan(Loan loan){loans.add(loan);}
    public List<Loan>getLoanByUserId(int userId){
        return  loans.stream().filter(loan -> loan.getUserId()==userId).toList();
    }
    public Loan getLoanById(int loanId){
         for( Loan loan:loans){
              if(loan.getLoanId()==loanId) return loan;
         }
          return null;
    }


}
