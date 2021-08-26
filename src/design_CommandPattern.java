

//https://en.wikipedia.org/wiki/Command_pattern

class Document {
    String text ;
}

abstract class DocumentCommand {
    Document doc ;
    DocumentCommand(Document dc) {
        this.doc = dc ;
    }
    abstract void execute() ;
}

class addPicture extends DocumentCommand {
    String picture ;
    addPicture(Document dc, String pic) {
        super(dc) ;
        this.picture = pic;
    }
    public void execute() {
        doc.text += picture ;
    }
}

class deletePicture extends DocumentCommand {
    String picture ;


    deletePicture(Document dc, String pic) {
        super(dc);
        this.picture = pic;
    }
    void execute() {
        doc.text = doc.text.replace("CAT-BROWN","\0");
    }
}

public class design_CommandPattern {
    public static void main(String[] args) {
        Document doc = new Document() ;
        addPicture add = new addPicture(doc, "CAT-BROWN") ;
        add.execute();
        System.out.println(doc.text);
        deletePicture del = new deletePicture(doc,"CAT-BROWN") ;
        del.execute();
        System.out.println(doc.text);
    }
}
