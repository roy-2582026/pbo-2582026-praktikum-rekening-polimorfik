public class Giro extends Rekening {
    private int batasOverdraft;

    public Giro(String nomor, String nama, int saldo, int batasOverdraft) {
        super(nomor, nama, saldo);
        this.batasOverdraft = batasOverdraft;
    }

    // 5. Override biaya admin sesuai aturan
    @Override
    public int biayaAdminBulanan() {
        return 15000; // Giro selalu Rp15.000
    }

    // 5. Override tarik tetap ada untuk overdraft
    @Override
    public boolean tarik(int jumlah) {
        if (saldo + batasOverdraft >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\n      Giro, batas overdraft " + formatRupiah(batasOverdraft);
    }
}