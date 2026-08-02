package SplitWiseLLD.entities;

public  abstract class Split {
    private final User user;
    public Split(User user){
         this.user=user;
    }
    public User getUser(){
          return this.user;
    }

}
