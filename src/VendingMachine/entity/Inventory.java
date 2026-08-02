package VendingMachine.entity;

import VendingMachine.enums.ItemType;

public class Inventory {
    private ItemShelf[]  inventoryItems;
    public Inventory(){
         this.inventoryItems=new ItemShelf[12];
          for(int id=0;id<12;id++){
               inventoryItems[id]=new ItemShelf(id);
          }
    }
    public void fillUpInventory(){
        for(int id=0;id<3;id++){
             inventoryItems[id].setItem(ItemType.COKE);
        }
        for(int id=3;id<6;id++){
             inventoryItems[id].setItem(ItemType.PEPSI);
        }
         for(int id=6;id<9;id++){
              inventoryItems[id].setItem(ItemType.LAYS);
         }
        for(int id=9;id<12;id++){
            inventoryItems[id].setItem(ItemType.DAIRYMILK);
        }
    }
    public ItemType getItem(int shelfCode){
        // validation
          if(inventoryItems[shelfCode].isAvailable()){
               return inventoryItems[shelfCode].getItem();
          }
          else {
               throw new  RuntimeException("Item sold out");
          }
    }
    public void printInventory(){
         for(int id=0;id<4;id++){
               for(int col=0;col<3;col++){
                    int shelfCode=id*3+col;
                   System.out.print(inventoryItems[shelfCode].getShelfCode()+" "+inventoryItems[shelfCode].getItem()+" "+inventoryItems[shelfCode].isAvailable()+" ");
               }
             System.out.println();
         }
    }


}
