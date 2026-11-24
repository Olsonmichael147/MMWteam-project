package Battle_Folder;

public class PrepTurn {
    private boolean blueTurn;
    private int turnNumber;
    private int mana;

    PrepTurn(boolean blueTurn, int turnNumber){
        this.blueTurn = blueTurn;
        this.turnNumber = turnNumber;
        this.mana = turnNumber;
    }

    public int getMana(){
        return mana;
    }

    public boolean isBlueTurn() {
        return blueTurn;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setMana(int mana) {
        this.mana -= mana;
    }
}
