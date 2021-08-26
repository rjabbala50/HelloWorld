
//Composite pattern


import java.util.ArrayList;
import java.util.List;

abstract class MenuComponent{
    String text ;
    MenuComponent() {
    }
    MenuComponent(String text) {
        this.text = text ;
    }
}
class MenuItem extends MenuComponent {
    MenuItem(String text) {
        super(text) ;
    }
}

class Menu extends MenuComponent {
    Menu(String text) {
        super(text) ;
    }
    List<MenuComponent> componentList = new ArrayList<MenuComponent>() ;
}

public class design_CompositePattern {

    public static void main(String[] args) {
        Menu file = new Menu("File") ;
        file.componentList.add(new MenuItem("Open"));
        file.componentList.add(new MenuItem("Save")) ;
        Menu recentFiles = new Menu("Recent") ;
        file.componentList.add(recentFiles) ;
        file.componentList.add(new MenuItem("Exit")) ;
    }
}
