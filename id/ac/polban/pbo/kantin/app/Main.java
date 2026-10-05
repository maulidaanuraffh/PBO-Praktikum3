package id.ac.polban.pbo.kantin.app;

// [TASK 6] Import dari package model
import id.ac.polban.pbo.kantin.model.Mahasiswa;
import id.ac.polban.pbo.kantin.model.MenuItem;
import id.ac.polban.pbo.kantin.model.Pesanan;

public class Main {
    public static void main(String[] args) {

        // [TASK 2] Bukti Class dan Object
        Mahasiswa m1 = new Mahasiswa("241001", "Asep");
        Mahasiswa m2 = new Mahasiswa("241002", "Siti");

        MenuItem nasi = new MenuItem("M01", "Nasi Goreng", 18000);
        MenuItem kopi = new MenuItem("M02", "Kopi Susu",   12000);
        MenuItem mie  = new MenuItem("M03", "Mie Ayam",    15000);


        // T-01 Dua Mahasiswa dari class yang sama, state berbeda
        System.out.println("=== T-01: Dua Mahasiswa, State Berbeda ===");
        System.out.println("m1 → NIM: " + m1.getNim() + " | Nama: " + m1.getNama());
        System.out.println("m2 → NIM: " + m2.getNim() + " | Nama: " + m2.getNama());
        System.out.println("Keduanya instance dari class Mahasiswa yang sama.");
        System.out.println();


        // T-03 Tandai satu menu habis, menu lain tidak terpengaruh
        System.out.println("=== T-03: Encapsulation — State Object Terisolasi ===");
        kopi.tandaiHabis(); // hanya kopi yang berubah
        System.out.println("nasi.isTersedia() → " + nasi.isTersedia()); 
        System.out.println("kopi.isTersedia() → " + kopi.isTersedia());  
        System.out.println("mie.isTersedia()  → " + mie.isTersedia());  
        System.out.println("State nasi dan mie tidak ikut berubah.");
        System.out.println();


        
        // T-05: menu tersedia, jumlah > 0 → dapatDiproses() = true
        Pesanan p1 = new Pesanan(m1, nasi, 2);

        // T-06: menu habis → dapatDiproses() = false
        Pesanan p2 = new Pesanan(m2, kopi, 1);

        // T-07: jumlah = 0 → dapatDiproses() = false
        Pesanan p3 = new Pesanan(m1, nasi, 0);

        // p4 → pesanan valid tambahan untuk melengkapi T-04
        Pesanan p4 = new Pesanan(m2, mie, 3);


        // [TASK 4} Static counter, nomor meningkat otomatis
        System.out.println("=== T-04 + Task 4: Static Counter ===");
        System.out.println("Nomor P1 : " + p1.getNomor()); 
        System.out.println("Nomor P2 : " + p2.getNomor()); 
        System.out.println("Nomor P3 : " + p3.getNomor()); 
        System.out.println("Nomor P4 : " + p4.getNomor()); 
        System.out.println("Total pesanan dibuat: " + Pesanan.getJumlahPesananDibuat());
        System.out.println();


        // T-05 Menu tersedia + jumlah > 0 → dapatDiproses() = true
        System.out.println("=== T-05: Menu Tersedia + Jumlah Valid ===");
        System.out.println("P1 [Nasi Goreng, jml 2] dapatDiproses: " + p1.dapatDiproses()); 
        System.out.println("P4 [Mie Ayam, jml 3]   dapatDiproses: " + p4.dapatDiproses()); 
        System.out.println();

        // T-06 — Menu habis → dapatDiproses() = false
        System.out.println("=== T-06: Menu Habis → Ditolak ===");
        System.out.println("P2 [Kopi Susu HABIS, jml 1] dapatDiproses: " + p2.dapatDiproses()); 
        System.out.println();

        // T-07 — Jumlah 0 → dapatDiproses() = false
        System.out.println("=== T-07: Jumlah 0 → Ditolak ===");
        System.out.println("P3 [Nasi Goreng, jml 0] dapatDiproses: " + p3.dapatDiproses());
        System.out.println();


        // [TASK 5] Bukti Relationship
        System.out.println("=== Task 5: Relationship antar Object ===");
        // p1.getPemesan() mengembalikan object Mahasiswa aslinya
        // lalu .getNama() meminta data dari object itu
        System.out.println("Pemesan P1     : " + p1.getPemesan().getNama());
        System.out.println("NIM pemesan P1 : " + p1.getPemesan().getNim());
        // p1.getMenu() mengembalikan object MenuItem aslinya
        System.out.println("Menu P1 : " + p1.getMenu().getNama());
        System.out.println("Harga   : Rp " + p1.getMenu().getHarga());
        // hitungTotal() tidak punya field harga sendiri
        // ia meminta harga ke object MenuItem melalui method call
        System.out.println("Total P1 (harga x jumlah)            : Rp " + p1.hitungTotal());
        System.out.println();


        // ============================================================
        // Ringkasan semua pesanan
        // ============================================================
        System.out.println("=== Ringkasan Semua Pesanan ===");
        p1.ringkasan();
        System.out.println();
        p2.ringkasan();
        System.out.println();
        p3.ringkasan();
        System.out.println();
        p4.ringkasan();
    }
}