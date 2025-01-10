import java.util.*;

public class EventPlanner {
    // HashMap to store events by date
    private Map<String, List<Event>> events;

    // Constructor
    public EventPlanner() {
        events = new HashMap<>();
    }

    // Add an event
    public void addEvent(String date, String eventName, String details) {
        events.putIfAbsent(date, new ArrayList<>());
        events.get(date).add(new Event(eventName, details));
        System.out.println("Event '" + eventName + "' added on " + date + ".");
    }

    // Update an event
    public void updateEvent(String date, String oldEventName, String newEventName, String newDetails) {
        if (events.containsKey(date)) {
            for (Event event : events.get(date)) {
                if (event.getName().equals(oldEventName)) {
                    if (newEventName != null) {
                        event.setName(newEventName);
                    }
                    if (newDetails != null) {
                        event.setDetails(newDetails);
                    }
                    System.out.println("Event '" + oldEventName + "' updated on " + date + ".");
                    return;
                }
            }
            System.out.println("No event named '" + oldEventName + "' found on " + date + ".");
        } else {
            System.out.println("No events found on " + date + ".");
        }
    }

    // Delete an event
    public void deleteEvent(String date, String eventName) {
        if (events.containsKey(date)) {
            List<Event> eventList = events.get(date);
            eventList.removeIf(event -> event.getName().equals(eventName));
            if (eventList.isEmpty()) {
                events.remove(date);
            }
            System.out.println("Event '" + eventName + "' deleted from " + date + ".");
        } else {
            System.out.println("No events found on " + date + ".");
        }
    }

    // View events by date
    public void viewEventsByDate(String date) {
        if (events.containsKey(date)) {
            System.out.println("Events on " + date + ":");
            for (Event event : events.get(date)) {
                System.out.println("- " + event.getName() + ": " + event.getDetails());
            }
        } else {
            System.out.println("No events found on " + date + ".");
        }
    }

    // List all events
    public void listAllEvents() {
        if (!events.isEmpty()) {
            System.out.println("All events:");
            for (String date : events.keySet()) {
                System.out.println("Date: " + date);
                for (Event event : events.get(date)) {
                    System.out.println("  - " + event.getName() + ": " + event.getDetails());
                }
            }
        } else {
            System.out.println("No events in the planner.");
        }
    }

    // Event class to hold individual event details
    private static class Event {
        private String name;
        private String details;

        public Event(String name, String details) {
            this.name = name;
            this.details = details;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        EventPlanner planner = new EventPlanner();

        // Add events
        planner.addEvent("Add Event");
        planner.addEvent("View Event");
        planner.addEvent("Delete Event");
        planner.addEvent("View All Event");
        planner.addEvent("Exit");

        // View events by date
        planner.viewEventsByDate("2025-01-10");

        // Update an event
        planner.updateEvent("", "", null, "");

        // Delete an event
        planner.deleteEvent("", "");

        // List all events
        planner.listAllEvents();
    }
}
