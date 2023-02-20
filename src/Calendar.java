import java.util.*;

public class Calendar {
    private Map<Integer, List<String>> events;

    public Calendar() {
        events = new HashMap<>();
    }

    public void addEvent(int day, String event) {
        if (day <= 0 || day >= 31) {
            throw new IllegalArgumentException("The day must be between 0 and 31");
        }

        if (!events.containsKey(day)) {
            events.put(day, new ArrayList<>());
        }
        events.get(day).add(event);
    }

    public void removeEvent(int day, int numberEvent) {
        if (!events.containsKey(day)) {
            throw new IllegalArgumentException("The day " + day + "in calendar is empty");
        }
        events.get(day).remove(numberEvent);
    }

    public List<String> getEvents(int day) {
        if (day <= 0 || day >= 31) {
            throw new IllegalArgumentException("The day must be between 0 and 31");
        }
        if (!events.containsKey(day)) {
            return Collections.emptyList();
        }
        return events.get(day);
    }

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static Calendar calendar = new Calendar();

    public static void main(String[] args) {


        int options;
        do {
            System.out.println("---------------------Calendar System--------------------------");
            System.out.println();
            System.out.println("1 -> Add a new e event to the calendar");
            System.out.println("2 -> Remove events of the calendar");
            System.out.println("3 -> Check events on the day");


            options = scanner.nextInt();
            switch (options) {
                case 1:
                    AddEvents();
                    break;
                case 2:
                    removeEvents();
                    break;
                case 3:
                    getEvents();
                    ;
                    break;
            }
        } while (options >= 1 && options <= 2);
    }

    private static void AddEvents() {
        System.out.println("Write the day you want to add an event :");
        int scanner1 = scanner.nextInt();
        int day = scanner1;
        scanner.nextLine();
        System.out.println("Write the event you want to add to day  " + day + " : ");
        String scanner2 = scanner.nextLine();
        String event = scanner2;
        calendar.addEvent(day, event);
    }

    private static void getEvents() {
        System.out.println("Write the day you to verify the events :");
        int day = scanner.nextInt();
        List<String> events = calendar.getEvents(day);
        System.out.println("Events on the day " + day + ": ");
        int index = 0;
        for (String event : events) {
            System.out.println(index + 1 + " : " + events.get(index));
            index++;
        }

    }

    private static void removeEvents() {
        System.out.println("Write the day you want to remove an event : ");
        int day = scanner.nextInt();
        List<String> events = calendar.getEvents(day);
        System.out.println("Events on the day " + day);
        int index = 0;
        for (String event : events) {
            System.out.println(index + 1 + " : " + events.get(index));
            index++;

        }
        System.out.println("Write the number of the event you want to remove");
        int numberEvent = scanner.nextInt();
        System.out.println("The Event Removed : " + events.get(numberEvent));
        calendar.removeEvent(day, numberEvent - 1);


    }

}