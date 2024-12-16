import java.util.*;
class bank{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer Name:");
        String name = sc.nextLine();
        System.out.println("Enter Customer ID:");
        int id =sc.nextInt();
        bankingapplication t = new bankingapplication(name,id);
        t.menu();
    }
}
class bankingapplication
{
    String cname;
    int cid;
    int balance;
    int previoustransaction;
    bankingapplication(String cname,int cid)
    {
        this.cname=cname;
        this.cid=cid;
    }
    public void deposit(int amount)
    {
        if(amount>0)
        {
            balance+=amount;
            previoustransaction=amount;
        }
    }
    public void withdraw(int amount)
    {
        if(amount>0)
        {
            if(amount<=balance)
            {
                balance-=amount;
                previoustransaction=-amount;
            }
        }else{
            System.out.println("Your balance is insufficient");
        }
    }
    public void getprevioustransactions()
    {
        if(previoustransaction>0)
        {
            System.out.println("Credited :"+previoustransaction);
        }else if(previoustransaction<0)
        {
            System.out.println("Debited :"+previoustransaction);
        }else{
            System.out.println("NO Transaction Occured");
        }
    }
    void menu(){
        System.out.println("Enter Option :-");
        char option ='\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Your name is : "+cname);
        System.out.println("Your cid is :"+cid);
        System.out.println(" A. Deposit");
        System.out.println(" B. Withdraw");
        System.out.println(" C. Previous transaction");
        System.out.println(" D. Total Balance");
        System.out.println(" E. Exit");
        do{
            option=Character.toUpperCase(sc.next().charAt(0));
            switch(option)
            {
                case 'A':
                    System.out.println("Enter amount");
                    int amount = sc.nextInt();
                    System.out.println("=======================");
                    deposit(amount);
                    System.out.println("Amount Credited :"+previoustransaction);
                    System.out.println("=======================");
                    break;
                case 'B':
                    System.out.println("Enter amount");
                    int amount1 = sc.nextInt();
                    System.out.println("=======================");
                    withdraw(amount1);
                    System.out.println("Amount Debited :"+previoustransaction);
                    System.out.println("=======================");
                    break;
                case 'C':
                    System.out.println("=======================");
                    System.out.println("Your previous transaction");
                    getprevioustransactions();
                    System.out.println("=======================");
                    break;
                case 'D':
                    System.out.println("=======================");
                    System.out.println("Total Balance is :"+balance);
                    System.out.println("=======================");
                    break;
                case 'E':
                    System.out.println("=======================");
                    System.out.println("Exiting your application");
                    System.out.println("=======================");
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }while(option!='E');
    }
}
/*
Enter Customer Name:
sumanthi
Enter Customer ID:
3058
Enter Option :-        
Your name is : sumanthi
Your cid is :3058       
 A. Deposit
 B. Withdraw
 C. Previous transaction
 D. Total Balance       
 E. Exit
a 
Enter amount
10000
=======================
Amount Credited :10000
=======================
b
Enter amount
200
=======================
Amount Debited :-200
=======================
b
Enter amount
5000
=======================
Amount Debited :-5000
=======================
c
=======================
Your previous transaction
Debited :-5000
=======================
d
=======================
Total Balance is :4800
=======================
e
=======================
Exiting your application
=======================
*/