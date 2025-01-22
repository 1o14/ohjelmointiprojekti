package Task2_4;

import java.util.PriorityQueue;

// Enum määrittelee eri tapahtumat
enum EventType {
    ARRIVAL, EXIT
}

// Asiakastyypit: X ja Y
enum ClientType {
    X, Y
}

// Event-luokka, joka pitää sisällään tapahtumat ja niiden aikaleimat
class Event implements Comparable<Event> {
    private EventType eventType;
    private double eventTime;
    private ClientType clientType;

    public Event(EventType eventType, double eventTime, ClientType clientType) {
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.clientType = clientType;
    }

    public EventType getEventType() {
        return eventType;
    }

    public double getEventTime() {
        return eventTime;
    }

    public ClientType getClientType() {
        return clientType;
    }

    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }

    @Override
    public String toString() {
        return "Event Type: " + eventType + ", Event Time: " + eventTime + ", Client Type: " + clientType;
    }
}

// EventList-luokka, joka hoitaa tapahtumien listan ja järjestyksen
class EventList {
    private PriorityQueue<Event> events;

    public EventList() {
        events = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event removeEvent() {
        return events.poll();
    }

    public void printEvents() {
        for (Event event : events) {
            System.out.println(event);
        }
    }
}

// Simulaation päätoteutus
public class Main {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Luodaan ja lisätään tapahtumia
        eventList.addEvent(new Event(EventType.ARRIVAL, 1.0, ClientType.X));  // Asiakas tyyppi X saapuu
        eventList.addEvent(new Event(EventType.EXIT, 2.0, ClientType.Y));     // Asiakas tyyppi Y poistuu
        eventList.addEvent(new Event(EventType.ARRIVAL, 0.5, ClientType.Y));  // Asiakas tyyppi Y saapuu
        eventList.addEvent(new Event(EventType.ARRIVAL, 1.5, ClientType.X));  // Toinen asiakas tyyppi X saapuu

        // Tulostetaan tapahtumat järjestyksessä
        System.out.println("Event List:");
        eventList.printEvents();

        // Poistetaan seuraava tapahtuma ja tulostetaan se
        Event nextEvent = eventList.removeEvent();
        System.out.println("\nNext event to be processed: " + nextEvent);

        // Jatketaan simulaatiota, kunnes asiakas tyyppi Y poistuu
        while (nextEvent != null && nextEvent.getClientType() != ClientType.Y) {
            nextEvent = eventList.removeEvent();
            System.out.println("\nNext event to be processed: " + nextEvent);
        }

        System.out.println("\nSimulation ended. A client of type Y has exited the system.");
    }
}
