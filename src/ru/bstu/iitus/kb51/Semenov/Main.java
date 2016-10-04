package ru.bstu.iitus.kb51.Semenov;
import java.util.Arrays;
import java.util.Scanner;

import ru.bstu.iitus.kb51.Semenov.Person.PersonType;
public class Main {
	static Scanner scan = new Scanner(System.in);
	static Person[] pr;
	static Person createPerson(String name, int age,PersonType type){
		switch(type){
		case StudentType: return new Student(age,name);
		case TheacherType: return new Theacher(age,name);
		case SchoolkidType: return new Schoolkid(age,name);
		case DirectorType: return new Director(age,name);
		}
		return null;
	}
	
	static Person readPerson(){
		String name=Reader.readString("Введите имя");		
		int age = Reader.readInt("Введите возраст");			
		Person p = null;
		int count=0;
		while(count<3 && p==null){  
			try{
			PersonType type =PersonType.values()[(Reader.readInt("Введите тип \n1-Student\n2-Theacher\n3-Schollkid\n4-Director"))-1];			
			p=createPerson(name,age,type);
			
			}
			catch(ArrayIndexOutOfBoundsException e){				
				count++;
			}
		}		
		if(p==null){throw new NullPointerException("Трижды не верно задан тип. Завершение работы программы"); }
		return p;								
	}
	 static Person findMin(Person pr[]){
		Arrays.sort(pr);
		return pr[0];
	}
	 static Student findMinRecordBook(Person pr[]){
		 Student min=null;
		 for (Person stud : pr){
			 if(stud.getClass()==Student.class){
				 if(min==null)
					 min=(Student)stud;
				 if(Student.compere(min, (Student)stud)>0)
					 min=(Student)stud;
			 }
		 }
		 return min;
	 }
	public static void main(String[] args) {
		Reader.init(scan);
		int count=Reader.readInt("Введите кол-во человек");	 
		pr=new Person[count];
		try{
			for(int i=0;i<count;i++){
				pr[i]=readPerson();
			}	
		System.out.println("Минимальный возраст у "+findMin(pr));	
		System.out.println("Минимальный номер зачетки у студента "+findMinRecordBook(pr));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
