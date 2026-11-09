public class Tabungan extends Rekening implements BerBunga {
    private double sukuBunga;

    public Tabungan(String nomor, String nama, int saldo, double sukuBunga) {
        super(nomor, nama, saldo);
        this.sukuBunga = sukuBunga;
    }

    // 4. Override biaya admin sesuai aturan
    @Override
    public int biayaAdminBulanan() {
        if (saldo >= 1000000) {
            return 0;
        } else {
            return 5000;
        }
    }

    // 4. Implementasi dari interface BerBunga
    @Override
    public int tambahBunga() {
        int bunga = (int) (saldo * sukuBunga);
        saldo += bunga;
        return bunga;
    }

    @Override
    public String toString() {
        // Format angka desimal bunga (misal 2.5) dengan locale netral
        String strBunga = String.valueOf(sukuBunga * 100);
        return super.toString() + "\n      Tabungan, bunga " + strBunga + "% per bulan";
    }
}