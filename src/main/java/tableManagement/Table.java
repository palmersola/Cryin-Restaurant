package tableManagement;



public class Table {
    private final int tableId;
    private final int tableSize;
    private String status;
    private String assignedCustomer;

    public Table(int tableId, int tableSize) {
        this.tableId = tableId;
        this.tableSize = tableSize;
        this.status = "Available";
        this.assignedCustomer = null;
    }

    public void assignCustomer(String customer) {
        if (status.equals("Available")) {
            status = "Occupied";
            assignedCustomer = customer;
            System.out.println("Table " + tableId + " has been assigned to " + customer);
        } else {
            System.out.println("Table " + tableId + " is not available for assignment.");
        }
    }

    public void freeTable() {
        status = "Available";
        assignedCustomer = null;
        System.out.println("Table " + tableId + " is now available.");
    }

    public void reserveTable(String customer) {
        if (status.equals("Available")) {
            status = "Reserved";
            assignedCustomer = customer;
            System.out.println("Table " + tableId + " has been reserved for " + customer);
        } else {
            System.out.println("Table " + tableId + " is not available for reservation.");
        }
    }

    public Integer getTableId() {
        return tableId;
    }

    public int getTableSize() {
        return tableSize;
    }

    public String getStatus() {
        return  status;
    }

    public String getAssignedCustomer() {
        return  assignedCustomer;
    }
}
