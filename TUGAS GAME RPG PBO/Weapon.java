class Weapon {
    public enum Type {PEDANG, PANAH}

    private Type type;
    private String name;
    private int damage;

    // Konstruktor untuk inisialisasi senjata berdasarkan tipe
    public Weapon(Type type) {
        this.type = type;
        switch (type) {
            case PEDANG:
                this.name = "Pedang";
                this.damage = 50;
                break;
            case PANAH:
                this.name = "Panah";
                this.damage = 30;
                break;
        }
    }

    // Getter untuk nama senjata
    public String getName() {
        return name;
    }

    // Getter untuk damage yang disebabkan oleh senjata
    public int getDamage() {
        return damage;
    }
}
