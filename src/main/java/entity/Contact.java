package entity;

/**
 * Created by hellotree on 2017/10/15.
 *
 * @author by ÁÚ¾ÓµÄ¶ú¶ä
 * @Begin 2017/10/15.
 */
public class Contact {
    private String id;
    private String name;
    private String sex;
    private String telephone;
    private String qq;
    private String email;

    public Contact(){
        super();
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public  Contact(String id, String name, String sex, String telephone, String qq, String email){
        this.id=id;
        this.name=name;
        this.telephone=telephone;
        this.email=email;
        this.qq=qq;
        this.sex=sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
