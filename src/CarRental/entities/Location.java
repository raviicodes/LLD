package CarRental.entities;

public class Location {
    private int locationId;
    private String city;
    private String pinCode;
    private String address;

    public Location(int locationId, String city, String pinCode, String address) {
        this.locationId = locationId;
        this.city = city;
        this.pinCode = pinCode;
        this.address = address;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getAddress() {
        return address;
    }
}
