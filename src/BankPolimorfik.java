public class BankPolimorfik {
    public static void main(String[] args) {
        // 6. Buat object di variabel masing-masing
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 0.025);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 0.020);
        Giro budi = new Giro("201", "Budi", 200000, 500000);

        // 8. Tulis, jalankan, copy pesan error, dan komen (sesuai instruksi)
        // Rekening r = new Rekening("999", "Eko", 0);
        // PESAN ERROR: java: <nama_package>.Rekening is abstract; cannot be instantiated

        // 6. Masukkan ke array
        Rekening[] semua = { ani, citra, budi };
        BerBunga[] berbunga = { ani, citra };

        // Method pembantu lokal untuk format rupiah
        java.util.function.Function<Integer, String> formatRp =
                (nominal) -> "Rp" + String.format("%,d", nominal).replace(',', '.');

        // --- CETAK REKENING AWAL ---
        System.out.println("========== REKENING AWAL ==========");
        for (Rekening rek : semua) {
            System.out.println(rek.toString());
        }

        // --- PROSES AKHIR BULAN ---
        System.out.println("\n========== AKHIR BULAN ============");

        // 7. Loop biaya admin (looping atas semua)
        for (Rekening rek : semua) {
            int potongan = rek.potongBiayaAdmin();
            System.out.printf("%s biaya admin  : %s\n", rek.getNomor(), formatRp.apply(potongan));
        }

        // 7. Loop bunga (looping atas berbunga)
        for (BerBunga bb : berbunga) {
            int bunga = bb.tambahBunga();
            System.out.printf("%s bunga        : %s\n", bb.getNomor(), formatRp.apply(bunga));
        }

        // --- CETAK REKENING AKHIR ---
        System.out.println("\n========== REKENING AKHIR =========");
        long totalDana = 0;
        for (Rekening rek : semua) {
            System.out.println(rek.toString());
            totalDana += rek.getSaldo();
        }

        System.out.println("-----------------------------------");
        System.out.println("Total dana bank : Rp" + String.format("%,d", totalDana).replace(',', '.'));
    }
}