package application;

import java.util.ArrayList;
import java.util.Collection;

import list.SimpleList;

public class Tests {

	public static void main(String[] args) {

		SimpleList<String> list = new SimpleList<>();
		Collection<String> nomes = new ArrayList<>();
		
		nomes.add("Leonardo");
		nomes.add("Aline");
		
		Collection<String> frutas = new ArrayList<>();
		
		frutas.add("Maçã");
		frutas.add("Banana");
		
		list.addAll(nomes);
		list.addAll(frutas);
		
		list.removeIf(node -> frutas.contains(node));
		
		System.out.println(list.toString());
		
		System.out.printf("\nEssa lista tem %d elementos.\n\n", list.size());
		
		System.out.println((list.contains("Maçã") ? "Essa lista contém maçã" : "Essa lista não contém maçã"));
		
		
	}

}
