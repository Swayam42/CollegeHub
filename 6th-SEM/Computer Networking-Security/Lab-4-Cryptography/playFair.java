import java.util.*;

public class playFair {

    static char[][] keyMatrix(String key) {
        key = key.toUpperCase().replaceAll("J","I").replaceAll(" ","");
        StringBuilder k = new StringBuilder();
        for(char c:key.toCharArray()) if(k.indexOf(""+c)==-1) k.append(c);
        for(char c='A';c<='Z';c++) if(c!='J' && k.indexOf(""+c)==-1) k.append(c);
        char[][] m = new char[5][5]; int p=0;
        for(int i=0;i<5;i++) for(int j=0;j<5;j++) m[i][j]=k.charAt(p++);
        return m;
    }

    static String prepare(String t) {
        t=t.toUpperCase().replaceAll("J","I").replaceAll(" ","");
        StringBuilder s=new StringBuilder();
        for(int i=0;i<t.length();i++){
            s.append(t.charAt(i));
            if(i+1<t.length() && t.charAt(i)==t.charAt(i+1)) s.append('X');
        }
        if(s.length()%2!=0) s.append('X');
        return s.toString();
    }

    static int[] pos(char c, char[][] m){
        for(int i=0;i<5;i++) 
            for(int j=0;j<5;j++) 
        if(m[i][j]==c) 
            return new int[]{i,j};
        return null;
    }

    static String encrypt(String t,char[][] m){
        StringBuilder r=new StringBuilder();
        for(int i=0;i<t.length();i+=2){
            char a=t.charAt(i),b=t.charAt(i+1);
            int[] p1=pos(a,m),p2=pos(b,m);
            if(p1[0]==p2[0]){ r.append(m[p1[0]][(p1[1]+1)%5]); r.append(m[p2[0]][(p2[1]+1)%5]); }
            else if(p1[1]==p2[1]){ r.append(m[(p1[0]+1)%5][p1[1]]); r.append(m[(p2[0]+1)%5][p2[1]]); }
            else{ r.append(m[p1[0]][p2[1]]); r.append(m[p2[0]][p1[1]]); }
        }
        return r.toString();
    }

    static String decrypt(String t,char[][] m){
        StringBuilder r=new StringBuilder();
        for(int i=0;i<t.length();i+=2){
            char a=t.charAt(i),b=t.charAt(i+1);
            int[] p1=pos(a,m),p2=pos(b,m);
            if(p1[0]==p2[0]){ r.append(m[p1[0]][(p1[1]+4)%5]); r.append(m[p2[0]][(p2[1]+4)%5]); }
            else if(p1[1]==p2[1]){ r.append(m[(p1[0]+4)%5][p1[1]]); r.append(m[(p2[0]+4)%5][p2[1]]); }
            else{ r.append(m[p1[0]][p2[1]]); r.append(m[p2[0]][p1[1]]); }
        }
        return r.toString();
    }

    public static void main(String[] args){
        String key="MONARCHY",text="BALLOON";
        char[][] m = keyMatrix(key);
        String p = prepare(text);
        String c = encrypt(p,m);
        String d = decrypt(c,m);

        for(char[] r:m) System.out.println(Arrays.toString(r));
        System.out.println("Prepared: "+p);
        System.out.println("Cipher: "+c);
        System.out.println("Decrypted: "+d);
    }
}