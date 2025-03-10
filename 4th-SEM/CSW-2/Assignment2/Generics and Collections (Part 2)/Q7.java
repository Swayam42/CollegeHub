package Assignment_2.Part_2;
import java.util.*;
class Address{
private int plotNo;
private String at;
private String post;

public Address(int plotNo,String at,String post){
    this.plotNo=plotNo;
    this.at=at;
    this.post=post;
}

public String toString() {
    return "Plot No: " + plotNo + ", At: " + at + ", Post: " + post;
}

}
public class Q7 {

    public static void main(String[] args) {
        TreeMap<String,Address> tree=new TreeMap<>();
        tree.put("GODX", new Address(14, "Soubhagya Nagar", "Bhubaneswar"));
        tree.put("BeastBoy",new Address(43,"CDA","Cuttack"));
        Iterator<Map.Entry<String,Address>> itr=tree.entrySet().iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

    }
}
