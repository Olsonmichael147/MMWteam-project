package Battle_Folder;

public class HandCard {
    private final String name;
    private final int hp;
    private final int atk;
    private final int cost; // True for the blue team, false for the Red Team
    private String image;
    private

    public PrepCard(String name, int hp, int atk, int cost) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.cost = cost;
        this.image = image;
    }
}
