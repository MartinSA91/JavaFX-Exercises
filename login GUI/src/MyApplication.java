import Model.LoginModel;
import Model.LoginModelManager;
import View.ViewHandler;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application

    {
      public void start(Stage primaryStage)
      {
        LoginModel loginModel = new LoginModelManager();
        ViewHandler view = new ViewHandler(loginModel);
        view.start(primaryStage);
      }

    }
