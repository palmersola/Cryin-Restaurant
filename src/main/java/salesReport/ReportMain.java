package salesReport;

public class ReportMain {


    public static void runReport(Restaurant restaurant){
        System.out.println();
        restaurant.getOrders().displayOrderStatus(1);

    }

}
