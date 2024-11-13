package View;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Model.LoginModel;
import javafx.scene.layout.Region;

public class LoginGUIController
{
  @FXML private TextField inputField;
  @FXML private Label errorLabel;
  private Region root;
  private LoginModel loginModel;
  private ViewHandler viewHandler;

  public LoginGUIController()
  {

  }
  public void init(ViewHandler viewHandler, LoginModel loginModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.loginModel = loginModel;
    this.root = root;
  }
  public void reset()
  {
    inputField.setText("");
    errorLabel.setText("");
  }
  public Region getRoot()
  {
    return root;
  }
  @FXML private void loginButtonPressed()
  {
    boolean loggedIn = loginModel.isLoggedIn();
    if (loggedIn)
    {
      errorLabel.setText("yaaay");
    }
    else
    {
      errorLabel.setText("no bueno");
    }
  }

  @FXML private void cancelButtonPressed()
  {
    viewHandler.closeView();
  }
}

