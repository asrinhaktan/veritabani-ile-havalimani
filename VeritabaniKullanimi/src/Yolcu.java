import javax.sound.midi.Soundbank;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Yolcu extends Baglanti{
    Yonetici y1 = new Yonetici();
    String tarihSecim;
    String kalkisHavalimani;
    String varisHavalimani;
    Scanner scanner = new Scanner(System.in);

    public void rezYap(){
        System.out.println("*-*-*-*-*-*-*Uçuş rezervasyon sistemi*-*-*-*-*-*-*");


        y1.ucuslarGetir();
        System.out.println("hangi ucusa rezervasyon yaptiracaksiniz?: (ucus no giriniz:)");
        int secim = scanner.nextInt();

        try {
            statement = con.createStatement();
            System.out.println("yolcu no giriniz:");
            int yolcuNo = scanner.nextInt();
            System.out.println("yolcu tc giriniz:");
            int yolcuTc = scanner.nextInt();
            scanner.nextLine();
            System.out.println("yolcu ad soyad giriniz");
            String adSoyad = scanner.nextLine();
            System.out.println("yolcu rezervasyon no giriniz:");
            int rezNo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("uçuş tarihi giriniz:");
            String ucusTarihi = scanner.nextLine();
            System.out.println("kalkis havalimani giriniz:");
            String havalimani = scanner.nextLine();
            System.out.println("varis havalimani giriniz:");
            String varisHavalimani = scanner.nextLine();
            System.out.println("ucus no giriniz:");
            int ucusNo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("koltuk no seciniz:(1-200):");
            int koltukNo = scanner.nextInt();
            scanner.nextLine();
            System.out.println("sinif seciniz:(Economy, Business):");
            String sinif = scanner.nextLine();
            int ucret = 0;
            if(sinif == "Economy"){
                ucret = 200;
            }else if(sinif == "Business"){
                ucret = 700;
            }
            System.out.println("durum giriniz:");
            int durum = scanner.nextInt();
            String rezYap = "Insert Into rezYap (kisiTc, yolcuAdSoyad, rezervasyonNo, ucusSaati, kalkisHavalimani, varisHavalimani, ucusNo, koltukNo, sinif, ucret, durum) VALUES(" + "'" + yolcuTc + "'," + "'" + adSoyad + "',"+ "'" + rezNo+ "',"+ "'" + ucusTarihi + "',"+ "'" + havalimani + "',"+ "'" +varisHavalimani+ "',"+ "'" +ucusNo+ "',"+ "'" +koltukNo + "',"+ "'"+ sinif + "',"+"'"+ ucret + "'," + "'" +durum+ "')";
            statement.executeUpdate(rezYap);

        }catch (SQLException e){
            System.out.println("yolcu rezervasyon hatası");
        }
    }

    public void ucuslariGoster(){
        System.out.println("*-*-*-*-*-*-*Uçuş arama sistemi*-*-*-*-*-*-*");
        System.out.print("yyyy-MM-dd formatında tarih giriniz:");
        tarihSecim = scanner.nextLine();
        System.out.println("Kalkis Havalimani giriniz:");
        kalkisHavalimani = scanner.nextLine();
        System.out.println("Varis Havalimani giriniz:");
        varisHavalimani = scanner.nextLine();

        String ucusGetir = ("Select * from uçuşlar WHERE ucusTarihi='"+tarihSecim+"' AND KalkisHavalimani='"+kalkisHavalimani+"' AND VarisHavalimani='"+varisHavalimani+"';");

        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(ucusGetir);

            if((rs.toString()).equals(tarihSecim) == true && (rs.toString()).equals(kalkisHavalimani) == true && (rs.toString()).equals(varisHavalimani) == true){
                System.out.println("ucus yok");
            }else {

            while (rs.next()){

                int ucusNo = rs.getInt("ucusNo");
                String ucusTarihi = rs.getString("ucusTarihi");
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
        }
        }catch (SQLException e){
            System.out.println("yolcu ucus listeleme hatası");
        }
    }
}
