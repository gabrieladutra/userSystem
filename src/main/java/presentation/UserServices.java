package presentation;

import business.UserFactory;
import data.UserRepository;


public class UserServices {
  UserRepository repository = UserRepository.getInstance();
  Menu menu = new Menu();
  UserFactory factory = new UserFactory();

  public void addUser() {

    var user = factory.fromConsole();
    repository.addUser(user);
  }

  public void findUser() {
    System.out.println(repository.getUser(getCpf()));
  }

  public void searchUser() {
    System.out.println("User name");
    var name = menu.readString();
    System.out.println(repository.searchUser(name));
  }

  public void deleteUser() {
    repository.deleteUser(getCpf());
  }

  public void alterUser() {
    repository.alterUser(getCpf());
  }

  public void listUsers(){
    System.out.println(repository.getUsers());

  }


  private String getCpf() {
    System.out.println("User CPF: \n");
    var cpf = menu.readString();

    if (cpf == null || cpf.isBlank()) {
      throw new IllegalArgumentException("The string of parameter is null or blank");
    }
    return cpf;
  }

}
