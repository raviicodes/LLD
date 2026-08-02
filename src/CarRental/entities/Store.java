package CarRental.entities;

public class Store {
    private int storeId;
    private String storeName;
    private  Location location;

    public Store(int storeId, String storeName, Location location) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.location = location;
    }

}
