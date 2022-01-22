package MuleSoft;

import java.util.Scanner;

public class Movies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		Scanner sc= new Scanner(System.in);
		DBMoives db= new DBMoives();
		String movieName,actorName,directorName,releaseDate;
		do
		{
			System.out.println("Sql Curd Operations (Enter a number to proceed).");
			System.out.println("1. Insert Movie");
			System.out.println("2. Retrive Movies");
			System.out.println("3. Delete Movie");
			System.out.println("4. Update Movie");
			System.out.println("5. Exit");
			choice=sc.nextInt();
			if(choice==1)
			{
				sc.nextLine();
				System.out.println("Movie Name :");
				movieName= sc.nextLine();
				
				System.out.println("Lead Actor/Actress Name :");
				actorName= sc.nextLine();
				
				System.out.println("Director Name :");
				directorName= sc.nextLine();
				
				System.out.println("Release Date :");
				releaseDate= sc.nextLine();
				db.Insert(movieName, actorName, directorName, releaseDate);
			}else if(choice ==2)
			{
				db.Retrive();
			}else if (choice ==3)
			{
				sc.nextLine();
				System.out.println("Enter movie name which you want to delete");
				movieName=sc.nextLine();
				db.delete(movieName);
			}else if (choice ==4 )
			{	
				sc.nextLine();
				System.out.println("Enter movie name whose data you want to update");
				movieName = sc.nextLine();
				System.out.println("Enter Data");
				System.out.println("Lead Actor/Actress Name :");
				actorName= sc.nextLine();
				
				System.out.println("Director Name :");
				directorName= sc.nextLine();
				
				System.out.println("Release Date :");
				releaseDate= sc.nextLine();
				
				db.update(movieName, actorName, directorName, releaseDate);
			}
			

			
		}while(choice!=5);


		sc.close();
	}

}
