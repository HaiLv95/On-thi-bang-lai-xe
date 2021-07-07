package testView;

import testModel.User;

/**
 *
 * @author hai95
 */
public class Run {
    public  static frHome home;
    public static dgLogin login;
    public static User user;
    public static void main(String[] args) {
        dgLogin();
    }
    public static void dgLogin(){
        login = new dgLogin(Run.home, true);
        login.setVisible(true);
    }
    public static void frHome(){
        home = new frHome();
        home.setVisible(true);
    }
}
