package Task1_6;

import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue;  // Jono asiakkaista
    private long totalServiceTime = 0;  // Yhteensä kulunut palveluaika

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
                customer.setServiceTime(serviceTime);  // Asetetaan asiakkaalle palveluaika
                totalServiceTime += serviceTime;  // Lisätään palveluaika kokonaispalveluaikaan

                try {
                    Thread.sleep(serviceTime);  // Simuloidaan palveluaika
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long waitingTime = customer.calculateTime();  // Lasketaan asiakkaan odotusaika

                // Tulostetaan asiakasnumero, odotusaika ja palveluaika
                System.out.println("Asiakas " + customer.getId() + " palvellaan.");
                System.out.println("Odottaminen: " + waitingTime + " ms, Palveluaika: " + serviceTime + " ms");
            }
        }
    }

    // Lasketaan keskimääräinen palveluaika
    public double calculateAverageServiceTime(int customerCount) {
        return (double) totalServiceTime / customerCount;
    }

    // Pääohjelma, joka luo asiakkaita ja palvelee ne
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();  // Luodaan palvelupiste
        CustomerGenerator generator = new CustomerGenerator(servicePoint);  // Luodaan asiakkaita palvelupisteelle

        int customerCount = 5;  // Testissä luodaan 5 asiakasta
        generator.generateCustomers(customerCount);  // Luodaan asiakkaat

        servicePoint.serve();  // Palvellaan kaikkia asiakkaita

        // Lasketaan ja tulostetaan keskimääräinen palveluaika
        double averageServiceTime = servicePoint.calculateAverageServiceTime(customerCount);
        System.out.println("Keskimääräinen palveluaika: " + averageServiceTime + " ms");
    }

    // Asiakas-luokka
    static class Customer {
        private int id;  // Asiakkaan tunniste
        private long startTime;  // Aika, jolloin asiakas tuli jonoon
        private long serviceTime;  // Asiakkaan palveluaika
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
            return System.currentTimeMillis() - startTime;  // Palautetaan odotusaika
        }

        public void setServiceTime(long serviceTime) {
            this.serviceTime = serviceTime;  // Asetetaan asiakkaan palveluaika
        }

        public long getServiceTime() {
            return serviceTime;  // Palautetaan asiakkaan palveluaika
        }
    }

    // Asiakkaiden luominen ja lisääminen palvelupisteelle
    static class CustomerGenerator {
        private ServicePoint servicePoint;  // Viittaus palvelupisteeseen

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