package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("둘리");
		list.add("도우너");
		list.add("고길동");
		
		
		long startTime = System.nanoTime();
		//순회1
		for(int i=0;i<list.size();i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		
		//삭제
		list.remove(1);
		
		//순회2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		//순회3
		for(String s: list) {
			System.out.println(s);
		}
		
		long endTime = System.nanoTime();
		
		System.out.println("걸린시간 : " + (endTime-startTime));
	}

}
