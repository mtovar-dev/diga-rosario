/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects.Indicators;

import Tools.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MITM
 */
public class Zsi_nros_sem_day {
    private int ano;
    private int sem;
    private int day1;
    private int day2;
    private int day3;
    private int day4;
    private int day5;
    private int day6;
    private int day7;
    
    /**
     * 
     */
    public Zsi_nros_sem_day(){
        
    }

    /**
     * 
     * @param rs 
     */
    public Zsi_nros_sem_day(ResultSet rs){
        try{
            ano         = rs.getInt(1);
            sem         = rs.getInt(2);
            day1        = rs.getInt(3);
            day2        = rs.getInt(4);
            day3        = rs.getInt(5);
            day4        = rs.getInt(6);
            day5        = rs.getInt(7);
            day6        = rs.getInt(8);
            day7        = rs.getInt(9);
            
                    
        }catch(SQLException e){
            Tools.getErrorMessage(e.getStackTrace(),e.getMessage());
        }
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the sem
     */
    public int getSem() {
        return sem;
    }

    /**
     * @param sem the sem to set
     */
    public void setSem(int sem) {
        this.sem = sem;
    }

    /**
     * @return the day1
     */
    public int getDay1() {
        return day1;
    }

    /**
     * @param day1 the day1 to set
     */
    public void setDay1(int day1) {
        this.day1 = day1;
    }

    /**
     * @return the day2
     */
    public int getDay2() {
        return day2;
    }

    /**
     * @param day2 the day2 to set
     */
    public void setDay2(int day2) {
        this.day2 = day2;
    }

    /**
     * @return the day3
     */
    public int getDay3() {
        return day3;
    }

    /**
     * @param day3 the day3 to set
     */
    public void setDay3(int day3) {
        this.day3 = day3;
    }

    /**
     * @return the day4
     */
    public int getDay4() {
        return day4;
    }

    /**
     * @param day4 the day4 to set
     */
    public void setDay4(int day4) {
        this.day4 = day4;
    }

    /**
     * @return the day5
     */
    public int getDay5() {
        return day5;
    }

    /**
     * @param day5 the day5 to set
     */
    public void setDay5(int day5) {
        this.day5 = day5;
    }

    /**
     * @return the day6
     */
    public int getDay6() {
        return day6;
    }

    /**
     * @param day6 the day6 to set
     */
    public void setDay6(int day6) {
        this.day6 = day6;
    }

    /**
     * @return the day7
     */
    public int getDay7() {
        return day7;
    }

    /**
     * @param day7 the day7 to set
     */
    public void setDay7(int day7) {
        this.day7 = day7;
    }
    
}
