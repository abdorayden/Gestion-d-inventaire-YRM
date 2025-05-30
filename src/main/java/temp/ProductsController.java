package temp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import stateMachin.BaseController;
import stateMachin.ControllerStateMachine;

public class ProductsController extends BaseController {
    @FXML private Label titleLabel;
    @FXML private ListView<String> productListView;
    @FXML private Button detailsButton;
    @FXML private Button popupButton;
    @FXML private Button locationButton;

    private boolean initialized = false;

    public ProductsController(ControllerStateMachine stateMachine) {
        super(stateMachine);
    }



    private void initialize() {
        if (initialized) return;

        // Setup button actions
      //  locationButton.setOnAction(e -> goToLocation());

        // Load items asynchronously
        Platform.runLater(() -> {
            productListView.getItems().addAll("Product 1", "Product 2", "Product 3");
        });

        initialized = true;
    }







    @Override
    public void onEnter() {
        super.onEnter();
        // Refresh data if needed when entering this state
        if (productListView != null && productListView.getItems().isEmpty()) {
            Platform.runLater(() -> {
                productListView.getItems().addAll("Product 1", "Product 2", "Product 3");
            });
        }
    }
}//
