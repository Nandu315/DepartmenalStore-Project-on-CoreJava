package com;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

import CustomException.InvalidChoiceException;
import CustomException.InvalidQuantityException;

public class departmentalStore 
{

	Scanner sc=new Scanner(System.in);
	LinkedHashMap<Integer,Product> db = new LinkedHashMap<Integer,Product>();
	int totalBill=0;
	public void addProduct()
	{
		db.put(1,new Product("Chocolates",10,20));
		db.put(2,new Product("Ice-Cream",20,15));
		db.put(3,new Product("Biscuits",35,10));
	}
	public void displayProduct()
	{
		Set<Integer>keys=db.keySet();
		for(int key:keys)
		{
			Product p=db.get(key);
			System.out.println("Enter "+key+" to order "+p.getName());
			System.out.println("Available Quantity:"+p.getQuantity());
			System.out.println(" Cost:"+p.getCost());
			System.out.println("-----------------------");
		}
	}
	public void buyProduct()
	{
		System.out.println("Enter Choice:");
		int choice=sc.nextInt();//choice->key
		Product p=db.get(choice);//getting the product based on key
		if(p!=null)
		{
			System.out.println("Enter quantity:");
			int qnty=sc.nextInt();
			if(qnty<=p.getQuantity())
			{
				int productCost=qnty*p.getCost();//current cost
				totalBill = totalBill+productCost;//totalbill+=productcost
				p.setQuantity(p.getQuantity()-qnty);
				System.out.println("Ordered "+qnty+" "+p.getName()+" at the cost of Rs."+productCost);
				System.out.println("Total Bill as of now: "+totalBill);
			}
			else
			{
				try
				{
					throw new InvalidQuantityException("Invalid Quantity "+p.getName()+" are not Available");
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		else
		{
			try
			{
				throw new InvalidChoiceException("Kindly Enter Valid Choice");
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	public void checkOut()
	{
		System.out.println("Total Bill: Rs."+totalBill);
		System.out.println("Thank You for Shopping");
	}

}
