# Tugas 1 — Pengantar OOP: TiketKonser


## Deskripsi Domain

Sistem sederhana untuk mencatat penjualan tiket satu event konser: kode tiket,
nama event, harga per tiket, dan sisa kuota kursi. Tiket "dijual" lewat method
`jual(jumlah)`, yang mengurangi kuota sampai habis.

## Rancangan Kelas

## Field
| - kodeTiket      : String   
│ − namaEvent      : String   
│ − hargaTiket     : double   (tidak boleh ≤ 0)
│ − kuotaTersedia  : int 


## Method

+ TiketKonser(kode, nama, harga, kuotaAwal)
+ jual(jumlah)
+ getKuotaTersedia()
+ getHargaTiket()
+ tampilkan()
```

## Invarian 

1. **`hargaTiket` harus lebih besar dari nol.**
   Alasan: tiket seharga 0 atau negatif tidak masuk akal secara bisnis — itu bukan
   tiket yang dijual, itu tiket gratis atau data korup. Dicek sekali di constructor,
   dan karena tidak ada setter untuk field ini, nilainya tidak bisa dirusak setelahnya.

2. **`kuotaTersedia` tidak boleh negatif.**
   Alasan: kuota mewakili jumlah kursi fisik yang tersisa. Kuota negatif berarti
   sistem menjual tiket yang tidak ada kursinya — invarian ini ditegakkan dua kali:
   saat objek dibuat (kuota awal ≥ 0) dan setiap kali `jual(jumlah)` dipanggil
   (jumlah yang diminta tidak boleh melebihi sisa kuota).

Field yang punya invarian (`hargaTiket`, `kuotaTersedia`) sengaja **tidak diberi
setter** — satu-satunya jalan mengubah `kuotaTersedia` adalah lewat `jual()`, yang
selalu memvalidasi dulu.

## Cara Menjalankan

### Java (butuh JDK 11+)

```bash
cd java/src
javac TiketKonser.java Main.java
java Main
```

### PHP (butuh PHP 8.1+ untuk `readonly`)

```bash
cd php
php main.php
```

Kedua program melakukan urutan yang sama: membuat objek valid → menampilkan →
satu perubahan sah (`jual(20)`) → dua operasi tidak sah (`jual(-5)` dan
`jual(1000)`, keduanya ditolak dengan exception) → menampilkan kondisi akhir
objek untuk membuktikan invarian tetap terjaga.

## Deklarasi Penggunaan AI

Struktur kelas, kedua implementasi (Java & PHP), dan draf README ini disusun
dengan bantuan Claude (Anthropic) berdasarkan materi Pertemuan 01 dan ketentuan
tugas. 
