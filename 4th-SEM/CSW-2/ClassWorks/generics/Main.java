package generics;


class TestA<T>{
	T obj;
	TestA (T obj){
		this.obj=obj;
	}
	public T getObject() {
		return obj;
	}
}

public class Main {

	public static void main(String[] args) {
		TestA<Integer> integer=new TestA<>(32);

	}

}
