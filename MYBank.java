package com.banking;

import java.util.Scanner;

class Customer
{
	protected int Accno,Amount = 0;
	protected String Name, Address, email;
	protected int dob, phno;
	protected String AccntType;
	
	public Customer()
	{
		System.out.print("");
	}
	
	
	public Customer(int accno, String name, String address, String email, int dob, int phno, String accntType) {
		super();
		Accno = accno;
		Name = name;
		Address = address;
		this.email = email;
		this.dob = dob;
		this.phno = phno;
		AccntType = accntType;
	}




	public int getAccno() {
		return Accno;
	}


	public void setAccno(int accno) {
		Accno = accno;
	}


	public int getAmount() {
		return Amount;
	}


	public void setAmount(int amount) {
		Amount = amount;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getDob() {
		return dob;
	}


	public void setDob(int dob) {
		this.dob = dob;
	}


	public int getPhno() {
		return phno;
	}


	public void setPhno(int phno) {
		this.phno = phno;
	}


	public String getAccntType() {
		return AccntType;
	}


	public void setAccntType(String accntType) {
		AccntType = accntType;
	}


	public void CustomerDetailsDisplay()
	{
		System.out.println("Name : " + this.Name);
		System.out.println("Account NO : " + this.Accno);
		System.out.println("DOB : " + this.dob);
		System.out.println("Address : " + this.Address);
		System.out.println("Phone : " + this.phno);
		System.out.println("Email : " + this.email);
	}
	
}

class Account extends Customer
{
	private int Acnt;
	Scanner s = new Scanner(System.in);
	
	
	public void Accounts()
	{
		System.out.println("Choose the Account type");
		System.out.println("1.Savings Account\t 2.Current Account");
		Acnt = s.nextInt();
		switch(Acnt)
		{
			case 1 : SBOperations();
					break;
			//case 2 : CurrentAcOperations();
				//	break;
		}
	}
	
	public void SBOperations()
	{
		int op;
		System.out.println("Choose the Option\n 1.Deposit\t 2.Withdraw\t 2.Blance Enquiry\t 4.Account Details");
		op = s.nextInt();
		switch(op)
		{
			case 1 : deposit();
					break;
			case 2 : Withdraw();
					break;
			case 3 : BlanceEnquiry();
					break;
			case 4 : CustomerDetailsDisplay();
					break;
		}
		
	}
	public void deposit()
	{
		int Damount = 0; // deposit amount
		System.out.println("Enter the Account Number");
		int accNo = s.nextInt();
		if(this.Accno == accNo)
		{
			System.out.println("Enter the amount to deposit");
			Damount = s.nextInt();
		}
		this.Amount = this.Amount + Damount;
	}
	public void Withdraw()
	{
		Scanner s = new Scanner(System.in);
		int NewAmount;
		System.out.println("Enter amount to be withdraw");
		NewAmount = s.nextInt();
		while(NewAmount >= this.Amount)
		{
			System.out.println("amount is insufficient");
			System.out.println("Enter the amount");
			NewAmount = s.nextInt();
		}
		if(NewAmount <= this.Amount)
		{
			this.Amount = this.Amount - NewAmount;
			System.out.println("The amount withdrwan successfully! " + NewAmount);
			System.out.println("Do you want to display the Blance (yes)y or (no)n");
			String inpt = s.next();
			if(inpt.equals("y"))
				BlanceEnquiry();
		}
				
	}
	public void BlanceEnquiry()
	{
		System.out.println("The available Blance is " + Amount);
	}
	
	public void NewDetails()
	{
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Customer Name : ");
		this.Name = s.next();
		System.out.println("Enter the Customer Account NO : ");
		this.Accno = s.nextInt();
		System.out.println("Enter the Customer DOB : ");
		this.dob = s.nextInt();
		System.out.println("Enter the Customer Address : ");
		this.Address = s.next();
		System.out.println(" Enter the CustomerPhone : ");
		this.phno = s.nextInt();
		System.out.println("Enter the Customer Email : ");
		this.email = s.next();
		System.out.println("Enter the Customer Account type : ");
		this.AccntType = s.next();
		Customer c = new Customer(Accno,Name,Address,email,dob,phno,"");
		
	}
	
	
}

class Admin
{
	Scanner s = new Scanner(System.in);
	private String userName = "Ananda"; 
	private String pass = "Anandam562";
	private String uname, upass;
	public Admin()
	{
		System.out.println("Welcome Admin");
	}
	
	public Admin(String userName, String pass) {
		this.userName = userName;
		this.pass = pass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void verify()
	{
		Scanner s = new Scanner(System.in);
		while((this.userName.equals(userName)))
		{
			if((this.userName.equals(userName)) && (this.pass.equals(pass)))
			{
				System.out.println("Successfully Loged in!");
				break;
			}
			/*else
			{
				System.out.println("The user name/ Password is incorrect");
				break;
			}
			System.out.println("Do you want exit press q or continue");
			String input = s.next();
			if(input.equals("q"))
			{
				System.exit(0);
			}
			*/
		}
		
	}
}

class AdminLogging extends Admin
{
	private String uname, upass;
	public void AdminLogin()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the User Name : ");
		uname = s.next();
		System.out.println("");
		System.out.println("Enter the Password : ");
		upass = s.next();
		System.out.println("");
		Admin a = new Admin(uname, upass);
	}
	
	public void AdminOperations()
	{
		Scanner s = new Scanner(System.in);
		AdminLogin();
		verify();
		int swt;
		System.out.println("1.Add Customer");
		swt = s.nextInt();
		switch(swt)
		{
			case 1 : Account a = new Account();
					a.NewDetails();
					break;
		}
	}
	
}


public class MYBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Customer c = new Customer();
		
		//c.NewDetails();
		//c.CustomerDetailsDisplay();
		Account A = new Account();
		AdminLogging AA = new AdminLogging();
		String input;
		System.out.println("Welcome to my Bank");
		do
		{
			System.out.println("1.User\t 2.Admin");
			int swt = s.nextInt();
			switch(swt)
			{
				case 1 : System.out.println("1.Account");
						A.Accounts();
						break;
				case 2 : //System.out.println("1.Add customer\t");
						AA.AdminOperations();
						
						break;
				default : System.out.println("Choose the Correct option");
						break;
				case 'q' : System.exit(0);
				
				
			}
			System.out.println("\n\nDo you want to continue?");
			input = s.next();
			
		}while(!(input.equals("q")));
		
	}

}
