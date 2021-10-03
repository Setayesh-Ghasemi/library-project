public class Book {

    String name;
    int count;
    int id;
    public static int idBase = 1000; //

    public Book(String name, int count) {
        this.name = name;
        this.count = count;
        this.id = idBase++;
    }
    public String print1(){ //
        return name+" "+id;
    }
    public String print2(){ //
        return name+" "+id+" "+count;
    }
}
