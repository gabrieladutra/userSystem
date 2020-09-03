import business.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

  @Test
  public void getName_whenAUserIsValid_shouldGetUserName() {
    User user = new User("Gabriela", 20, "214324342");
    assertEquals("Gabriela", user.getName());
  }

  @Test
  public void getAge_whenAUserIsValid_shouldGetUserAge() {
    User user = new User("Gabriela", 20, "214324342");
    assertEquals(20, user.getAge());
  }

  @Test
  public void getCpf_whenAUserIsValid_shouldGetUserNCpf() {
    User user = new User("Gabriela", 20, "214324342");
    assertEquals("214324342", user.getCpf());
  }

  @Test
  public void setName_whenANameIsNull_shouldThrowAException() {
    User user = new User("Gabriela", 20, "214324342");
    assertThrows(IllegalArgumentException.class, () -> user.setName(null));
  }

  @Test
  public void setName_whenANameIsEmpty_shouldThrowAException() {
    User user = new User("Gabriela", 20, "214324342");
    assertThrows(IllegalArgumentException.class, () -> user.setName(""));
  }

  @Test
  public void setName_whenANameIsValid_shouldSetName() {
    User user = new User("Gabriela", 20, "214324342");
    final var newName = "Eve";
    user.setName(newName);
    assertEquals(newName, user.getName());
  }

  @Test
  public void setCpf_whenACpfIsNull_shouldThrowAException() {
    User user = new User("Gabriela", 20, "214324342");
    assertThrows(IllegalArgumentException.class, () -> user.setCpf(null));
  }

  @Test
  public void setCpf_whenACpfIsEmpty_shouldThrowAException() {
    User user = new User("Gabriela", 20, "214324342");
    assertThrows(IllegalArgumentException.class, () -> user.setCpf(""));
  }

  @Test
  public void setCpf_whenACpfIsValid_shouldSetCpf() {
    User user = new User("Gabriela", 20, "214324342");
    final var newCpf = "543.434.344.11";
    user.setCpf(newCpf);
    assertEquals(newCpf, user.getCpf());
  }

  @Test
  public void setAge_whenAgeIsValid_shouldSetAge() {
    User user = new User("Gabriela", 20, "214324342");
    final var newAge = 33;
    user.setAge(newAge);
    assertEquals(newAge, user.getAge());
  }

  @Test
  public void setAge_whenAgeIsNegative_shouldThrowException() {
    User user = new User("Gabriela", 20, "214324342");
    assertThrows(IllegalArgumentException.class, () -> user.setAge(-1));
  }
}
