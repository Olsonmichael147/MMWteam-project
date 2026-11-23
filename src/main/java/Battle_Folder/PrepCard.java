package Battle_Folder;

import java.util.HashMap;

public class PrepCard extends CardAbstract{
    private String name;
    private int hp;
    private int atk;
    private boolean owner; // True for the blue team, false for the Red Team
    private String image;

    public PrepCard(String name, int hp, int atk, boolean owner) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.owner = owner;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public boolean BlueIsOwner() {
        return owner;
    }

    public String getImage() {
        return image;
    }

    public void ModifyHealth(int amount) {
        hp = Math.max(0, hp + amount);
    }

    private void findImage{}

}

