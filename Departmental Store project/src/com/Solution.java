package com;

import java.util.Scanner;

public class Solution 
{
	public static void main(String[] args) 
	{
		
		System.out.println("Welcome to XYZ Departmenta Store");
		System.out.println("********************************");
		Scanner sc=new Scanner(System.in);
		departmentalStore d=new departmentalStore ();
		d.addProduct();
		int choice=1;
		while(choice==1)
		{
		d.displayProduct();
		d.buyProduct();
		System.out.println("==========================");
		System.out.println("Enter 1 to Continue or any number to checkOut");
		choice=sc.nextInt();
		}
		d.checkOut();
		
	}

}
