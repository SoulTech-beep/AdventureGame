package Combat;

abstract class Alive {
    private int hp;
    private int damage;

//    public abstract void animalSound();


    public int getHP(){
        return hp;
    }

    public int getDamage(){
        return damage;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }
}