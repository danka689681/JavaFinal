package nl.inholland.javafx.endassignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Map;

public class getTableData {
        public void initialize(TableView tableRoom, int num, MoviesDatabase moviesDatabase) {
            TableColumn start = new TableColumn("Start");
            TableColumn end = new TableColumn("End");
            TableColumn title = new TableColumn("Title");
            TableColumn seats = new TableColumn("Seats");
            TableColumn price = new TableColumn("Price");

            if (tableRoom.getColumns().isEmpty()) {
                tableRoom.getColumns().addAll(start, end, title, seats, price);
            }
            ObservableList<Movie> data = FXCollections.observableArrayList(num == 1 ? moviesDatabase.getRoom1() : moviesDatabase.getRoom2());
            start.setCellValueFactory(new PropertyValueFactory<Movie, String>("startString"));
            end.setCellValueFactory(new PropertyValueFactory<Movie, String>("endString"));
            title.setCellValueFactory(new PropertyValueFactory<Movie, String>("title"));
            seats.setCellValueFactory(new PropertyValueFactory<Movie, Integer>("seats"));
            price.setCellValueFactory(new PropertyValueFactory<Movie, Double>("price"));
            tableRoom.setItems(data);
        }
 }



