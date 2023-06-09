package orderProcessing;


import salesReport.Restaurant;

import java.util.Scanner;

public class OrderMain {

    public static Scanner scanner = new Scanner(System.in);
    public static void runOrder(Restaurant res) {
        boolean loop = true;

        while(loop){
            System.out.println("""
                    Manage Orders
                       1.) Update Order Status
                       2.) Display Order Status
                       3.) Display All Orders
                       4.) Back
                    """);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1 ->{
                    System.out.println("Enter Order ID:");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Change status to INQUEUE, PREPARING, or READY");
                    String status = scanner.nextLine();
                    res.getOrders().updateOrderStatus(id, OrderStatus.valueOf(status));
                }
                case 2 ->{
                    System.out.println("Enter Order ID:");
                    int id = Integer.parseInt(scanner.nextLine());
                    res.getOrders().displayOrderStatus(id);
                }
                case 3 -> System.out.println(res.getOrders().displayAll());
                case 4 -> loop = false;
            }
        }

        res.getMenu().displayPopular();
        res.getOrders().displayAll();

    }
}