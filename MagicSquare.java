//Program to generate magic Numbers (Grid Odd Numbers)

public class MagicSquare{
	
	int[][] gridSize;
	int numberOfRows_N_Cols;

	MagicSquare(int numberOfRows_N_Cols){

		this.numberOfRows_N_Cols = numberOfRows_N_Cols;		

		initiateGrid();
		generateGrid(numberOfRows_N_Cols);
		printGrid();

	}

	public void initiateGrid(){
		gridSize = new int[numberOfRows_N_Cols][numberOfRows_N_Cols];
		for (int row = 0;row < numberOfRows_N_Cols;row ++){
			for (int col = 0; col< numberOfRows_N_Cols;col ++){
				gridSize[row][col]= 0;
			}
		}
	}

	public void printGrid(){
		for (int row = 0;row < numberOfRows_N_Cols;row ++){
		int rowSum = 0;			
			for (int col = 0;col < numberOfRows_N_Cols;col ++){
				rowSum = rowSum + gridSize[row][col];	
				System.out.print("|   "+ gridSize[row][col]+"	|");
		
			}
				System.out.println("="+rowSum);
				System.out.println("");		
		}
	}

	public void generateGrid(int numberOfRows_N_Cols){
		
	//initiating the First Number	
	int givenNumber = 1;
	int currRow = 0;
	int currCol = numberOfRows_N_Cols/2;	
	gridSize[currRow][currCol] = givenNumber;
	int lastNum = numberOfRows_N_Cols*numberOfRows_N_Cols;
		
	//second number onwards	
	while(givenNumber != lastNum){
		givenNumber = givenNumber+1;
		if(currRow == 0 && currCol <= numberOfRows_N_Cols-2){
			currRow = numberOfRows_N_Cols-1;
			currCol = currCol + 1;
			gridSize[currRow][currCol] = givenNumber;
		}else if(currCol==numberOfRows_N_Cols-1 && currRow != 0){
			currRow = currRow-1;
			currCol = 0;
			gridSize[currRow][currCol] = givenNumber;
		}else if(currRow != 0 && gridSize[currRow-1][currCol+1]==0  ){
			currRow = currRow-1;
			currCol = currCol + 1;
			gridSize[currRow][currCol] = givenNumber;
		}else if(gridSize[currRow+1][currCol]==0){
			currRow = currRow+1;
			gridSize[currRow][currCol] = givenNumber;
		}
	}
}


public static void  main(String args[]){

MagicSquare ms= new MagicSquare(7);

}
}