class Implementation
{

    private int[] leaves;

    private int[] solution;

    private int[] leaves_passed;
    private int[] path;

    public Implementation( int[] leaves )
    {
        this.leaves = leaves;

    }

    public void solveExercise1()
    {
        solution = new int[leaves.length];
        leaves_passed = new int[leaves.length];
        int i, j, incr;

        if (leaves[0] == 0 || leaves.length == 0){ //If the first leaf has no food, or the array is empty
            System.out.println("Problem can't be solved.");
        }

        solution[0] = 0;

        for(i = 1; i < leaves.length; i++){
            solution[i] = Integer.MAX_VALUE;
            for(j = 0; j < i; j++){
                if (i <= j + leaves[j] && solution[j] != Integer.MAX_VALUE){
                    solution[i] = Math.min(solution[i], solution[j] + 1);
                }
            }
        }


        leaves_passed[0] = -1;

        for(i = 1; i < leaves.length; i++){
            incr = 0;
            for(j = 0; j < i; j++){
                if (i <= j + leaves[j] && solution[j] != Integer.MAX_VALUE){
                    incr++;
                    if(incr == 1){
                        leaves_passed[i] = j;
                    }
                }
            }
        }


    }

    /*A function to help keep track of the solution:  
    public void printSolution()
    {
        if(solution!=null)
            for( int i=0; i<solution.length; i++ )
            {
                System.out.print( solution[i]+" " );
            }
        else
            System.out.print( " Solution for Exercise1 is empty." );

        System.out.println();



        if(leaves_passed!=null)
            for( int i=0; i<leaves_passed.length; i++ )
            {
                System.out.print( leaves_passed[i]+" " );
            }
        else
            System.out.print( " Solution for Exercise1 is empty." );

        System.out.println();

    }*/

    public void findPath(){
        path = new int[solution[solution.length-1]+1];
        path[path.length-1] = leaves_passed.length-1;
        for(int k = path.length - 2; k>=0; k--){
            path[k] = leaves_passed[path[k+1]];
        }

    }


    //Prints the initial array given as an input
	public void printInputData()
	{
		if( leaves !=null )
		{
            System.out.println("The initial array is: ");
			for( int i=0; i<leaves.length; i++ )
			{
				System.out.print( leaves[i]+" " );
			}
			System.out.println();
		} 
		else
			System.out.println("Input table is null.");
	}

	public void composedAnswer(){
        System.out.println("The number of jumps is: "+solution[leaves.length-1]);
        System.out.print("And the leaves he had to pass were: ");
        for(int t=0; t<path.length-1; t++){
            System.out.print(path[t]+"->");
        }
        System.out.println(path[path.length-1]);
    }

}
