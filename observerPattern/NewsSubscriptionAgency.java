package SoftEng1.observerPattern;
import java.util.*;
public class NewsSubscriptionAgency {
    static NewsAgency newsAgency = new NewsAgency();
    static List<String> newsCategories = new ArrayList<>(Arrays.asList("Weather", "Sports", "Health"));


    // Subscribe to newsAgency.

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner service = new Scanner(System.in);
        Scanner sub = new Scanner(System.in);
        System.out.println("Welcome to Real-time News Subscription Service! \n");

        // for future enhancements to categorization of news updates.
        List<String> newsCategories = new ArrayList<>(Arrays.asList("Weather", "Sports", "Health"));
        System.out.println("Current News Categories: " + newsCategories + " \n");

        Subscriber subs1 = new Subscriber("Thomas Shelby");
        Subscriber subs2 = new Subscriber("Michael Scofield");
        Subscriber subs3 = new Subscriber("Danny DeVito");

        newsAgency.sub(subs1);
        newsAgency.sub(subs2);
        newsAgency.sub(subs3);


        // store subscriber for Preference's List.
        List<Subscriber> subsList = new ArrayList<>(Arrays.asList(subs1, subs2, subs3));

        // store the current Preference's List, which is "Sports".
        List<String> preferencesList = new ArrayList<>(List.of("Weather"));
        System.out.println("Current Subscriber Preference's List: ");
        for (Subscriber subscriber : subsList) {
            subscriber.modifyPreference(preferencesList);
        }
        System.out.println("=====================================================================================");

        // Current News agency published news
        newsAgency.notifySubscribers("[Weather] Severe storms forecasted to hit the region, prompting residents to prepare for heavy rainfall and potential flooding");

        boolean choice = true;
        while(choice) {

            System.out.println("\nList of Subscribers:");
            int i = 1;
            for(Subscriber subscriber: subsList){
                System.out.println((i)+".)"+subscriber.getName());
                i++;
            }
            System.out.print("Enter User Number: ");
            Integer userNumber = scan.nextInt();
            if (userNumber == 0) {
                choice = false;
                continue;
            }
            System.out.println();
            // Check if the userNumber is within the valid range
            if (userNumber >= 1 && userNumber <= subsList.size()) {
                // Get the Subscriber based on user input
                Subscriber selectedSubscriber = subsList.get(userNumber - 1);

                // Perform actions based on the selected Subscriber
                switch (userNumber) {
                    case 1, 2, 3, 4, 5, 6:
                        // Action for user 1
                        String name = selectedSubscriber.getName();
                        function(userNumber,name,subsList);
                        break;
                    // Add more actions as needed

                    default:
                        System.out.println("Invalid User Number");
                }
            } else {
                System.out.println("Invalid User Number");
                System.out.println();
            }

            System.out.println("\n---News Agency---");
            System.out.println("1.) Use Subscription Service");
            System.out.println("2.) Subscribe New User");
            System.out.println("3.) Exit");
            System.out.print("Which Service do you want to use: ");
            Integer services = service.nextInt();

            switch (services){

                case 1:
                    break;
                case 2:
                    System.out.print("\nEnter New Subscriber: ");
                    String newSubName = sub.nextLine();
                    Subscriber newSub = new Subscriber(newSubName);
                    newsAgency.sub(newSub);
                    subsList.add(newSub);
                    break;

                case 3:
                    System.out.println("\nExiting Program");
                    System.out.println("Goodbye Thank you for Using our Subscription Services");
                    System.out.println("\n--!!App Shutting Down!!--");
                    System.exit(0);
                    break;

                default:
            }
        }

        // Close the scanner
        scan.close();

    }

    public static void function(Integer userNumber, String name, List<Subscriber> subsList){
        Scanner input = new Scanner(System.in);
        Scanner category = new Scanner(System.in);
        System.out.println("Services Offered:");
        System.out.println("1.) Unsubscribe User");
        System.out.println("2.) Modify Preference");
        System.out.println("3.) Subscribe User");
        System.out.print("Enter Number: ");
        Integer services = input.nextInt();
        System.out.println();
        Subscriber selectedSubscriber = null;
        if (userNumber >= 1 && userNumber <= subsList.size()) {
            // Get the Subscriber based on user input
            selectedSubscriber = subsList.get(userNumber - 1);
        }
        switch (services){
            case 1:
                newsAgency.unsub(selectedSubscriber);
                System.out.println("\tUser "+name+" canceled his/her subscription");
                newsAgency.notifySubscribers("[Weather] Severe storms forecasted to hit the region, prompting residents to prepare for heavy rainfall and potential flooding");
                break;
            case 2:
                System.out.println("These are the available news category: 1.[Sports], 2.[Health]");
                System.out.print("Enter the preferred news category number: ");
                Integer cat = category.nextInt();

                if(cat == 1){
                    System.out.println();
                    newsAgency.unsub(selectedSubscriber);
                    System.out.println("\t"+name+" received breaking news: [Sports] In a thrilling match, the underdog team secures a surprising victory, shaking up the standings in the league.");
                    newsAgency.notifySubscribers("[Weather] Severe storms forecasted to hit the region, prompting residents to prepare for heavy rainfall and potential flooding");
                    newsAgency.sub(selectedSubscriber);

                }
                else if(cat == 2){
                    System.out.println();
                    newsAgency.unsub(selectedSubscriber);
                    System.out.println("\t"+name+" received breaking news: [Health] Breakthrough study reveals a promising new treatment for a rare genetic disorder, offering hope for affected patients.");
                    newsAgency.notifySubscribers("[Weather] Severe storms forecasted to hit the region, prompting residents to prepare for heavy rainfall and potential flooding");
                    newsAgency.sub(selectedSubscriber);
                }
                else{
                    System.out.println("Invalid Number");
                }
                break;
            case 3:
                newsAgency.sub(selectedSubscriber);
                newsAgency.notifySubscribers("[Weather] Severe storms forecasted to hit the region, prompting residents to prepare for heavy rainfall and potential flooding");

                break;
            default:
                System.out.println("\nInvalid Number");
        }
    }
}




