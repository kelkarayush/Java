import java.util.*;
public class LogarithmFunction {
    //This program is for finding the logarithm of a number to the base 10 [also called: log(x)], if and only if the user does not input a base.
    //If the user chooses to input a base, then it will be the log of the number to the respective base.
    double x; //Number to be inputted by the user.
    double b = 10.0; //Base 10 as default logarithm. But changes if the user inputs a different base.
    double counter = 0.0; //Counter variable initially, but transforms into the result of this function.
    int choice;
    public void input() { 
        Scanner sc=new Scanner(System.in); //Initializing Scanner Class.
        System.out.println("Enter the argument:"); 
        x = sc.nextDouble(); //Getting the input of x from the user.
        System.out.println("Do you want to enter a base? If yes, type 0. If no, type 1");
        choice = sc.nextInt();
        if (choice == 0) { //switch statement won't work here as we do not want anything to happen when the user types 1, which is possible only
            System.out.println("Enter the base: "); //through if statement, whereas switch statement will ask for an argument of some sort.
            b = sc.nextDouble();
        }
        sc.close(); //Closing the scanner. BlueJ does this automatically but VS Code fails to do so, as it is not an IDE.
    }
    public void Logarithm() {
        double temp1 = x; //Declaring the x value in a temporary variable as we cannot change the value of x or else that will mess things up.
        while (temp1 > b) {
            temp1/=b; //Dividing the value of x by Euler's number to get a value which is less than Euler's number.
            counter++; //Incrementing the counter variable to see how many times x divided e to get the result. This becomes the integer before
        }              //the decimal point.
        double position = 1.0; //
        for(int i = 0; i < 60 ; i++) { //Double values can hold presicion upto 57 significant figures so iterating 60 times does nothing other
            temp1*=temp1;             //than making double sure that it gets divided till 57 sig. figures.
            position/=2.0; //In binary form, dividing the position variable by 2 moves the value to the right, in this case, to the right of
            if(temp1 > b) {  //the decimal point.
                counter+=position; 
                temp1/=b;
            }
        }
    }
    public void display() { //Function to display the result.
        System.out.println("Logarithm of "+x+" to the base "+b+" is: "+counter); //Printing the counter variable as it now carries the result.
    }
    public static void main(String[] args) {
        LogarithmFunction ln = new LogarithmFunction(); //Creating an object to call functions.
        ln.input(); //Calling all functions.
        ln.Logarithm(); 
        ln.display();
    }
}
