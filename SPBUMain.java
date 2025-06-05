import java.util.Scanner;

public class SPBUMain {
    public static void main(String[] args) {
        AntrianKendaraanLinkedList antrianKendaraan = new AntrianKendaraanLinkedList();
        QueueTransaksi queueTransaksi = new QueueTransaksi(50);
        Scanner scanner = new Scanner(System.in);

        int pilihan;
        
        do {
            System.out.println("\n--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Plat Nomor: ");
                    String platNomor = scanner.nextLine();
                    System.out.print("Masukkan Jenis Kendaraan: ");
                    String tipe = scanner.nextLine();
                    System.out.print("Masukkan Merk: ");
                    String merk = scanner.nextLine();
                    
                    Kendaraan kendaraan = new Kendaraan(platNomor, tipe, merk);
                    antrianKendaraan.tambahAntrian(kendaraan);
                    break;
                case 2:
                    antrianKendaraan.tampilkanAntrian();
                    break;
                case 3:
                    System.out.println(">> Jumlah kendaraan dalam antrian: " + antrianKendaraan.cekJumlahAntrian());
                    break;
                case 4:
                    if (antrianKendaraan.isEmpty()) {
                        System.out.println("Tidak ada kendaraan dalam antrian.");
                        return;
                    }
                    
                    Kendaraan kendaraanDilayani = antrianKendaraan.layaniKendaraan();
                    System.out.println("Petugas melayani " + kendaraanDilayani.platNomor);
                    kendaraanDilayani.tampilkanInformasi();
                    
                    System.out.print("Masukkan Jenis BBM: ");
                    String jenisBBM = scanner.nextLine();
                    
                    System.out.print("Masukkan Harga per liter: ");
                    double hargaPerLiter = scanner.nextDouble();
                    
                    System.out.print("Masukkan Jumlah liter: ");
                    double jumlahLiter = scanner.nextDouble();
                    scanner.nextLine();
                    
                    BBM bbm = new BBM(jenisBBM, hargaPerLiter);
                    TransaksiPengisian transaksi = new TransaksiPengisian(kendaraanDilayani, bbm, jumlahLiter);
                    queueTransaksi.tambahTransaksi(transaksi);
                    break;
                case 5:
                    queueTransaksi.tampilkanRiwayatTransaksi();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
} 
