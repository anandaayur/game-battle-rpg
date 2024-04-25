class Character {
    protected String nama;
    protected String ras;
    protected int level;
    protected int HP;
    protected int MP;

    // Konstruktor untuk inisialisasi karakter
    public Character(String nama, String ras, int level) {
        this.nama = nama;
        this.ras = ras;
        this.level = level;
        this.HP = level * 10; // Misalnya, HP maksimum adalah 100 * level
        this.MP = level * 5; // Misalnya, MP maksimum adalah 50 * level
    }

    // Metode untuk menyerang karakter lain
    public void attack(Character target) {
        // Implementasi serangan karakter
    }

    // Metode untuk menggunakan skill
    public void useSkill(Character target) {
        // Implementasi penggunaan skill
    }

    // Metode untuk menggunakan item
    public void useItem() {
        // Implementasi penggunaan item
    }

    // Metode untuk meningkatkan level karakter
    public void levelUp() {
        this.level++;
        this.HP = level * 100; // Mengembalikan HP ke maksimum
        this.MP = level * 50; // Mengembalikan MP ke maksimum
    }

    // Override metode toString untuk mencetak informasi karakter
    @Override
    public String toString() {
        return nama + ": HP = " + HP + ", MP = " + MP;
    }
}