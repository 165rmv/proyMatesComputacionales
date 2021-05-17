import java.util.*; 
import java.io.File; 
import java.io.FileNotFoundException; 

// ndfa-lambda
        /*
        txt file specifications 
        - The first line indicates the set of the states of the automata separated by commas
        - The second line indicates the alphabet symbols separated by commas 
        - The third line indicates the initial state
        - The fourth line indicates the set of the final state 
        - The following lines indicate the transition table in the following format 
        
        state, symbol = > states
        states is a list of elements separated by commas.
        Example, the following line
        q0, a => q1,q2
        indicates that the NDFA processes the following: d(q0,a) = {q1,q2}
        To indicate a spontaneous transition, the word lambda will be used.
        It is not necessary that all transitions are specified in this file. An evaluation may not appear if a state indicating that the result of that evaluation is the empty set
        The program should print step by step the processing. And this should be repeated while the user wants to.
        Do not worry about validating the values in the input file. Suppose that were built correctly.       
        */
public class proyecto_matesCompu{
    public static void main(String[] args){
       
        try {
            File myObj = new File("test1.txt"); // file
            Scanner sc = new Scanner(myObj);
            // we decided to use arraylists instead of arrays, because they can still grow after declared
            ArrayList<String> states = new ArrayList<String>();
            ArrayList<String> alphabet = new ArrayList<String>();
            ArrayList<String> initialState = new ArrayList<String>();
            ArrayList<String> finalState = new ArrayList<String>();
            ArrayList<String> transitionTable = new ArrayList<String>();
            
            /***************/
            /*    states   */ 
            /***************/
            sc.hasNextLine(); 
            String data = sc.nextLine();
            String[] takeOut = data.split(","); 
            for(int i = 0;i < takeOut.length;i++){
                states.add(takeOut[i]);
            }
            System.out.println("The states are: "+states);            
           
            /***************/
            /*   alphabet  */ 
            /***************/
            sc.hasNextLine(); 
            data = sc.nextLine();
            takeOut = data.split(","); 
            for(int i = 0;i < takeOut.length;i++){
                alphabet.add(takeOut[i]);
            }
            alphabet.add("lambda"); 
            System.out.println("The alphabet is: "+alphabet);
            

            /*****************/
            /*    initial    */
            /*    states     */ 
            /*****************/ 
            sc.hasNextLine();
            data = sc.nextLine();
            takeOut = data.split(","); 
            for(int i = 0;i < takeOut.length;i++){
                initialState.add(takeOut[i]);
            }
            System.out.println("The initial state is: "+initialState);

            /*****************/
            /*     final     */
            /*     states    */ 
            /*****************/ 
            sc.hasNextLine(); 
            data = sc.nextLine();
            takeOut = data.split(","); 
            for(int i = 0;i < takeOut.length;i++){
                finalState.add(takeOut[i]);
            } 
            System.out.println("The final state is or are: "+finalState);
        
            /*****************/
            /*   transition  */
            /*      table    */ 
            /*****************/            
            while(sc.hasNextLine()){ // loop in file for all possible elements in transition table
                data = sc.nextLine(); // reads data
                takeOut = data.split(","); 
                takeOut = data.split("=>"); 
                for(int i = 0;i < takeOut.length;i++){
                    finalState.add(takeOut[i]);
                } 
            }
            System.out.println("The table is: "+transitionTable); 
             
            sc.close(); // close document

        } catch (FileNotFoundException e) {
            System.out.println("An error occured with the file"); 
            e.printStackTrace(); 
        }

    }

}
