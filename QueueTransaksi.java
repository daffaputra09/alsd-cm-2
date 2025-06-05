public class QueueTransaksi {
    TransaksiPengisian[] transaksi;
    int front;
    int rear;
    int size;
    int max;
    
    public QueueTransaksi(int n) {
        max = n;
        transaksi = new TransaksiPengisian[max];
        size = 0;
        front = rear = -1;
    }
    
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    
    public void tampilkanRiwayatTransaksi() {
        if (isEmpty()) {
            System.out.println("Belum ada transaksi");
        } else {
            System.out.println("-- Riwayat Transaksi --");
            System.out.println("Daftar Transaksi:");
            int i = front;
            while (i != rear) {
                System.out.println(transaksi[i].kendaraan.platNomor + ": Rp " + (int)transaksi[i].totalBayar + ".0");
                i = (i + 1) % max;
            }
            System.out.println(transaksi[i].kendaraan.platNomor + ": Rp " + (int)transaksi[i].totalBayar + ".0");
        }
    }
    
    public void tambahTransaksi(TransaksiPengisian dt) {
        if (isFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            transaksi[rear] = dt;
            size++;
            System.out.println(">> Transaksi berhasil dicatat.");
        }
    }
} 