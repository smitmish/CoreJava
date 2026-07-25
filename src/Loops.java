import java.util.ArrayList;
public class Loops {
    void main(){
        //For loop
        for(int i=0; i<5; i++){
            System.out.println("i="+i);
        }
        //While loop
        int j = 0;
        while(j<5){
            System.out.println("j="+j);
            j++;
        }
        //Do-while loop
        int k = 0;
        do{
            System.out.println("k="+k);
            k++;
        }while(k<5);

        //Enhanced for loop (for-each loop)
        int[] arr = {1, 2, 3, 4, 5};
        for(int num : arr){
            System.out.println("num="+num);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("Sunday"); 
        list.add("Monday");
        list.add("Tuesday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");
        list.forEach(day -> System.out.println("day="+day));
        list
        .stream()
        .filter(day -> !day.startsWith("S")) //intermediate operation
        .forEach(day -> System.out.println("day = "+day)); //terminal operation
        //So without the terminal operation, the stream will not be executed and the filter() method will not be called.

        list.stream()
        .filter(day -> !day.startsWith("S"))
        .peek(day -> System.out.println("day=" + day)) // "Peeks" at the data
        .count(); // A terminal operation required to trigger the stream

        //So without the terminal operation, the stream will not be executed and the peek() method will not be called.

        //Terminal operations are operations that produce a result or a side-effect, 
        // such as forEach(), count(), collect(), reduce(), max(), min()

    }   
}
