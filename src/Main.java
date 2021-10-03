import java.util.Scanner;
public class Main {

    static int counterBook=0;
    static int counterMember=0;
    static Book books[] = new Book[50];
    static Member members[] = new Member[50];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String commands [] = new String[1000];
        String s="";

        int i=0;
        while ((s = in.nextLine()).compareTo("End") != 0){
            commands[i] = s;
            i++;
        }

        for (int j = 0; j < i; j++) {
            String array[] = commands[j].split(" ");

            switch (array[0]){
                case "addBook":
                    books[counterBook] = new Book(array[1],Integer.parseInt(array[2]));
                    counterBook++;
                    break;
                case "addMember":
                    members[counterMember] = new Member(array[1],Integer.parseInt(array[2]));
                    counterMember++;
                    break;
                case "get":
                    get(Integer.parseInt(array[1]),Integer.parseInt(array[2]));
                    break;
                case "return":
                    returnBook(Integer.parseInt(array[1]),Integer.parseInt(array[2]));
                    break;
                case "bookStat":
                    for (int k = 0; k < counterBook; k++) {
                        System.out.println(books[k].print2());
                    }
                    break;
                case "memberStat":
                    for (int k = 0; k < counterMember; k++) {
                        System.out.println(members[k].print());
                    }
                    break;
            }
        }
    }

    public static void get(int idMember, int idBook){
        int indexBook = -1;
        int indexMember = -1;

        for (int i = 0; i < counterBook; i++) {
            if(idBook==books[i].id){
                indexBook = i;
                break;
            }
        }

        for (int i = 0; i < counterMember; i++) {
            if(idMember==members[i].id){
                indexMember = i;
                break;
            }
        }

        if (indexBook == -1)
            System.out.println("Book not found.");
        else if(indexMember == -1)
            System.out.println("Member not found.");
        else if(members[indexMember].countBook>=5)
            System.out.println("MaxReached:"+members[indexMember].name+" "+idBook);
        else if(books[indexBook].count<=0)
            System.out.println("NotAvailable:"+books[indexBook].print1());
        else{
            members[indexMember].addBook(books[indexBook]);
        }
    }

    public static void returnBook(int idMember , int idBook){
        int indexBook = -1;
        int indexMember = -1;

        for (int i = 0; i < counterBook; i++) {
            if(idBook==books[i].id){
                indexBook = i;
                break;
            }
        }

        for (int i = 0; i < counterMember; i++) {
            if(idMember==members[i].id){
                indexMember = i;
                break;
            }
        }

        if (indexBook == -1)
            System.out.println("Book not found.");
        else if(indexMember == -1)
            System.out.println("Member not found.");
        else{
            members[indexMember].returnBook(books[indexBook]);
            books[indexBook].count++;
        }
    }
}