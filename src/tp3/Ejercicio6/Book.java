package tp3.Ejercicio6;

public class Book{
    int key;
    Book left, right;
    String title, author;
    int quantity, yearOfPublic;
    List<String> genders;

    Book(int key, String title, String author, int yearOfPublic, int quantity){
        this.key = key;
        this.left = null;
        this.right = null;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.yearOfPublic = yearOfPublic;
        this.genders = new ArrayList<String>();
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Book getLeft() {
        return left;
    }

    public void setLeft(Book left) {
        this.left = left;
    }

    public Book getRight() {
        return right;
    }

    public void setRight(Book right) {
        this.right = right;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getYearOfPublic() {
        return yearOfPublic;
    }

    public void setYearOfPublic(int yearOfPublic) {
        this.yearOfPublic = yearOfPublic;
    }

}