package Task2_3;

import java.util.PriorityQueue;

// Enum määrittelee tapahtumatyypit
enum EventType {
    ARRIVAL, EXIT
}

// Tapahtuma-luokka
class Event implements Comparable<Event> {
    private String name;
    private int time;
    private EventType type;

    // Konstruktori
    public Event(String name, int time, EventType type) {
        this.name = name;
        this.time = time;
        this.type = type;
    }

    // Getterit
    public int getTime() {
        return time;
    }

    // Vertailu tapahtuma-ajan perusteella
    @Override
    public int compareTo(Event other) {
        return Integer.compare(this.time, other.time);
    }

    // Muotoilu tulostusta varten
    @Override
    public String toString() {
        return name + " at time " + time + ", type " + type;
    }
}

// Tapahtumalistaluokka
class EventList {
    private PriorityQueue<Event> events;

    // Konstruktori
    public EventList() {
        events = new PriorityQueue<>();
    }

    // Lisää tapahtuma listalle
    public void addEvent(Event event) {
        events.add(event);
    }

    // Hakee ja poistaa seuraavan tapahtuman
    public Event getNextEvent() {
        return events.poll();
    }

    // Tulostaa kaikki tapahtumat järjestyksessä
    public void printEvents() {
        PriorityQueue<Event> copy = new PriorityQueue<>(events);
        while (!copy.isEmpty()) {
            System.out.println(copy.poll());
        }
    }
}

// Main-luokka
public class Main {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Lisätään tapahtumat
        eventList.addEvent(new Event("Arrival of person A", 10, EventType.ARRIVAL));
        eventList.addEvent(new Event("Exit of person B", 5, EventType.EXIT));
        eventList.addEvent(new Event("Arrival of person C", 20, EventType.ARRIVAL));

        // Tulostetaan tapahtumat ennen käsittelyä
        System.out.println("Events before processing:");
        eventList.printEvents();

        // Poistetaan ja käsitellään ensimmäinen tapahtuma
        System.out.println("\nRemoving the first event:");
        Event nextEvent = eventList.getNextEvent();
        System.out.println("Event being processed: " + nextEvent);

        // Tulostetaan jäljellä olevat tapahtumat
        System.out.println("\nRemaining events:");
        eventList.printEvents();
    }
}
