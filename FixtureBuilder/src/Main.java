import java.util.*;

public class Main {


    public static void main(String[] args) {
         ArrayList<String> thisWeekFiks = new ArrayList<>();
         ArrayList<String> stashFiks = new ArrayList<>();
         ArrayList<Integer> randCheck = new ArrayList<>();


        Scanner src = new Scanner(System.in);

        List<String> tSet = new ArrayList<>();
        // Takımların sayısını girdiğimiz bölüm .
        int n = 0;
        try {
            System.out.print("Enter number of teams : ");
            n = src.nextInt();
        } catch (Exception e) {
            System.out.println("Please Enter of number !!!");
        }

        // Takımları girdiğimiz bölüm.
        try {

            for (int i = 0; i < n; i++) {
                System.out.print("Enter Teams : ");
                String a = src.next();
                tSet.add(a.toUpperCase());
            }

            if (n % 2 != 0) {
                tSet.add("BAY");
            }

        } catch (Exception e) {
            System.out.println("You Entered Wrong Value !!!!");
        }
        // Ekrana bastırdığımız bölüm.
        if (tSet.size() != 0) {

            System.out.println("The Teams\n");

            for (String b : tSet) {

                System.out.println(b);


            }
            System.out.println("#######################################");
        } else {
            System.out.println("Enter the number of teams to play !!!");
        }

        // Raund sistemini
    try {
        int round = 1;
        while (round <= 2 * (tSet.size() - 1)) {

            System.out.println("Round : " + round);

            for (int l = 0; l < tSet.size()/2; l++) {

                int home = (int) (Math.random() * tSet.size());
                while (randCheck.contains(home)) {
                    home = (int) (Math.random() * tSet.size());
                }

                int guest = (int) ((Math.random() * tSet.size()));
                while (guest == home || randCheck.contains(guest)) {
                    guest = (int) ((Math.random() * tSet.size()));
                }

                String fiksComb = home + "" + guest;

                while (stashFiks.contains(fiksComb)) {
                    home = (int) ((Math.random() * tSet.size()));

                    while (randCheck.contains(home)) {
                        home = (int) ((Math.random() * tSet.size()));
                    }

                    guest = (int) ((Math.random() * tSet.size()));

                    while (guest == home || randCheck.contains(guest)) {
                        guest = (int) ((Math.random() * tSet.size()));
                    }
                    fiksComb = home + "" + guest;
                }

                randCheck.add(home);
                randCheck.add(guest);
                stashFiks.add(fiksComb);
                String match = tSet.get(home) + " VS " + tSet.get(guest);
                thisWeekFiks.add(match);
            }
            // Ekrana eşleşme bastırdığımız bölüm .
            for (Object l : thisWeekFiks) {
                System.out.println(l);
            }


            System.out.println("------------------");

            randCheck.clear();
            thisWeekFiks.clear();
            round++;
        }
    }catch (Exception e ){
        System.out.println("Error Received !!!");
    }


        System.out.println("end");
    }

}


