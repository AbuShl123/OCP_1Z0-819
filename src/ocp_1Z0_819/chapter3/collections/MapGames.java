package ocp_1Z0_819.chapter3.collections;

import java.util.*;
import static ocp_1Z0_819.utils.JavaUtils.*;

public class MapGames {
	static final int kz = 7;
	static final int us = 1;
	static final Map<Integer, Map<String, Long>> contactBook;
	static Map<String, Long> kzNums = new HashMap<>();
	static Map<String, Long> usNums = new HashMap<>();

	static {
		contactBook = Map.ofEntries(
			Map.entry(kz, kzNums),
			Map.entry(us, usNums)
		);
	}

	static class Contact {
		String name;
		int code;
		long num;

		Contact(String name, int code, long num) {
			this.name = name;
			this.code = code;
			this.num = num;
		}

		@Override
		public String toString() {
			return name + " +" + code + num;
		}
	}
	
	public static void main(String[] args_) {
		Scanner in = new Scanner(System.in);
		
		do {
			println("0. Quit");
			println("1. Add new contact");
			println("2. Remove contact");
			println("3. Display contact");
			print("Enter action number: ");
			int userInput = in.nextInt();

			switch (userInput) {
				case 0: return;
				case 1: 
					print("contact name: ");
					String name = in.next();
					print("contury code: ");
					int countryCode = in.nextInt();
					print("phone number: ");
					long phoneNumber = in.nextLong();
					boolean result = add(name, phoneNumber, countryCode); 

					if (result) 
						printf("Contact [%s +%d%d] was added successfully.\n", name, countryCode, phoneNumber);
	 				else 
						println("Contact with name " + name + " already exists or country code is not supported.");
					break;
				case 2: 
					print("name of the contact to delete: ");
					String contactName = in.next();
					Contact contact = remove(contactName);

					if (contact != null)
						printf("Contact [%s] was deleted successfully from the contact list.\n", contact);
					else 
						println("Contact with name " + contactName + " does not exist.");
					break;
				case 3:
					print("Enter contact name: ");
					String nameToSearch = in.next();
					Contact foundContact = search(nameToSearch);
				
					if (foundContact == null) 
						println("Contact with name " + nameToSearch + " is not found");
					else 
						printf("Contact: [%s]\n", foundContact);
					break;
				default: 
					println("Please enter valid option number.");
			}
			println();
		} while (true);
	}

	static boolean add(String name, long number, int countryCode) {
		if (search(name) != null) return false;
		if (countryCode != us && countryCode != kz) return false;
	
		contactBook.get(countryCode).put(name, number);
		
		return contactBook.get(countryCode).put(name, number) != null;
	}

	static Contact remove(String name) {
		Contact contact = search(name);
		
		if (contact == null) return null;

		contactBook.get(contact.code).remove(name);

		return contact;
	}

	
	static Contact search(String name) {
		Long n1 = contactBook.get(kz).get(name);	
		Long n2 = contactBook.get(us).get(name);

		int code = n1 != null ? kz : us;
		Long num = n1 != null ? n1 : n2;

		if (num == null) return null;

		return new Contact(name, code, num);
	}
}
