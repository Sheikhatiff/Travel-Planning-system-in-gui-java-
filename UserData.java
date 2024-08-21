
package journey;

public class UserData {
   private String username,name,password,answer,cnic;

    public UserData(String username, String name, String password, String answer) {
        this.setUsername(username);
        this.setName(name);
        this.setPassword(password);
        this.setAnswer(answer);
    }

    public UserData(String username, String name, String password, String answer,String cnic) {
        this.setUsername(username);
        this.setName(name);
        this.setPassword(password);
        this.setAnswer(answer);
        this.setCnic(cnic);
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }
    
}
