package com.pepijnvdsteen;

import java.util.ArrayList;
import java.util.Scanner;

class Kratten {
    static int maxKratten = 0;
    protected static ArrayList<Kratten> kratjes = new ArrayList<>();
    String typeKrat;
    int aantal;

    public Kratten(String typeKrat, int aantal) {
        this.typeKrat = typeKrat;
        this.aantal = aantal;
    }

    public static void voegKratToe(String typeKrat, int aantal) {
        Kratten krat = new Kratten(typeKrat, aantal);
        kratjes.add(krat);
    }
}

class Tellen extends Kratten {
    public Tellen(String typeKrat, int aantal) {
        super(typeKrat, aantal);
    }

    public static int verschilAantal(int aantal) {
        if (maxKratten - aantal > 0) {
            return maxKratten - aantal;
        }
        return -1;
    }
}

class Hoeveelheid extends Kratten {
    public Hoeveelheid(String typeKrat, int aantal) {
        super(typeKrat, aantal);
    }

    public static void hoeveelheidAanpassen(String typeKrat, int aantal){
        voegKratToe(typeKrat, aantal);
        for (Kratten i : kratjes) {
            if (kratjes.contains(typeKrat)) {
                kratjes.remove(i);
            }
        }
    }
}

class Tekst {
    public static void print () {
        System.out.println("||======================================||");
        System.out.println("||            Welkom bij Krat!          ||");
        System.out.println("||    Typ het getal van je optie in     ||");
        System.out.println("||======================================||");
        System.out.println("||          1. Kratten tellen           ||");
        System.out.println("||   2. Kratten hoeveelheid aanpassen   ||");
        System.out.println("||     3. Nieuwe kratten toevoegen      ||");
        System.out.println("|| Elk ander getal sluit het programma! ||");
        System.out.println("||======================================||");
    }
}

class Vragen {
    public static void initieleVragen() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Tekst.print();

            int keuze = scanner.nextInt();

            if (keuze == 1) {
                System.out.println("Hoeveel kratten zijn er momenteel?");
                int hoeveelheid = scanner.nextInt();

                System.out.println("Hoeveel kratten zijn er maximaal?");
                int maximaal = scanner.nextInt();

                Kratten.maxKratten = maximaal;
                System.out.println("Je moet " + Tellen.verschilAantal(hoeveelheid) + " krat(ten) bestellen");

            } else if (keuze == 2) {
                scanner.nextLine();

                System.out.println("Welke krat wil je aanpassen?");
                String welkeKrat = scanner.nextLine();

                System.out.println("Hoeveel kratten wil je maximaal hebben?");
                int hoeveelheid = scanner.nextInt();

                Hoeveelheid.hoeveelheidAanpassen(welkeKrat, hoeveelheid);

                System.out.println(welkeKrat + " is aangepast tot " + hoeveelheid + " kratten als maximum!");

            } else if (keuze == 3) {
                System.out.println("Wat voor drankje zit in de nieuwe krat?");
                scanner.nextLine();
                String welkeKrat = scanner.nextLine();

                System.out.println("Hoeveel kratten wil je maximaal hebben?");
                int hoeveelheid = scanner.nextInt();

                Kratten.voegKratToe(welkeKrat, hoeveelheid);

                System.out.println(welkeKrat + " is toegevoegd met " + hoeveelheid + " kratten als maximum!");
            }
            else { break; }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Vragen.initieleVragen();
    }
}
