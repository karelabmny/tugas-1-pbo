public class TiketKonser {

    private final String kodeTiket;
    private final String namaEvent;
    private final double hargaTiket;
    private int kuotaTersedia;

    public TiketKonser(String kodeTiket, String namaEvent, double hargaTiket, int kuotaAwal) {
        if (hargaTiket <= 0) {
            throw new IllegalArgumentException("Harga tiket harus lebih besar dari nol");
        }
        if (kuotaAwal < 0) {
            throw new IllegalArgumentException("Kuota awal tidak boleh negatif");
        }
        this.kodeTiket = kodeTiket;
        this.namaEvent = namaEvent;
        this.hargaTiket = hargaTiket;
        this.kuotaTersedia = kuotaAwal;
    }

    public void jual(int jumlah) {
        if (jumlah <= 0) {
            throw new IllegalArgumentException("Jumlah tiket yang dijual harus lebih besar dari nol");
        }
        if (jumlah > kuotaTersedia) {
            throw new IllegalArgumentException("Kuota tidak mencukupi, sisa kuota: " + kuotaTersedia);
        }
        this.kuotaTersedia -= jumlah;
    }

    public int getKuotaTersedia() {
        return kuotaTersedia;
    }

    public double getHargaTiket() {
        return hargaTiket;
    }

    public void tampilkan() {
        System.out.println("Kode Tiket   : " + kodeTiket);
        System.out.println("Nama Event   : " + namaEvent);
        System.out.println("Harga Tiket  : Rp" + String.format("%,.0f", hargaTiket));
        System.out.println("Kuota Tersisa: " + kuotaTersedia);
    }
}
