package chapter12;

import java.util.ArrayList;

public class ArrayList01 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList();
		list.add("딸기"); //값입력(등록)
		list.add("수박");
		list.add("참외");
		list.add(1, "망고"); // (index, value)
		list.set(3, "오렌지"); // 3번의 참외를 오렌지로 수정(set)
		list.remove(3); // 3번을 지우기(remove)
		// int[] array = new int[5];
		// array[0] = 3;
		
		// 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		for (String val : list) {
			System.out.println(val);
		}
	}

}
