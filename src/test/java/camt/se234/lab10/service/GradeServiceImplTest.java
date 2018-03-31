package camt.se234.lab10.service;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
@RunWith(JUnitParamsRunner.class)
public class GradeServiceImplTest {
    @Test
    public void testGetGrade(){
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(100),is("A"));
        assertThat(gradeService.getGrade(80),is("A"));
        assertThat(gradeService.getGrade(78.9),is("B"));
        assertThat(gradeService.getGrade(75),is("B"));
        assertThat(gradeService.getGrade(74.4),is("C"));
        assertThat(gradeService.getGrade(60),is("C"));
        assertThat(gradeService.getGrade(59.4),is("D"));
        assertThat(gradeService.getGrade(33),is("D"));
        assertThat(gradeService.getGrade(32),is("F"));
        assertThat(gradeService.getGrade(0),is("F"));
    }
    @Test
    @Parameters(method="paramsForTestGetGradeParams")
    @TestCaseName("Test getGrade Params [{index}] : input is {0},expect \"{1}\"")
    public void testGetGradeparams(double score,String expectedGrade){
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(score),is(expectedGrade));
    }
    public Object paramsForTestGetGradeParams(){
        return new Object[][]{
                {100,"A"},
                {77,"B"},
                {66,"C"},
                {55,"D"},
                {20,"F"}
        };
    }
    @Test
    @Parameters(method="paramsForTestGetGradeParams2")
    @TestCaseName("Test getGrade Params [{index}] : input is {0} and {1},expect \"{2}\"")
    public void testGetGradeparams2(double midtermScore,double finalScore,String expectedGrade){
        GradeServiceImpl gradeService = new GradeServiceImpl();
        assertThat(gradeService.getGrade(midtermScore,finalScore),is(expectedGrade));
    }
    public Object paramsForTestGetGradeParams2(){
        return new Object[][]{
                {50,50,"A"},
                {30,47,"B"},
                {33,33,"C"},
                {25,30,"D"},
                {10,10,"F"}
        };
    }
}