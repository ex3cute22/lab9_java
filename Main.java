import java.io.IOException;
import java.util.Scanner;
import java.io.PrintStream;

class Car{
    private String name;
    private int year;
    private int price;
    private Support supportCar = new Support();
    public static int count = 0;

    public Car(){
        name = " ";
        year = 0;
        price = 0;
        count++;
    }

    public Car(String name){
        this.name = name;
        year = 0;
        price = 0;
        count++;
    }

    public Car(String name, int year, int price){
        this.name = name;
        this.year = year;
        this.price = price;
        count++;
    }

    public void read() {
        //Защищенный блок
        boolean validInput = false;
        while(!validInput){
        try {
			Scanner scan = new Scanner(System.in);
			System.out.println("Input name: ");
			name = scan.nextLine();
			System.out.println("Input year: ");
			year = scan.nextInt();
			System.out.println("Input price: ");
            price = scan.nextInt();
            validInput = true;
        } 
        //Перехват исключений
        catch (Exception error) {
			error.printStackTrace();
        }
    }
    }

    public void addTag(){
        name += " (purchased)";
    }

    public void display(){
        try {
			PrintStream ps = new PrintStream(System.out, true, "Windows-1251");
			ps.println("Name: " + name + "\n" + "Year: " + year + "\n" + "Price: " + price);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    public String getName(){
        return name;
    }
    public int getYear(){
        return year;
    }
    public int getPrice(){
        return price;
    }
    public void showRate(){
        supportCar.getRate(this);
    }
    public static void RemoveItem(){
        count--;
    }
    public static int InfoCount(){
        return count;
    }

}
class Support{
    void getRate(Car car){
        System.out.println("Rate " + car.getName() +": " + ((float) car.getYear() * 200) / car.getPrice() );
    }
}


public class Main{
    public static void main(String[] args) {
            
        //Одномерный массив обьектов
            Car[] array = new Car[] {
                new Car("Toyota", 1998, 150000),
                new Car("Bmw", 2010, 300000)
            };

            for (int i = 0; i < array.length; i++){
                array[i].display();
            }
        //Двумерный массив обьектов
            Car[][] array2 = new Car[2][];
           
            for (int i = 0; i < 2; i++){
                array2[i] = new Car[2];
            }
            
            for (int j = 0; j < 2; j++){
                array2[0][j] = new Car("Toyota[0][" + j + "]", 1998 + j*2, 150000 + j*30000);
            }

            for (int j = 0; j < 2; j++){
                array2[1][j] = new Car("Bmw[1][" + j + "]", 2000 + j*2, 300000 + j*30000);
            }

            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 2; j++){
                    array2[i][j].display();
                }
            }
            // Car toyota = new Car("toyota", 1998, 100000);
            // toyota.display();
            // Car bmw = new Car("bmw");
            // bmw.display();
            // Car nissan = new Car();
            // nissan.read();
            // nissan.display();
}
}