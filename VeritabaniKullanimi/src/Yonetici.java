import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Yonetici extends Baglanti{

    private static String id_y = "root";
    private static String pw_y = "root";
    public String getId_y() {
        return id_y;
    }
    public String getPw_y() {
        return pw_y;
    }

    Scanner scanner = new Scanner(System.in);

    public void havayoluSirketiEkle() {
        try {
            statement = con.createStatement();

            System.out.println("Havayolu Şirketi ismi giriniz:");
            String havayoluSirketiAdi = scanner.nextLine();

            String havayoluSirketiEkle = "Insert Into HavayoluSirketleri (HavayoluSirketiAdi) VALUES(" + "'" +havayoluSirketiAdi + "')";
            statement.executeUpdate(havayoluSirketiEkle);

        } catch (SQLException e) {
            System.out.println("yonetici hata");
        }
    }

    public void havalimaniEkle() {
        try {
            statement = con.createStatement();

            System.out.println("Havalimani ismi giriniz:");
            String havalimaniAdi = scanner.nextLine();
            System.out.println("Havalimanı ülkesini giriniz:");
            String ulke = scanner.nextLine();
            System.out.println("Havalimanı şehrini giriniz:");
            String sehir = scanner.nextLine();
            String havalimaniEkle = "Insert Into Havalimanları (HavalimaniAdi, Ulke, Sehir) VALUES(" + "'" + havalimaniAdi + "'," + "'" + ulke + "',"+ "'" + sehir + "')";
            statement.executeUpdate(havalimaniEkle);

        } catch (SQLException e) {
            System.out.println("yonetici havalimani ekleme hatasi");
        }
    }

    public void ucakEkle(){

        try {
            statement = con.createStatement();

            System.out.println("Ucak tipi giriniz:");
            String ucakTipi = scanner.nextLine();
            System.out.println("Ucak kapasitesi giriniz:");
            int kapasite = scanner.nextInt();
            System.out.println("Uretim yili giriniz:");
            int yil = scanner.nextInt();
            String ucakEkle = "Insert Into Uçaklar (Tip, Kapasite, uretimYili) VALUES(" + "'" + ucakTipi + "'," + "'" + kapasite + "',"+ "'" + yil + "')";
            statement.executeUpdate(ucakEkle);

        } catch (SQLException e) {
            System.out.println("yonetici havalimani ekleme hatasi");
        }
    }

    public void ucusEkle(){

        try {
            statement = con.createStatement();

            System.out.println("Uçuş tarihi giriniz örn-(2022-05-10):");
            String ucusTarihi = scanner.nextLine();
            System.out.println("Ucus suresi giriniz (dakika):");
            int ucusSuresi = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Kalkis ulke/sehir giriniz:");
            String kalkisKonum = scanner.nextLine();
            System.out.println("Kalkis havalimani giriniz:");
            String kalkisHavalimani = scanner.nextLine();
            System.out.println("Varis ulke/sehir giriniz:");
            String varisKonum = scanner.nextLine();
            System.out.println("Varis havalimani giriniz:");
            String varisHavalimani = scanner.nextLine();
            System.out.println("ucak tipi giriniz:");
            String ucakTipi = scanner.nextLine();
            System.out.println("Havayolu sirketi giriniz:");
            String havayoluSirketi = scanner.nextLine();
            System.out.println("Durum giriniz (1-4 arası):");
            int durum = scanner.nextInt();
            String ucusEkle = "Insert Into uçuşlar (ucusTarihi, ucusSuresi, KalkisKonum, KalkisHavalimani, VarisKonum, VarisHavalimani, UcakTipi, HavayoluSirketi, Durum) VALUES(" + "'" + ucusTarihi + "'," + "'" + ucusSuresi + "',"+ "'" + kalkisKonum+ "',"+ "'" + kalkisHavalimani + "',"+ "'" + varisKonum + "',"+ "'" +varisHavalimani+ "',"+ "'" +ucakTipi+ "',"+ "'" +havayoluSirketi + "',"+ "'" +durum+ "')";
            statement.executeUpdate(ucusEkle);

        } catch (SQLException e) {
            System.out.println("yonetici havalimani ekleme hatasi");
        }
    }

    public void ucuslarGetir(){
        String ucusGetir = "Select * From uçuşlar";

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(ucusGetir);

            while (rs.next()){
                int ucusNo = rs.getInt("ucusNo");
                Date ucusTarihi = rs.getDate("ucusTarihi");
                int ucusSuresi = rs.getInt("ucusSuresi");
                String KalkisKonum = rs.getString("KalkisKonum");
                String KalkisHavalimani = rs.getString("KalkisHavalimani");
                String VarisKonum = rs.getString("VarisKonum");
                String VarisHavalimani = rs.getString("VarisHavalimani");
                String UcakTipi = rs.getString("UcakTipi");
                String HavayoluSirketi = rs.getString("HavayoluSirketi");
                int durum = rs.getInt("Durum");


                System.out.println("\nUcus no: "+ucusNo);
                System.out.println("Ucus Tarihi: "+ucusTarihi);
                System.out.println("Ucus Suresi: "+ucusSuresi+" dk");
                System.out.println("Kalkis konum: "+KalkisKonum);
                System.out.println("Kalkis havalimani: "+ KalkisHavalimani);
                System.out.println("Varis Konum: "+VarisKonum);
                System.out.println("Varis Havalimani: "+VarisHavalimani);
                System.out.println("Ucak Tipi: "+UcakTipi);
                System.out.println("Havayolu Sirketi: "+HavayoluSirketi);
                System.out.println("Durum: "+durum);
            }

        }catch (SQLException e){
            System.out.println("yonetici ucus listeleme hatası");
        }
    }

    public void ucaklarGetir(){
        String ucakGetir = "Select * From Uçaklar";

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(ucakGetir);

            while (rs.next()){
                String tip = rs.getString("Tip");
                int kapasite= rs.getInt("Kapasite");
                int uretimYili = rs.getInt("uretimYili");


                System.out.println("\nUcak tipi: "+tip);
                System.out.println("Kapasitesi: "+kapasite);
                System.out.println("Uretim Yili: "+uretimYili);
            }

        }catch (SQLException e){
            System.out.println("yonetici ucak listeleme hatası");
        }
    }

    public void havayoluSirketiGetir(){
        String havayoluGetir = "Select * From HavayoluSirketleri";

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(havayoluGetir);

            while(rs.next()){
                String havayoluAdi = rs.getString("HavayoluSirketiAdi");
                int id = rs.getInt("id");

                System.out.println("\nHavayolu Id: "+id);
                System.out.println("Havayolu adı: "+havayoluAdi);
            }

        }catch (SQLException e){
            System.out.println("havayolu sirketi listeleme hatası");
        }
    }

    public void havalimaniGetir() {
        String havalimaniGetir = "Select * From Havalimanları";

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(havalimaniGetir);

            while (rs.next()){
                String havalimaniAdi = rs.getString("HavalimaniAdi");
                String Ulke = rs.getString("Ulke");
                String sehir = rs.getString("Sehir");

                System.out.println("\nHavalimanı adı: "+havalimaniAdi);
                System.out.println("Ülke: "+Ulke);
                System.out.println("Şehir: "+sehir);
            }
        }catch (SQLException e){
            System.out.println("hata havalimani");
        }
    }
}