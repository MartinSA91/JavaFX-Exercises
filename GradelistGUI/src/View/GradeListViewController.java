package View;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import model.*;
import java.util.Optional;
public class GradeListViewController
{
  @FXML private TableView<GradeViewModel> gradeListTable;
  @FXML private TableColumn<GradeViewModel, Number> gradeColumn;
  @FXML private TableColumn<GradeViewModel, String> courseColumn;
  @FXML private Label errorLabel;
  private Region root;
  private GradeListModelmodel;
  private ViewHandlerviewHandler;
  private GradeListViewModelviewModel;

  public GradeListViewController()
  {

  }
  public void init(ViewHandler viewHandler, GradeListModel model, Region root)
  {
    this.model= model;
    this.viewHandler= viewHandler;
    this.root= root;
    this.viewModel= new GradeListViewModel(model);
    gradeColumn.setCellValueFactory(cellData-> cellData.getValue().getGradeProperty());
    courseColumn.setCellValueFactory(cellData-> cellData.getValue().getCourseProperty());
    gradeListTable.setItems(viewModel.getList());
  }
  public void reset()
  {
    errorLabel.setText("");
    viewModel.update();
  }
  public Region getRoot()
  {
    return root;
  }
  @FXML private void addGradeButtonPressed()
  {
    viewHandler.openView("add");
  }
  @FXML private void showGradeDetailsButtonPressed()
  {
    viewHandler.openView("details");
  }
  @FXML private void removeGradeButtonPressed()
  {
    errorLabel.setText("");
    try
    {
      GradeViewModel selectedItem= gradeListTable.getSelectionModel().getSelectedItem();
      boolean remove = confirmation();if (remove)
      {
        Grade grade= new Grade(selectedItem.getGradeProperty().get(),selectedItem.getCourseProperty().get());
        model.removeGrade(grade);
        viewModel.remove(grade);
        gradeListTable.getSelectionModel().clearSelection();
      }
    }
    catch (Exception e)
    {
      errorLabel.setText("Item not found: " + e.getMessage());
    }
  }
  private boolean confirmation()
  {
    int index = gradeListTable.getSelectionModel().getSelectedIndex();
    GradeViewModel selectedItem= gradeListTable.getItems().get(index);
    if (index < 0 || index >= gradeListTable.getItems().size())
    {
      return false;
    }
    Alert alert= new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Confirmation");
    alert.setHeaderText("Removing grade {"  + selectedItem.getCourseProperty().get() + ": "+ selectedItem.getGradeProperty().get() + "}");
    Optional<ButtonType> result = alert.showAndWait();
    return (result.isPresent())&&(result.get()==ButtonType.OK);
  }
}
