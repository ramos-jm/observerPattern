package SoftEng1.observerPattern;

public interface NewsAgencySubject {
    void sub(Subscriber subscriber);
    void unsub(Subscriber subscriber);
    void notifySubscribers(String news);

}
