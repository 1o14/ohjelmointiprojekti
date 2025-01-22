package Task1_5;

import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue;  // Jono asiakkaista

    public ServicePoint() {
        queue = new LinkedList<>();  // Alustetaan tyhjä jono
    }

    // Metodi, joka lisää asiakkaan jonoon
    public void addToQueue(Customer customer) {
        queue.add(customer);  // Lisätään asiakas jonon loppuun
    }

    // Metodi, joka poistaa asiakkaan jonosta ja palauttaa sen
    public Customer removeFromQueue() {
        if (!queue.isEmpty()) {
            return queue.removeFirst();  // Poistetaan asiakas jonon alusta
        }
        return null;  // Jos jono on tyhjä, palautetaan null
    }

    // Metodi, joka palvelee asiakkaita yksi kerrallaan
    public void serve() {
        while (!queue.isEmpty()) {  // Jatkaa, kun jono ei ole tyhjä
            Customer customer = removeFromQueue();  // Poistetaan seuraava asiakas
            if (customer != null) {
                long serviceTime = (long) (Math.random() * 2000) + 1000; // Satunnainen palveluaika (1–3 sekuntia)
                long waitingTime = customer.calculateTime();  // Lasketaan asiakkaan odotusaika

                try {
                    Thread.sleep(serviceTime);  // Simuloidaan palveluaika
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Tulostetaan asiakasnumero, odotusaika ja palveluaika
                System.out.println("Asiakas " + customer.getId() + " palvellaan.");
                System.out.println("Odottaminen: " + waitingTime + " ms, Palveluaika: " + serviceTime + " ms");
            }
        }
    }

    // Pääohjelma, joka luo asiakkaita ja palvelee niitä
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();  // Luodaan palvelupiste
        CustomerGenerator generator = new CustomerGenerator(servicePoint);  // Luodaan asiakkaita palvelupisteelle
        generator.generateCustomers(5);  // Luodaan 5 asiakasta

        servicePoint.serve();
    }

    // Asiakas-luokka
    static class Customer {
        private int id;  // Asiakkaan tunniste
        private long startTime;  // Aika, jolloin asiakas tuli jonoon
        private long endTime;  // Aika, jolloin asiakas poistui jonosta
        private static int idCount = 1;  // Laskuri asiakasnumeroiden luomiseksi

        public Customer() {
            id = idCount++;  // Määritetään asiakasnumero ja kasvatetaan laskuria
            startTime = System.currentTimeMillis();  // Asetetaan saapumisaika
        }

        public int getId() {
            return id;  // Palautetaan asiakkaan ID
        }

        // Lasketaan, kuinka kauan asiakas on ollut jonossa
        public long calculateTime() {
            return System.currentTimeMillis() - startTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;  // Asetetaan palvelun loppuaika
        }
    }

    // Asiakkaiden luominen ja lisääminen palvelupisteelle
    static class CustomerGenerator {
        private ServicePoint servicePoint;

        public CustomerGenerator(ServicePoint servicePoint) {
            this.servicePoint = servicePoint;  // Säilytetään palvelupiste, johon asiakkaat lisätään
        }

        // Metodi, joka luo asiakkaita ja lisää ne palvelupisteen jonoon
        public void generateCustomers(int count) {
            for (int i = 0; i < count; i++) {
                Customer customer = new Customer();  // Luodaan uusi asiakas
                servicePoint.addToQueue(customer);  // Lisätään asiakas jonoon
                try {
                    Thread.sleep(500);  // Simuloidaan asiakkaan saapumisaikaa (500 ms)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}