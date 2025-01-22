package Task1_3;

public class Customer {
    private int id; // Asiakkaan ID
    private long startTime; // Palvelun aloitusaika
    private long endTime; // Palvelun lopetusaika
    private static int idCount = 1; // Seuraava käytettävä ID

    // Rakentaja, joka asettaa asiakastunnuksen ja kasvattaa ID-laskuria
    public Customer() {
        id = idCount++; // Asetetaan asiakkaalle ID ja kasvatetaan laskuria
    }

    // Getter ja setter ID:lle
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) { // Tarkistetaan, että ID on positiivinen
            this.id = id;
        } else {
            System.out.println("ID:n pitää olla suurempi kuin 0.");
        }
    }

    // Getter ja setter aloitusajalle
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime; // Asetetaan aloitusaika
    }

    // Getter ja setter lopetusajalle
    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime; // Asetetaan lopetusaika
    }

    // Lasketaan kuinka kauan asiakas on ollut palvelussa
    public long calculateTimeSpent() {
        return endTime - startTime; // Palautetaan aika, joka on kulunut
    }

    public static void main(String[] args) {
        // Luodaan uusi asiakas ja asetetaan palvelun aloitus ja lopetusajat
        Customer customer1 = new Customer();
        customer1.setStartTime(System.nanoTime()); // Asetetaan aloitusaika
        try {
            Thread.sleep(100); // Simuloidaan, että asiakas on odottanut 100 millisekuntia
        } catch (InterruptedException e) {
            e.printStackTrace(); // Jos tulee virhe, tulostetaan virhe
        }
        customer1.setEndTime(System.nanoTime()); // Asetetaan lopetusaika

        // Tulostetaan asiakkaan ID, odotusaika ja palveluaika
        System.out.println("Asiakas ID: " + customer1.getId());
        System.out.println("Vietetty aika (nanosekuntia): " + customer1.calculateTimeSpent());
    }
}
