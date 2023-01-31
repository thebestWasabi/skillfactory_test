import file.TxtParser;
import repository.DataSource;
import repository.DataSourceImpl;
import ui.Menu;

public class App {

    public static void main(String[] args) {
        DataSource dataSource = new DataSourceImpl();
        TxtParser txtParser = new TxtParser();
        Menu menu = new Menu(txtParser, dataSource);
        menu.printMenu();
    }
}
