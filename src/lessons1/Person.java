package lessons1;

public abstract class Person implements Comparable<Person> {
	private int age;
	private String name;
	
	Person(int age,String name){
		this.age=age;
		this.name=name;
	}
	public int getAge(){
		return age;
	}
	 @Override
	public String toString(){
		return name;
	}	
	 @Override
	public int compareTo(Person p){
		return age-p.age;
	}
}
class Student extends Person
{	
	Student(int age,String name){
		super(age, name);
	}		
}
class Theacher extends Person
{	
	Theacher(int age,String name){
		super(age, name);
	}		
}
class Schoolkid extends Person
{	
	Schoolkid(int age,String name){
		super(age, name);
	}		
}
class Manager extends Person
{	
	Manager(int age,String name){
		super(age, name);
	}		
}

