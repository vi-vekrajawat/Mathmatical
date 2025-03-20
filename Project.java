import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import java.io.*;

public class Project {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> t = new ArrayList<>();
        ArrayList<String> l = new ArrayList<>();
        l.add("You Have To Prepare 'News' !");
        l.add("You Have To Prepare 'Thought' !");
        l.add("You Have To Prepare 'History' !");
        l.add("You Have To Prepare 'Fact' !");
        l.add("You Have To Prepare 'G.K' !");

        int i = 0;
        Random r = new Random();

        System.out.println("How Many Students You Have?");
        int student = Integer.parseInt(sc.nextLine());
        int student1 = student;

        // Pehle se removed students ko file se load karna
        HashSet<String> removedNames = loadRemovedNames();

        while (student > 0) {
            System.out.println("Enter " + (++i) + " Student name");
            String name = sc.nextLine();
            if (!removedNames.contains(name)) { // Agar ye naam pehle remove nahi hua hai to hi add kare
                t.add(name);
            }
            student--;
        }

        if (t.isEmpty()) {
            System.out.println("No students left to assign tasks!");
            return;
        }

        System.out.println();
        LocalDate today = LocalDate.now();
        String dname = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println(today + " " + dname);

        while (student1 > 0 && !t.isEmpty() && !l.isEmpty()) {
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            int randomIndex = r.nextInt(t.size());
            int randomIndex1 = r.nextInt(l.size());

            String s = t.get(randomIndex);
            String s1 = l.get(randomIndex1);

            System.out.println(s);
            try {
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(s1);
            System.out.println();

            t.remove(s);
            l.remove(s1);
            removedNames.add(s); // Removed students ko set me add karenge
            student1--;
        }

        // Removed names ko file me save karna
        saveRemovedNames(removedNames);

        System.out.println("Please come with Prepared Task!");
        LocalDate tomorrow = today.plusDays(1);
        while (tomorrow.getDayOfWeek().getValue() == 7) {
            tomorrow = tomorrow.plusDays(1);
        }
        String dayname = tomorrow.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        System.out.println("Date :- " + tomorrow + " " + dayname);
        System.out.println("Thank You!");
    }

    // File se removed names load karne ka method
    private static HashSet<String> loadRemovedNames() {
        HashSet<String> removedNames = new HashSet<>();
        File file = new File("removed_names.txt");
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    removedNames.add(line.trim());
                }
            } catch (IOException e) {
                System.out.println("Error reading removed names: " + e.getMessage());
            }
        }
        return removedNames;
    }

    // Removed names ko file me save karne ka method
    private static void saveRemovedNames(HashSet<String> removedNames) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("removed_names.txt"))) {
            for (String name : removedNames) {
                bw.write(name);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving removed names: " + e.getMessage());
        }
    }
}
