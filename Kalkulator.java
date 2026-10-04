package kalkulator;

import java.util.Scanner;

/**
 * Program Kalkulator Terminal / Konsol di Java.
 
 */
public class Kalkulator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;

        System.out.println("");
        System.out.println("");
        System.out.println("");

        while (lanjut) {
            System.out.println("\n--- MENU OPERASI ---");
            System.out.println("1. Penjumlahan (+)");
            System.out.println("2. Pengurangan (-)");
            System.out.println("3. Perkalian (*)");
            System.out.println("4. Pembagian (/)");
            System.out.println("5. Keluar Program");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("[Error] Input tidak valid! Harap masukkan angka 1-5.");
                continue;
            }

            // Opsi keluar dari program
            if (pilihan == 5) {
                System.out.println("\nTerima kasih telah menggunakan program kalkulator!");
                lanjut = false;
                break;
            }

            // Validasi menu
            if (pilihan < 1 || pilihan > 5) {
                System.out.println("[Error] Pilihan menu tidak tersedia. Coba lagi.");
                continue;
            }

            double angka1 = bacaInputAngka(scanner, "Masukkan angka pertama : ");
            double angka2 = bacaInputAngka(scanner, "Masukkan angka kedua   : ");
            double hasil = 0;

            switch (pilihan) {
                case 1:
                    hasil = tambah(angka1, angka2);
                    System.out.printf("\n>>> Hasil Penjumlahan: %.2f + %.2f = %.2f\n", angka1, angka2, hasil);
                    break;
                case 2:
                    hasil = kurang(angka1, angka2);
                    System.out.printf("\n>>> Hasil Pengurangan: %.2f - %.2f = %.2f\n", angka1, angka2, hasil);
                    break;
                case 3:
                    hasil = kali(angka1, angka2);
                    System.out.printf("\n>>> Hasil Perkalian: %.2f * %.2f = %.2f\n", angka1, angka2, hasil);
                    break;
                case 4:
                    // Penanganan error pembagian dengan nol
                    if (angka2 == 0) {
                        System.out.println("\n[Error] Pembagian dengan angka 0 tidak diperbolehkan!");
                    } else {
                        hasil = bagi(angka1, angka2);
                        System.out.printf("\n>>> Hasil Pembagian: %.2f / %.2f = %.2f\n", angka1, angka2, hasil);
                    }
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Helper method untuk memastikan input dari terminal berupa angka valid.
     */
    private static double bacaInputAngka(Scanner scanner, String pesanPrompt) {
        while (true) {
            System.out.print(pesanPrompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input salah, harap masukkan angka valid (contoh: 12 atau 4.5).");
            }
        }
    }

    // Fungsi Penjumlahan
    public static double tambah(double a, double b) {
        return a + b;
    }

    // Fungsi Pengurangan
    public static double kurang(double a, double b) {
        return a - b;
    }

    // Fungsi Perkalian
    public static double kali(double a, double b) {
        return a * b;
    }

    // Fungsi Pembagian
    public static double bagi(double a, double b) {
        return a / b;
    }
}