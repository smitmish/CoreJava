public class ConditionalStatement {
    void main(){
        int a = 10;
        int b = 20;
        int c = 30;
        if(a > b){      
            System.out.println("a is greater than b");
        } else if(a < b){
            System.out.println("a is less than b");
        } else {
            System.out.println("a is equal to b");
        }

        if(a<b && a<c){ 
            System.out.println("a is the smallest number");
        }else if(b<c){
            System.out.println("b is the smallest number");
        }else{
            System.out.println("c is the smallest number");
        }
        int num = 4;
        boolean result = (num % 2 == 0) ? true : false;
        System.out.println("Is num even? " + result);
        //Ternary operator only useful when we have to assign value to a variable 
        // based on some specific condition or small logic.

        int day = 7;
        String dayName = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> {System.out.println("It's Saturday!"); yield "Saturday";}
            case 7 -> {System.out.println("It's Sunday!"); yield "Sunday";}
            default -> "Invalid day";
        };
        String message = switch (day) {
            case 1, 2, 3, 4, 5 -> "It's a weekday.";
            case 6, 7 -> "It's a weekend.";
            default -> "Invalid day";
        };
        System.out.println("Day name: " + dayName);
        System.out.println("Message: " + message);

        enum daysOfWeek {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        String dayName2 = switch (daysOfWeek.SATURDAY) {
            case MONDAY -> "It's Monday!";
            case TUESDAY -> "It's Tuesday!";
            case WEDNESDAY -> "It's Wednesday!";
            case THURSDAY -> "It's Thursday!";
            case FRIDAY -> "It's Friday!";
            case SATURDAY -> "It's Saturday!";
            case SUNDAY -> "It's Sunday!";
            default -> "Invalid day!";
        };
        System.out.println("Day name 2: " + dayName2);
    }   
}
