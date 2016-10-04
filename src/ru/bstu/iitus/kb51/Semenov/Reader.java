package ru.bstu.iitus.kb51.Semenov;
import java.util.Scanner;
public class Reader {
	private static Scanner scan;
	Reader(Scanner scan){
		Reader.scan=scan;
	}
	public static void init(Scanner scan){
		Reader.scan=scan;
	}
	public static int readInt(String text){
		System.out.println(text);
		int k=scan.nextInt();
		scan.nextLine();
		return k;
	}
	public static String readString(String text){
		System.out.println(text);
		return scan.nextLine();
	}
	public static float readFloat(String text){
		System.out.println(text);
		 float k=scan.nextFloat();
		 scan.nextLine();
		 return k;
	}
	public static long readLong(String text){
		System.out.println(text);
		 long k=scan.nextLong();
		 scan.nextLine();
		 return k;
	}
	
}
