import java.util.Scanner;

public class main {
    private static Scanner in;
    public static void main(String[] args){
        in = new Scanner(System.in);
        System.out.println("Nama  : Prasetyo");
        System.out.println("Kelas : TI 20 C 1");
        System.out.println("NIM   : 312010126");
        System.out.println("UAS - Kriptografi Semester Gasal 2022/2023");
        System.out.println("");

        System.out.print("1. Enkript\n2. Deskript\nPilih(1,2): ");
        int choice = in.nextInt();
        in.nextLine();

        if(choice == 1){
            System.out.println("---Enkript---");
            cipherEncryption();
        } else if (choice == 2){
            System.out.println("---Deskript---");
            cipherDecryption();
        } else {
            System.out.println("Pilihan yang anda masukkan salah");
        }
    }

    private static void cipherDecryption() {
        System.out.print("Masukan Pesan: ");
        String msg = in.nextLine();

        System.out.print("Masukkan kunci: ");
        String key = in.nextLine();

        String hexToDeci = "";
        for (int i = 0; i < msg.length()-1; i+=2) {
            
            String output = msg.substring(i, (i+2));
            int decimal = Integer.parseInt(output, 16);
            hexToDeci += (char)decimal;
        }

        // deskript
        String decrypText = "";
        int keyItr = 0;
        for (int i = 0; i < hexToDeci.length(); i++) {
            // Operasi XOR
            int temp = hexToDeci.charAt(i) ^ key.charAt(keyItr);

            decrypText += (char)temp;
            keyItr++;
            if(keyItr >= key.length()){
                
                keyItr = 0;
            }

        }

        System.out.println("Pesan terdeskript: " + decrypText);
    }

    private static void cipherEncryption() {
        System.out.print("Masukan Pesan: ");
        String msg = in.nextLine();

        System.out.print("Masukan Kunci: ");
        String key = in.nextLine();

        String encrypHexa = "";
        int keyItr = 0;
        for (int i = 0; i < msg.length(); i++) {
            // Opersi XOR
            int temp = msg.charAt(i) ^ key.charAt(keyItr);

            encrypHexa += String.format("%02x", (byte)temp);
            keyItr++;
            if(keyItr >= key.length()){
                
                keyItr = 0;
            }

        }

        System.out.println("Pesan terenkript: " + encrypHexa);
    }
}
