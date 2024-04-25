class Hero extends Character {
    private Weapon weapon; // Senjata yang dimiliki oleh Hero
    private Armor armor; // Armor yang digunakan oleh Hero

    public Hero(String nama, String ras, int level, Weapon.Type weaponType, Armor.Type armorType) {
        super(nama, ras, level);
        this.weapon = new Weapon(weaponType);
        this.armor = new Armor(armorType);
    }

    // Getter untuk senjata Hero
    public Weapon getWeapon() {
        return weapon;
    }

    // Setter untuk senjata Hero
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // Getter untuk armor Hero
    public Armor getArmor() {
        return armor;
    }

    // Setter untuk armor Hero
    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    // Override metode attack untuk menyesuaikan serangan dengan senjata yang digunakan
    @Override
    public void attack(Character target) {
        int damage = weapon.getDamage();
        target.HP -= damage;
        System.out.println(nama + " menyerang " + target.nama + " dengan " + weapon.getName() + " dan menyebabkan " + damage + " damage!");

        // Kurangi MP ketika menyerang
        int biayaMP = 20; // Sesuaikan biaya MP sesuai kebutuhan
        MP -= biayaMP;
        System.out.println(nama + " menggunakan " + biayaMP + " MP untuk menyerang. MP " + nama + " sekarang: " + MP);
    }

    // Metode untuk bertahan dengan menggunakan armor
    public void defend() {
        int shield = armor.getShield();
        HP += shield;
        System.out.println(nama + " menggunakan " + armor.getName() + " untuk bertahan dan mendapatkan shield sebesar " + shield + "!");
    }

    // Metode untuk menggunakan item
    public void item(String itemName) {
        switch (itemName.toLowerCase()) {
            case "elixir":
                MP += 30; // Misalnya, menambahkan MP sebanyak 30
                HP += 20; // Misalnya, menambahkan HP sebanyak 20
                System.out.println(nama + " menggunakan Elixir dan meningkatkan MP sebesar 30 dan HP sebesar 20!");
                break;
            case "potion":
                HP += 50; // Misalnya, menambahkan HP sebanyak 50
                System.out.println(nama + " menggunakan Potion dan meningkatkan HP sebesar 50!");
                break;
            case "ether":
                MP += 50; // Misalnya, menambahkan MP sebanyak 50
                System.out.println(nama + " menggunakan Ether dan meningkatkan MP sebesar 50!");
                break;
            default:
                System.out.println("Item tidak valid.");
        }
    }
}
