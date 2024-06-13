public class TransaksiRental {
    BarangRental head;
    int size;

    int kodeTransaksi, lamaPinjam;
    String namaPeminjam;
    double totalBiaya;
    String br;

    public TransaksiRental() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(String noTNKB, String namaKendaraan, String jenisKendaraan, int tahun, int biayaSewa) {
        if (isEmpty()) {
            head = new BarangRental(null, noTNKB, namaKendaraan, jenisKendaraan, tahun, biayaSewa, null);
        } else {
            BarangRental newNode = new BarangRental(null, noTNKB, namaKendaraan, jenisKendaraan, tahun, biayaSewa,
                    head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void remove(int index) throws Exception {
        if (isEmpty() || index >= size) {
            System.out.println("Masukkan nilai yang valid");
        } else if (index == 1) {
            head = head.next;
            head.prev = null;
            size--;
        } else {
            BarangRental current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else if (current.next == null) {
                current.prev.next = null;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public String get(String br2) throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
    
        BarangRental tmp = head;
        while (!tmp.noTNKB.equalsIgnoreCase(br2)) {
            if (tmp.next == null) {
                throw new Exception("Unexpected null node encountered");
            }
            tmp = tmp.next;
        }
        return tmp.noTNKB;
    }

    public void printBarang() {
        if (isEmpty()) {
            System.out.println("Data kosong");
        } else {
            BarangRental tmp = head;
            while (tmp != null) {
                System.out.println("No TNKB : " + tmp.noTNKB);
                System.out.println("Jenis Kendaraan : " + tmp.jenisKendaraan);
                System.out.println("Tahun : " + tmp.tahun);
                System.out.println("Biaya Sewa : " + tmp.biayaSewa);
                System.out.println();
                tmp = tmp.next;
            }
        }
    }

    public void addPeminjaman(String namaPeminjam, int lamaPinjam, double totalBiaya, String br) throws Exception {
        kodeTransaksi++;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.totalBiaya = totalBiaya;
        this.br = get(br);
    }

    public void removePeminjaman(){
        kodeTransaksi = 0;
        namaPeminjam = null;
        lamaPinjam = 0;
        totalBiaya = 0;
        br = null;
    }

    public void printPeminjaman() {
        if (isEmpty()) {
            System.out.println("Data kosong");
        } else {
            System.out.println("Kode Transaksi : " + kodeTransaksi);
            System.out.println("Nama : " + namaPeminjam);
            System.out.println("Lama Pinjam : " + lamaPinjam);
            System.out.println("Total Biaya : " + totalBiaya);
            System.out.println("No TNKB : " + br);
        }
    }
}
