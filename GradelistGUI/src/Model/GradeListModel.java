package Model;

public interface GradeListModel
{
  public void addGrade(Grade grade);

  public void removeGrade(int index);

  public void removeGrade(Grade grade);

  public int gradeListSize();

  public Grade getGrade(int index);

  public Grade getMaxGrade();

  public Grade getMinGrade();

  public double getAverageGrade();

  public boolean isLegalGrade();

  public String validateLogin
}
