package testView;

import testModel.User;

/**
 *
 * @author hai95
 */
public class Run {
    public  static frHome home;
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
        home = new frHome();
        home.setVisible(true);
    }
}
