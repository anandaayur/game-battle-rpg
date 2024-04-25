import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pilih Hero
        Hero hero = selectHero(scanner);

        // Pilih Foe
        Foe foe = selectFoe(scanner);

        // Mulai pertempuran
        System.out.println("\nPertempuran dimulai!");

        while (foe.HP > 0 && hero.HP > 0) {
            // Foe memilih aksi secara acak: 0 untuk menyerang, 1 untuk bertahan
            int foeAction = new Random().nextInt(2);

            // Lakukan serangan atau bertahan sesuai dengan pilihan Foe
            if (foeAction == 0) {
                foe.attack(hero);
            } else {
                foe.defend();
            }

            // Tampilkan informasi karakter setelah serangan Foe
            System.out.println("\nInformasi Karakter Setelah Serangan Foe:");
            System.out.println(hero);
            System.out.println(foe);

            // Pilihan aksi Hero
            int heroAction = selectAction(scanner);

            // Lakukan serangan, bertahan, atau menggunakan item sesuai dengan pilihan pengguna
            switch (heroAction) {
                case 1:
                    hero.attack(foe);
                    break;
                case 2:
                    hero.defend();
                    break;
                case 3:
                    useItem(hero, scanner);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }

            // Tampilkan informasi karakter setelah serangan Hero atau penggunaan item
            System.out.println("\nInformasi Karakter Setelah Aksi Hero:");
            System.out.println(hero);
            System.out.println(foe);
        }

        // Tampilkan hasil pertempuran
        if (foe.HP <= 0) {
            System.out.println(foe.nama + " telah dikalahkan!");
            hero.levelUp();
            System.out.println(hero.nama + " naik level menjadi level " + hero.level + "!");
        } else if (hero.HP <= 0) {
            System.out.println(hero.nama + " telah dikalahkan...");
        }

        scanner.close();
    }

    // Metode untuk memilih Hero
    public static Hero selectHero(Scanner scanner) {
        System.out.println("Pilih Hero:");
        System.out.println("1. Arthur (Knight)");
        System.out.println("2. Robin (Archer)");
        System.out.print("Pilih Hero (masukkan nomor): ");
        int heroChoice = scanner.nextInt();

        switch (heroChoice) {
            case 1:
                return new Hero("Arthur", "Knight", 10, Weapon.Type.PEDANG, Armor.Type.PERISAI);
            case 2:
                return new Hero("Robin", "Archer", 8, Weapon.Type.PANAH, Armor.Type.ZIRAH);
            default:
                System.out.println("Pilihan Hero tidak valid, Arthur (Knight) akan dipilih secara default.");
                return new Hero("Arthur", "Knight", 10, Weapon.Type.PEDANG, Armor.Type.PERISAI);
        }
    }

    // Metode untuk memilih Foe
    public static Foe selectFoe(Scanner scanner) {
        System.out.println("\nPilih Foe:");
        System.out.println("1. Orc");
        System.out.println("2. Elf");
        System.out.print("Pilih Foe (masukkan nomor): ");
        int foeChoice = scanner.nextInt();

        switch (foeChoice) {
            case 1:
                return new Foe("Orc", "Orc", 12, 30, 50); // Misalnya, Potion: 30, Elixir: 50
            case 2:
                return new Foe("Elf", "Elf", 9, 25, 40); // Misalnya, Potion: 25, Elixir: 40
            default:
                System.out.println("Pilihan Foe tidak valid, Orc akan dipilih secara default.");
                return new Foe("Orc", "Orc", 12, 30, 50);
        }
    }

    // Metode untuk memilih aksi Hero
    public static int selectAction(Scanner scanner) {
        System.out.println("\nApa yang akan dilakukan oleh Hero?");
        System.out.println("1. Serang");
        System.out.println("2. Bertahan");
        System.out.println("3. Gunakan item");
        System.out.print("Pilih aksi (masukkan nomor): ");
        return scanner.nextInt();
    }

    // Metode untuk menggunakan item
    public static void useItem(Hero hero, Scanner scanner) {
        System.out.println("\nPilih item yang akan digunakan:");
        System.out.println("1. Elixir (Menambahkan MP dan HP)");
        System.out.println("2. Potion (Menambahkan HP)");
        System.out.println("3. Ether (Menambahkan MP)");
        System.out.print("Pilih item (masukkan nama item): ");
        String itemName = scanner.next();
        hero.item(itemName);
    }
}
