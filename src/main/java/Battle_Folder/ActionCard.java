package Battle_Folder;

public class ActionCard extends CardAbstract{
    private final String name;
    private final int hp;
    private final int atk;
    private final boolean owner; // True for the blue team, false for the Red Team
    private final String image;

    public ActionCard(String name, int hp, int atk, boolean owner, String image) {
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
}
