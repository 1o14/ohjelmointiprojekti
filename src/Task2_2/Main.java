package Task2_2;
import java.util.*;

// Event-luokka, joka implementoi Comparable-rajapinnan
class Event implements Comparable<Event> {
    private String name;  // Tapahtuman nimi
    private int time;     // Tapahtuman aika

    // Konstruktorin avulla luodaan tapahtuma
    public Event(String name, int time) {
        this.name = name;
        this.time = time;
    }

    // Getteri tapahtuman nimeen
    public String getName() {
        return name;
    }

    // Getteri tapahtuman aikaan
    public int getTime() {
        return time;
    }

    // compareTo-metodi, joka vertaa tapahtumia aikojen perusteella
    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.time, other.time);  // Vertaa tapahtumien aikoja
    }

    // Tulostaa tapahtuman muotoon "Tapahtuma nimi at time aika"
    @Override
    public String toString() {
        return name + " at time " + time;
    }
}

// EventList-luokka, joka käyttää PriorityQueue:a tapahtumien säilyttämiseen aikajärjestyksessä
class EventList {
    private PriorityQueue<Event> events;  // PriorityQueue, joka pitää tapahtumat aikajärjestyksessä

    // Konstruktorissa luodaan tyhjä lista
    public EventList() {
        events = new PriorityQueue<>();  // Prioriteettijono huolehtii automaattisesti järjestyksestä
    }

    // Lisää tapahtuma listalle
    public void addEvent(Event event) {
        events.add(event);
    }

    // Poistaa ja palauttaa seuraavan tapahtuman (seuraavan käsiteltävän)
    public Event getNextEvent() {
        return events.poll();  // Poistaa ja palauttaa ensimmäisen (aikajärjestyksessä olevan) tapahtuman
    }

    // Tulostaa kaikki tapahtumat aikajärjestyksessä
    public void printEvents() {
        // Käytetään väliaikaista PriorityQueue:ta, jotta tapahtumat tulostetaan oikeassa järjestyksessä
        PriorityQueue<Event> tempQueue = new PriorityQueue<>(events);
        while (!tempQueue.isEmpty()) {
            System.out.println(tempQueue.poll());  // Poistetaan ja tulostetaan tapahtumat aikajärjestyksessä
        }
    }
}

// Pääohjelma
public class Main {
    public static void main(String[] args) {
        // Luodaan EventList-olio
        EventList eventList = new EventList();

        // Lisätään tapahtumia listalle
        eventList.addEvent(new Event("Event 1", 10));
        eventList.addEvent(new Event("Event 2", 5));
        eventList.addEvent(new Event("Event 3", 20));

        // Tulostetaan tapahtumat ennen käsittelyä
        System.out.println("Events before processing:");
        eventList.printEvents();

        // Poistetaan ensimmäinen tapahtuma ja tulostetaan se
        System.out.println("\nRemoving the first event:");
        Event nextEvent = eventList.getNextEvent();
        System.out.println("Event being processed: " + nextEvent);

        // Tulostetaan jäljelle jääneet tapahtumat
        System.out.println("\nRemaining events:");
        eventList.printEvents();
    }
}
