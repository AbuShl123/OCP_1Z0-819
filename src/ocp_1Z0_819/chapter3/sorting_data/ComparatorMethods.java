package ocp_1Z0_819.chapter3.sorting_data;

import java.util.*;
import java.io.*;

public class ComparatorMethods {

	static class Student implements Comparable<Student> {
		private String name;
		private float gpa;
		private int attendance;

		public Student(String name, float gpa, int attendance) {
			this.name = name;
			this.gpa = gpa;
			this.attendance = attendance; 
		}

		public String getName() { return name; }
		public float getGPA() { return gpa; }
		public int getAttendance() { return attendance; }

		@Override
		public int compareTo(Student another) {
			return this.name.compareTo(another.name);
		}

		@Override
		public String toString() {
			return name + " gpa: " + gpa + ", attendance: " + attendance + "\n";
		}
	}

	public static List<Student> readStudentsData(String filename) {
		List<Student> list = new ArrayList<>();

		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader file = new BufferedReader(fileReader);
			file.readLine(); // skipping headers
			String line;
			while ( (line = file.readLine()) != null ) {
				String[] cells = line.split(",");
				list.add(new Student(cells[0], Float.parseFloat(cells[1]), Integer.parseInt(cells[2])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}	

	public static void main(String... args) {
		var students = readStudentsData("students.csv");

		Comparator<Student> byRanking = Comparator.comparing(Student::getGPA).thenComparingInt(Student::getAttendance);

		System.out.println(students);
	
		Collections.sort(students, byRanking);

		System.out.println(students);	

		byRanking = byRanking.reversed();

		Collections.sort(students, byRanking);

		System.out.println("Now, the best students are listed first: \n" + students);	

		Comparator byNaturalOrder = Comparator.naturalOrder();
		Comparator byReverseOrder = Comparator.reverseOrder();

		Collections.sort(students, byNaturalOrder);
		System.out.println("Now, sorting by natural order (by students' name): \n" + students);		
		
		Collections.sort(students, byReverseOrder);
		System.out.println("Now, sorting by reversed order (by students' name): \n" + students);				
	}
}
