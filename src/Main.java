import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int antallVinn = 0;
        int antallTap = 0;

        while (true) {
            System.out.print("Skriv inn din trekk (stein, papir, saks eller avslutt): ");
            String mittTrekk = scanner.nextLine().toLowerCase();
            if (mittTrekk.equals("avslutt")) {
                System.out.println("Spill avsluttet.");
                break;
            }

            if (!(mittTrekk.equals("stein") || mittTrekk.equals("papir") || mittTrekk.equals("saks"))) {
                System.out.println("Ditt trekk er ikke gyldig!");
                continue;
            }

            String[] moves = {"stein", "papir", "saks"};
            int index = (int) (Math.random() * 3);
            String datatrekk = moves[index];
            System.out.println("Datamaskinens trekk: " + datatrekk);

            if (mittTrekk.equals(datatrekk)) {
                System.out.println("Det ble likt!");

            } else if ((mittTrekk.equals("stein") && datatrekk.equals("saks")) ||
                    (mittTrekk.equals("saks") && datatrekk.equals("papir")) ||
                    (mittTrekk.equals("papir") && datatrekk.equals("stein"))) {
                System.out.println("Du vant!");
                antallVinn++;
            } else {
                System.out.println("Du tapte!");
                antallTap++;

            }

            System.out.println("Resultat: Vinn - " + antallVinn + ", Tap - " + antallTap);
        }
        // Sammendrag av resultat
        if (antallVinn > antallTap) {
            System.out.println("Gratulerer! Du vant flere runder enn du tapte!");
        } else if (antallTap > antallVinn) {
            System.out.println("Du tapte flere runder enn du vant.");
        } else {
            System.out.println("Det ble likt mellom deg og datamaskinen.");
        }

        scanner.close();
    }
}
