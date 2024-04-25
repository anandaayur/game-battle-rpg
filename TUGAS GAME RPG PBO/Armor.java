class Armor {
    public enum Type {PERISAI, ZIRAH}

    private Type type;
    private String name;
    private int shield;

    // Konstruktor untuk inisialisasi armor berdasarkan tipe
    public Armor(Type type) {
        this.type = type;
        switch (type) {
            case PERISAI:
                this.name = "Perisai";
                this.shield = 30;
                break;
            case ZIRAH:
                this.name = "Zirah";
                this.shield = 20;
                break;
        }
    }

    // Getter untuk nama armor
    public String getName() {
        return name;
    }

    // Getter untuk shield yang diberikan oleh armor
    public int getShield() {
        return shield;
    }
}