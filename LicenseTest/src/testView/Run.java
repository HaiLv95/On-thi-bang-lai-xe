package testView;

import testModel.User;

/**
 *
 * @author hai95
 */
public class Run {
    public  static frHomePage home;
    public static frLogin login;
    public static User user;
    public static void main(String[] args) {
        frLogin();
    }
    public static void frLogin(){
        login = new frLogin();
        login.setVisible(true);
    }
    public static void frHome(){
        home = new frHomePage();
        home.setVisible(true);
    }
}
