package nl.inholland.javafx.endassignment;
import javafx.application.Application;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.converter.DateTimeStringConverter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException, ParseException {
        // database setup
        StreamingDatabase streamingDatabase = new StreamingDatabase();
        RoomsDatabase roomsDatabase = new RoomsDatabase();
        MoviesDatabase moviesDatabase = new MoviesDatabase();
        // LOGIN STYLING
        GridPane loginScene = new GridPane();
        Label userNameLabel = new Label("Username");
        TextField userName = new TextField();
        Label passwordLabel = new Label("Password");
        PasswordField password = new PasswordField();
        Button loginBtn = new Button("Log in");
        Label errorMessage = new Label();

        errorMessage.setTextFill(Color.web("#ff0000"));

        VBox vboxLogin1 = new VBox(10);
        VBox vboxLogin2 = new VBox(10);
        HBox hboxLogin = new HBox(10);

        vboxLogin1.getChildren().addAll(userNameLabel, passwordLabel, loginBtn, errorMessage);
        vboxLogin2.getChildren().addAll(userName, password);
        hboxLogin.getChildren().addAll(vboxLogin1, vboxLogin2);

        loginScene.add(hboxLogin, 0, 0);

        loginScene.setPadding(new Insets(25, 25, 25, 25));
        loginScene.setAlignment(Pos.CENTER);
        Scene login = new Scene(loginScene, Color.ORANGE);


        // NAVBAR STYLING
        Menu adminBtn = new Menu("Admin");
        MenuItem menuShowings = new MenuItem("Manage showings");
        MenuItem menuMovies = new MenuItem("Manage movies");
        adminBtn.getItems().addAll(menuShowings, menuMovies);
        Menu helpBtn = new Menu("Help");
        MenuItem h1 = new MenuItem("About");
        helpBtn.getItems().add(h1);

        Button logoutBtn = new Button("Logout");

        // HOME STYLING
        GridPane homeScene = new GridPane();
        homeScene.setHgap(30);
        homeScene.setVgap(30);

        // purchase part
        Label heading = new Label("Purchase tickets");
        heading.setId("heading");
        Label room = new Label("Room");
        Label start = new Label("Start");
        Label end = new Label("End");
        Label roomValue = new Label();
        Label startDate = new Label();
        Label endDate = new Label();
        Label title = new Label("Movie title");
        Label seats = new Label("No. of seats");
        Label name = new Label("Name");
        Label titleValue = new Label();
        ComboBox comboSeats = new ComboBox();
        TextField nameField = new TextField();
        Button purchaseBtn = new Button("Purchase");
        Button clearBtn = new Button("Clear");
        Label room1 = new Label("Room 1");
        Label room2 = new Label("Room 2");
        TableView tableRoom1 = new TableView();
        TableView tableRoom2 = new TableView();
        Label errorMessageHome = new Label();

        VBox vboxFooterPurchase1 = new VBox(10);
        VBox vboxFooterPurchase2 = new VBox(10);
        VBox vboxFooterPurchase3 = new VBox(10);
        VBox vboxFooterPurchase4 = new VBox(10);
        VBox vboxFooterPurchase5 = new VBox(10);
        HBox hboxFooterPurchase = new HBox(10);

        vboxFooterPurchase1.getChildren().addAll(room, start, end);
        vboxFooterPurchase2.getChildren().addAll(roomValue, startDate, endDate);
        vboxFooterPurchase3.getChildren().addAll(title, seats, name);
        vboxFooterPurchase4.getChildren().addAll(titleValue, comboSeats, nameField);
        vboxFooterPurchase5.getChildren().addAll(purchaseBtn, clearBtn);
        hboxFooterPurchase.getChildren().addAll(vboxFooterPurchase1, vboxFooterPurchase2, vboxFooterPurchase3, vboxFooterPurchase4, vboxFooterPurchase5);


        // showings part
        Label Title = new Label("Movie title");
        Label Room = new Label("Room");
        Label Start = new Label("Start");
        Label End = new Label("End");
        ComboBox titleCombo = new ComboBox();
        Label selectedMovie = new Label();
        for (String i : moviesDatabase.getTitle()) {
            titleCombo.getItems().add(i);
        }
        ComboBox roomCombo = new ComboBox();
        roomCombo.getItems().addAll("Room 1", "Room 2");
        Label seatValueShowings = new Label();
        Label price = new Label("Price");
        DatePicker datePicker = new DatePicker(LocalDate.now());
        Label Seats = new Label("No. of seats");

        Label movieEndTime = new Label();
        Label movieEndDate = new Label();
        Label movieEndDateTime = new Label();

        Label priceValue = new Label();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        TextField time = new TextField();
        time.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse(LocalTime.now().toString())));
        Button addShowingBtn = new Button("Add showing");
        Button clearShowing = new Button("Clear");

        HBox hBoxFooterShowings = new HBox(10);
        HBox hBoxRooms = new HBox(10);
        VBox vboxRoom1 = new VBox(10);
        VBox vboxRoom2 = new VBox(10);
        HBox hboxErrorMessage = new HBox(10);

        hboxErrorMessage.setId("errorMesage");
        hboxErrorMessage.getChildren().addAll(errorMessageHome);
        vboxRoom1.getChildren().addAll(room1, tableRoom1);
        vboxRoom2.getChildren().addAll(room2, tableRoom2);
        hBoxRooms.getChildren().addAll(vboxRoom1, vboxRoom2);

        // navbar
        BorderPane borderPane = new BorderPane();
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(adminBtn, helpBtn);
        HBox hboxMenu = new HBox();
        VBox vboxMenu = new VBox(20);
        hboxMenu.getChildren().addAll(menuBar, logoutBtn);
        vboxMenu.getChildren().addAll(hboxMenu, heading);
        hboxMenu.setId("MenuBar");
        borderPane.setTop(vboxMenu);
        borderPane.setCenter(homeScene);

        // Home part
        homeScene.add(hBoxRooms, 0, 2);
        homeScene.add(hboxFooterPurchase, 0, 3);
        homeScene.add(hBoxFooterShowings, 0, 3);
        homeScene.add(hboxErrorMessage, 0, 4);

        hboxFooterPurchase.setId("footer");
        hBoxFooterShowings.setId("footer");

        // Movie scene
        Label MovieTitle = new Label("Title");
        Label MoviePrice = new Label("Price");
        Label MovieDuration = new Label("Duration");

        TextField MovieTitleValue = new TextField();
        TextField MoviePriceValue = new TextField();
        TextField MovieDurationValue = new TextField();
        TableView tableMovie = new TableView();
        new getMoviesTableData().initialize(tableMovie, moviesDatabase);

        Button addMovieBtn = new Button("Add movie");
        Button clearMovie = new Button("Clear");

        HBox hBoxFooterMovie = new HBox(10);
        VBox vboxMovies1 = new VBox(10);
        VBox vboxMovies2 = new VBox(10);
        VBox vboxMovies3 = new VBox(10);
        VBox vboxMovies4 = new VBox(10);

        vboxMovies1.getChildren().addAll(MovieTitle, MovieTitleValue);
        vboxMovies2.getChildren().addAll(MoviePrice, MoviePriceValue);
        vboxMovies3.getChildren().addAll(MovieDuration, MovieDurationValue);
        vboxMovies4.getChildren().addAll(addMovieBtn, clearMovie);

        hBoxFooterMovie.getChildren().addAll(vboxMovies1, vboxMovies2, vboxMovies3, vboxMovies4);

        GridPane movieScene = new GridPane();
        movieScene.setHgap(30);
        movieScene.setVgap(30);
        movieScene.add(tableMovie, 0, 2);
        movieScene.add(hBoxFooterMovie, 0, 3);
        movieScene.add(hboxErrorMessage, 0, 4);

        List<Stream> database = new ArrayList<>();
        database = streamingDatabase.getWholeDatabase();
        List<Stream> finalDatabase = database;

        List<Movie> databaseMovie = new ArrayList<>();
        databaseMovie = moviesDatabase.getWholeDatabase();
        List<Movie> finalDatabaseMovie = databaseMovie;


        titleCombo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String name) {
                if (name != null) {
                    time.setText(String.format(time.getText(), "00:00"));
                    selectedMovie.setText(name);
                    getDuration(moviesDatabase, name, finalDatabaseMovie, time, movieEndDate, movieEndTime, movieEndDateTime, errorMessageHome, datePicker);
                    int index = moviesDatabase.getMovieIndex(name);
                    double moviePrice = finalDatabaseMovie.get(index).getPrice();
                    priceValue.setText(String.valueOf(moviePrice));
                }
            }
        });

        List<Rooms> databaseRooms = new ArrayList<>();
        databaseRooms = roomsDatabase.getRoomsData();
        List<Rooms> finalDatabaseRooms = databaseRooms;
        roomCombo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String name) {
                if (name != null) {
                    int index = roomsDatabase.getRoomsDataIndex(name);
                    int roomCapacity = finalDatabaseRooms.get(index).getCapacity();
                    seatValueShowings.setText(String.valueOf(roomCapacity));
                }
            }
        });

        time.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(time);

            if (!selectedMovie.getText().isEmpty()) {
                getDuration(moviesDatabase, selectedMovie.getText(), finalDatabaseMovie, time, movieEndDate, movieEndTime, movieEndDateTime, errorMessageHome, datePicker);
            }

        });

        homeScene.setPadding(new Insets(10, 10, 10, 10));
        homeScene.setAlignment(Pos.CENTER);

        movieScene.setPadding(new Insets(10, 10, 10, 10));
        movieScene.setAlignment(Pos.CENTER);
        hBoxFooterShowings.setVisible(false);

        VBox vboxShowings1 = new VBox(10);
        VBox vboxShowings2 = new VBox(10);
        VBox vboxShowings3 = new VBox(10);
        VBox vboxShowings4 = new VBox(10);
        VBox vboxShowings5 = new VBox(10);
        VBox vboxShowings6 = new VBox(10);

        vboxShowings1.getChildren().addAll(Title, Room, Seats);
        vboxShowings2.getChildren().addAll(titleCombo, roomCombo, seatValueShowings);
        vboxShowings3.getChildren().addAll(Start, End, price);
        vboxShowings4.getChildren().addAll(datePicker, movieEndDateTime, priceValue);
        vboxShowings5.getChildren().addAll(time);
        vboxShowings6.getChildren().addAll(addShowingBtn, clearShowing);
        hBoxFooterShowings.getChildren().addAll(vboxShowings1, vboxShowings2, vboxShowings3, vboxShowings4, vboxShowings5, vboxShowings6);


        // Stage settings
        stage.setHeight(300);
        stage.setWidth(300);
        homeScene.getStylesheets().add("style.css");
        movieScene.getStylesheets().add("style.css");
        borderPane.getStylesheets().add("style.css");
        login.getStylesheets().add("style.css");
        Scene movie = new Scene(movieScene);
        Scene home = new Scene(borderPane, Color.ORANGE);
        stage.setTitle("Fabulous Cinema --Login");
        stage.setScene(login);
        stage.show();


        // Dialog stage

        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        HBox dialogHbox = new HBox(20);
        Text dialogText = new Text("Confirm purchase");
        Button confirmBtn = new Button("Confirm");
        Button cancelBtn = new Button("Cancel");
        dialogHbox.getChildren().addAll(confirmBtn, cancelBtn);
        dialogVbox.getChildren().addAll(dialogText, dialogHbox);

        GridPane dialogScene = new GridPane();
        dialogScene.setPadding(new Insets(25, 25, 25, 25));
        dialogScene.setAlignment(Pos.CENTER);
        dialogScene.add(dialogVbox, 0, 0);
        dialogStage.setHeight(300);
        dialogStage.setWidth(300);
        Scene dialog = new Scene(dialogScene);
        dialogStage.setTitle("Fabulous Cinema --confirm purchase");
        dialogStage.setScene(dialog);

        // LOGIN LOGIC
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                // get users
                UsersDatabase db = new UsersDatabase();
                ObservableList<User> users = FXCollections.observableArrayList(db.getUsers());
                StringProperty passwordFieldProperty = password.textProperty();

                if (!userName.getText().isEmpty()) {
                    String usernameInput = String.valueOf(userName.getText());
                    String passwordInput = passwordFieldProperty.getValue();
                    boolean userExists = false;
                    // find if user exists
                    for (User u : users) {
                        System.out.println(u);
                        if (u.toString().equals(usernameInput)) {
                            userExists = true;
                        }
                    }
                    if (userExists) {
                        int userIndex = IndexOf(users, usernameInput);
                        String passwordFromDb = users.get(userIndex).getPassword();
                        User userFromDb = users.get(userIndex);
                        if (passwordInput.equals(passwordFromDb)) {

                            // Change scene to Homepage + implement logic class

                            new getStreamingTableData().initialize(tableRoom1, 1, streamingDatabase);
                            new getStreamingTableData().initialize(tableRoom2, 2, streamingDatabase);
                            if (userFromDb instanceof Admin) {
                                adminBtn.setVisible(true);
                            } else {
                                adminBtn.setVisible(false);

                            }
                            stage.setHeight(700);
                            stage.setWidth(800);

                            borderPane.setCenter(homeScene);
                            stage.setScene(home);
                            stage.setTitle("Fabulous Cinema-- -- purchase tickets -- username: " + usernameInput);
                            stage.show();

                        } else {
                            errorMessage.setText("Wrong password!");
                        }
                    } else {
                        errorMessage.setText("User with this username does not exist!");
                    }
                } else {
                    errorMessage.setText("Enter your username!");
                }
            }
        });

        // HOME LOGIC
        logoutBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                userName.clear();
                password.clear();
                stage.setTitle("Fabulous Cinema --Login");
                stage.setHeight(300);
                stage.setWidth(300);
                stage.setScene(login);
                stage.show();
            }
        });


        clearBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hboxFooterPurchase.setVisible(false);
                startDate.setText("");
                endDate.setText("");
                titleValue.setText("");
                comboSeats.getItems().clear();
                nameField.clear();
            }
        });

        clearShowing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                movieEndDateTime.setText("");
                priceValue.setText("");
                seatValueShowings.setText("");
                datePicker.setValue(LocalDate.now());
                time.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
                roomCombo.setValue(null);
                titleCombo.setValue(null);
                nameField.clear();
            }
        });

        addShowingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean overlaps = false;
                String pattern = "dd-MM-yyyy";
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
                String timePattern = "HH:mm";
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(timePattern);
                LocalTime newMovieStartTime = LocalTime.parse(time.getText(), timeFormatter).minusMinutes(15);
                LocalDate newMovieStartDate = datePicker.getValue();
                LocalTime newMovieEndTime = LocalTime.parse(movieEndTime.getText()).plusMinutes(15);
                LocalDate newMovieEndDate = newMovieEndTime.isBefore(newMovieStartTime) ? LocalDate.parse(movieEndDate.getText(), dateFormatter) : LocalDate.parse(movieEndDate.getText(), dateFormatter).plusDays(1);
                String room = roomCombo.getValue().toString();
                List<Stream> selectedRoom = room == "Room 1" ? streamingDatabase.getRoom1() : streamingDatabase.getRoom2();
                int index = streamingDatabase.getRoomsIndex(titleCombo.getValue().toString());
                int duration = finalDatabase.get(index).getDuration();

                errorMessageHome.setText("");
                for (int i = 0; i < selectedRoom.size(); i++) {
                    LocalTime startTime = LocalTime.parse(selectedRoom.get(i).getStart().get("startTime"), timeFormatter);
                    LocalDate startDate = LocalDate.parse(selectedRoom.get(i).getStart().get("startDate"), dateFormatter);
                    LocalTime endTime = LocalTime.parse(selectedRoom.get(i).getEnd().get("endTime"), timeFormatter);

                    if (startDate.equals(newMovieStartDate) && ((startTime.isBefore(newMovieStartTime) && (endTime.isAfter(newMovieStartTime)) || ((startTime.isAfter(newMovieStartTime) && startTime.isBefore(newMovieEndTime))) || startTime.equals(newMovieStartTime) || endTime.equals(newMovieEndTime)))) {
                        errorMessageHome.setText("Showings in the same room must not overlap. Please enter different date or time");
                        overlaps = true;
                        break;
                    }
                }
                if (!overlaps) {
                    errorMessage.setText("");

                    streamingDatabase.createStream(
                            selectedRoom,
                            newMovieStartDate.format(dateFormatter),
                            newMovieStartTime.format(DateTimeFormatter.ofPattern("HH:mm")),
                            newMovieEndDate.format(dateFormatter),
                            newMovieEndTime.format(DateTimeFormatter.ofPattern("HH:mm")),
                            titleCombo.getValue().toString(),
                            Integer.parseInt(seatValueShowings.getText()),
                            Double.parseDouble(priceValue.getText()),
                            finalDatabase,
                            duration
                    );

                    if (room == "Room 1") {
                        new getStreamingTableData().initialize(tableRoom1, 1, streamingDatabase);
                    } else {
                        new getStreamingTableData().initialize(tableRoom2, 2, streamingDatabase);
                    }
                }
            }
        });


        TableInteraction(tableRoom1, startDate, endDate, titleValue, comboSeats, roomValue, "Room 1", hboxFooterPurchase, hBoxFooterShowings, heading);
        TableInteraction(tableRoom2, startDate, endDate, titleValue, comboSeats, roomValue, "Room 2", hboxFooterPurchase, hBoxFooterShowings, heading);

        purchaseBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Integer.parseInt(comboSeats.getValue().toString()) > 0 && nameField.getText().isEmpty() == false) {
                    errorMessageHome.setText("");
                    dialogStage.show();

                } else {
                    errorMessageHome.setText(nameField.getText().isEmpty() ? "Please enter your name" : "Enter amount of tickets you want to purchase");
                }
            }
        });

        confirmBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int newSeatValue = 0;
                if (roomValue.getText().equals("Room 1")) {
                    int index = streamingDatabase.getRoom1Index(titleValue.getText());
                    int originSeatsValue = streamingDatabase.getRoom1().get(index).getSeats();
                    newSeatValue = originSeatsValue - Integer.parseInt(comboSeats.getValue().toString());
                    streamingDatabase.getRoom1().get(index).setSeats(newSeatValue);
                    tableRoom1.getItems().clear();
                    new getStreamingTableData().initialize(tableRoom1, 1, streamingDatabase);
                } else {
                    int index = streamingDatabase.getRoom2Index(titleValue.getText());
                    int originSeatsValue = streamingDatabase.getRoom2().get(index).getSeats();
                    newSeatValue = originSeatsValue - Integer.parseInt(comboSeats.getValue().toString());
                    streamingDatabase.getRoom2().get(index).setSeats(newSeatValue);
                    tableRoom2.getItems().clear();
                    new getStreamingTableData().initialize(tableRoom2, 2, streamingDatabase);
                }

                comboSeats.getItems().clear();
                for (int i = 1; i <= newSeatValue; i++) {
                    comboSeats.getItems().add(i);
                }
                dialogStage.close();
            }
        });

        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialogStage.close();
            }
        });

        // SHOWINGS
        menuShowings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String usernameInput = String.valueOf(userName.getText());
                hBoxFooterShowings.setVisible(true);
                hboxFooterPurchase.setVisible(false);
                borderPane.setCenter(homeScene);
                stage.setScene(home);
                heading.setText("Manage showings");
                stage.setTitle("Fabulous Cinema-- -- manage showings -- username: " + usernameInput);
                MovieTitleValue.clear();
                MovieDurationValue.clear();
                MoviePriceValue.clear();
            }
        });

        // MOVIES
        menuMovies.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String usernameInput = String.valueOf(userName.getText());
                heading.setText("Manage movies");
                borderPane.setCenter(movieScene);
                stage.setScene(home);
                stage.setTitle("Fabulous Cinema-- -- manage movies -- username: " + usernameInput);
                movieEndDateTime.setText("");
                priceValue.setText("");
                seatValueShowings.setText("");
                datePicker.setValue(LocalDate.now());
                time.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
                roomCombo.setValue(null);
                titleCombo.setValue(null);
                nameField.clear();
            }
        });


        clearMovie.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MovieTitleValue.clear();
                MovieDurationValue.clear();
                MoviePriceValue.clear();
            }
        });

        addMovieBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean movieExists = false;
                for (Movie movie : moviesDatabase.getWholeDatabase()) {
                    if (movie.getTitle().equals(MovieTitleValue.getText())) {
                        errorMessageHome.setText("Movie with same title already exists");
                        movieExists = true;
                        break;
                    }
                }
                if (!movieExists) {
                    MoviesDatabase.createMovie(moviesDatabase.getWholeDatabase(), MovieTitleValue.getText(), Double.parseDouble(MoviePriceValue.getText()), Integer.parseInt(MovieDurationValue.getText()));
                    new getMoviesTableData().initialize(tableMovie, moviesDatabase);
                    titleCombo.getItems().add(MovieTitleValue.getText());
                }
            }
        });
    }


    public static int IndexOf(ObservableList array, String value) {
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            System.out.println(i);

            if (value.equals(array.get(i).toString())) {
                index = i;
                System.out.println(i);
            }
        }
        return index;
    }

    public void TableInteraction(TableView tableRoom, Label startDate, Label endDate, Label titleValue, ComboBox comboSeats, Label roomValue, String roomValueString, HBox hboxFooterPurchase, HBox hBoxFooterShowings, Label heading) {
        // table interaction

        tableRoom.setRowFactory(tv -> {
            TableRow<Stream> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!row.isEmpty())) {
                    hBoxFooterShowings.setVisible(false);
                    Stream rowData = row.getItem();
                    startDate.setText(rowData.getStartString());
                    System.out.println(rowData.getEndString());
                    endDate.setText(rowData.getEnd().get("endDate"));
                    titleValue.setText(rowData.getTitle());
                    comboSeats.getItems().clear();
                    for (int i = 1; i <= rowData.getSeats(); i++) {
                        comboSeats.getItems().add(i);
                    }
                    roomValue.setText(roomValueString);
                    hboxFooterPurchase.setVisible(true);
                    heading.setText("Purchase Tickets");

                }
            });
            return row;
        });
    }
        public void getDuration(MoviesDatabase moviesDatabase, String title, List<Movie> finalDatabase, TextField time, Label endDate,  Label endTime, Label movieEndDateTime, Label errorMessageHome, DatePicker datePicker) {
            String pattern = "dd-MM-yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            int index = moviesDatabase.getMovieIndex(title);
            int duration = finalDatabase.get(index).getDuration();
            int hours = duration / 60;
            int minutes = duration - hours * 60;
            try {
                LocalTime movieEndTime = LocalTime.parse(time.getText()).plusHours(hours).plusMinutes(minutes);
                LocalTime movieStartTime = LocalTime.parse(time.getText());
                LocalDate movieEndDate = movieEndTime.isBefore(movieStartTime) ? datePicker.getValue().plusDays(1) : datePicker.getValue();
                endTime.setText(movieEndTime.format(DateTimeFormatter.ofPattern("HH:mm")));
                endDate.setText(movieEndDate.format(dateFormatter));
                movieEndDateTime.setText(endDate.getText() + " " + endTime.getText());
                errorMessageHome.setText("");
            }
            catch(Exception e) {}
        };


}