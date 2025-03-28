package pemlanTugas4;

public class Pengguna {
    private double saldo;
    private String nomorRek;
    private String nama;
    private int nomorPin;
    private int pembelian;
    private boolean aktif;
    private int autentikasiCount = 0;
    private  static int jumlahObjek = 0;
    
    public Pengguna(double saldo, String nomorRek, String nama, int nomorPin){
        this.saldo = saldo;
        this.nomorRek = nomorRek;
        this.nama = nama;
        this.nomorPin = nomorPin;
        aktif = true;
        jumlahObjek++;
    }

    public void Bayar(int pembelian){
        this.pembelian = pembelian;
        if (aktif = true) {
            if (saldo < 10.000 || saldo < this.pembelian) {
                System.out.println("saldo anda tidak cukup (Minimal: Rp.10.000)!");
            }
            
            if (saldo >= this.pembelian) {
                if (nomorRek.substring(0, 2).equals("38")) {
                    saldo -= this.pembelian;
                    if (this.pembelian > 1_000_000) {
                        saldo = saldo + (this.pembelian * 0.05);
                    }
                    System.out.println("Pembayaran Berhasil");
                    System.out.println("Saldo anda sisa: " + saldo);
                }
        
                if (nomorRek.substring(0, 2).equals("56")) {
                    saldo -= this.pembelian;
                    if (this.pembelian > 1_000_000) {
                        saldo = saldo + (this.pembelian * 0.07);
                        saldo = saldo + (this.pembelian * 0.02);
                    }
                    System.out.println("Pembayaran Berhasil");
                    System.out.println("Saldo anda sisa: " + saldo);
                }
                if (nomorRek.substring(0, 2).equals("74")) {
                    saldo -= this.pembelian;
                    if (this.pembelian > 1_000_000) {
                        saldo = saldo + (this.pembelian * 0.1);
                        saldo = saldo + (this.pembelian * 0.05);
                    }
                    System.out.println("Pembayaran Berhasil");
                    System.out.println("Saldo anda sisa: " + saldo);
                }
            }
        } else if (aktif = false) {
            System.out.println("Akun sudah terblokir");
        }
           
        
    } 
    public void TopUp(int TopUp){
        saldo += TopUp;
        System.out.println("Top Up Berhasil!");
        System.out.println("Saldo anda: " + saldo);
    } 

    
    public String getNomorRek(){
        return nomorRek;
    }

    public int getNomorPin(){
        return nomorPin;
    }

    public double getSaldo(){
        return saldo;
    }

    public int getPembelian(){
        return pembelian;
    }
    public static int getJumlahobjek(){
        return jumlahObjek;
    }
    public boolean getAktif(){
        return aktif;
    }

    public void ErrorAuth(){
        autentikasiCount++;
        System.out.println("Verifikasi Salah Coba Lagi");
        if (autentikasiCount >= 3) {
            System.out.println("Anda terlalu banyak melakukan verifikasi, Akun terblokir");
            aktif = false;
        }
    }

}
