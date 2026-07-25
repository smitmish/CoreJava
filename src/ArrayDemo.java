class Student{
    int rollNo;
    int marks;
    String name;
    Student(int rollNo, int marks, String name){
        this.rollNo = rollNo;
        this.marks = marks;
        this.name = name;
    }
}
public class ArrayDemo {
    void main(){
        System.out.println("Array Demo");
        System.out.println("One dimensional array:");
        int arr[] = new int[5];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }

        System.out.println("Two dimensional array:");
        int twoDimensionalArray[][] = new int[2][3];
        for(int i=0; i<twoDimensionalArray.length; i++){
            for(int j=0; j<twoDimensionalArray[i].length; j++){
                twoDimensionalArray[i][j] = (i+1)*(j+1);
            }
        }
        for(int i=0; i<twoDimensionalArray.length; i++){
            for(int j=0; j<twoDimensionalArray[i].length; j++){
                System.out.print(twoDimensionalArray[i][j] + " ");
            }
            System.out.println();
        }
        //printing two-dimensional using enhanced for loop.
        for(int row[] : twoDimensionalArray){
            for(int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }

        System.out.println("Jagged array:");
        //Jadded array
        int jaggedArray[][] = new int[3][];
        jaggedArray[0] = new int[2];
        jaggedArray[1] = new int[3];
        jaggedArray[2] = new int[4];
        for(int i=0; i<jaggedArray.length; i++){
            for(int j=0; j<jaggedArray[i].length; j++){
                jaggedArray[i][j] = (i+1)*(j+1);
            }
        }
        for(int i=0; i<jaggedArray.length; i++){
            for(int j=0; j<jaggedArray[i].length; j++){
                System.out.print(jaggedArray[i][j] + " ");
            }
            System.out.println();
        }
        //printing jagged array using enhanced for loop.
        for(int row[] : jaggedArray){
            for(int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println("Three dimensional array:");
        //Three dimensional array
        int threeDimensionalArray[][][] = new int[2][3][4];
        for(int i=0; i<threeDimensionalArray.length; i++){
            for(int j=0; j<threeDimensionalArray[i].length; j++){
                for(int k=0; k<threeDimensionalArray[i][j].length; k++){
                    threeDimensionalArray[i][j][k] = (i+1)*(j+1)*(k+1);
                }
            }
        }   
        for(int i=0; i<threeDimensionalArray.length; i++){
            for(int j=0; j<threeDimensionalArray[i].length; j++){
                for(int k=0; k<threeDimensionalArray[i][j].length; k++){
                    System.out.print(threeDimensionalArray[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }   
        System.out.println("Four dimensional array:");
        //Four dimensional array
        int fourDimensionalArray[][][][] = new int[2][3][4][5];
        for(int i=0; i<fourDimensionalArray.length; i++){
            for(int j=0; j<fourDimensionalArray[i].length; j++){
                for(int k=0; k<fourDimensionalArray[i][j].length; k++){
                    for(int l=0; l<fourDimensionalArray[i][j][k].length; l++){
                        fourDimensionalArray[i][j][k][l] = (i+1)*(j+1)*(k+1)*(l+1);
                    }
                }
            }
        }
        for(int i=0; i<fourDimensionalArray.length; i++){
            for(int j=0; j<fourDimensionalArray[i].length; j++){
                for(int k=0; k<fourDimensionalArray[i][j].length; k++){
                    for(int l=0; l<fourDimensionalArray[i][j][k].length; l++){
                        System.out.print(fourDimensionalArray[i][j][k][l] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }

        //Array of objects
        System.out.println("Array of objects:");
        Student students[] = new Student[3];
        students[0] = new Student(1, 90, "John");
        students[1] = new Student(2, 80, "Jane");   
        students[2] = new Student(3, 70, "Jack");
        for(int i=0; i<students.length; i++){
            System.out.println("Roll No: " + students[i].rollNo + ", Marks: " + students[i].marks + ", Name: " + students[i].name);
        }
        System.out.println("Using enhanced for loop:");
        for(Student student : students){
            System.out.println("Roll No: " + student.rollNo + ", Marks: " + student.marks + ", Name: " + student.name);
        }
    }
}
