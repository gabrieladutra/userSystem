package data;

import business.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import presentation.Menu;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {
  private static UserRepository repositoryInstance;
  private final List<User> users = readUser();

  private UserRepository() {}

  public static UserRepository getInstance() {
    if (repositoryInstance == null) {
      repositoryInstance = new UserRepository();
    }
    return repositoryInstance;
  }

  public List<User> readUser() {
    try {
      var mapper = new ObjectMapper();
      User[] json = mapper.readValue(new File("allUsers.json"), User[].class);

      return Arrays.stream(json).collect(Collectors.toList());
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public void writeUser() {
    try {
      ObjectMapper mapper = new ObjectMapper();

      mapper.writerWithDefaultPrettyPrinter().writeValue(new File("allUsers.json"), users);

    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public void addUser(final User user) {
    users.add(user);
    writeUser();
  }

  public List<User> getUsers(){
    return users;
  }


  public User getUser(final String cpf) {
    for (User user : users) {
      if (user.getCpf().equals(cpf)) {
        return user;
      }
    }
    return null;
  }

  public void deleteUser(final String cpf) {
    for (User user : users) {
      if (user.getCpf().equals(cpf)) {
        users.remove(user);
      }
    }
    writeUser();
  }

  public int getSize() {
    return users.size();
  }

  public ArrayList<User> searchUser(final String name) {
    var searchedUsers = new ArrayList<User>();
    for (User user : users) {
      if (user.getName().contains(name)) {
        searchedUsers.add(user);
      }
    }
    return searchedUsers;
  }

  public void alterUser(final String cpf) {
    for (User user : users) {
      if (user.getCpf().equals(cpf)) {
        var menu = new Menu();
        System.out.println("New name: ");
        var newName = menu.readString();

        if (!newName.equals("")) {
          user.setName(newName);
        }
        System.out.println("New age: ");
        var newAge = menu.readOption();
        if (newAge != 0) {
          user.setAge(newAge);
        }
        System.out.println("New CPF: ");
        var newCpf = menu.readString();
        if (!newCpf.equals("")) {
          user.setCpf(newCpf);
        }
      }
    }
    writeUser();
  }
}
