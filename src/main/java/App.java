import java.io.Console;
import java.util.*;

public class App {

  public static boolean isInteger( String input )  {
    try {
      Integer.parseInt( input );
      return true;
    }
    catch( Exception e) {
      return false;
    }
  }

  public static void printReceipt (Event myEvent) {
    int numberOfGuests = myEvent.getNumberOfGuests();
    Map<String,Integer> theseDrinks = myEvent.getDrinks();
    Map<String,Integer> thisFood = myEvent.getFood();
    Map<String,Integer> theseEntertainments = myEvent.getEntertainment();

    System.out.println("==============================");
    System.out.println("Your event:");

    System.out.println("Number of guests: " + numberOfGuests);
    System.out.println("FOOD:");
    for (String food : thisFood.keySet()) {
      System.out.println('\t' + food + ":" + " $" + thisFood.get(food) + " per person");
    }
    System.out.println("DRINK:");
    for (String drink : theseDrinks.keySet()) {
      System.out.println('\t' + drink + ":" + " $" + theseDrinks.get(drink) + " per person");
    }
    System.out.println("ENTERTAINMENT:");
    if (theseEntertainments.isEmpty()) {
      System.out.println("\tNone. Boring.");
    } else {
      for (String entertainment : theseEntertainments.keySet()) {
        System.out.println('\t' + entertainment + ":" + " $" + theseEntertainments.get(entertainment));
      }
    }
    System.out.println("\nYOUR TOTAL: $" + myEvent.totalEvent());
  }

  public static void main(String[] args) {

    Map<String, Integer> baseFood = new HashMap();
    Map<String, Integer> baseDrinks = new HashMap();
    Map<String, Integer> baseEntertainment = new HashMap();
    Map<String, Integer> baseCoupons = new HashMap();

    Console myConsole = System.console();

    int intNumberOfGuests = 0;
    boolean inGuests = true;

    System.out.println ("Welcome to Evening Event Master.");
    System.out.println ("I'll come up with a quote based on your preferences for an event.");

    while (inGuests) {


      System.out.println ("How many guests do you have?");

      String numberOfGuests = myConsole.readLine();


      if (isInteger(numberOfGuests)) {
        intNumberOfGuests = Integer.parseInt(numberOfGuests);
        inGuests = false;
      } else {
        System.out.println("==============================");
        System.out.println("You must enter only an integer:");
      }

    };

    System.out.println("==============================");


    Event myEvent = new Event (intNumberOfGuests, baseFood, baseDrinks, baseEntertainment, baseCoupons);

    boolean inFood = true;
    String userFood = "";
    while (inFood) {
      System.out.println ("What food choices would you like?");
      System.out.println ("Enter 'light snack', 'dinner', or 'both':");
      userFood = myConsole.readLine();
      if (userFood.equals("light snack")) {myEvent.getFood().put("light snack", 9); inFood = false;}
      else if (userFood.equals("dinner")) {myEvent.getFood().put("dinner", 15); inFood = false;}
      else if (userFood.equals("both")) {myEvent.getFood().put("both", 20); inFood = false;}
      else {System.out.println("=============================="); System.out.println("You only have three choices:");}
    }

    System.out.println("==============================");
    System.out.println ("Great choice: " + userFood + ".");

    boolean inDrinks = true;
    String userDrinks = "";
    while (inDrinks) {
      System.out.println ("What beverage service would you like?");
      System.out.println ("Enter 'non-alcoholic' or 'full bar':");
      userDrinks = myConsole.readLine();
      if (userDrinks.equals("non-alcoholic")) {myEvent.getDrinks().put("non-alcoholic", 7); inDrinks = false;}
      else if (userDrinks.equals("full bar")) {myEvent.getDrinks().put("full bar", 20); inDrinks = false;}
      else {System.out.println("=============================="); System.out.println("You only have two choices:");}
    }

    System.out.println("==============================");
    System.out.println ("Great choice: " + userDrinks + ".");

    boolean inEntertainment = true;
    String userEntertainments = "";
    while (inEntertainment) {
      System.out.println ("What entertainment would you like to choose from?");
      System.out.println ("Enter 'none' (or Enter), 'all', 'balloons', 'live band' or 'DJ'.");
      System.out.println ("You can also enter several of these divertissements seperated by commas.");
      System.out.println ("   EXAMPLE: 'live band, DJ'");
      userEntertainments = myConsole.readLine();

      if (userEntertainments == "") {
        System.out.println ("You've selected no entertainment. Boring.");
        System.out.println ("===============================");
      } else {
        String [] arrUserEntertainments = userEntertainments.split(",");
        for (String s : arrUserEntertainments) {
          String sTrimmed = s.trim();

          switch (sTrimmed.toLowerCase()) {
            case "all":
              myEvent.getEntertainment().put("ballons", 250);
              myEvent.getEntertainment().put("live band", 700);
              myEvent.getEntertainment().put("dj", 400);
              break;
            case "balloons":
              myEvent.getEntertainment().put("ballons", 250);
              break;
            case "live band":
              myEvent.getEntertainment().put("live band", 700);
              break;
            case "dj":
              myEvent.getEntertainment().put("dj", 400);
              break;
            default:
              System.out.println ("Don't recognize " + sTrimmed + ". Moving on as if nothing happened.");
          }

        };

      }

      inEntertainment = false;
    }

    printReceipt(myEvent);

    // System.out.println("==============================");
    //
    // System.out.println("Your event:");
    //
    // System.out.println("Number of guests: " + numberOfGuests);
    // System.out.println("FOOD:");
    // for (String food : thisFood.keySet()) {
    //   System.out.println('\t' + food + ":" + " $" + thisFood.get(food) + " per person");
    // }
    // System.out.println("DRINK:");
    // for (String drink : theseDrinks.keySet()) {
    //   System.out.println('\t' + drink + ":" + " $" + theseDrinks.get(drink) + " per person");
    // }
    // System.out.println("ENTERTAINMENT:");
    // if (theseEntertainments.isEmpty()) {
    //   System.out.println("\tNone. Boring.");
    // } else {
    //   for (String entertainment : theseEntertainments.keySet()) {
    //     System.out.println('\t' + entertainment + ":" + " $" + theseEntertainments.get(entertainment));
    //   }
    // }
    //
    //
    // System.out.println("\nYOUR TOTAL: $" + myEvent.totalEvent());

    System.out.println("==============================");
    System.out.println("Any coupons to redeem (only one per event)?");
    System.out.println("Press ENTER for none or, for purposes of this command line app,");
    System.out.println("ENTER 'abcde' (free DJ with 150+ guests,dinner and full bar;");
    System.out.println(" or 'fghij' ($50 discount)");

    String userCoupon = myConsole.readLine();

    if (myEvent.processCoupon(userCoupon)) {
      if (userCoupon.equals("abcde")) {
        System.out.println("Your DJ is free!");
      } else {
        System.out.println("$50 off your event!");
      }
      printReceipt(myEvent);
    } else {
      if (userCoupon.equals("abcde")) {
        System.out.println ("Sorry, you did not meet the stated requirements for this coupon.");
      } else {
        System.out.println ("Sorry, don't recognize this code.");
      }
      System.out.println ("You have your quote above.");

    }


  }


}
