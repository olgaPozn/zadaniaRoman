package zadaniaDodatkowe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//TODO : METODY PUBLIC (zewnetrzne)
//TODO : JUNIT
//TODO : NAPRAWA METODY arePermutations
public class ArraysAndStrings {
	//<1.1
	/*
	 * implement an algorithm to determine if a string has all unique characters.
	 */
	public boolean uniqueCharactersBit(String str){
		int checker = 0;
		
		for(int i = 0; i < str.length(); i++){
			int bitAtIndex = str.charAt(i) - 'a';
			if((checker & (1 << bitAtIndex)) > 0)
				return false;
			checker = checker | (1 << bitAtIndex);
		}
		return true;	
	}
	
	public void displayUniqueCharacters(String input){
		ArraysAndStrings test = new ArraysAndStrings();
		if(test.uniqueCharactersBit(input))
			System.out.println("unique character containing string");
		else
		{
			System.out.println("duplicate character containing string");
		}
	}
	//1.1/>
	
	//<1.2
	/*
	 * given the two strings, write a method to decide if one is a permutation of the other.
	 */
	public boolean arePermutations(String s1, String s2){
		Map<Character,Integer> permutationMap = new HashMap<Character,Integer>();
		
		for (int i = 0; i != s1.length(); i++){
			char c = s1.charAt(i);
			if (permutationMap.containsKey(c)){
				permutationMap.put(c, permutationMap.get(c) + 1);
			}
			else
			{
				permutationMap.put(c, 1);
			}
				
		}
		
		for (int i = 0; i != s2.length(); i++){
			char c = s2.charAt(i);
			if (permutationMap.containsKey(c)){
				permutationMap.put(c, permutationMap.get(c) + 1);
				if (permutationMap.get(c) == 0) {
					permutationMap.remove(c);
				}
			}
			else
			{
				return false;
			}	
		};
		System.out.println(permutationMap.toString());
		return true;
	}
	
	//1.2/>
	
	//<1.3
	/*
	 * write a method to replace all spaces in a string with "%20". You may assume that the string has sufficient
	 * space at the end to hold the additional characters, and that You are given the "true" length of the string.
	 * 
	 */
	
	public String URLifyString(String s){
		
		char array[] = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < array.length; i++){
			if (array[i] == 32)
				sb.append("%20");
			else
			{
				sb.append(array[i]);
			}
		}
		System.out.println(sb);
		return sb.toString();
	}	
	
	//1.3/>
	
	//<1.5
	/*
	 * there are three types of edits that can be performed on strings : insert a character, remove a character or replace a character.
	 * Given two strings write a function to check if they are one edit or zero edits away
	 * I DONT UNDERSTAND THIS TASK
	 */
	//1.5/>
	
	//<1.6
	/*
	 * implement a method to perform basic string compression using the counts of repeated characters. For example, the string
	 * aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller than the original string, your method should return the original string. 
	 * You can assume the string has only uppercase and lowercase letters (a-z),
	 */
	
	public String stringCompression(String s){
		
		int initialLength = s.length();
		String compressedString = ""; // fixed mistake of putting space in front of the result string
		char lastChar = s.charAt(0);
		int charCount = 1;
		
		if (s.length() < 3){
			System.out.println(s);
			return s;
			}
		else
		{
			for (int i = 1; i < initialLength; i++){
				if (s.charAt(i) == lastChar)
					charCount ++;
				else
				{
					compressedString += Character.toString(lastChar) + Integer.toString(charCount);
					lastChar = s.charAt(i);
					charCount = 1;
				}
			}
			compressedString += Character.toString(lastChar) + Integer.toString(charCount);
			if (compressedString.length() < initialLength)
				System.out.println(compressedString);
				return compressedString;
		}
	}
	//1.6/>
	
	
	//<1.7
	/*
	 * Given an image represented by an NxN matrix, where each pixel in the image is n = 4 bytes, 
	 * write a method to rotate the image by 90 degrees. Can you do this in place?
	 * each pixel in the image is 4 bytes - that means that the matrix is 4x4? I assumed so, therefore n = 4.
	 */
	
	public void rotateMatrix90Degree(int matrix[][],int n){
		
		int matrixLength = n - 1;
		
		for (int i = 0; i <= (matrixLength/2); i++){
			for (int j = i; j < matrixLength-i; j++){
				int firstSwap = matrix[i][j];
				int secondSwap = matrix[j][matrixLength-i];
				int thirdSwap = matrix[matrixLength-i][matrixLength-j];
				int fourthSwap = matrix[matrixLength-j][i];
				
				matrix[j][matrixLength-i] = firstSwap;
				matrix[matrixLength-i][matrixLength-j] = secondSwap;
				matrix[matrixLength-j][i] = thirdSwap;
				matrix[i][j] = fourthSwap;		
			}
		}
	}
		
	public static void printMatrix(int matrix[][]){
	
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//1.7/>
	
	//<1.8
	/*
	 * Write an algorithm such that if an element in an MxN matrix is 0 its entire row and column are set to 0
	 */
	
	public void setMatrixValuesToZero(int [][] matrix, int a, int b){
		
		int row [] = new int [a];
		int column [] = new int [b]; // can i design this algorithm size sensitive any other way??
		
		for (int i = 0 ; i < a; i++){
			row[i] = 1;
		}
		
		for (int i = 0; i < b; i++){
			column[i] = 1;
		}
		
		for (int i = 0; i < a; i++){
			for (int j = 0; j < b; j++){	
				if(matrix[i][j] == 0){	
					row[i] = 0;
					column[j] = 0;
				}
			}
		}
		
		for (int i = 0; i < a; i++){
			for (int j = 0; j < b; j++){
				if (row[i] == 0 || column[j] == 0){
					matrix[i][j] = 0;
				}
					
			}
		}
		
		for (int i = 0; i < a; i++){
			for (int j = 0; j < b; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	//1.8/>
	
	//<1.9
	/*
	 * Assume you have a method isSubstring which checks if one word is a substring of the other one. Given two strings s1 and s2 write
	 * code to check if s2 is a rotation of s1 using only one call to isSubstring.
	 * 
	 */
	
	public boolean isRotation(String s1, String s2){
		int s1len = s1.length();
		if (s1len == s2.length()){
			String s1s1 = s1 + s1;
			return isSubstring(s1s1,s2);
		}else
		{
			return false;
		}
	}
	
	
	private static boolean isSubstring(String s1, String s2){
		if(s1.contains(s2)){
			System.out.println("substring noticed");
			return true;
		}else
		{
			System.out.println("substring unnnoticed");
			return false;
		}
	}
		
	//1.9/>
	
	//<Rozwiazania Review>
	
	/*String str = "aad sdf sdf fg";
	str = str.replaceAll(" ", "%20");
	System.out.println(str);


	String str2 = "abBcdfgr";
	Set<Character> resultSet = new HashSet<>();
	for (int i = 0; i < str2.length(); i++) {
	    resultSet.add(str2.charAt(i));
	}
	System.out.println(str2.length()==resultSet.size());

	String s1 = "hello";
	String s2 = "loleh";
	System.out.println(isPerm(s1, s2));


	private boolean isPerm(String s1, String s2) {
	    if (s1.length() == s2.length()) {
	        char s1Tmp[] = s1.toCharArray();
	        Arrays.sort(s1Tmp);
	        char s2Tmp[] = s2.toCharArray();
	        Arrays.sort(s2Tmp);

	        for (int i = 0; i < s1Tmp.length; i++) {
	            if (!(s1Tmp[i] == s2Tmp[i])){
	                return false;
	            }
	        }
	        return true;
	    } else {
	        return false;
	    }
	}
*/
	public static void main (String args[]){
		displayUniqueCharacters("ab"); //<1.1/>
		System.out.println(arePermutations("hello","helol"));//<1.2/>
		URLifyString(" Hello   World My  Friend ");//<1.3/>
		stringCompression("aa");//<1.5/>
		//<1.7
		int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(matrix);
		rotateMatrix90Degree(matrix,4);
		printMatrix(matrix);
		//1.7/>
		//<1.8
		int [][] matrix2 = {{1,1,1,1},{1,0,1,1},{1,1,1,1}};
		setMatrixValuesToZero(matrix2,3,4);
		//1.8/>
		isRotation("sabc", "bcad"); //<1.9/>
}
}