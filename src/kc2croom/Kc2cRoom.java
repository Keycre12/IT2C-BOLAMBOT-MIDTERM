
package kc2croom;

import java.util.Scanner;


public class Kc2cRoom {
      public void addRecord(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Room No.: ");
        String room_number = sc.next();
 
        System.out.print("Room Type(Private/General): ");
        String room_type = sc.next();
        
        System.out.print("Room Availability(Occupied/Available): ");
        String availability_status = sc.next();
        
        System.out.print("Daily rate: ");
        Double daily_rate = sc.nextDouble();
       

        String sql = "INSERT INTO Rooms ( room_number, room_type, availability_status, daily_rate ) VALUES (?, ?, ?, ?)";
        config conf = new config();
        conf.addRecord(sql, room_number, room_type, availability_status, daily_rate);
    }
     public void viewRecords(){
   
    String cqry = "SELECT room_id, room_number, room_type, availability_status, daily_rate FROM Rooms";
    String[] hrds = {"ID", "Room no.", "Room Type", "Status", "Daily Rate"};
    String[] clmns = {"room_id", "room_number", "room_type", "availability_status", "daily_rate"};

    config conf = new config();
    conf.viewRecords(cqry, hrds, clmns);
    }

     
     private void updateRecord(){
         
         Scanner sc = new Scanner(System.in);
         System.out.println("Enter Room ID: ");
         int id = sc.nextInt();
         
         System.out.print("Enter new Room no.: ");
         String room_number = sc.next();
         
         System.out.print("Enter new Room Type(Private/General): ");
         String room_type = sc.next();
         
         System.out.print("Enter new Availability(Occupied/Available): ");
         String availability_status = sc.next();
         
         System.out.print("Enter new Daily Rate: ");
         Double daily_rate = sc.nextDouble();
         
         String qry = "UPDATE Rooms SET room_number = ?, room_type = ?, availability_status = ?, daily_rate = ? WHERE room_id = ? ";
         
         config conf = new config();
         conf.updateRecord(qry, room_number, room_type, availability_status, daily_rate,  id);
             
     }
      public void DeleteRecord(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Room no. to delete: ");
        int id = sc.nextInt();
        
        
         String sqlDelete = "DELETE FROM Rooms WHERE room_id = ?";
         config conf = new config();
         conf.deleteRecord(sqlDelete, id);
       
}
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         Kc2cRoom room = new  Kc2cRoom(); 
        String response;
        
        do{
            System.out.println("1. Add:");
            System.out.println("2. View:");
            System.out.println("3. Update:");
            System.out.println("4. Delete:");
            System.out.println("5. Exit:");
            
            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            
            switch (action){
                case 1:
                    room.addRecord();
                    
                    break;
                    
                case 2:
                   room.viewRecords();
                    break;
                    
                    case 3:
                   room.viewRecords();
                   room.updateRecord();
                    break;
                    
                    case 4:
                    room.viewRecords();
                    room.DeleteRecord();
                    room.viewRecords();
                    break;
                    
                    case 5: 
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid action. Please try again.");
            }
            
            System.out.print("Continue (yes/no): ");
            response = sc.next();
            
        } while(response.equalsIgnoreCase("yes"));
        System.out.println("Thank You See You Soon!");
        
    }
    
}

    
    

