package SplitWiseLLD.entities;

import java.util.UUID;

public class User {
    private final UUID userId;
    private final String userName;
    private final BalanceSheet balanceSheet;
    public User(String userName) {
        this.userName = userName;
        this.userId=UUID.randomUUID();
         this.balanceSheet=new BalanceSheet();
    }

    public UUID getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
    public BalanceSheet getBalanceSheet(){
         return balanceSheet;
    }
}
