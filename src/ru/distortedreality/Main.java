package ru.distortedreality;

import javax.swing.*;
import java.util.Random;

/**
 * Created by Lenovo on 24.02.2017.
 */
public class Main {

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.print("Введите слово: ");
//        String a = in.nextLine();
//        System.out.println("Слово: " + a);

        double[] phoenix = new double [5];
        phoenix[0] = 5; // strenght
        phoenix[1] = 5; // dextery
        phoenix[2] = 5; // protection
        phoenix[3] = 5; // snaiper
        phoenix[4] = 20; // health

        double[] ksana = new double [5];
        ksana[0] = 5; // strenght
        ksana[1] = 5; // dextery
        ksana[2] = 5; // protection
        ksana[3] = 5; // snaiper
        ksana[4] = 20; // health

        int round = 1;

        final Random random = new Random();

        while ((phoenix[4] > 0) && (ksana[4] > 0)) {
            System.out.println("\nРаунд: " + round);

            double uvorotPhoen = 1 - ksana[3]/(ksana[3] + phoenix[1]);
            double uvorotKsana = 1 - phoenix[3]/(phoenix[3] + ksana[1]);

            if (random.nextFloat() > uvorotPhoen) {
                double uronKsana = ksana[0]*ksana[0]/(ksana[0]+phoenix[2]);
                phoenix[4] = phoenix[4] - uronKsana;
                System.out.println("Ксана ударила Феникса на " + uronKsana + " урона");
            } else {
                System.out.println("Феникс увернулся");
            }

            if (random.nextFloat() > uvorotKsana) {
                double uronPhoen = phoenix[0]*phoenix[0]/(phoenix[0]+ksana[2]);
                ksana[4] = ksana[4] - uronPhoen;
                System.out.println("Феникс ударил Ксану на " + uronPhoen + " урона");
            } else {
                System.out.println("Ксана увернулась");
            }

            round++;
        }

        if (phoenix[4] <= 0) {
            System.out.println("Феникс побежден! Его ХП: " + phoenix[4]);
        }

        if (ksana[4] <= 0) {
            System.out.println("Ксана побеждена! Её ХП: " + ksana[4]);
        }

    }
}
