package ru.bstu.iitus.kb51.Semenov;
import java.util.Scanner;
public abstract class Person implements Comparable<Person> {
	private int age;
	private String name;
	protected static Scanner scan;
	Person(int age,String name){
		this.age=age;
		this.name=name;
		init();
	}
	public int getAge(){
		return age;
	}
	 @Override
	public String toString(){
		return name;
	}
	abstract void init();	 
	 @Override
	public int compareTo(Person p){
		return age-p.age;
	}
	 public static enum PersonType{	
		 StudentType{@Override public String toString(){return "Студент";}},
		 TheacherType{@Override public String toString(){return "Учитель";}},
		 SchoolkidType{@Override public String toString(){return "Школьник";}},
		 DirectorType{@Override public String toString(){return "Директор";}};
		 
	 }
}
class Student extends Person
{	
	Long recordBook;
	float averageMark;
	String group;
	Student(int age,String name){
		super(age, name);
	}		
	void init(){		
		group=Reader.readString("Группа");
		averageMark=Reader.readFloat("Средний балл");
		recordBook=Reader.readLong("Номер зачетной книжки студента");	
	}
	public static int compere(Student one,Student two){
		return one.recordBook.compareTo(two.recordBook);
	}
}

class Schoolkid extends Person
{	
	float averageMark;
	int clas;
	Schoolkid(int age,String name){
		super(age, name);
	}		
void init(){	
	clas=Reader.readInt("Класс школьника");	
	averageMark=Reader.readFloat("Средний балл");	
	}
}
class Manager extends Person
{	
	String job; 
	Manager(int age,String name){
		super(age, name);		
	}		
	void init(){
		job=Reader.readString("Место работы");
	}
}
class Theacher extends Manager
{	
	String subject;
	String certificate;
	Theacher(int age,String name){
		super(age, name);
	}		
	void init(){
		super.init();
		subject=Reader.readString("Преподаваемый предмет");
		certificate=Reader.readString("Номер сертификата преподователя");
	}
}
class Director extends Manager{
	String inn;
	Director(int age,String name){
		super(age, name);		
	}
	void init(){
		super.init();
		inn=Reader.readString("Введите ИНН");
	}
}

