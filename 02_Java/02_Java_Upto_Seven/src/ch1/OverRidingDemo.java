package ch1;

class DomesticAnimal 
{
	   public void move() {
	      System.out.println("Animals can move");
	   }
}

class Dog extends DomesticAnimal {
   public void move() {
      System.out.println("Dogs can walk and run");
   }
}

public class OverRidingDemo {

   public static void main(String args[]) 
   {
	   DomesticAnimal a = new DomesticAnimal();   // Animal reference and object
	   DomesticAnimal b = new Dog();   // Animal reference but Dog object

	   a.move();   // runs the method in Animal class
	   b.move();   // runs the method in Dog class
   }
}