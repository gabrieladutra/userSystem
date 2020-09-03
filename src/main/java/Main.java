import business.User;
import data.UserRepository;
import presentation.Menu;
import presentation.UserServices;

public class Main {
  public static void main(String[] args) {
    final var services = new UserServices();
    final var menu = new Menu();
    Integer option = null;

    while (option == null || option != 0) {
      menu.display();
      option = menu.readOption();

      switch (option) {
        case 1:
          services.addUser();
          break;
        case 2:
          services.findUser();
          break;

        case 3:
          services.searchUser();
          break;

        case 4:

          services.listUsers();
          break;

        case 5:
          services.deleteUser();
          break;

        case 6:
          services.alterUser();
          break;
      }
    }
  }
}
