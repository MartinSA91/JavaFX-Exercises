package View;

import Model.LoginModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
  private Scene currentScene;
  private Stage primaryStage;
  private LoginGUIController loginGUIController;
  private LoginModel loginModel;
  public ViewHandler(LoginModel loginModel)
  {
    this.currentScene= new Scene(new Region());
    this.loginModel = loginModel;
  }
  public void start(Stage primaryStage)
  {
    this.primaryStage= primaryStage;
    openView();
  }
  public void openView()
  {
    Region root = loadSimpleGUIView("LoginGUI.fxml");
    currentScene.setRoot(root);
    String title = "";
    if (root.getUserData() != null)
    {
      title += root.getUserData();
    }
    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }
  private Region loadSimpleGUIView(String fxmlFile)
  {
    if (loginGUIController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        Region root= loader.load();
        loginGUIController = loader.getController();
        loginGUIController.init(this, loginModel, root);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }

    }
    else
    {
      loginGUIController.reset();
    }
    return loginGUIController.getRoot();
  }

public void closeView()
{
  primaryStage.close();
}
}

