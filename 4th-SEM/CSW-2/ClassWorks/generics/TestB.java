package generics;

public class TestB<T,V> {
	T obj1;
	V obj2;
	TestB(T obj1,V obj2){
		this.obj1=obj1;
		this.obj2=obj2;
	}
	
	T getObj1() {
		return obj1;
	}
	V getObj2() {
		return obj2;
	}
	
	String printObjects() {
		return "obj1 : "+getObj1()+"\nobj2 : "+getObj2();
	}
	public static void main(String[] args) {
		TestB<Integer,String> ob=new TestB<>(12,"PUPUN");
		System.out.println(ob.printObjects());

	}

}
