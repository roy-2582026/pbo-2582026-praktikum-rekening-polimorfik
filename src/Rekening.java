public abstract class Rekening {
    protected String nomor;
    protected String nama;
    protected int saldo;

    public Rekening(String nomor, String nama, int saldo) {
        this.nomor = nomor;
        this.nama = nama;
        this.saldo = saldo;
    }

    public String getNomor() {
        return nomor;
    }

    public String getNama() {
        return nama;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setor(int jumlah) {
        saldo += jumlah;
    }

    public boolean tarik(int jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    // 1. Method abstract untuk biaya admin bulanan
    public abstract int biayaAdminBulanan();

    // 2. Method konkret untuk memotong biaya admin dari saldo
    public int potongBiayaAdmin() {
        int biaya = biayaAdminBulanan();
        saldo -= biaya;
        return biaya;
    }

    // Method pembantu untuk format Rupiah standar (titik ribuan)
    protected String formatRupiah(int nominal) {
        return "Rp" + String.format("%,d", nominal).replace(',', '.');
    }

    // Override toString untuk format polimorfisme (tanpa instanceof)
    @Override
    public String toString() {
        return String.format("%s | %-6s | %12s", nomor, nama, formatRupiah(saldo));
    }
}