import java.util.Scanner;

public class Giris extends Yonetici{

    Yonetici y1 = new Yonetici();
    Yolcu y2 = new Yolcu();

    public void girisYap() {

        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*Uçak Yonetim ve Rezervasyon sistemi *-*-*-*-*-*-*-*-*-*-*-*-*");
        Scanner scanner = new Scanner(System.in);
        String kullAdi;
        String pw;

        System.out.println("Çıkmak için 0'a basınız!:");
        System.out.println("1-Yonetici Girisi\n2-Yolcu Girisi\n");
        System.out.print("Seçim:");

        int secim,islem,islem2,sayac=3;
        secim = scanner.nextInt();
        scanner.nextLine();

        if(secim == 0){
            System.out.println("sistemden cikiliyor...");
        } else if (secim == 2) {
            while(true){
                System.out.println("** Yolcu rezervasyon ve ucus goruntuleme **");
                System.out.println("Yapilacak islemi seciniz\n1-Ucuslari goruntuleme\n2-Rezervasyon yap\n3-Rezervasyon iptal et");
                System.out.print("\nislem:");
                islem = scanner.nextInt();
                if(islem == 1){
                    y2.ucuslariGoster();
                    System.out.println("Ucuslar listeleniyor...");
                } else if (islem == 2) {
                    y2.rezYap();
                } else if (islem == 3) {
                    //rez iptal yazılacak
                }
                System.out.println("Baska bir islem yapmak istiyor musunuz?(1-evet 2-hayır):");
                islem2 = scanner.nextInt();
                if (islem2 == 1) {
                    scanner.nextLine();
                    continue;
                } else if (islem2 == 2) {
                    System.out.println("sistemden cikiliyor...");
                    break;
                }
            }
        } else if (secim == 1) {
            System.out.println("Kullanici adi giriniz:");
            kullAdi = scanner.nextLine();
            System.out.println("Sifre giriniz:");
            pw = scanner.nextLine();

            while (sayac > 0){
                if(kullAdi.equals(getId_y())== false && pw.equals(getPw_y())==false){
                    sayac--;
                    System.out.println("hatali giris! Su kadar hakkiniz kaldi ->"+sayac);
                    System.out.println("Kullanici adi giriniz:");
                    kullAdi = scanner.nextLine();
                    System.out.println("Sifre giriniz:");
                    pw = scanner.nextLine();
                    if(sayac == 1){
                        System.out.println("hakkiniz bitti sistemden cikiliyor...");
                        break;
                    }

                }else{
                    while(true){
                        sayac = 0;
                        if(kullAdi.equals(getId_y()) && pw.equals(getPw_y())){
                            System.out.println("\nIslemler\n1-Havalimani getir\n2-Havayolu Sirketi getir\n3-Ucaklari Getir\n4-Ucuslar getir\n5-Havalimani ekle\n6-Havayolu Sirketi ekle\n7-Ucak ekle\n8-Ucus ekle");
                            System.out.println("islem giriniz:");
                            islem = scanner.nextInt();
                            if (islem == 1) {
                                System.out.println("havalimanlari listeleniyor...");
                                y1.havalimaniGetir();
                            } else if (islem == 2) {
                                System.out.println("havayolu sirketleri listeleniyor");
                                y1.havayoluSirketiGetir();
                            } else if (islem == 3) {
                                System.out.println("ucaklar listeleniyor...");
                                y1.ucaklarGetir();
                            } else if (islem == 4) {
                                System.out.println("ucuslar listeleniyor...");
                                y1.ucuslarGetir();
                            } else if (islem == 5) {
                                y1.havalimaniEkle();
                            } else if (islem == 6) {
                                y1.havayoluSirketiEkle();
                            } else if (islem == 7) {
                                y1.ucakEkle();
                            } else if (islem == 8) {
                                y1.ucusEkle();
                            }
                        }
                        System.out.println("Baska bir islem yapmak istiyor musunuz?(1-evet 2-hayır):");
                        islem2 = scanner.nextInt();
                        if (islem2 == 1) {
                            scanner.nextLine();
                            continue;
                        } else if (islem2 == 2) {
                            System.out.println("sistemden cikiliyor...");
                            break;
                        }
                    }
                }
            }
        }
    }
}


