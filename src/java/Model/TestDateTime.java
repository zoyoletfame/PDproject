package Model;

import java.util.logging.Logger;
import conDB.ConnectionBuilder;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jenny
 */
public class TestDateTime {

    private int roundId;
    private int round;
    private Date date;

    public TestDateTime(int roundId, int round, Date date) {
        this.roundId = roundId;
        this.round = round;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public TestDateTime(int roundId, int round) {
        this.roundId = roundId;
        this.round = round;
    }

    public TestDateTime() {

    }

    public TestDateTime(int round) {
        this.round = round;
    }

    @Override
    public String toString() {
        return "TestDateTime{" + "roundId=" + roundId + ", round=" + round + "Date " + date + '}';
    }
    
    public TestDateTime getRoundValue(int userId , Date dateRound) {
        TestDateTime tdt = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT MAX(recRound) "
                    + "FROM record join patient on record.patient_patId_fk = patient.patId "
                    + "WHERE patId = ? and recDate = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            pstm.setDate(2, new java.sql.Date(dateRound.getTime()));
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
                tdt = new TestDateTime();
                tdt.setRound(rs.getInt("MAX(recRound)"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tdt;
    }
    
  
    public static TestDateTime collectRoundId(Date d , int userID) { // show roundID
       TestDateTime tdt = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select recId from record join patient on record.patient_patId_fk = patient.patId "
                    + "where recDate = ? and patId = ? ";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setDate(1, new java.sql.Date(d.getTime()));
            pstm.setInt(2, userID);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tdt = new TestDateTime();
                tdt.setRoundId(rs.getInt("recId"));           
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return tdt;
    }

    public static String chageDate(Date d) { //chage Date+543
        String ca = null;
        try {
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            String newDate = s.format(d);
            String Date = newDate.substring(0, 2);
            String month = newDate.substring(3, 5);
            String year = newDate.substring(6);
            int newYear = Integer.parseInt(year) + 543;
            String newYear2 = String.valueOf(newYear);
            switch (month) {
                case "01":
                    ca = Date + "  มกราคม  " + newYear2;
                    break;
                case "02":
                    ca = Date + "  กุมภาพันธ์ " + newYear2;
                    break;
                case "03":
                    ca = Date + "  มีนาคม  " + newYear2;
                    break;
                case "04":
                    ca = Date + "  เมษายน  " + newYear2;
                    break;
                case "05":
                    ca = Date + "  พฤษภาคม  " + newYear2;
                    break;
                case "06":
                    ca = Date + "  มิถุนายน  " + newYear2;
                    break;
                case "07":
                    ca = Date + "  กรกฎาคม  " + newYear2;
                    break;
                case "08":
                    ca = Date + "  สิงหาคม  " + newYear2;
                    break;
                case "09":
                    ca = Date + "  กันยายน  " + newYear2;
                    break;
                case "10":
                    ca = Date + "  ตุลาคม  " + newYear2;
                    break;
                case "11":
                    ca = Date + "  พฤศจิกายน  " + newYear2;
                    break;
                case "12":
                    ca = Date + "  ธันวาคม  " + newYear2;
                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return ca;
    }
   
      public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String s = "2017-04-02";
        Date d = sf.parse(s);
       /* TestDateTime t = collectRoundId(d, 1);
        System.out.println(t.getRoundId());*/
        TestDateTime td = showDate(1,60);
        System.out.println(td.getDate());
     
    }
    public static TestDateTime showDate(int userId , int roundId) { //show Date when save
        TestDateTime tdt = null;

        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = " select recDate from record JOIN patient ON record.patient_patId_fk = patient.patId "
                    + " where patId = ? and recId = ? ";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            pstm.setInt(2, roundId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                tdt = new TestDateTime();
                tdt.setDate(rs.getDate("recDate"));
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return tdt;
    }
  
    public static boolean insertRound(int round, Date date, int rId) { // save round Date to DB    
        try {
            Connection conn = ConnectionBuilder.getConnection();
            String sql = "INSERT INTO record(recRound,recDate,patient_patId_fk) VALUES(?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, round);
            pstm.setDate(2, new java.sql.Date(date.getTime()));
            pstm.setInt(3, rId);
            int rs = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);

        }
        return true;
    }

}
