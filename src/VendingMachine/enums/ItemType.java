package VendingMachine.enums;

public enum ItemType {
    COKE(40),
    LAYS(20),
    PEPSI(45),
    KURKURE(20),
    DAIRYMILK(25);
    private int price;
    ItemType(int price){
         this.price=price;
    }
    public int getPrice(){
         return this.price;
    }
}
