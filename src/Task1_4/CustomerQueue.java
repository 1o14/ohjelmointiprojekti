package Task1_4;

import Task1_3.Customer;

import java.util.LinkedList;
import java.util.Scanner;

public class CustomerQueue {
    private static LinkedList<Customer> queue = new LinkedList<>(); // Asiakasjono
    private static Scanner scanner = new Scanner(System.in); // Scanneri käyttäjän syötteiden lukemiseen

    public static void main(String[] args) {
        while (true) {
            // Kysytään käyttäjältä, mitä hän haluaa tehdä
            System.out.println("Valitse toiminto: ");
            System.out.println("1. Lisää asiakas jonoon");
            System.out.println("2. Poista asiakas jonosta");
            System.out.println("3. Lopeta ohjelma");
            System.out.print("Valintasi: ");
            int choice = scanner.nextInt();

            // Suoritetaan käyttäjän valinta
            if (choice == 1) {
                addCustomerToQueue(); // Lisätään asiakas jonoon
            } else if (choice == 2) {
                removeCustomerFromQueue(); // Poistetaan asiakas jonosta
            } else if (choice == 3) {
                System.out.println("Ohjelma lopetetaan.");
                break; // Lopetetaan ohjelma
            } else {
                System.out.println("Virheellinen valinta. Yritä uudelleen.");
            }
        }
    }

    // Funktio, joka lisää asiakkaan jonoon
    public static void addCustomerToQueue() {
        Customer newCustomer = new Customer(); // Luodaan uusi asiakas
        newCustomer.setStartTime(System.nanoTime()); // Asetetaan aloitusaika
        queue.addFirst(newCustomer); // Lisätään asiakas jonon alkuun (FIFO-periaate)
        System.out.println("Asiakas ID " + newCustomer.getId() + " lisätty jonoon.");
    }

    // Funktio, joka poistaa asiakkaan jonosta
    public static void removeCustomerFromQueue() {
        if (queue.isEmpty()) {
            System.out.println("Jono on tyhjä.");
        } else {
            Customer removedCustomer = queue.removeLast(); // Poistetaan asiakas jonon lopusta
            removedCustomer.setEndTime(System.nanoTime()); // Asetetaan lopetusaika
            long timeSpent = removedCustomer.calculateTimeSpent(); // Lasketaan kuinka kauan asiakas oli jonossa
            System.out.println("Asiakas ID " + removedCustomer.getId() + " poistettiin jonosta.");
            System.out.println("Asiakas oli jonossa " + timeSpent + " nanosekuntia.");
        }
    }
}
