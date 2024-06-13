import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Scanner sc3 = new Scanner(System.in);

        TransaksiRental b = new TransaksiRental();
        TransaksiRental[] tr = new TransaksiRental[5];

        b.add("S 4567 YV", "Beat", "Motor", 2017, 10000);
        b.add("N 4511 VS", "Vario", "Motor", 2018, 10000);
        b.add("N 1453 AA", "Yaris", "Sedan", 2022, 30000);
        b.add("AB 4321 A", "Innova", "Sedan", 2019, 60000);
        b.add("B 1234 AG", "Avanza", "Sedan", 2021, 25000);

        for (int i = 0; i < tr.length; i++) {
            tr[i] = new TransaksiRental();
        }
        tr[0].addPeminjaman("Ahmad", 2, 60000, "N 1453 AA");
        tr[1].addPeminjaman("Joni", 3, 30000, "N 4567 YV");

        boolean run = true;
        while (run) {
            System.out.println("Menu");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Peminjaman");
            System.out.println("3. Tampil seluruh transaksi");
            System.out.println("4. Exit");
            System.out.print("pilih: ");
            int pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    b.printBarang();
                    break;
                case 2:
                    System.out.println("Tambah Peminjaman");
                    System.out.print("Masukkan nama: ");
                    String nama = sc2.nextLine();
                    System.out.print("Masukkan lama pinjam: ");
                    int lp = sc2.nextInt();
                    System.out.print("Masukkan no TNKB: ");
                    String TNKB = sc3.nextLine();
                    System.out.print("Masukkan total biaya: ");
                    int total = sc2.nextInt();

                    b.addPeminjaman(nama, lp, total, TNKB);

                    break;
                case 3:
                    for (int i = 0; i < tr.length; i++) {
                        tr[i].printPeminjaman();
                    }
                    break;
                case 4:
                    run = false;
                    break;

                default:
                    break;
            }
        }
    }
}
