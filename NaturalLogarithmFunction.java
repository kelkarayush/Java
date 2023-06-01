import java.util.*;
public class NaturalLogarithmFunction {
    //This program is to find the natural logarithm of a number (also called: ln(x)), which is also called the logarithm of a number to the base
    //e which is Euler's number.
    double x; //Number to be inputted by the user.
    double e = 2.71828; //Euler's number correct to 5 decimal places.
    double counter = 0.0; //Counter variable initially, but transforms into the result of this function.
    public void input() { 
        Scanner sc=new Scanner(System.in); //Initializing Scanner Class.
        System.out.println("Enter the number:"); 
        x = sc.nextDouble(); //Getting the input of x from the user.
        sc.close(); //Closing the scanner. BlueJ does this automatically but VS Code fails to do so, as it is not an IDE.
    }
    public void NaturalLogarithm() {
        double temp1 = x; //Declaring the x value in a temporary variable as we cannot change the value of x or else that will mess things up.
        while (temp1 > e) {
            temp1/=e; //Dividing the value of x by Euler's number to get a value which is less than Euler's number.
            counter++; //Incrementing the counter variable to see how many times x divided e to get the result.
        }
        double position = 1.0; //
        for(int i = 0; i < 60 ; i++) { //Double values can hold presicion upto 57 significant figures so interating 60 times does nothing other
            temp1*=temp1;             //than making double sure that it gets divided.
            position/=2.0; //In binary form, dividing the position variable by 2 moves the value to the right, in this case, to the right of
            if(temp1 > e) {  //the decimal point.
                counter+=position; 
                temp1/=e;
            }
        }
    }
    public void display() {
        System.out.println("Natural Logarithm of "+x+" is: "+counter); //Printing the counter variable as it now carries the result.
    }
    public static void main(String[] args) {
        NaturalLogarithmFunction ln = new NaturalLogarithmFunction(); //Creating an object to call functions.
        ln.input(); //Calling all functions.
        ln.NaturalLogarithm(); 
        ln.display();
    }
}
