package Battle_Folder;

public class Battle_Card {
    private String name;
    private int hp;
    private int atk;
    private boolean owner; // True for the blue team, false for the Red Team
    private String image;

    public Battle_Card(String name, int hp, int atk, boolean owner, String image){
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.owner = owner;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public int getHp(){
        return hp;
    }
    public int getAtk(){
        return atk;
    }
    public boolean BlueIsOwner(){
        return owner;
    }
    public String getImage(){
        return image;
    }

    public void ModifyHealth(int amount){
        hp = Math.max(0, hp + amount);

    }

    public void basicAttack(Battle_Card target){
        target.ModifyHealth((-1) * atk);
    }
    public boolean isDead(){
        return hp == 0;
    }

}
