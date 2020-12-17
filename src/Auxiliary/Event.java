package Auxiliary;

public class Event {
    private String mainText;
    private String position;
    private String tb1;
    private String tb2;
    private String tb3;
    private String tb4;
    private String tb5;
    private String background;
    private Song song;
    private int HP;
    private int damage;
    private int type; //either 1, 2 or 3 for enemies

    public Event(String mainText, String position, String tb1, String tb2, String tb3, String tb4, String tb5,
                 String background, String songLink, int HP, int damage, int type) {
        super();
        this.mainText = mainText;
        this.position = position;
        this.tb1 = tb1;
        this.tb2 = tb2;
        this.tb3 = tb3;
        this.tb4 = tb4;
        this.tb5 = tb5;
        this.background = background;
        song = new Song (songLink);
        this.HP = HP;
        this.damage = damage;
        this.type=type;
    }

        public String getMainText() {
            return mainText;
        }

        public void setMainText(String mainText) {
            this.mainText = mainText;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getTb1() {
            return tb1;
        }

        public void setTb1(String tb1) {
            this.tb1 = tb1;
        }

        public String getTb2() {
            return tb2;
        }

        public void setTb2(String tb2) {
            this.tb2 = tb2;
        }

        public String getTb3() {
            return tb3;
        }

        public void setTb3(String tb3) {
            this.tb3 = tb3;
        }

        public String getTb4() {
            return tb4;
        }

        public void setTb4(String tb4) {
            this.tb4 = tb4;
        }

        public String getTb5() {
            return tb5;
        }

        public void setTb5(String tb5) {
            this.tb5 = tb5;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public int getHP() {
            return HP;
        }

        public void setHP(int hP) {
            HP = hP;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public Song getSong(){
            return song;
        }

        public int getType(){
            return type;
        }

}
