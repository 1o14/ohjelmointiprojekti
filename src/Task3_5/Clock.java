package Task3_5;

public class Clock {
    private static Clock instance; // Vain yksi kellon instanssi saa olla
    private int time; // Aikamuuttuja kellon ajan tallentamiseen

    // Yksityinen konstruktori, ettei tätä voi luoda suoraan
    private Clock() {
        time = 0; // Aluksi aika on nolla
    }

    // Julkinen metodi, joka palauttaa kellon instanssin
    public static Clock getInstance() {
        if (instance == null) { // Jos instanssia ei ole vielä luotu
            instance = new Clock(); // Luodaan uusi instanssi
        }
        return instance; // Palautetaan aina sama instanssi
    }

    // Ajan asettaminen
    public void setTime(int newTime) {
        time = newTime; // Asetetaan aika
    }

    // Nykyajan hakeminen
    public int getTime() {
        return time; // Palautetaan nykyinen aika
    }

    // Testataan kellon toimintaa pääohjelmassa
    public static void main(String[] args) {
        // Haetaan kello-instanssi
        Clock clock = Clock.getInstance();

        // Asetetaan aika 10 ja tulostetaan se
        clock.setTime(10);
        System.out.println("Current time: " + clock.getTime());

        // Vaihdetaan aika 20:ksi ja tulostetaan se
        clock.setTime(20);
        System.out.println("Updated time: " + clock.getTime());

        // Varmistetaan, että sama instanssi toimii
        Clock anotherClock = Clock.getInstance();
        System.out.println("Time from another reference: " + anotherClock.getTime());
    }
}
