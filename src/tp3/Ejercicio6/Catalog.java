package tp3.Ejercicio6;

public class Catalog {
    Book root;


    Catalog(){
        this.root = null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void addBook(int key, String title, String author, int yearOfPublic, int quantity){
        Book book = new Book(key, title, author, yearOfPublic, quantity);
        if(this.isEmpty())
            this.root = book;
        else
            addBook(book, this.root);
    }

    private void addBook(Book actual, Book father){
        if(actual.getKey() < father.getKey()){
            if(father.getLeft() == null)
                father.setLeft(actual);
            else
                addBook(actual, father.getLeft());
        }
        else if(actual.getKey() > father.getKey()){
            if(father.getRight() == null)
                father.setRight(actual);
            else
                addBook(actual, father.getRight());
        }
    }

    public int getQuantityOfBooksById(int id){
        if(this.isEmpty())
            return 0;
        return getQuantityOfBooksById(id, this.root);
    }

    private int getQuantityOfBooksById(int id, Book actual){
        if(actual != null){
            if(id < actual.getKey())
                return getQuantityOfBooksById(id, actual.getLeft());
            else if (id > actual.getKey())
                return getQuantityOfBooksById(id,actual.getRight());
            else
                return actual.getQuantity();
        }else
            return 0;
    }
   
    
}
