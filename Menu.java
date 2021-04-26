import java.util.Scanner;

public class Menu {
    static AdminSys admin = new AdminSys();
    Scanner sc = new Scanner(System.in);
    public void showMenu() {
        admin.addMessage();
        System.out.println("Please enter username and password: ");
        String str = sc.next();
        String[] info = str.split("/");
        if(info.length < 2) {
            System.out.println("format is wrong, please enter again");
            showMenu();
        } else {
            if(admin.findById(info[0])!=null && admin.findById(info[0]).getPassword().equals(info[1]) ) {
                adminMenu();
            } else if (admin.findUserById(info[0])!=null && admin.findUserById(info[0]).getPassword().equals((info))) {
                User user = admin.findUserById(info[0]);
                userMenu(user);
            } else {
                System.out.println("Username and password doesn't match, please enter again");
                showMenu();
            }
        }
    }
    public void userMenu(User user) {
        System.out.println("=========Welcome to the Menu=======");
        System.out.println("====【1】Show menu=================");
        System.out.println("====【2】Display all dishes according to dish type===");
        System.out.println("====【3】Show all orders============");
        System.out.println("====【4】Change password===============");
        System.out.println("====【5】Show infromation============");
        System.out.println("====【6】Exit==================");
        System.out.println("Please enter what you want to do：");
        String n = sc.next();
        switch (n) {
        case "1":
        admin.shopDishes(user);
        userMenu(user);
        break;
        case "2":
        admin.showDishOfType();
        userMenu(user);
        break;
        case "3":
        admin.showAllOrderByUser(user);
        userMenu(user);
        break;
        case "4":
        admin.changePwdByUser(user);
        userMenu(user);
        break;
        case "5":
        admin.showByUser(user);
        userMenu(user);
        break;
        case "6":
        System.out.println("Thanks for using!");
        break;
        default:
        System.out.println("Input error, please re-enter：");
        userMenu(user);
        }
    }

    private void adminMenu() {
        System.out.println("=========Welcome to Admin System=======");
        System.out.println("====【1】Add dish===============");
        System.out.println("====【2】Show All dish information=======");
        System.out.println("====【3】Show dish information based on dish type=====");
        System.out.println("====【4】Update dish price=====");
        System.out.println("====【5】Delete dish=========");
        System.out.println("====【6】Add user================");
        System.out.println("====【7】Show user list=============");
        System.out.println("====【8】Delete user==========");
        System.out.println("====【9】Show all orders=============");
        System.out.println("====【10】Change order status====");
        System.out.println("====【11】Exit=================");
        String m = sc.next();
        switch (m) {
        case "1":
        admin.addDish();
        adminMenu();
        break;
        case "2":
        System.out.println("Please enter how much data you need to display in each row:");
        int pageSize = sc.nextInt();
        admin.showAllDishes(pageSize);
        adminMenu();
        break;
        case "3":
        admin.selectBytypeOfAdmin();
        adminMenu();
        break;
        case "4":
        admin.updateDishPrice();
        adminMenu();
        break;
        case "5":
        admin.deleteDish();
        adminMenu();
        break;
        case "6":
        admin.addUser();
        adminMenu();
        break;
        case "7":
        admin.findUser();
        adminMenu();
        break;
        case "8":
        admin.deleteUserByAdmin();
        adminMenu();
        break;
        case "9":
        admin.showAllOrder();
        adminMenu();
        break;
        case "10":
        admin.changeOrderStatus();
        adminMenu();
        break;
        case "11":
        System.out.println("Thanks for using!");
        System.exit(0);
        break;
        default:
        System.out.println("Input error, please re-enter：");
        adminMenu();
        }
    }
    
}

