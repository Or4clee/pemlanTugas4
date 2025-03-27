package pemlanTugas4;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      
        Pengguna pengguna[] = new Pengguna[10];

        pengguna[0] = new Pengguna(2_000_000, "74999999", "Byan", 1234);
        pengguna[1] = new Pengguna(3_000_000, "38999999", "Sigma", 3333); 
        pengguna[2] = new Pengguna(3_500_000, "56999999", "Mew", 2222); 

        while (true) {
            System.out.println("\n--- Sistem Transaksi ---");
            System.out.println("1. Lakukan Transaksi");
            System.out.println("2. Top Up");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    Pengguna PenggunaDitemukan = null;
                    System.out.print("Masukan nomoRek: ");
                    String noRek = input.next();

                    for(int i = 0; i < Pengguna.getJumlahobjek() ; i++){
                        if (pengguna[i].getNomorRek().equals(noRek)) {
                            PenggunaDitemukan = pengguna[i];
                            break;
                        }
                    }
                    if (PenggunaDitemukan == null) {
                        System.out.println("Pengguna tidak ditemukan");
                        break;
                    }
                    if (!PenggunaDitemukan.equals(null) && PenggunaDitemukan.getAktif() == true) {
                        System.out.print("Masukan Pin: ");
                        int pin = input.nextInt();
                        if (PenggunaDitemukan.getNomorPin() == pin) {
                            System.out.print("Masukan nominal pembelian: ");
                            int pembelian = input.nextInt();
                            PenggunaDitemukan.Bayar(pembelian);
                        } else if (PenggunaDitemukan.getNomorPin() != pin) {
                            PenggunaDitemukan.ErrorAuth();
                            break;
                        }
                    }

                    if (!PenggunaDitemukan.equals(null) && PenggunaDitemukan.getAktif() == false) {
                        System.out.println("Akun Terblokir");
                        break;
                    }
                    break;
        
                
                case 2:
                PenggunaDitemukan = null;
                System.out.print("Masukan nomoRek: ");
                noRek = input.next();

                for(int i = 0; i < Pengguna.getJumlahobjek() ; i++){
                    if (pengguna[i].getNomorRek().equals(noRek)) {
                        PenggunaDitemukan = pengguna[i];
                        break;
                    }
                }
                if (PenggunaDitemukan == null) {
                    System.out.println("Pengguna tidak ditemukan");
                    break;
                }
                if (!PenggunaDitemukan.equals(null) && PenggunaDitemukan.getAktif() == true) {
                    System.out.print("Masukan Pin: ");
                    int pin = input.nextInt();
                    if (PenggunaDitemukan.getNomorPin() == pin) {
                        System.out.print("Masukan nominal TopUp: ");
                        int topup = input.nextInt();
                        PenggunaDitemukan.TopUp(topup);
                    } else if (PenggunaDitemukan.getNomorPin() != pin) {
                        PenggunaDitemukan.ErrorAuth();
                        break;
                    }
                }

                if (!PenggunaDitemukan.equals(null) && PenggunaDitemukan.getAktif() == false) {
                    System.out.println("Akun Terblokir");
                    break;
                }

                break;
                case 3:
                    System.out.println("Program Selesai!");
                    return;
                default:
                    System.out.println("Input salah coba lagi!");
                    break;
            }
        }
    }
}
