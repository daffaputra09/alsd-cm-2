public class AntrianKendaraanLinkedList {
    private Node head;
    private int jumlahAntrian;
    
    public AntrianKendaraanLinkedList() {
        this.head = null;
        this.jumlahAntrian = 0;
    }
    
    public void tambahAntrian(Kendaraan kendaraan) {
        Node newNode = new Node(kendaraan);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        jumlahAntrian++;
        System.out.println(">> Kendaraan masuk ke dalam antrian.");
    }
    
    public void tampilkanAntrian() {
        if (head == null) {
            System.out.println("Antrian kosong");
            return;
        }
        
        System.out.println("-- Antrian Kendaraan --");
        Node current = head;
        while (current != null) {
            System.out.println("Plat Nomor: " + current.kendaraan.platNomor);
            System.out.println("Tipe: " + current.kendaraan.tipe);
            System.out.println("Merk: " + current.kendaraan.merk);
            System.out.println();
            current = current.next;
        }
    }
    
    public int cekJumlahAntrian() {
        return jumlahAntrian;
    }
    
    public Kendaraan layaniKendaraan() {
        if (head == null) {
            return null;
        }
        
        Kendaraan kendaraanDilayani = head.kendaraan;
        head = head.next;
        jumlahAntrian--;
        
        return kendaraanDilayani;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
} 