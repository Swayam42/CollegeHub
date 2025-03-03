/*
Create a generic class Pair<K, V> with private member variables key and value. The 
class should include a parameterized constructor and provide getter and setter methods 
for these attributes. In the main class, create and add objects of the Pair class, then 
retrieve and print the key-value pairs.
*/
class Pair<K,V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public String toString() {
		return "Key : "+getKey()+" Value : "+getValue();
	}
	
	
}
public class Q1 {

	public static void main(String[] args) {
		Pair<Integer,Integer> p1=new Pair<>(1,2);
		Pair<Integer,Integer> p2=new Pair<>(2,4);
		Pair<Integer,Integer> p3=new Pair<>(3,6);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
}

}
/*
OUTPUT :
Key : 1 Value : 2
Key : 2 Value : 4
Key : 3 Value : 6
*/
