package SoftEng1.observerPattern;
import java.util.*;
public class NewsAgency implements NewsAgencySubject {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String news;
    @Override
    public void sub(Subscriber subscriber) {
        if (!subscriberList(subscriber.getName())) {
            subscribers.add(subscriber);
        } else {
            System.out.println("\t"+ subscriber.getName() + " is already subscribed.");
        }
    }

    @Override
    public void unsub(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    private boolean subscriberList(String name) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void notifySubscribers(String news) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(news);
        }
    }
}
