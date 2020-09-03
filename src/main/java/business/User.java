package business;

public class User {

    private String name;
    private Integer age;
    private  String cpf;


    public User(){

    }
    public User(String name, Integer age, String cpf) {
        setName(name);
        setAge(age);
        setCpf(cpf);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setName(String name){
        this.name = validateStringIsNullOrBlank(name);
    }
    public void setAge(Integer age){
        this.age = validateAge(age);
    }

    public void setCpf(String cpf){
        this.cpf = validateStringIsNullOrBlank(cpf);
    }


    private static String validateStringIsNullOrBlank(final String paramString){
        if(paramString == null || paramString.isBlank()){
            throw new IllegalArgumentException("The string of parameter is null or blank");
        }
        return paramString;
    }

    private static Integer validateAge(final Integer number){
        if(number < 0){
            throw new IllegalArgumentException("The number of parameter is negative");
        }
        return number;
    }


    @Override
    public String toString() {
        return  "[Name]: " + name + " [Age]: " + age + " [CPF]: " + cpf;
    }
}
