package application;

import list.SimpleList;

public class Tests {

	public static void main(String[] args) {

		SimpleList<String> list = new SimpleList<>();
		
		list.add("Leonardo");
		list.add("Aline");
		list.add("Sei la");
		list.add("Lacerda");
		
		list.remove("Lacerda");
		
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
		
		
		System.out.println(list.toString());
		
		
	}

}
