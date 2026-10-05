package id.ac.polban.pbo.kantin.model;

public class Pesanan {

    private static int nextNumber = 1;

    private int nomor;
    private Mahasiswa pemesan;
    private MenuItem menu;
    private int jumlah;

    public Pesanan(Mahasiswa pemesan, MenuItem menu, int jumlah){
        this.nomor = nextNumber++;
        this.pemesan = pemesan;
        this.menu = menu;
        this.jumlah = jumlah;
    }

    public int getNomor() { 
        return nomor;
    }

    public Mahasiswa getPemesan() {
        return pemesan;
    }

    public MenuItem getMenu() {
        return menu;
    }

    public boolean dapatDiproses(){
        return jumlah > 0 && menu.isTersedia();
    }

    public int hitungTotal() {
        return menu.getHarga() * jumlah;
    }

    public static int getJumlahPesananDibuat() {
        return nextNumber - 1;
    }

    public void ringkasan() {
        System.out.println("=== Pesanan #" + nomor + " ===");
        System.out.println("Pemesan : " + pemesan.getNama() + " (" + pemesan.getNim() + ")");
        System.out.println("Menu    : " + menu.getNama());
        System.out.println("Jumlah  : " + jumlah);
        System.out.println("Total   : Rp " + hitungTotal());
        System.out.println("Status  : " + (dapatDiproses() ? "Dapat diproses" : "Ditolak"));
    }

}
