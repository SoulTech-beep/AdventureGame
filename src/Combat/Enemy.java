package Combat;

public class Enemy extends Alive {

    private String name;


    //weaker to stronger:
    //Bat < Imp < Goblin < Cultist < Knight < Troll < Wraith < DemonKing

    public Enemy(String name, int damage, int hp){
        updateEnemy(name, damage, hp);
    }

    public Enemy(){}

    public String getName(){
        return name;
    }

    public void updateEnemy(String name, int damage, int hp){
        this.name = name;
        setHP(hp);
        setDamage(damage);
        System.out.println("Class Enemy =" + damage);
    }
}
