import Loggerlld.Logger;
import VendingMachine.entity.Inventory;

public class Main {
    public static void main(String[] args) {
                  //

        Player{
            PlayingPiece,
            playername,
            playerId;
        }
        PlayeingPiece{
            Color color;
            Cell position;
        }

        Dice{
             int maxValue;
           int  rollDice ()
        }

        Board {
            Cell[][]=new Cell[10][10];

        }
        Cell{
            int row, int col;
            Jump jump;

        }
        Jump{
            Cell from;
             Cell to;

        }

        GameClass{
            initializeGame();
             addLadders,addSnakes;
             startGame();
        }
    }
}
