package ui;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestNGGroups
{
  @BeforeGroups("Smoke Test, Regression")
  public void setup()
  {
    System.out.println("Launching URL");
  }

  @Test(groups={"Smoke Test"})
  public void method1()
  {
    System.out.println("Smoke");
  }

  @Test(groups={"Regression"}, dependsOnGroups = {"Smoke Test"})
  public void method2()
  {
    System.out.println("Regression-1");
  }

  @Test(groups={"Regression"}, dependsOnGroups = {"Smoke Test"})
  public void method3()
  {
    System.out.println("Regression-2");
  }
  
}