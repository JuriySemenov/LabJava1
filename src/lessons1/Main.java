package lessons1;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	static Scanner scan = new Scanner(System.in);
	static Person[] pr;
	static Person createPerson(String name, int age,int type){
		switch(type){
		case(1): return new Student(age,name);
		case(2): return new Theacher(age,name);
		case(3): return new Schoolkid(age,name);
		case(4): return new Manager(age,name);
		}
		return null;
	}
	
	static Person readPerson(){
		scan.nextLine();//после использования scan.nextInt у нас в потоке in остается /n. тут его убираем.
		System.out.println("Введите имя");
		String name = scan.nextLine();
		System.out.println("Введите возраст");
		int age = scan.nextInt();		
		Person p = null;
		int count=0;
		while(count<3 && p==null){
			System.out.println("Введите тип \n1-Student\n2-Theacher\n3-Schollkid\n4-Manager");
			int type = scan.nextInt();
			p=createPerson(name,age,type);
			count++;
		}
		try{
		if(p==null){throw new NullPointerException("Трижды не верно задан тип. Завершение работы программы"); }
		return p;
		}		
		catch(NullPointerException e){			
			throw e;
		}
		
	}
	 static Person findMin(Person pr[]){
		Arrays.sort(pr);
		return pr[0];
	}
	public static void main(String[] args) {
		System.out.println("Введите кол-во человек");
		int count = scan.nextInt();
		pr=new Person[count];
		try{
			for(int i=0;i<count;i++){
				pr[i]=readPerson();
			}	
		System.out.println(findMin(pr).toString());	
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
