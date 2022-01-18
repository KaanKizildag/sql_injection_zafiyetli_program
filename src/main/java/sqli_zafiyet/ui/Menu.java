package sqli_zafiyet.ui;

import sqli_zafiyet.entity.User;
import sqli_zafiyet.service.UserService;

import java.util.Scanner;

public class Menu extends EkranElementi {

    private UserService userService;
    private final Scanner scanner = new Scanner(System.in);

    public Menu() {
        userService = new UserService();
    }

    public void menuBas() {
        // ekraniTemizle();
        System.out.println("1: giriş ekranı");
        System.out.println("2: kayıt ekranı");
        kayitYap();
    }

    private String girdiAl(String mesaj) {
        System.out.println(mesaj);
        return scanner.nextLine();
    }

    private void girisYap() {
        String userName = girdiAl("kullaniciAdi");
        String password = girdiAl("parola");
        boolean girisBasariliMi = userService.getByNameAndPassword(userName, password);
        System.out.println(girisBasariliMi ? "giriş başarılı" : "kullanıcı adı veya parola hatalı");
    }

    private void kayitYap() {
        String userName = girdiAl("kullaniciAdi");
        String password = girdiAl("parola");
        User user = new User();
        user.setName(userName);
        user.setPassword(password);
        userService.insertUser(user);
    }

}
