class Character {
    protected String nama;
    protected String ras;
    protected int level;
    protected int HP;
    protected int MP;

    public Character(String nama, String ras, int level) {
        this.nama = nama;
        this.ras = ras;
        this.level = level;
        this.HP = level * 10; 
        this.MP = level * 5;
    }

    public void attack(Character target) {
        // Implementasi serangan karakter
    }

    public void useSkill(Character target) {
        // Implementasi penggunaan skill
    }

    public void useItem(Character target) {
        // Implementasi penggunaan item
    }

    public void levelUp() {
        this.level++;
        this.HP = level * 100;
        this.MP = level * 50;
    }

    @Override
    public String toString() {
        return nama + ": HP = " + HP + ", MP = " + MP;
    }
}
