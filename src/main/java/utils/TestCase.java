package utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotations, a form of metadata, provide data about a program that is not part of the program itself.
 * Annotations have no direct effect on the operation of the code they annotate.
 * Annotations have a number of uses, among them:
 *
 * Information for the compiler — Annotations can be used by the compiler to detect errors or suppress warnings.
 * Compile-time and deployment-time processing — Software tools can process annotation information to generate code,
 *              XML files, and so forth.
 * Runtime processing — Some annotations are available to be examined at runtime.
 *
 * More details at https://docs.oracle.com/javase/tutorial/java/annotations/
 *
 * In this example we are using annotation for "runtime processing", store the test case number.
 * When we will write this annotation near test method like @TestCase(id = "1"), then in any place
 * of java code we will be able to get value of 'id' and use it to post results to the TestRail.
 * This is called bidirectional link and it helps to update test run results in TestRail automatically.
 *
 * We can write annotation for and use it with any 3rd party tool, annotation is just a holder for information.
 * Results in TestRail will be updating different code - ListenerTest, updateTestRun method.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //can use in method only.
public @interface TestCase {

    //should ignore this test?
    public String id() default "";

}