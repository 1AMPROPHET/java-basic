import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Student management system!");
            System.out.println("Please select the option: 1.Login 2.Register 3. Forget password");
            String choose = sc.next();
            switch (choose) {
                case "1" -> login(list);
                case "2" -> register(list);
                case "3" -> forgetPassword(list);
                case "4" -> {
                    System.out.println("Exit");
                    System.exit(0);
                }
                default -> System.out.println("No such option");
            }
        }

    }

    private static void login(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; true; i++) {
            System.out.println("Please enter username:");
            String username = sc.next();

            boolean flag = contains(list, username);
            if (!flag) {
                System.out.println("username " + username + " is not registered, please register before login");
                return;
            }
            System.out.println("Please enter password");
            String password = sc.next();

            while (true) {
                String captcha = getCaptcha();
                System.out.println("Captcha is: " + captcha);
                System.out.println("Please enter the captcha:");
                String c = sc.next();
                if (c.equalsIgnoreCase(captcha)) {
                    System.out.println("Captcha correct.");
                    break;
                } else {
                    System.out.println("Captcha wrong, please try again");
                }
            }
            // check if username and password correct
            User userInfo = new User(username, password, null, null);
            boolean result = checkUserInfo(list, userInfo);
            if (result) {
                System.out.println("Login succeed, welcome to student's management system");
                StudentSystem.startStudentSystem();
                break;
            } else {
                System.out.println("Login failed, wrong username or password");
                if (i == 2) {
                    System.out.println("Current account " + username + " has been locked, please contact system manager");
                    return;
                } else {
                    System.out.println("Username or password is wrong, " + i + " chances left");
                }
            }
        }
    }

    private static boolean checkUserInfo(ArrayList<User> list, User userInfo) {
        for (User user : list) {
            if (user.getUsername().equals(userInfo.getUsername()) && user.getPassword().equals(userInfo.getPassword())) {
                return true;
            }
        }
        return false;
    }

    private static void forgetPassword(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter username");
        String username = sc.next();
        boolean flag = contains(list, username);
        if (!flag) {
            System.out.println("Current user is not registered, please register first");
            return;
        }
        System.out.println("Please enter ID");
        String personID = sc.next();
        System.out.println("Please enter phone number");
        String phoneNumber = sc.next();

        int index = findIndex(list, username);
        User user = list.get(index);

        if (!(user.getPersonID().equalsIgnoreCase(personID) && user.getPhoneNumber().equals(phoneNumber))) {
            System.out.println("Wrong phone number or ID, update password failed");
            return;
        }

        while (true) {
            System.out.println("Please enter the new password");
            String password = sc.next();
            System.out.println("Please enter the password again");
            String againPassword = sc.next();
            if (password.equals(againPassword)) {
                System.out.println("Password matches");
                break;
            } else {
                System.out.println("Password does not match, please try again");
            }
        }
    }

    private static int findIndex(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    private static void register(ArrayList<User> list) {
        System.out.println("Register");
        Scanner sc = new Scanner(System.in);
        String username;
        while (true) {
            System.out.println("Please enter the username");
             username = sc.next();
            // unique username
            boolean flag1 = checkUsername(username);
            if (!flag1) {
                System.out.println("Illegal username, Please try again");
                continue;
            }

            // judge unique username
            boolean flag2 = contains(list, username);
            if (flag2) {
                // username exists
                System.out.println("Username " + username + " already exists, please enter a new one");
            } else {
                // username does not exist
                System.out.println("Username " + username + " available");
                break;
            }
        }

        // password
        // enter the same password twice
        String password;
        String againPassword;
        while (true) {
            System.out.println("Please enter your password:");
            password = sc.next();
            System.out.println("Please enter the password again:");
            againPassword = sc.next();
            if (!password.equals(againPassword)) {
                System.out.println("The password entered do not match, please try again");
            } else {
                System.out.println("Password match");
                break;
            }
        }

        // ID number
        String personID;
        while (true) {
            System.out.println("Please enter ID code");
            personID = sc.next();
            boolean flag = checkPersonID(personID);
            if (!flag) {
                System.out.println("illegal ID, please try again");
            } else {
                System.out.println("legal ID");
                break;
            }
        }

        // phone number
        String phoneNumber;
        while (true) {
            System.out.println("Please enter phone number");
            phoneNumber = sc.next();
            boolean flag = checkPhoneNumber(phoneNumber);
            if (flag) {
                System.out.println("Legal phone number");
                break;
            } else {
                System.out.println("Illegal phone number, please try again");
            }
        }

        User u = new User(username, password, personID, phoneNumber);

        list.add(u);
        System.out.println("Register succeed");

        printList(list);
    }

    private static void printList(ArrayList<User> list) {
        for (User u : list) {
            System.out.println(u.getUsername() + ", " + u.getPassword() + ", " + u.getPersonID() + ", " + u.getPhoneNumber());
        }
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        }
        if (phoneNumber.startsWith("0")) {
            return false;
        }

        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkPersonID(String personID) {
        if (personID.length() != 18) {
            return false;
        }

        // first character can not be 0
        boolean flag = personID.startsWith("0");
        if (flag) {
            return false;
        }

        for (int i = 0; i < personID.length(); i++) {
            char c = personID.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                 return false;
            }
        }

        char endChar = personID.charAt(personID.length() - 1);
        return (endChar >= '0' && endChar <= '9') || (endChar == 'x') || (endChar == 'X');

    }

    private static boolean contains(ArrayList<User> list, String username) {
        for (User user : list) {
            String legalUsername = user.getUsername();
            if (legalUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkUsername(String username) {
        // username length between 3 and 15
        int len = username.length();
        if (len < 3 || len > 15) {
            return false;
        }

        // characters mix numbers
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }

        // not pure number
        int count = 0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                count++;
                break;
            }
        }
        return count > 0;
    }

    // generate a Captcha code
    public static String getCaptcha() {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a' + i));
            list.add((char)('A' + i));
        }

        // randomly generate a captcha with 4 character
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(list.size());
            char c = list.get(index);
            sb.append(c);
        }

        // connect with a number
        int number = r.nextInt(10);
        sb.append(number);

        char[] arr = sb.toString().toCharArray();
        int randomIndex = r.nextInt(arr.length);
        char temp = arr[randomIndex];
        arr[randomIndex] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        return new String(arr);
    }
}
