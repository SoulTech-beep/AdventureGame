package Combat;

import java.util.HashMap;

public class Enemy extends Alive {

    private String name;
    private HashMap<String, Integer> EnemyDamage;
    private HashMap<String, Integer> EnemyHealth;

    //weaker to stronger:
    //Bat < Imp < Goblin < Cultist < Knight < Troll < Wraith < DemonKing


    public Enemy(){
        enemies();
    }

    public String getName(){
        return name;
    }

    public void updateEnemy(String name){
        this.name = name;
        setHP(EnemyHealth.get(name));
        setDamage(EnemyDamage.get(name));
    }

    private void enemies(){
        EnemyDamage = new HashMap<String, Integer>();
        //(key, City)
        EnemyDamage.put("bat", 1);
        EnemyDamage.put("imp", 2);
        EnemyDamage.put("goblin", 3);
        EnemyDamage.put("cultist", 4);
        EnemyDamage.put("knight", 5);
        EnemyDamage.put("troll", 6);
        EnemyDamage.put("wraith", 6);
        EnemyDamage.put("demonKing", 6);

        EnemyHealth = new HashMap<String, Integer>();
        EnemyHealth.put("bat", 5);
        EnemyHealth.put("imp", 7);
        EnemyHealth.put("goblin", 9);
        EnemyHealth.put("cultist", 12);
        EnemyHealth.put("knight", 15);
        EnemyHealth.put("troll", 19);
        EnemyHealth.put("wraith", 23);
        EnemyHealth.put("demonKing", 25);
    }

}
