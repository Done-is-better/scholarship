package com.example.scholarship_backend.utils;

import com.example.scholarship_backend.entity.Students;
import org.springframework.context.annotation.Configuration;

/**
 * @author chixinyu
 * @version 2022/1/31 21:43
 */
@Configuration
public class CalculateScore {
    /*
    * 学期平均绩点=∑（每一科绩点*每一科学分）/该学期学分总和
    *
    * s1-s10 绩点：3,4,5,6,4,4,4,3,3,4
    *
    * 成绩100分=绩点5.0 成绩91分=绩点4.1 成绩86分=绩点3.6 成绩80分=绩点3.0 成绩73分=绩点2.3 成绩66分=绩点1.6
    * 成绩60分=绩点1.0 成绩<60分，不好意思，无论多少，绩点都是0
    *
     * */

    //各科绩点计算
    public double compute(double score){
        if(score == 100.0) return 5.0;
        double tens = score/10 - (score%10)/10 -5;
        double units = (score%10)/10;
        if(tens >= 1.0) return tens + units;
        else return 0.0;
    }
    public double computeTenSubjects(Students s){
        double totalScore = compute(s.getScore1())*3 + compute(s.getScore2())*4
                + compute(s.getScore3())*5 + compute(s.getScore4())*6
                + compute(s.getScore5())*4 + compute(s.getScore6())*4
                + compute(s.getScore7())*4 + compute(s.getScore8())*3
                + compute(s.getScore9())*3 + compute(s.getScore10())*4;
        return totalScore/40;
    }
}
