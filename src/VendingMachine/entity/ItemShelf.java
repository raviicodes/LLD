package VendingMachine.entity;

import VendingMachine.enums.ItemType;

public class ItemShelf {
    private int shelfCode;
    private ItemType item;
    private boolean isAvailable;
    public ItemShelf(int shelfCode){
          this.shelfCode=shelfCode;
          this.isAvailable=false;
    }

    public void setItem(ItemType item) {
         this.item = item;
         this.isAvailable=true;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public ItemType getItem() {
      ItemType currItem=item;
      isAvailable=false;
       setItem(null);
        return currItem;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getShelfCode() {
        return shelfCode;
    }
}
