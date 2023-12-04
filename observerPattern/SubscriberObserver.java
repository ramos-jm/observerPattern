package SoftEng1.observerPattern;

import java.util.List;

public interface SubscriberObserver {
    void update(String news);

    void modifyPreference(List<String> preferences);
}
