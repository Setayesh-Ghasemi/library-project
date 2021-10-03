public class Member {

    String name;
    int birth;
    int id;
    static int idBase = 30; //
    Book books[];
    int countBook=0; //

    public Member(String name, int birth) {
        this.name = name;
        this.birth = birth;
        this.id = idBase++;
        books = new Book[5];
    }
    public String print(){ //to string
        String s=name+" "+id+"[";

        for (int i = 0; i < 5; i++) {
            if(books[i] == null)
                break;
            if(i!=0)
                s+=" - ";
            if(books[i]!=null)
                s+=books[i].print1();
        }
        return s+"]";
    }

    public void addBook(Book b){
        books[countBook] = b;
        countBook++;
    }

    public void returnBook(Book b){
        int index=-1;
        M:  for (int i = 0; i < countBook; i++) {
            if(books[i].id == b.id){
                for (int j = i; j < 4; j++) {
                    books[j] = books[j+1];
                }
                books[countBook] = null;
            }
            countBook--;
            break M;
        }
    }
}
