<?php

declare(strict_types=1);

require_once __DIR__ . '/TiketKonser.php';

echo "=== 1. Membuat objek valid ===\n";
$tiket = new TiketKonser("TK-001", "Konser Sheila On 7 - Reuni", 350000, 100);
$tiket->tampilkan();

echo "\n=== 2. Perubahan sah: jual(20) ===\n";
$tiket->jual(20);
$tiket->tampilkan();

echo "\n=== 3. Operasi tidak sah #1: jual(-5) ===\n";
try {
    $tiket->jual(-5);
    echo "BUG: seharusnya ditolak!\n";
} catch (InvalidArgumentException $e) {
    echo "Ditolak (sesuai harapan): " . $e->getMessage() . "\n";
}

echo "\n=== 4. Operasi tidak sah #2: jual(1000) ===\n";
try {
    $tiket->jual(1000);
    echo "BUG: seharusnya ditolak!\n";
} catch (InvalidArgumentException $e) {
    echo "Ditolak (sesuai harapan): " . $e->getMessage() . "\n";
}
