<?php

declare(strict_types=1);

class TiketKonser
{
    public function __construct(
        private readonly string $kodeTiket,
        private readonly string $namaEvent,
        private readonly float $hargaTiket,
        private int $kuotaTersedia
    ) {
        if ($hargaTiket <= 0) {
            throw new InvalidArgumentException('Harga tiket harus lebih besar dari nol');
        }
        if ($kuotaTersedia < 0) {
            throw new InvalidArgumentException('Kuota awal tidak boleh negatif');
        }
    }

    public function jual(int $jumlah): void
    {
        if ($jumlah <= 0) {
            throw new InvalidArgumentException('Jumlah tiket yang dijual harus lebih besar dari nol');
        }
        if ($jumlah > $this->kuotaTersedia) {
            throw new InvalidArgumentException("Kuota tidak mencukupi, sisa kuota: {$this->kuotaTersedia}");
        }
        $this->kuotaTersedia -= $jumlah;
    }

    public function getKuotaTersedia(): int
    {
        return $this->kuotaTersedia;
    }

    public function getHargaTiket(): float
    {
        return $this->hargaTiket;
    }

    public function tampilkan(): void
    {
        $hargaFormatted = number_format($this->hargaTiket, 0, ',', '.');
        echo "Kode Tiket   : {$this->kodeTiket}\n";
        echo "Nama Event   : {$this->namaEvent}\n";
        echo "Harga Tiket  : Rp{$hargaFormatted}\n";
        echo "Kuota Tersisa: {$this->kuotaTersedia}\n";
    }
}
