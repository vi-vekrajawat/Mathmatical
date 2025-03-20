import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
public class Project1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArrayList<String> t = new ArrayList<>();
		ArrayList<String> l = new ArrayList<>();
		l.add("You Have To Prepare 'News' !");
		l.add("You Have To Prepare 'Thought' !");
		l.add("You Have To Prepare 'History' !");
		l.add("You Have To Prepare 'Fact' !");
		l.add("You Have To Prepare 'G.K' !");
		int i=0;
		Random r = new Random();
// Random number genrate krne ke liye!
        System.out.println("How Many Student You have");
		int student = Integer.parseInt(sc.nextLine());
		int student1 = student;
// first loop run hone ke badd dusre student ki value zero ho jati.
// jisse dusra loop nhi chl pata isliye student ko stduent 1 me store kiya .


		while(student>0){
			System.out.println("Enter "+(++i)+" Student name");
// ye loop user se input lega aur use data ko list me add karayega
			t.add(sc.nextLine());
			student--;
		}
		System.out.println();
		LocalDate today = LocalDate.now();
// ye current date ko print kranta
		String dname = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
/*TextStyle.FULL ka use din ka naam (day name) ya month ka naam poore format me dikhane ke liye hota hai.
Agar hum TextStyle.FULL use karte hain, to pura naam print hoga, jaise:
Monday*/
		System.out.println(today+" "+dname);


// second loop start
		while(student1>0){
		System.out.println();
		// ye 3 second baad sms print karata hao
		try{
		Thread.sleep(2000);
		}
		 catch(Exception e){
			System.out.println(e.getMessage());

		 }
		int rnadomIndex = r.nextInt(t.size());
		int rnadomIndex1 = r.nextInt(l.size());
		/*r.nextInt(t.size()) → Students list (t) se ek random student ka index generate karta hai.
		r.nextInt(l.size()) → Task list (l) se ek random task ka index generate karta hai.
		 */
		String s = t.get(rnadomIndex);
		String s1 = l.get(rnadomIndex1);
		/*Uper se index ko yaha pr bhejta hai hai jisse random name aur task assign ho jate hai */
		System.out.println(s);
		// y name print karega 
		// again time method use
		try{
		Thread.sleep(3000);
		}
		 catch(Exception e){
			System.out.println(e.getMessage());

		 }
		System.out.println(s1);
		// ye task print karega 
		System.out.println();
		t.remove(s);
		l.remove(s1);
		// ek baar jo nam aur task print ho jayega use ye remove method list se delete kr degi.
		// jisse again vahi name aur task print n jaye isiliye esa kiya .
		student1--;
		}
		System.out.println("Please come with Prepare your Task!");
		LocalDate tomorrow = today.plusDays(1);
		// ye ek din aage ki date print karane ka method hai 
		// task assign ek din pahele ki date ke liye krte hai isiliye aesa kiya  
		while(tomorrow.getDayOfWeek().getValue()==7){
			tomorrow = tomorrow.plusDays(1);
			// in between sunday aa jata hai use skip krne ke liye aur sunday ki aage ki date print krne ke liye ye loop ka use kiya.
		}
		String dayname = tomorrow.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

		// System.out.println("ON "+dayname);
		System.out.println("Date :- "+tomorrow+" "+dayname);
		System.out.println("Thank You!");


	}

}

