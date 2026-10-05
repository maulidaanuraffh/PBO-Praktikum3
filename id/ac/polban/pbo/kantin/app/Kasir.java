package id.ac.polban.pbo.kantin.app;

import id.ac.polban.pbo.kantin.model.Pesanan;

public class Kasir {

    private String namaKasir;

    public Kasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    // uses-a: Pesanan HANYA diterima sebagai parameter
    // Kasir tidak menyimpan Pesanan sebagai field
    // Setelah method ini selesai, Kasir tidak "ingat" pesanan apapun
    public void proses(Pesanan pesanan) {
        System.out.println("Kasir [" + namaKasir + "] " + "memproses Pesanan #" + pesanan.getNomor());

        if (pesanan.dapatDiproses()) {
            System.out.println("  Hasil  : DITERIMA");
            System.out.println("  Total  : Rp " + pesanan.hitungTotal());
        } else {
            System.out.println("  Hasil  : DITOLAK");
            System.out.println("  Alasan : Menu habis atau jumlah tidak valid");
        }
    }

    // uses-a Pesanan masuk sebagai parameter, bukan field
    public void cetakStruk(Pesanan pesanan) {
        if (!pesanan.dapatDiproses()) {
            System.out.println("  [Struk tidak dicetak — pesanan ditolak]");
            return;
        }
        System.out.println("  ======= STRUK KANTIN POLBAN =======");
        System.out.println("  Kasir  : " + namaKasir);
        System.out.println("  No.    : " + pesanan.getNomor());
        System.out.println("  Pemesan: " + pesanan.getPemesan().getNama() + " (" + pesanan.getPemesan().getNim() + ")");
        System.out.println("  Menu   : " + pesanan.getMenu().getNama());
        System.out.println("  Total  : Rp " + pesanan.hitungTotal());
        System.out.println("  ===================================");
    }
}
