import java.io.*; 
import java.util.List;
public class MinJumps{
    public static void main(String[] args) {

        String ex1fileName = args[0];
        exercise1( ex1fileName );
        
    }

    public static void exercise1( String fileName )
	{
		int[] data = turnListIntoTable( fileName );
        Implementation exercise1 = new Implementation( data );
        System.out.println("|------EXERCISE 1------|");
		exercise1.printInputData();
        exercise1.solveExercise1();
        //exercise1.printSolution();
        exercise1.findPath();
        exercise1.composedAnswer();	

    }

    
    
    public static int[] turnListIntoTable( String fileName )
	{
		List<Integer> list = null;
		int[] data = null;

		try
		{
			File file = new File(fileName); 
			list = (List)Utilities.convertFileSequenceToList(file);  
			data = new int[list.size()]; 
 			for( int i=0; i<data.length; i++ )
                data[i] = list.get(i);
		}
		catch( Exception e )
		{
			System.out.println("- Problem with file-reading.");
		}	

		return data;
    }


}
