package View;

import javafx.beans.property.*;
import model.Grade;
public class GradeViewModel
{
  private String PropertycourseProperty;
  private Integer PropertygradeProperty;

  public GradeViewModel(Grade grade)
  {
    courseProperty= new SimpleStringProperty(grade.getCourse());
    gradeProperty= new SimpleIntegerProperty(grade.getGrade());
  }
  public StringProperty getCourseProperty()
  {
    return courseProperty;
  }
  public IntegerProperty getGradeProperty()
  {
    return gradeProperty;
  }

}


