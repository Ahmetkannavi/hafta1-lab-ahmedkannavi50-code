// Öğrenci No:240541603
// AD-SOYAD:ahmed kannavi

// Lütfen seçtiğiniz algoritmaya ait çözümü ve diğer isterleri aşağıya ekleyiniz:

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
     
    

        Scanner input = new Scanner(System.in);

        // 1. Kullanıcıdan gerekli verileri al
        System.out.print("Hava durumu (güzel/yağmurlu): ");
        String havaDurumu = input.nextLine();

        System.out.print("Trafik durumu (az/yoğun): ");
        String trafikDurumu = input.nextLine();

        System.out.print("Otobüs bekleme süresi (dakika): ");
        int otobusSaati = input.nextInt();

        System.out.print("Metro bekleme süresi (dakika): ");
        int metroSaati = input.nextInt();

        System.out.print("Üniversite mesafesi (birim): ");
        int universiteMesafesi = input.nextInt();

        // 2. Ulaşım seçenekleri: yürüyüş, otobüs, metro
        double yuruyusSuresi;
        double otobusSuresi;
        double metroSuresi;

        // 3. Yürüyüş süresi hesapla
        if (havaDurumu.equalsIgnoreCase("yağmurlu")) {
            yuruyusSuresi = universiteMesafesi * 15; // yağmurlu havada yavaş yürünür
        } else {
            yuruyusSuresi = universiteMesafesi * 10;
        }

        // 4. Otobüs süresi hesapla
        if (trafikDurumu.equalsIgnoreCase("yoğun")) {
            otobusSuresi = (universiteMesafesi * 5) + 15; // trafik gecikmesi
        } else {
            otobusSuresi = universiteMesafesi * 5;
        }

        // 5. Metro süresi hesapla
        metroSuresi = (universiteMesafesi * 4) + (metroSaati * 2);

        // 6. Ulaşım aracının bekleme süresini ekle
        if (otobusSaati > 10) {
            otobusSuresi += otobusSaati;
        }

        if (metroSaati > 5) {
            metroSuresi += metroSaati;
        }

        // 7. En kısa süreyi bul
        double minSure = yuruyusSuresi;
        String enKisaYol = "Yürüyüş";

        if (otobusSuresi < minSure) {
            minSure = otobusSuresi;
            enKisaYol = "Otobüs";
        }

        if (metroSuresi < minSure) {
            minSure = metroSuresi;
            enKisaYol = "Metro";
        }

        // 8. Sonucu yazdır
        System.out.println("\n--- Sonuç ---");
        System.out.println("En kısa sürede üniversiteye gitme yöntemi: " + enKisaYol);
        System.out.println("Tahmini süre: " + minSure + " dakika");

        // 9. (Opsiyonel) Otobüs beklerken zamanı simüle et
        if (enKisaYol.equals("Otobüs") && otobusSaati > 0) {
            System.out.println("\nOtobüs bekleniyor...");
            for (int i = 1; i <= otobusSaati; i++) {
                System.out.println(i + ". dakika geçti...");
            }
            System.out.println("Otobüs geldi!");
        }

        input.close();
        }
    }

