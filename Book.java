
class Book{
    String title;
    String author;
    int yearPublished;
    Book(String title, String author, int yearPublished){
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    String getBookInfo(){
        return "\n"+title + "," + author + ","+yearPublished;
    }
    void printBookDetails(){
        System.out.printf("""
                Title: %s
                Author: %s
                Year Published: %d
                """,title,author,yearPublished);
    }
}

class PrintedBook extends Book{
    int numberOfPages;
    String publisher;
    int price;

    PrintedBook(String title, String author, int year, int numberOfPages, String publisher){
        super(title, author, year);
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.price = (int)(numberOfPages * 1.3);
    }
    PrintedBook(String title, String author, int year, int numberOfPages){
        super(title,author,year);
        this.numberOfPages = numberOfPages;
        this.publisher = "unknown";
        this.price = (int)(numberOfPages * 1.3);
    }

    @Override
    String getBookInfo(){
        return super.getBookInfo() + "," + numberOfPages + "," + publisher + "," + price;
    }
    @Override
    void printBookDetails(){
        System.out.println("\nPrinted Book Info:");
        super.printBookDetails();
        System.out.printf("""
                Publisher: %s
                Number of Pages: %d
                Price: %d som
                """,publisher,numberOfPages,price);
    }
    void bookType(){
        System.out.println("This is a printed book!");
    }

    void setPrice(int price){
        this.price = price;
    }
    void setPublisher(String publisher){
        this.publisher = publisher;
    }

    void printTheBook() {
        System.out.println("Printing the book...");
        for (int i = 1; i <= numberOfPages; i++) {
            try {
                Thread.sleep(500); // 0.5-second delay
            } catch (InterruptedException e) {
                e.printStackTrace(); // Handle the exception
            }
            System.out.printf("Printing page %d...%n", i);
        }
        System.out.println("Completed!");
    }


}


class EBook extends Book{
    double fileSizeMB;
    String fileFormat;
    int price;

    EBook(String title, String author, int year, double fileSizeMB, String fileFormat) {
        super(title, author, year);
        this.fileFormat = fileFormat;
        this.fileSizeMB = fileSizeMB;
        if (fileSizeMB > 99) this.price = 400;
        else this.price = 300;
    }

    EBook(String title, String author, int year, String fileFormat) {
        super(title,author,year);
        this.fileFormat = fileFormat;
        this.price = 400;
    }

    @Override
    String getBookInfo(){
        return super.getBookInfo() + String.format(",%.2f,%s,%d",fileSizeMB,fileFormat,price);
    }
    @Override
    void printBookDetails(){
        System.out.println("\nEBook Info:");
        super.printBookDetails();
        System.out.printf("""
                File Size: %.2f
                File Format: %s
                Price: %d som
                """,fileSizeMB,fileFormat,price);
    }
    void bookType(){
        System.out.println("This is an ebook!");
    }
    void setPrice(int price){
        this.price = price;
    }
    void setFileSizeMB(double sizeMB){
        this.fileSizeMB = sizeMB;
    }
}

class Main{
    public static void main(String[] args) {
        PrintedBook jamila = new PrintedBook("Jamila", "Gengiz Aitmatov",
                1958, 96, "Mansur Basma Uyu");

        EBook pap = new EBook("Pride and Prejudice",
                "Jane Austen", 1813, 20.86, "epub");

//        jamila.setPrice(350);
//        pap.setPrice(200);
//
//        System.out.println(jamila.getBookInfo());
//        jamila.printBookDetails();
//
//        System.out.println(pap.getBookInfo());
//        pap.printBookDetails();
//
//        jamila.printTheBook();
//
//        //OTHER CONSTRUCTORS
//        PrintedBook warAndPeace = new PrintedBook("War and Peace", "Lev Tolstoy",
//                1869, 1225);
//
//        EBook gatsby = new EBook("The Great Gatsby",
//                "F. Scott Fitzgerald", 1925, "pdf");
//
//        warAndPeace.setPrice(2500);
//        warAndPeace.setPublisher("Some Random Publisher");
//        gatsby.setFileSizeMB(25.0);
//
//        warAndPeace.printBookDetails();
//        gatsby.printBookDetails();
    }

}