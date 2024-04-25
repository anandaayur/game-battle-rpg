import java.util.Random;

class Foe extends Character {
    private int magicDamage;
    private int magicUlti;

    public Foe(String nama, String ras, int level, int magicDamage, int magicUlti) {
        super(nama, ras, level);
        this.magicDamage = magicDamage;
        this.magicUlti = magicUlti;
    }

    @Override
    public void attack(Character target) {
        Random random = new Random();
        int attackChoice = random.nextInt(3); // 0: Normal Attack, 1: Potion, 2: Elixir

        switch (attackChoice) {
            case 0:
                normalAttack(target);
                break;
            case 1:
                useMagicDamage(target);
                break;
            case 2:
                useMagicUlti(target);
                break;
        }
    }

    private void normalAttack(Character target) {
        // Implementasi serangan normal Foe
    }

    private void useMagicDamage(Character target) {
        target.HP -= magicDamage;
        System.out.println(nama + " menggunakan magic damage dan " + target.nama + " menerima damage sebesar "
                + magicDamage + "!");
    }

    public void defend() {
        // Implementasi perilaku bertahan Foe
        System.out.println(nama + " sedang bertahan!");

    }

    private void useMagicUlti(Character target) {
        target.HP -= magicUlti;
        System.out
                .println(nama + " menggunakan Ulti dan " + target.nama + " menerima damage sebesar " + magicUlti + "!");
    }
}
