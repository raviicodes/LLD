package LoanPayment.entity;

import java.util.List;

public class User {
    private int userId;
    private String userName;
    private List<Integer> loanIds;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    public void addLoan(int loanId){
         loanIds.add(loanId);
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<Integer> getLoanIds() {
        return loanIds;
    }
}
