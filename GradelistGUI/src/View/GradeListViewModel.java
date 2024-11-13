package View;

import javafx.collections.*;
import model;

public class GradeListViewModel
{
  private ObservableList<GradeViewModel> list;
  private GradeListModelmodel;
  public GradeListViewModel(GradeListModelmodel)
  {
    this.model= model;
    this.list= FXCollections.observableArrayList();
    update();
  }
  public void update()
  {
    list.clear();
    for (int i = 0; i < model.gradeListSize(); i++)
    {
      list.add(new GradeViewModel(model.getGrade(i)));
    }
  }
  public ObservableList<GradeViewModel> getList()
  {
    return list;
  }
  public void add(Grade grade)
  {
    list.add(new GradeViewModel(grade));
  }
  public void remove(Grade grade)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getCourseProperty().get().equals(grade.getCourse())&& list.get(i).getGradeProperty().get() == grade.getGrade())
      {
        list.remove(i);break;
      }
    }
  }
}
