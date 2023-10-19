import java.util.Scanner;
public class Route {
   static Scanner input = new Scanner(System.in);
   static double  speed, distance, TOA, mns;
   static double r1, r2, r3, r4a, r4a1, r4a2, E, r4b, r4b1, r4b2, r5, r5a, r5b;
   static int hrs;
   Route(){
      distance = 0;
      hrs = 0;
      mns = 0;
      r1 = 14.2;
      r2 = 23.1;
      r3 = 20.2;
      r4a = 16.1;
      r4a1 = 17.5;
      r4a2 = 10;
      r4b = 12.7;
      r4b1 = 30.0;
      r4b2 = 16.3;
      r5 = 27.4;
      r5a = 21.4;
      r5b = 13.0;
      E = 3;
   }
   public double defRoute(){  
      distance += r1 + r2 + r3;
      return distance;
   }
   public static void main(String[] args){
      Route newR = new Route();
      System.out.print("Speed: ");
      speed = input.nextInt();
      
      System.out.println("\t\tCebu City - Moalboal");
      System.out.println("\tSouth Bus Terminal\n\tMinglanilla\n\tSan Fernando\n\tCarcar");
      System.out.println("Choose route: [1] Route 4.1: Barili\t[2] Route 4.2: Sibonga");
      System.out.print("Choice: ");
      int c = input.nextInt();
      
      if(c == 1){ //route barili
         System.out.println("\tBarili\n\tDumanjug\n\tAlcantara\n\tMoalboal\n");
         newR.defRoute();
         
         distance += r4a + r4a1 + r4a2 + E;
         TOA = distance / speed;
         hrs = (int)TOA;
         mns = (int)(TOA*100) % 60;
         
         System.out.println("Distance: " + Math.round(distance*100.0)/100.0 + "km");
         System.out.printf("Estimated TOA: %dhrs %.0fmins", hrs, mns);
      } else { //route sibonga
         newR.defRoute();
         distance += r4b;
         
         System.out.println("\tRoute 4.2: Sibonga");
         System.out.println("Choose route: [1] Route 4.2.1: Dumanjug\t[2] Route 5: Argao");
         System.out.print("Choice: ");
         c = input.nextInt();
         if(c == 1){ //route dumanjug
            System.out.println("\tDumanjug\n\tAlcantara\n\tMoalboal\n");
            
            distance += r4b1 + r4b2 + E;
            TOA = distance / speed;
            hrs = (int)TOA;
            mns = (TOA*100) % 100;
            
            System.out.println("Distance: " + Math.round(distance*100.0)/100.0 + "km");
            System.out.printf("Estimated TOA: %dhrs %.0fmins", hrs, mns);
         } else { //route argao
            System.out.println("\tArgao\n\tRonda\n\tAlcantara\n\tMoalboal\n");
            
            distance += r5 + r5a + r5b + E;
            TOA = distance / speed;
            hrs = (int)TOA;
            mns = (TOA*100) % 100;
            
            System.out.println("Distance: " + Math.round(distance*100.0)/100.0 + "km");
            System.out.printf("Estimated TOA: %dhrs %.0fmins", hrs, mns);
         }
      }
   }
}