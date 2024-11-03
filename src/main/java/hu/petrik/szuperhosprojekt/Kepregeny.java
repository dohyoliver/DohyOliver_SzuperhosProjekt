package hu.petrik.szuperhosprojekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kepregeny {
    public static List<Szuperhos> szuperhosLista = new ArrayList<>();

    public static void szereplok(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String tipus = parts[0];
                int szorzo = Integer.parseInt(parts[1]);

                Szuperhos hos;
                if ("Batman".equalsIgnoreCase(tipus)) {
                    hos = new Batman();
                } else if ("Vasember".equalsIgnoreCase(tipus)) {
                    hos = new Vasember();
                } else {
                    continue;
                }

                for (int i = 0; i < szorzo; i++) {
                    if (hos instanceof Milliardos) {
                        ((Milliardos) hos).kutyutKeszit();
                    }
                }

                szuperhosLista.add(hos);
            }
        } catch (IOException e) {
            System.err.println("Hiba a fájl olvasásakor: " + e.getMessage());
        }
    }

    public static void szuperhosok() {
        for (Szuperhos hos : szuperhosLista) {
            System.out.println(hos);
        }
    }

    public static void main(String[] args) {
        String filePath = "szuperhosok.txt";
        szereplok(filePath);
        szuperhosok();
    }
}