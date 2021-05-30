package Project;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.bson.Document;
import java.util.*;
import java.util.List;
import static javafx.geometry.Pos.CENTER;

/**
 *
 * @author Vajith Chamuditha
 */


public class TrainBooking extends Application {
    static final int SEATING_CAPACITY = 42; //creating a global variable

    public static void main(String[] args) {
        Application.launch(); }
    private static void addCustomer(String[][] seat) {
        DatePicker datePicker=new DatePicker();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        while (true) {
            System.out.println("Enter 1 to book seats from colombo to badulla:");
            System.out.println("Enter 2 to book seats from badulla to colombo:");
            System.out.println("Enter any letter to quit to main menu:");
            int choice;
            try {
                choice= sc.nextInt() ; //checking whether input is an integer or not
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                break; //if input is not an integer loop breaks and return to main menu
            }
            if (choice == 1 || choice==2) {
                Stage stageNew = new Stage();
                List<Integer> temp = new ArrayList<>(); //creating a tempory list to add the elements when seat # button clicked
                Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15,
                        btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28,btn29,
                        btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42;
                Button[] buttonArray = {
                        btn1 = new Button("Seat No: 1"), btn2 = new Button("Seat No: 2"), btn3 = new Button("Seat No: 3"),
                        btn4 = new Button("Seat No: 4"), btn5 = new Button("Seat No: 5"), btn6 = new Button("Seat No: 6"),
                        btn7 = new Button("Seat No: 7"), btn8 = new Button("Seat No: 8"), btn9 = new Button("Seat No: 9"),
                        btn10 = new Button("Seat No: 10"), btn11 = new Button("Seat No: 11"), btn12 = new Button("Seat No: 12"),
                        btn13 = new Button("Seat No: 13"), btn14 = new Button("Seat No: 14"), btn15 = new Button("Seat No: 15"),
                        btn16 = new Button("Seat No: 16"), btn17 = new Button("Seat No: 17"), btn18 = new Button("Seat No: 18"),
                        btn19 = new Button("Seat No: 19"), btn20 = new Button("Seat No: 20"), btn21 = new Button("Seat No: 21"),
                        btn22 = new Button("Seat No: 22"), btn23 = new Button("Seat No: 23"), btn24 = new Button("Seat No: 24"),
                        btn25 = new Button("Seat No: 25"), btn26 = new Button("Seat No: 26"), btn27 = new Button("Seat No: 27"),
                        btn28 = new Button("Seat No: 28"), btn29 = new Button("Seat No: 29"), btn30 = new Button("Seat No: 30"),
                        btn31 = new Button("Seat No: 31"), btn32 = new Button("Seat No: 32"), btn33 = new Button("Seat No: 33"),
                        btn34 = new Button("Seat No: 34"), btn35 = new Button("Seat No: 35"), btn36 = new Button("Seat No: 36"),
                        btn37 = new Button("Seat No: 37"), btn38 = new Button("Seat No: 38"), btn39 = new Button("Seat No: 39"),
                        btn40 = new Button("Seat No: 40"), btn41 = new Button("Seat No: 41"), btn42 = new Button("Seat No: 42")
                };
                Button btn43 = new Button("Book Now");
                Button btn44 = new Button("Reset");
                btn1.setLayoutY(50);btn1.setLayoutX(60);btn2.setLayoutY(80);btn2.setLayoutX(60);
                btn3.setLayoutY(110);btn3.setLayoutX(60);btn4.setLayoutY(140);btn4.setLayoutX(60);
                btn5.setLayoutY(170);btn5.setLayoutX(60);btn6.setLayoutY(200);btn6.setLayoutX(60);
                btn7.setLayoutY(230);btn7.setLayoutX(60);btn8.setLayoutY(50);btn8.setLayoutX(160);
                btn9.setLayoutY(80);btn9.setLayoutX(160);btn10.setLayoutY(110);btn10.setLayoutX(160);
                btn11.setLayoutY(140);btn11.setLayoutX(160);btn12.setLayoutY(170);btn12.setLayoutX(160);
                btn13.setLayoutY(200);btn13.setLayoutX(160);btn14.setLayoutY(230);btn14.setLayoutX(160);
                btn15.setLayoutY(50);btn15.setLayoutX(260);btn16.setLayoutY(80);btn16.setLayoutX(260);
                btn17.setLayoutY(110);btn17.setLayoutX(260);btn18.setLayoutY(140);btn18.setLayoutX(260);
                btn19.setLayoutY(170);btn19.setLayoutX(260);btn20.setLayoutY(200);btn20.setLayoutX(260);
                btn21.setLayoutY(230);btn21.setLayoutX(260);btn22.setLayoutY(50);btn22.setLayoutX(420);
                btn23.setLayoutY(80);btn23.setLayoutX(420);btn24.setLayoutY(110);btn24.setLayoutX(420);
                btn25.setLayoutY(140);btn25.setLayoutX(420);btn26.setLayoutY(170);btn26.setLayoutX(420);
                btn27.setLayoutY(200);btn27.setLayoutX(420);btn28.setLayoutY(230);btn28.setLayoutX(420);
                btn29.setLayoutY(50);btn29.setLayoutX(520);btn30.setLayoutY(80);btn30.setLayoutX(520);
                btn31.setLayoutY(110);btn31.setLayoutX(520);btn32.setLayoutY(140);btn32.setLayoutX(520);
                btn33.setLayoutY(170);btn33.setLayoutX(520);btn34.setLayoutY(200);btn34.setLayoutX(520);
                btn35.setLayoutY(230);btn35.setLayoutX(520);btn36.setLayoutY(50);btn36.setLayoutX(620);
                btn37.setLayoutY(80);btn37.setLayoutX(620);btn38.setLayoutY(110);btn38.setLayoutX(620);
                btn39.setLayoutY(140);btn39.setLayoutX(620);btn40.setLayoutY(170);btn40.setLayoutX(620);
                btn41.setLayoutY(200);btn41.setLayoutX(620);btn42.setLayoutY(230);btn42.setLayoutX(620);
                btn43.setLayoutY(300);btn43.setLayoutX(480);btn44.setLayoutY(300);btn44.setLayoutX(580);
                AnchorPane root = new AnchorPane();
                root.getChildren().addAll(btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,
                        btn15,btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25,btn26,btn27,btn28,btn29,btn30,
                        btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39, btn40, btn41, btn42,btn43,btn44);
                for (int i = 0; i < SEATING_CAPACITY; i++) {
                    int finalInt = i;           //adding elements to the tempory list and set the booked ones disable
                    buttonArray[i].addEventHandler(MouseEvent.MOUSE_CLICKED,
                            event -> {
                                temp.add(finalInt + 1);
                                buttonArray[finalInt].setStyle("-fx-background-color: #9933ff;");
                                buttonArray[finalInt].setDisable(true);
                            }); //adding details from the button array to tempory list
                }
                for (int i = 0; i < SEATING_CAPACITY; i++) {
                    if (seat[choice-1][i] != null) {
                        buttonArray[i].setDisable(true);
                    } //using for loop disable the buttons booked by previous users
                }
                btn43.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        event -> {
                            for (Integer integer : temp) {
                                seat[choice - 1][integer - 1] = name;
                            }        //adding the elements from list to array when book now button clicked
                            stageNew.close();
                        });
                btn44.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        event -> {
                            temp.clear();   //clearing temp list and set buttons default when reset clicked
                            for (int i = 0; i < SEATING_CAPACITY; i++) {
                                if (seat[choice-1][i] != null) {
                                    buttonArray[i].setDisable(true);
                                } else {
                                    buttonArray[i].setStyle(null);
                                    buttonArray[i].setDisable(false);
                                }
                            }
                        });
                Label lblTrip=new Label("Make Reservations as your Wish");
                lblTrip.setLayoutY(350);
                lblTrip.setLayoutX(40);
                Label lbl1=new Label("W\nI\nN\nD\nO\nW");
                Label lbl2=new Label("W\nI\nN\nD\nO\nW");
                lbl1.setLayoutX(10);
                lbl1.setLayoutY(50);
                lbl2.setLayoutX(705);
                lbl2.setLayoutY(50);
                lbl1.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lbl2.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lblTrip.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lbl1.setAlignment(CENTER);
                lbl2.setAlignment(CENTER);
                lblTrip.setAlignment(CENTER);
                lbl1.setFont(new Font(14));
                lbl2.setFont(new Font(14));
                lblTrip.setFont(new Font(20));
                lbl1.setMinHeight(208);
                lbl1.setMinWidth(40);
                lbl2.setMinHeight(208);
                lbl2.setMinWidth(40);
                lblTrip.setMinHeight(40);
                lblTrip.setMinWidth(660);
                lbl1.setStyle("-fx-background-color:#3399ff");
                lbl2.setStyle("-fx-background-color:#3399ff");
                lblTrip.setStyle("-fx-background-color:#ff9966");
                root.getChildren().addAll(lbl1,lbl2,lblTrip,datePicker);
                Scene scene = new Scene(root, 745, 480);
                stageNew.setScene(scene); //creating the scene
                stageNew.setTitle("Train Booking App");
                stageNew.setResizable(false);
                stageNew.showAndWait();
                return;
            }else {
                System.out.println("Enter either 1 or 2");
            }
        }
    }
    private static void viewAllSeats(String[][] seat) {
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter 1 to view seats from colombo to badulla:");
            System.out.println("Enter 2 to view seats from badulla to colombo:");
            System.out.println("Enter any letter to quit to main menu:");
            int choice;
            try {  //passing only integers
                choice= sc.nextInt() ;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                break;   //if input is not an integer loop breaks and return to main menu
            }

            if(choice==1 || choice ==2){
                AnchorPane aPane = new AnchorPane();

                int x=60;  //creating buttons using for loop
                int y=50;
                for (int i=0;i<SEATING_CAPACITY;i++){ //addding buttons to the pane
                    Button btn = new Button();
                    btn.setLayoutX(x);
                    btn.setLayoutY(y);
                    aPane.getChildren().add(btn);
                    if (seat[choice-1][i]!=null){
                        btn.setStyle("-fx-background-color:red"); //setting booked buttons into red
                        btn.setText("Booked");

                    }else{
                        btn.setStyle("-fx-background-color:#33cc33");
                        btn.setText("Seat "+(i+1));
                    }

                    btn.setMouseTransparent(true);
                    y=y+30;
                    if (y==260){
                        if (x==60 | x==160 | x==260 | x==420 | x==520 | x==620){
                            if(x==260){ x=x+60;}
                            x=x+100;
                        }
                        y=50;
                    }
                }
                Label lblTrip=new Label("All Seats in the Train");
                lblTrip.setLayoutY(350);
                lblTrip.setLayoutX(40);
                Label lbl1=new Label("W\nI\nN\nD\nO\nW");
                Label lbl2=new Label("W\nI\nN\nD\nO\nW");
                lbl1.setLayoutX(10);
                lbl1.setLayoutY(50);
                lbl2.setLayoutX(685);
                lbl2.setLayoutY(50);
                lbl1.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lbl2.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lblTrip.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lbl1.setAlignment(CENTER);
                lbl2.setAlignment(CENTER);
                lblTrip.setAlignment(CENTER);
                lbl1.setFont(new Font(14));
                lbl2.setFont(new Font(14));
                lblTrip.setFont(new Font(20));
                lbl1.setMinHeight(208);
                lbl1.setMinWidth(40);
                lbl2.setMinHeight(208);
                lbl2.setMinWidth(40);
                lblTrip.setMinHeight(40);
                lblTrip.setMinWidth(660);
                Button button=new Button("Back to Menu");
                button.setLayoutY(300);
                button.setLayoutX(480);
                lbl1.setStyle("-fx-background-color:#3399ff");
                lbl2.setStyle("-fx-background-color:#3399ff");
                lblTrip.setStyle("-fx-background-color:#ff9966");
                aPane.getChildren().addAll(lbl1,lbl2,lblTrip,button);
                Scene scene = new Scene(aPane,730,480);
                Stage stage = new Stage();
                button.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        event -> stage.close());
                stage.setScene(scene);
                stage.setTitle("Train Booking System");
                stage.setResizable(false);
                stage.showAndWait();
            }else{
                System.out.println("Enter either 1 or 2");
                continue;
            }
            break;
        }
    }
    private static void viewEmptySeats(String [][] seat) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 to view empty seats from colombo to badulla:");
            System.out.println("Enter 2 to view empty seats from badulla to colombo:");
            System.out.println("Enter any letter to quit to main menu:");
            int choice;
            try { //passing integers only
                choice= sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                break;
            }
            if(choice==1 || choice ==2 ){
                AnchorPane aPane = new AnchorPane();
                int x=60;
                int y=50;                //creating buttons using for loop
                for (int i=0;i<SEATING_CAPACITY;i++){
                    Button btn = new Button("Seat "+(i+1));
                    btn.setLayoutX(x);
                    btn.setLayoutY(y);
                    aPane.getChildren().add(btn);
                    if (seat[choice-1][i]==null){
                        btn.setStyle("-fx-background-color:#33cc33"); //setting vacant buttons green
                    }else{btn.setVisible(false); //setting booked buttons invisible
                    }
                    btn.setMouseTransparent(true);
                    y=y+30;
                    if (y==260){
                        if (x==60 | x==160 | x==260 | x==420 | x==520 | x==620){
                            if(x==260){ x=x+60;}
                            x=x+100;
                        }
                        y=50;
                    }
                }
                Label lblTrip=new Label("Empty Seats In the Train");
                lblTrip.setLayoutY(350);
                lblTrip.setLayoutX(40);
                Label lbl1=new Label("W\nI\nN\nD\nO\nW");
                Label lbl2=new Label("W\nI\nN\nD\nO\nW");
                lbl1.setLayoutX(10);
                lbl1.setLayoutY(50);
                lbl2.setLayoutX(685);
                lbl2.setLayoutY(50);
                lbl1.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lbl2.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lblTrip.setBorder(new Border(new BorderStroke(Color.LIGHTGRAY,BorderStrokeStyle.SOLID,null,new BorderWidths(3))));
                lbl1.setAlignment(CENTER);
                lbl2.setAlignment(CENTER);
                lblTrip.setAlignment(CENTER);
                lbl1.setFont(new Font(14));
                lbl2.setFont(new Font(14));
                lblTrip.setFont(new Font(20));
                lbl1.setMinHeight(208);
                lbl1.setMinWidth(40);
                lbl2.setMinHeight(208);
                lbl2.setMinWidth(40);
                lblTrip.setMinHeight(40);
                lblTrip.setMinWidth(660);
                Button button=new Button("Back to Menu");
                button.setLayoutY(300);
                button.setLayoutX(480);
                lbl1.setStyle("-fx-background-color:#3399ff");
                lbl2.setStyle("-fx-background-color:#3399ff");
                lblTrip.setStyle("-fx-background-color:#ff9966");
                aPane.getChildren().addAll(lbl1,lbl2,lblTrip,button);
                Scene scene = new Scene(aPane,730,480);
                Stage stage = new Stage();
                button.addEventHandler(MouseEvent.MOUSE_CLICKED,
                        event -> stage.close());
                stage.setScene(scene);
                stage.setTitle("Train Booking System");
                stage.setResizable(false);
                stage.showAndWait();
            }else{
                System.out.println("Enter either 1 or 2");
                System.out.println();
                continue;
            }
            break;
        }
    }
    private static void deleteBookedSeat(String[][] seat) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 to delete seats from colombo to badulla:");
            System.out.println("Enter 2 to delete seats from badulla to colombo:");
            System.out.println("Enter any letter to quit to main menu:");
            int choice;
            try { //passing only integers
                choice= sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                break;
            }
            if(choice==1 || choice==2){
                Boolean flag = Boolean.TRUE;
                while(flag) { //adding booked elements to a tempory list
                    int seatNum;
                    List<Integer> temp = new ArrayList<>();
                    for (int i=0;i<SEATING_CAPACITY;i++){
                        if(seat[choice-1][i]!=null){
                            temp.add(i+1);
                        }
                    }
                    System.out.println(Arrays.toString(temp.toArray())); //showing the booked elemets
                    System.out.println("Enter seat number to delete(1-42):");
                    try {
                        seatNum = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input");
                        break;
                    }
                    if( seatNum<1 || seatNum>SEATING_CAPACITY){
                        System.out.println("Enter a seat number between 1-42");
                        continue;
                    }
                    if (temp.size() == 0) {
                        System.out.println("** No Records to delete please add **");
                        flag=false;
                        continue;
                    }
                    System.out.println("Enter your Name given when booking that seat:");
                    String bookedName=sc.next();
                    if (bookedName.equalsIgnoreCase(seat[choice-1][seatNum-1])){
                        if (temp.contains(seatNum)) { //checking elements which match to the input
                            System.out.println("Do you want to Delete "+seat[choice-1][seatNum-1] +"'s Booking in seat number "+
                                    seatNum+"\nIf yes enter \"y\" if no enter \"n\"");
                            String yesOrNo=sc.next();
                            if (yesOrNo.equalsIgnoreCase("y")){
                                seat[choice-1][seatNum-1]=null;
                                System.out.println("Entry Deleted :)");
                                flag=false;
                            }else if(yesOrNo.equalsIgnoreCase("n")){
                                System.out.println("Deletion Cancelled");
                                flag=false;
                            }else {
                                System.out.println("Enter y or n");
                            }
                        }else{
                            System.out.println("Invalid seat Number");
                        }
                    }else{
                        System.out.println("Access Denied");
                        break;
                    }
                }
            }else{
                System.out.println("Enter either 1 or 2");
                System.out.println();
                continue;
            }
            break;
        }
    }
    private static void findSeatByCustomer(String[][] seat) {
        Scanner sc = new Scanner(System.in);
        String seatName;
        System.out.println("Enter name to Search for:");
        seatName = sc.next();
        int x;
        boolean Checker = false; //setting checker to false
        for (x = 0; x < SEATING_CAPACITY; x++) {
            if (seatName!=null && seatName.equalsIgnoreCase(seat[0][x])) {
                System.out.println("The Seat that matches the name "+ seatName+ " is Seat number " + (x+1)+
                        "\nTravelling from Colombo to badulla");
                Checker = true; //break
            }
            if (seatName!=null && seatName.equalsIgnoreCase(seat[1][x])) {
                System.out.println("The Seat that matches the name "+ seatName+ " is Seat number " + (x+1)+
                        "\nTravelling from badulla to colombo");
                Checker = true;
            }
        }
        if (!Checker) {
            System.out.println("There are no seats Booked with that name.\nmake sure you've used the correct name :)");
            //break;
        }
    }
    private static void StoreProgramDataInToFile(String[][] seat) {
        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        //creating a mongo client online
        MongoDatabase database = mongo.getDatabase("TrainBooking");
        //get access to the database
        MongoCollection<org.bson.Document> collection = database.getCollection("BookingRecords");
        BasicDBObject document = new BasicDBObject();
        collection.deleteMany(document);
        for(int i=0;i<SEATING_CAPACITY;i++){
            if (seat[0][i]!=null){
                org.bson.Document data = new org.bson.Document("title", "BookingRecord")
                        .append("seatNumber", i+1)  //creating and appending elements to the document
                        .append("direction", 0)
                        .append("name", seat[0][i]);
                collection.insertOne(data);  //exporting the record
            }
        }
        for (int i=0;i<SEATING_CAPACITY;i++){
            if (seat[1][i]!=null){
                org.bson.Document data = new org.bson.Document("title", "BookingRecord")
                        .append("seatNumber", i+1)
                        .append("direction", 1)    //creating and adding elements to th document
                        .append("name", seat[1][i]);
                collection.insertOne(data);  //exporting the record
            }
        }
        System.out.println("\nAll Records have been Saved.");
    }
    private static String[][] LoadProgramDataFromFile(String[][] seat) {
        //accessing the online database
        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongo.getDatabase("TrainBooking");
        MongoCollection<Document> collection = database.getCollection("BookingRecords"); //getting the collection
        FindIterable<Document> data = collection.find();
        for(Document temp :data){
            //loading elements from the file to the data structure
            int direction = temp.getInteger("direction");
            int seatNum = temp.getInteger("seatNumber")-1;
            seat[direction][seatNum]=temp.getString("name");
        }
        System.out.println("\nAll Records has been imported from the Database");
        return seat;
    }
    private static void displaySeatsInAlphabeticalOrder (String[][] seat) {
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1 to view sorted namelist of bookings from colombo to badulla:");
            System.out.println("Enter 2 to view sorted namelist of bookings from badulla to colombo:");
            System.out.println("Enter any letter to quit to main menu:");
            int choice ;
            try {  //checking whether input is a integer or not
                choice= sc.nextInt();
            } catch (InputMismatchException e) {
                break;
            }
            if(choice==1|| choice==2){
                ArrayList<String> enteredSeats=new ArrayList<>();
                for (int i=0; i<SEATING_CAPACITY; i++){ //adding array elements to a temp list
                    if(seat[choice-1][i]!=null) {
                        enteredSeats.add(seat[choice-1][i]+ " - "+ Integer.toString(i+1)); //converting integers into string
                    }
                }
                if(enteredSeats.size()==0){  //checking temp list is empty
                    System.out.println("No entries to set Alphabetical order");
                    return;
                }
                Boolean flag=Boolean.TRUE;
                String tempory=new String("");
                while (flag){
                    for (int i=0;i<enteredSeats.size();i++){
                        for (int k=0;k<enteredSeats.size();k++){ //sorting the tempory list
                            flag=false;
                            if(enteredSeats.get(i).compareToIgnoreCase(enteredSeats.get(k))<0){
                                tempory=enteredSeats.get(i);
                                enteredSeats.set(i,enteredSeats.get(k));
                                enteredSeats.set(k,tempory);
                                flag=true;
                            }
                        }
                    }
                }
                for (String enteredSeat : enteredSeats) {
                    System.out.println(enteredSeat); //printing the tempory list of sorted names
                }
            }else{
                System.out.println("Enter either 1 or 2");
            }
            break;
        }
    }

    @Override
    public void start(Stage stage)  {
        String[][] seat = new String[2][SEATING_CAPACITY];
        String green="\u001B[32m"; //for colors in text
        String def="\u001B[0m";
        String blue="\u001B[34m";
        //String
        System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println(green+" ++ Welcome to Denuwara Manike Seat Booking System ++ "+def);
        System.out.println("******************************************************");
        System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
        while (true) {
            System.out.println();
            System.out.println(blue+"\nEnter \"A\" for add a Customer:");
            System.out.println("Enter \"V\" for view all seats:");
            System.out.println("Enter \"E\" for view empty seats:");
            System.out.println("Enter \"D\" for delete a booked seat:");
            System.out.println("Enter \"F\" for find a seat by Customer Name:");
            System.out.println("Enter \"O\" for view seats by Alphabetical Order:");
            System.out.println("Enter \"S\" for Store the data to a file:");
            System.out.println("Enter \"L\" for Load data from the file:");
            System.out.println("Enter \"Q\" for Quit:"+def);
            Scanner sc = new Scanner(System.in);
            System.out.print("\nPlease Select an Option: ");
            String option = sc.next();
            option = option.toUpperCase();
            switch (option) {
                case "A":
                    addCustomer(seat);
                    //System.out.println(Arrays.deepToString(seat));
                    break;
                case "V":
                    viewAllSeats(seat);
                    break;
                case "E":
                    viewEmptySeats(seat);
                    break;
                case "D":
                    deleteBookedSeat(seat);
                    break;
                case "F":
                    findSeatByCustomer(seat);
                    break;
                case "S":
                    StoreProgramDataInToFile(seat);
                    break;
                case "L":
                    LoadProgramDataFromFile(seat);
                    break;
                case "O":
                    displaySeatsInAlphabeticalOrder(seat);
                    break;
                case "Q":
                    System.out.println("******************** Thank you!! *********************");
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    System.exit(0); //exit from the programme
                    break;
                default:
                    System.out.println("Invalid Selection\nPlease enter the relevant letter");
                    break;
            }
        }
    }
}