package com.example.javaexercises5.advanced.abstractclass;

import java.util.Arrays;

public class Main01 {

	public static void main(String[] args) {
		Person[] people = new Person[5];
		people[0] = new Person("z", "z");
		people[1] = new Person("b", "b");
		people[2] = new Person("f", "f");
		people[3] = new Person("x", "x");
		people[4] = new Person("y", "y");

		Arrays.sort(people);

		for (Person person : people) {
			System.out.println(person);
		}

	}

}
