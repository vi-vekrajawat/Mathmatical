import java.util.*;
import java.io.*;
public class Q2 {
    public static void main(String[] args) throws IOException {
        File f = new File("demo.txt");
        FileWriter fw = new FileWriter(f);
        fw.write("sdkj");
        fw.write("dkj");
        fw.close();
        FileReader fr = new FileReader(f);
        int x = fr.read();
        int y = fr.read();
        int count = 0;
        int count1 = 0;

        while(x!=-1){
            count++;
            while(y!=-1){
                if((char) x==(char) y){
                    count1++;
                    y= fr.read();
                }
                System.out.println( x +" "+ count1);

            }
            x = fr.read();
           
        }
        System.out.println(count);


    }
}
