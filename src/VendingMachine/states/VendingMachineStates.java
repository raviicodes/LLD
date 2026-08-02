package VendingMachine.states;

import VendingMachine.entity.VendingMachine;
import VendingMachine.enums.Coin;
import VendingMachine.enums.ItemType;

import java.util.List;

public interface VendingMachineStates {

    void clickInsertCoin(VendingMachine VendingMachine);
    void insertCoin(VendingMachine machine, Coin coin);
    void clickStartProductSelection(VendingMachine machine);
    void selectItem(VendingMachine machine,int shelfCode);
    void cancel(VendingMachine machine);
    void processRefund(VendingMachine machine);
    void returnChange(VendingMachine machine);
    void dispense(VendingMachine machine,ItemType item);
}
