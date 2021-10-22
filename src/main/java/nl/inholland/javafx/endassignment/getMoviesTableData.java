package nl.inholland.javafx.endassignment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class getMoviesTableData {
        public void initialize(TableView tableMovie, MoviesDatabase moviesDatabase) {
            TableColumn title = new TableColumn("Title");
            TableColumn price = new TableColumn("Price");
            TableColumn duration = new TableColumn("Duration");

            if (tableMovie.getColumns().isEmpty()) {
                tableMovie.getColumns().addAll(title, price, duration);
            }
            ObservableList<Movie> data = FXCollections.observableArrayList(moviesDatabase.getWholeDatabase());
            title.setCellValueFactory(new PropertyValueFactory<Movie, String>("title"));
            price.setCellValueFactory(new PropertyValueFactory<Movie, String>("price"));
            duration.setCellValueFactory(new PropertyValueFactory<Movie, String>("duration"));
            tableMovie.setItems(data);
        }
 }



