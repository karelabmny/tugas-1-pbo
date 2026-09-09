public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. Membuat objek valid ===");
        TiketKonser tiket = new TiketKonser("TK-001", "Konser Sheila On 7 - Reuni", 350000, 100);
        tiket.tampilkan();

        System.out.println("\n=== 2. Perubahan sah: jual(20) ===");
        tiket.jual(20);
        tiket.tampilkan();

        System.out.println("\n=== 3. Operasi tidak sah #1: jual(-5) ===");
        try {
            tiket.jual(-5);
            System.out.println("BUG: seharusnya ditolak!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ditolak (sesuai harapan): " + e.getMessage());
        }

        System.out.println("\n=== 4. Operasi tidak sah #2: jual(1000) ===");
        try {
            tiket.jual(1000);
            System.out.println("BUG: seharusnya ditolak!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ditolak (sesuai harapan): " + e.getMessage());
        }

    }
}
