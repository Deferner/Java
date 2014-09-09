import java.io.*;

import javax.swing.JOptionPane;
public class mainSorting {
		static int no;
		static int type;
	public static void main(String [] args) throws IOException {
		EnterNumber en = new EnterNumber();
		no = en.number();
		String[] string1 = new String[no];
		EnterTypeOfSorting t = new EnterTypeOfSorting();
		type = t.getTypeChoice();
		int choice4 = t.UpDown();
		
		switch(type) {
		case 1 : InputNumberClass objInput = new InputNumberClass();
			 	 objInput.runInputNumber(no);
			 	 int choice1 = objInput.getSelectChoice();
			
			switch(choice1) {
				case 1 : System.out.println("\nThe result of InsertionSort is");
						 runCal(new InsertionSort(objInput.getNumber(),no,choice4));
						 System.exit(0);
						 break;
				case 2 : System.out.println("\nThe result of HeapSort");
				 		 runCal(new HeapSort(objInput.getNumber(),no,choice4));
				 		 System.exit(0);
				 		 break;
				case 3 : System.out.println("\nThe result of ShellSort is");
				 		 runCal(new ShellSort(objInput.getNumber(),no,choice4));
				 		 System.exit(0);
				 		 break;
				}//end switch(choice1)
		case 2 : InputStringClass objInput2 = new InputStringClass();
				 objInput2.runInputString(no);
				 string1 = objInput2.get_String();
				 SortString objInput3 = new SortString();
				 objInput3.sort_string(string1,no,choice4);
		}//end switch(type)
	}//end main method
	
	static void runCal(Operand obj) {
		obj.operation();
	}//end runCal method
}//end Sorting Class

class EnterNumber { //for entering amount of number for sorting
	int number = 0;
		public int number() throws IOException {
			boolean done = false;
			do {
				try {
					String input4 = JOptionPane.showInputDialog("Enter number of your input for sorting");
					number = Integer.parseInt(input4);
					System.out.println("number of your sorting-->" +number);
					done = true;
				}//end try
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Enter NUMBER Only (Integer)!!","Warning",JOptionPane.PLAIN_MESSAGE);
					done = false;
				}//end catch
			}while(!done); //end do...while loop
			return number;
		}//end method number()
}//end class EnterNumber

class EnterTypeOfSorting { //for select character sorting of number sorting
	public int getTypeChoice() throws IOException { //Select method of Sorting 
		int input10 = 0;
		boolean check = false;
		
		System.out.println("\nWhice type do you want to sort?");
		System.out.println("1. Number");
		System.out.println("2. Character");
		do {
			try {
				String input9 = JOptionPane.showInputDialog("Enter your type that you want to use(1 or 2)");
				input10 = Integer.parseInt(input9);
				if(input10 < 1 || input10 > 2) {
					JOptionPane.showMessageDialog(null,"Enter Number 1 or 2 Only!!","Warning",JOptionPane.PLAIN_MESSAGE);
					check = false;
				}//end if
			}//end try
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Enter NUMBER Only!!","Warning",JOptionPane.PLAIN_MESSAGE);
				check = false;
			}//end catch
		}while(!check); //end do
		return input10;
	}//end getSelectChoice method
	
	public int UpDown() throws IOException { //Select method of Sorting(Ascending or Descending)
		int choice3 = 0;
		boolean check2 = false;
		System.out.println("\nChoose Ascending or Descending?");
		System.out.println("1. Ascending");
		System.out.println("2. Descending");
		System.out.println("Please enter the number of your choice");
		do {
			try {
				String input20 = JOptionPane.showInputDialog("Enter your method that you want to use");
				choice3 = Integer.parseInt(input20);
				check2 = true;
				if(choice3 < 1 || choice3 > 2) {
					JOptionPane.showMessageDialog(null,"Enter Number1 or 2 Only!!", "Warning",JOptionPane.PLAIN_MESSAGE);
					check2 = false;
				}//end if
			}//end try
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Enter NUMBER Only(1-2)!!","Warning",JOptionPane.PLAIN_MESSAGE);
				check2 = false;
			}//end catch
		}while(!check2); //end do...while loop
		return choice3;
	}//end method UpDown
}//end EnterTypeOfSorting Class

class InputNumberClass { //For entering each number for sorting
	private int[] input3 = new int[100];
		public void runInputNumber(int n) throws IOException {
			boolean check = false;
			int count = 0;
			int input2 = 0;
			do {
				try {
					if(count < n) {
						String input1 = JOptionPane.showInputDialog("Enter your input");
						input2 = Integer.parseInt(input1);
						count++;
						System.out.print("number " +count);
						input3[count-1] = input2;
						System.out.println("  is " +input3[count-1]);
						check = false;
					}//end if
					else {
						check = true;
					}
				}//end try
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Enter NUMBER Only!!","Warning",JOptionPane.PLAIN_MESSAGE);
					check = false;
				}//end catch
			}while(!check); //end do...while loop
		}//end runInput method
		
		public int getSelectChoice() throws IOException { //Select method of Sorting
			int choice2 = 0;
			boolean check = false;
			System.out.println("\nWhat method do you want to sort?");
			System.out.println("1. InsertionSort");
			System.out.println("2. HeapSort");
			System.out.println("3. ShellSort");
			System.out.println("Please enter the number of your sorting method");
			do {
				try {
					String input5 = JOptionPane.showInputDialog("Enter your method that you want to use");
					choice2 = Integer.parseInt(input5);
					check = true;
					if(choice2 < 1 || choice2 > 3) {
						JOptionPane.showMessageDialog(null,"Enter Number1-3 Only!!","Warning",JOptionPane.PLAIN_MESSAGE);
						check = false;
					}//end if
				}//end try
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null,"Enter NUMBER Only(1-3)","Warning",JOptionPane.PLAIN_MESSAGE);
					check = false;
				}//end catch
			}while(!check); //end do...while loop
			return choice2;
		}//end getSelectChoice method
		
		public int[] getNumber() {
			return input3;
		}//end getNumber method
}//end InputNumberClass Class

class InputStringClass { //enter each string to sort
	private String[] input12 = new String[100];
	boolean check = false;
	int count;
	
	public void runInputString(int no1) {
		do {
			check = true;
			if(count < no1) {
				String input1 = JOptionPane.showInputDialog("Enter your input");
				count++;
				System.out.print("Word " +count);
				input12[count-1] = input1;
				System.out.println("  is " +input12[count-1]);
				check = false;
			}//end if (count<n)
		}while(!check);
	}//end runInputString method
	
	public String[] get_String() {
		return input12;
	}//end getNumber method
}//end InputStringClass Class

class Operand {
	protected int[] input6;
	protected int num3;
	protected int type1;
	
	Operand(int[] input7, int num2, int type) {
		input6 = input7;
		num3 = num2;
		type1 = type;
	}//end Operand method
	
	void operation() {
	}//end operation method
}//end Operand Class

class InsertionSort extends Operand {
	int type;
	InsertionSort(int[] input8, int num1, int type) {
		super(input8,num1,type);
	}//end InsertionSort method
	
	public void operation() {
		for(int i = 1; i < num3; i++) {
			int temp = input6[i];
			int j;
			for(j = i-1; j >= 0; j--) {
				if(input6[j] <= temp) break;
				input6[j+1] = input6[j];
			}
			input6[j+1] = temp;
		}
		System.out.print("\n");
		if(type1 == 1)
			for(int ii = 0; ii < num3; ii++)
				System.out.println(input6[ii]);
		else
			for(int ii = num3-1; ii >= 0; ii--)
				System.out.println(input6[ii]);
	}//end Operation method(override method)
}//end InsertionSort Class

class HeapSort extends Operand {
	HeapSort(int[] input8, int num1, int type) {
		super(input8,num1,type);
	}//end input6Sort method
	
	void operation() {
		int i, temp;
		for(i = (num3/2)-1; i >= 0; i++)
			siftDown(input6,i,num3);
		for(i = num3-1; i >= 1; i--) {
			temp = input6[0];
			input6[0] = input6[i];
			input6[i] = temp;
			siftDown(input6,0,i-1);
		}//end for
		System.out.print("\n");
		if(type1 == 1)
			for(int ii = 0; ii < num3; ii++)
				System.out.println(input6[ii]);
		else
			for(int ii = num3-1; ii >= 0; ii--)
				System.out.println(input6[ii]);
	}//end method operation()
	
	void siftDown(int input6[], int root, int bottom) {
		boolean done = false;
		int maxChild, temp;
		while((root * 2 <= bottom) && (!done)) {
			if(root * 2 == bottom)
				maxChild = root * 2;
			else if(input6[root*2] > input6[root*2 + 1])
				maxChild = root * 2;
			else
				maxChild = root * 2 + 1;
			
			if(input6[root] < input6[maxChild]) {
				temp = input6[root];
				input6[root] = input6[maxChild];
				input6[maxChild] = temp;
				root = maxChild;
			}//end if(input6[root]... loop
			else
				done = true;
		}//end while(root*2 <= bottom) loop
	}//end operation method(override method)
}//end HeapSort Class

class ShellSort extends Operand {
	ShellSort(int[] input8, int num1, int type) {
		super(input8,num1,type);
	}//end ShellSort method
	
	void operation() {
		int i, j, increment, temp;
		increment = 3;
		while(increment > 0) {
			for(i = 0; i < num3; i++) {
				j = i;
				temp = input6[i];
				while((j >= increment) && (input6[j-increment] > temp)) {
					input6[j] = input6[j - increment];
					j = j - increment;
				}//end while(j >= increment) loop
				input6[j] = temp;
			}//end for (i=o)
			if(increment/2 != 0)
				increment = increment/2;
			else if(increment ==1)
				increment = 0;
			else
				increment = 1;
		}//end while(increment=0
		System.out.print("\n");
		if(type1 == 1)
			for(j = 0; j < num3; j++)
				System.out.println(input6[j]);
		else
			for(int ii = num3-1 ; ii >= 0; ii--)
				System.out.println(input6[ii]);
	}//end operation method(override method)
}//end ShellSort class

class SortString {
	public void sort_string(String[] string2, int no2, int type) {
		String temp = "";
		for(int i = 0; i < no2; i++) {
			for(int j = i+1; j < no2; j++) {
				if(string2[i].compareTo(string2[j]) > 0) {
					temp = string2[i];
					string2[i] = string2[j];
					string2[j] = temp;
				}//end if(string2[i].compareTo(string2[j] > 0)
			}//end for(int j...) loop
		}//end for(int i...) loop
		if(type == 1) {
			System.out.println("\nThe result of sorting is\n");
			for(int k = 0; k < no2; k++)
				System.out.println(string2[k]);
			System.exit(0);
		}
		else {
			System.out.println("\nThe Result of sorting is\n");
			for(int k = no2-1; k >= 0; k--)
				System.out.println(string2[k]);
			System.exit(0);
		}
	}//end sort_string method
}//end SortString Class
