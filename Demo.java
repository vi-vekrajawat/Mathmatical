import java.util.*;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;
class Demo{
public static void main(String[] args){
    Predicate<String> str = (s->{
        String string =" ";
        for(int i = s.length()-1;i>=0;i--){
            string  = string+s.charAt(i);
        }
        if(string.trim().equals(s.trim())){
            System.out.println("Pailndrome");
        }
        else{
        System.out.println("Not pailndrome");
        }
        return true;
    });
    str.test("etehf");
}
}