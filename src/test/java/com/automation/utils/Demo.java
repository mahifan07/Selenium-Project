package com.automation.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import org.testng.annotations.Test;

public class Demo {
	@Test
	public void countOccurence() {
		String str = "MS Dhoni";
		String lowerCaseString = str.toLowerCase();
		int count = 0;
		Map<Character, Integer> storeOccurence = new TreeMap<>();

		for (int i = 0; i < lowerCaseString.length(); i++) {
			if(lowerCaseString.charAt(i) == ' ') {
				continue;
			}
			for (int j = 0; j < lowerCaseString.length(); j++) {
				if (lowerCaseString.charAt(i) == lowerCaseString.charAt(j)) {
					count++;
				}
			}
			storeOccurence.put(lowerCaseString.charAt(i), count);
			count = 0;
		}

		for(Map.Entry<Character, Integer> entry : storeOccurence.entrySet()) {
			System.out.println(entry.getKey() + "::" + entry.getValue());
		}
	}

	@Test
	public void reverseStringUsingHashMap() {
		String str = "Sandip";
		Map<Integer, Character> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			map.put(i, str.charAt(i));
		}

		StringBuffer stbfr = new StringBuffer();
		for (int i = str.length() - 1 ; i >= 0; i--) {
			stbfr.append(map.get(i));
		}
		System.out.println("reverseStringUsingHashMap : " + stbfr);
	}

	@Test
	public void stringLengthWithoutLengthFunction() {
		String str = "Sandip";
		int count = 0;

		for(char ch : str.toCharArray()) {
			count++;
			System.out.println(ch);
		}

		System.out.println("String length is : "+ count);
	}

	@Test
	public void countLettersDigitsSymbols() {
		String str = "Automat@123ion,";
		char[] ch = str.toCharArray();
		int digitCount = 0, letterCount = 0, symbolsCount = 0;

		for (char element : ch) {
			if(Character.isDigit(element)) {
				digitCount++;
			}else if(Character.isLetter(element)) {
				letterCount++;
			}else {
				symbolsCount++;
			}
		}

		System.out.println("Count of digits is : "+digitCount);
		System.out.println("Count of letters is : "+letterCount);
		System.out.println("Count of symbols is : "+symbolsCount);
	}

	@Test
	public void findDuplicateElements() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 9, 8, 7, 6, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 7, 8, 9, 0, 9, 8, 7, 8,
				9, 0, 9, 8, 9, 0, 9, 0 };
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count >= 2) {
				if (set.add(arr[i])) {
					map.put(i, arr[i]);
					System.out.println("Count of "+ arr[i] + " is : "+ count);
					count = 0;
				}
			} else {
				count = 0;
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "::" + entry.getValue());
		}
	}

	@Test
	public void descendingArray() {
		int[] array = {8,5,1,9,3};
		int count = (array.length)-1;
		//System.out.println(count);

		Set<Integer> set = new TreeSet<>();
		for(int element: array) {
			set.add(element);
		}

		for(int element : set) {
			//System.out.println(element);
			array[count] = element;
			count--;
		}

		for(int element: array) {
			System.out.println(element);
		}

		/*for(int i=(set.size()-1); i>= 0 ; i--) {
           array[count] = set
		}*/
	}

	@Test
	public void reverseSLString() {
		String string ="Java is Beautiful programming";
		String[] stringArray = string.split(" ");
		String updatedString = "";
		List<String> list = new ArrayList<>();
		int count = 1;
		int arrayCount = 0;

		Map<Integer, String> map = new TreeMap<>();
		for(String string1: stringArray) {
			int length = string1.length();
			map.put(length, string1);
		}

		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" +++ "+entry.getValue());
			if(count == 1 || count == map.size()) {
				list.add(entry.getValue());
			}
			count++;
		}

		for(String string1: stringArray) {
			if(list.contains(string1)) {
				String revString = Demo.reverseString(string1);
				stringArray[arrayCount] = revString;
			}
			arrayCount++;
		}

		for(String string1: stringArray) {
			//System.out.println(string1);
			updatedString = updatedString + string1;
			updatedString = updatedString + " ";
		}

		System.out.println(updatedString);

	}

	private static String reverseString(String string1) {
		String revString = "";

		for (int i = (string1.length()-1); i >= 0; i--) {
			revString = revString + string1.charAt(i);
		}		
		//System.out.println(revString);
		return revString;
	}

	@Test
	public void countCharacterOccurence() {
		String str = "Automation";
		String strInLowerCase = str.toLowerCase();
		Map<Character, Integer> map = new TreeMap<>();
		for(int i=0; i<strInLowerCase.length(); i++) {
			map.put(strInLowerCase.charAt(i), map.getOrDefault(strInLowerCase.charAt(i), 0)+1);
		}

		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" ___ "+entry.getValue());
		}

	}

	@Test
	public void findMostFrequentCharacter() {
		String str = "Sandip Bandal";
		String lowerCaseStr = str.toLowerCase();
		Map<Character, Integer> map = new TreeMap<>();
		int count = 0;
		boolean flag = false;
		char frequentChar = 'a';

		for (int i = 0; i < lowerCaseStr.length(); i++) {
			if(lowerCaseStr.charAt(i) == ' ') {
				continue;
			}else {
				map.put(lowerCaseStr.charAt(i), map.getOrDefault(lowerCaseStr.charAt(i), 0)+1);
			}
		}

		Iterator<Map.Entry<Character, Integer>> itr = map.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Character, Integer> entry = itr.next();
			System.out.println(entry.getKey()+" === "+entry.getValue());
			if(count<entry.getValue()) {
				count = entry.getValue();
			}
		}

		Iterator<Map.Entry<Character, Integer>> itr1 = map.entrySet().iterator();
		while(itr1.hasNext()){
			Map.Entry<Character, Integer> entry = itr1.next();
			if(entry.getValue() == count) {
				frequentChar = entry.getKey();
				flag = true;
				continue;
			}
		}

		if(flag) {
			System.out.println(frequentChar +" is the character with the highest frequency");
		}else {
			System.out.println("All characters are equally frequent");
		}
	}

	@Test
	public void sortedMap() {
		SortedMap<Integer, String> students = new TreeMap<>();

		students.put(103, "Ravi");
		students.put(101, "Amit");
		students.put(102, "Pooja");

		System.out.println("Students sorted by roll number:");
		for (Map.Entry<Integer, String> entry : students.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

		// Extra methods from SortedMap
		System.out.println("First Key: " + students.firstKey());   // 101
		System.out.println("Last Key: " + students.lastKey());     // 103
		System.out.println("SubMap (101 to 103): " + students.subMap(101, 103)); // 101, 102
	}

	//0,1,1,2,3,5,8,13

	@Test
	public void fibbonacci() {
		int first = 0;
		int second  = 1;

		for(int i=0; i<10; i++) {
			if(i==0) {
				System.out.println(first);
			}
			else {	
				int temp = second;
				System.out.println(temp);
				second = first+second;
				first = temp;
			}
		}
	}

	//i/p-int []arr={1,0,2,0,3,0}
	//o/p-int arr[]={1,2,3,0,0,0}

	@Test
	public void test() {
		int arr[]= {1,0,2,0,3,0};
		int count = 0;

		for(int i=0; i<arr.length;i++) {
			if(arr[i]!=0) {
				arr[count] = arr[i];
				count++;
			}
		}

		for(int i=count; i<arr.length;i++) {
			arr[i] = 0;
			count++;
		}

		for(int i : arr) {
			System.out.println(i);
		}
	}

	@Test
	public void secondLargest() {
		int arr[] = {1,2,3,4,5,9,8,7,6};
		int count = 1;

		Set<Integer> set = new TreeSet<>();
		for(int digit : arr) {
			set.add(digit);
		}

		int largest = set.size() - 1;
		for(int element: set){
			if(count==largest) {
				System.out.println(element);
			}
			count++;
		}
	}

	@Test
	public void removeDuplicatesFromList(){
		List<Integer> list = new ArrayList<>();
		List<Integer> updatedList = new ArrayList<>();
		for(int i=0; i<10; i++) {
			int random = (int) (Math.random()*10)+1;
			//System.out.println(random);
			list.add(random);
		}

		Map<Integer, Integer> map = new TreeMap<>();
		for(int digit : list) {
			map.put(digit, map.getOrDefault(digit, 0)+1);
		}

		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			System.out.println(entry.getKey()+" ==== "+entry.getValue());
			if(!(entry.getValue()>1)) {
				updatedList.add(entry.getKey());
			}
		}

		for(int digit : updatedList) {
			System.out.println("___"+digit);
		}

	}	

	@Test
	public void reverseString(){
		String str = "Sandip Bandal";
		String reversedString = "";
		//System.out.println(str);
		for(int i=str.length()-1; i>=0;i--) {
			//System.out.println(str.charAt(i));
			reversedString = reversedString + str.charAt(i);
		}
		System.out.println(reversedString);

		StringBuilder stbr = new StringBuilder(str).reverse();
		System.out.println(stbr);
	}

	@Test
	public void checkPalindrome(){
		String str = "madam";
		String reversed = new StringBuilder(str).reverse().toString();
		if(str.equalsIgnoreCase(reversed)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not Palindrome");
		}
	}

	//0,1,1,2,3,5

	@Test
	public void fibboncci() {
		int first = 0;
		int second = 1;
		int temp;
		System.out.println(first);
		System.out.println(second);
		for(int i=0; i<10;i++) {
			temp = first+second;
			System.out.println(temp);
			first = second;                  
			second = temp;      
		}
	}

	@Test
	public void factorial() {
		int number = 5;
		int factorial = 1;
		for(int i=number; i>=1;i--) {
			factorial *= i;
		}
		System.out.println(factorial);
	}

	@Test
	public void isPrime() {
		int number = 7;
		int count = 0;
		for (int i = 1; i <= number; i++) {
			if(number%i==0) {
				count++;
			}
		}
		if(count==2) {
			System.out.println("Number is prime");
		}else {
			System.out.println("Number is not prime");
		}
	}

	@Test
	public void vowelsConsonantCount() {
		String str= "Sandip Bandal";
		int vowelsCount = 0;
		int consonantCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if(!(str.charAt(i) == ' ')) {
				if(str.charAt(i) =='a' || str.charAt(i) =='e' ||str.charAt(i) =='i' ||str.charAt(i) =='o' ||str.charAt(i) =='u' ||str.charAt(i) =='A' ||str.charAt(i) =='E' ||str.charAt(i) =='I' ||str.charAt(i) =='O' ||str.charAt(i) =='U') {
					vowelsCount++;
				}else {
					consonantCount++;
				}
			}
		}
		System.out.println("Count of vowels is : "+vowelsCount);
		System.out.println("Count of consonant is : "+consonantCount);
	}

	@Test
	public void sortArray() {
		int arr[] = {1,2,3,4,5,9,8,7,6};
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	@Test
	public void mergeArrays() {
		int[] arr1= {1,2,4,6};
		int[] arr2= {3,5,7,8,9};
		int[] mergedArray = new int[arr1.length+arr2.length];
		int count = 0;
		
		for (int i : arr1) {
			mergedArray[count] = i;
			count++;
		}
		
		for (int i : arr2) {
			mergedArray[count] = i;
			count++;
		}
		
		for (int i : mergedArray) {
			System.out.println(i);
		}
	}

	@Test
    public void armstrongNumber() {
    	int number = 153;
        int sum = 0;
        int temp = 0;
    	while(number!=0) {
    		temp = number%10;
    		sum = sum+ (temp*temp*temp);
    		number = number/10;
    	}
    	System.out.println(sum);
    }

	@Test
    public void checkAnagram() {
    	String str1 = "Sandip";
    	String str2 = "kiran";
    	
    	char[] str1toCharArray = str1.toLowerCase().toCharArray();
    	char[] str2toCharArray = str2.toLowerCase().toCharArray();
    	
    	Arrays.sort(str1toCharArray);
    	Arrays.sort(str2toCharArray);
    	
    	System.out.println(Arrays.equals(str1toCharArray, str2toCharArray));
     }

	@Test
	public void countDigits() {
		int number = 123451345;
		int count = 0;
//		String numberInString = String.valueOf(number);
//		int count = numberInString.length();
//		System.out.println(count);
		while(number>0) {
			number = number/10;
			count++;
		}
		System.out.println(count);
	}

	@Test
	public void removeDuplicates() {
		String str = "This is a test and this test is simple";
		StringBuilder sb = new StringBuilder();
		String[] strArray = str.split(" ");
		Set<String> set = new HashSet<>();
		for(String input: strArray) {
			set.add(input.toLowerCase());
		}
		for(String input: set) {
			sb.append(input).append(" ");
		}
		System.out.println(sb);
	}
	
	@Test
	public void findDuplicates() {
		int[] arr = {1, 2, 3, 2, 4, 5, 1};
		Set<Integer> set = new TreeSet<>();
		for(int input: arr){
			if(set.add(input)) {
				continue;
			}else {
				System.out.println("Duplicate element: "+input);
			}
		}
	}

   @Test
   public void checkString() {
	   String str= " Sandip@1110 Bandal@1999 ";
	   System.out.println(str);
	   System.out.println(str.trim());
	   char[] charArr = str.toCharArray();
	   int digit = 0;
	   int vowel = 0;
	   int consonant = 0;
	   int space = 0;
	   for(char ch : charArr) {
		   if(Character.isDigit(ch)) {
			   digit++;
		   }else if(Character.isLetter(ch)) {
			   if(ch =='a' || ch =='e' ||ch =='i' ||ch =='o' ||ch =='u' ||ch =='A' ||ch =='E' ||ch =='I' ||ch =='O' ||ch =='U') {
					vowel++;
				}else {
					consonant++;
				}
		   }else if(ch == ' ') {
			 space++;	
			}
	   }
	   System.out.println(digit+" "+vowel+" "+consonant+" "+space);
   }
   
   @Test
   public void nonRepeatedChar() {
	   String str = "success";
	   
//	   char[] charArray = str.toCharArray();
//	   Arrays.sort(charArray);
//	   for(char ch : charArray) {
//		   System.out.println(ch);
//	   }
	   
	   
	   Map<Character,Integer> map = new LinkedHashMap<>();
	   for (int i = 0; i < str.length(); i++) {
		map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
	   }
	   
	   for(Map.Entry<Character, Integer> entry : map.entrySet()) {
		   if(entry.getValue() == 1) {
			   System.out.println(entry.getKey()+" is the first non repetitave character.");
			   break;
		   } 
	   }
   }
   
   @Test
   public void stringToInt() {
	   String input = "-1234";
       int result = 0;
       int sign = 1;
       int i = 0;

       // Handle negative numbers
       if (input.charAt(0) == '-') {
           sign = -1;
           i = 1;
       }

       for (; i < input.length(); i++) {
           char c = input.charAt(i);

           // Check if the character is a digit
           if (c >= '0' && c <= '9') {
               result = result * 10 + (c - '0');
           } else {
               throw new IllegalArgumentException("Invalid character in number: " + c);
           }
       }
       
       System.out.println("Converted integer: " + result * sign);
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   











}
