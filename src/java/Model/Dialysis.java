/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import conDB.ConnectionBuilder;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fame
 */
public class Dialysis {

    private int volDiaIn;
    private int volDiaOut;
    private Date timeDiaIn_start;
    private Date timeDiaIn_end;
    private Date timeDiaOut_start;
    private Date timeDiaOut_end;
    private int urinate;
    private int profit;
    private int totalProfit;
    private int weight;
    private String bloodPressure;  
    private String desDiaLiquid;
    private int round_Id;
    private int round;
    private Date date;
   

    public Dialysis() {
    }

    public Dialysis(int volDiaIn) {
        this.volDiaIn = volDiaIn;
    }

    public Dialysis(int volDiaIn, Date timeDiaIn_start, Date timeDiaIn_end) {

        this.volDiaIn = volDiaIn;
        this.timeDiaIn_start = timeDiaIn_start;
        this.timeDiaIn_end = timeDiaIn_end;
    }

    public Dialysis(int round, int volDiaIn, int volDiaOut, Date timeDiaIn_start, Date timeDiaIn_end, Date timeDiaOut_start, Date timeDiaOut_end, int urinate) {
        this.round = round;
        this.volDiaIn = volDiaIn;
        this.volDiaOut = volDiaOut;
        this.timeDiaIn_start = timeDiaIn_start;
        this.timeDiaIn_end = timeDiaIn_end;
        this.timeDiaOut_start = timeDiaOut_start;
        this.timeDiaOut_end = timeDiaOut_end;
        this.urinate = urinate;
    }

    public Boolean getRecordIn(int volDiaIn, Date timeDiaIn_start, Date timeDiaIn_end, int roundId) { //insert data to DB

        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "insert into dialysis(volDiaIn,timeDiaIn_start,timeDiaIn_end , record_recId_fk) value(?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, volDiaIn);
            pstm.setTime(2, new java.sql.Time(timeDiaIn_start.getTime()));
            pstm.setTime(3, new java.sql.Time(timeDiaIn_end.getTime()));
            pstm.setInt(4, roundId);
            int rs = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }
   
    public Dialysis showRecord(int userId, Date d) { //show record after click date
        Dialysis dia = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select volDiaIn , timeDiaIn_start,timeDiaIn_end , record_recId_fk "
                    + "from dialysis JOIN record ON dialysis.record_recId_fk = record.recId "
                    + "JOIN patient ON record.patient_patId_fk = patient.patId "
                    + "WHERE patId = ? and recDate = ? ";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            pstm.setDate(2, new java.sql.Date(d.getTime()));
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                dia = new Dialysis();
                dia.setTimeDiaIn_start(rs.getTime("timeDiaIn_start"));
                dia.setTimeDiaIn_end(rs.getTime("timeDiaIn_end"));
                dia.setVolDiaIn(rs.getInt("volDiaIn"));
                dia.setRound_Id(rs.getInt("record_recId_fk"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return dia;
    }
     public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String dat = "2017-04-05";
        List<Dialysis> dia = showRecordTable(1);
         for (int i = 0; i < dia.size()-1; i++) {
             System.out.println(dia.get(i));
         }
        
    }
    public static List<Dialysis> showRecordTable(int userId) { // show all in table
        List<Dialysis> diaAll = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select volDiaIn , timeDiaIn_start,timeDiaIn_end ,volDiaOut,timeDiaOut_start, "
                    + " timeDiaOut_end, profit , urinate , totalProfit , weight , bloodPressure ,desDiaLiquid "
                    + " , recDate , recRound "
                    + " from dialysis join record on dialysis.record_recId_fk = record.recId "
                    + " join patient on record.patient_patId_fk = patient.patId "
                    + " WHERE patId = ? "
                    + " ORDER BY recDate DESC ";
            PreparedStatement pstm = con.prepareCall(sql);
            pstm.setInt(1, userId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Dialysis dia = new Dialysis();               
                dia.setVolDiaIn(rs.getInt("volDiaIn"));
                dia.setTimeDiaIn_start(rs.getTime("timeDiaIn_start"));
                dia.setTimeDiaIn_end(rs.getTime("timeDiaIn_end"));
                dia.setProfit(rs.getInt("profit"));
                dia.setUrinate(rs.getInt("urinate"));
                dia.setTotalProfit(rs.getInt("totalprofit"));
                dia.setWeight(rs.getInt("weight"));
                dia.setBloodPressure(rs.getString("bloodPressure"));
                dia.setDesDiaLiquid(rs.getString("desDiaLiquid"));
                dia.setDate(rs.getDate("recDate"));
                dia.setRound(rs.getInt("recRound"));
                
                if (diaAll == null) {
                    diaAll = new ArrayList<>();
                }
                
                diaAll.add(dia);
               
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return diaAll;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVolDiaIn() {
        return volDiaIn;
    }

    public void setVolDiaIn(int volDiaIn) {
        this.volDiaIn = volDiaIn;
    }

    public Date getTimeDiaIn_start() {
        return timeDiaIn_start;
    }

    public Date getTimeDiaIn_end() {
        return timeDiaIn_end;
    }

    public void setTimeDiaIn_start(Date timeDiaIn_start) {
        this.timeDiaIn_start = timeDiaIn_start;
    }

    public void setTimeDiaIn_end(Date timeDiaIn_end) {
        this.timeDiaIn_end = timeDiaIn_end;
    }

    public int getVolDiaOut() {
        return volDiaOut;
    }

    public Date getTimeDiaOut_start() {
        return timeDiaOut_start;
    }

    public Date getTimeDiaOut_end() {
        return timeDiaOut_end;
    }

    public int getUrinate() {
        return urinate;
    }

    public int getRound_Id() {
        return round_Id;
    }

    public void setVolDiaOut(int volDiaOut) {
        this.volDiaOut = volDiaOut;
    }

    public void setTimeDiaOut_start(Date timeDiaOut_start) {
        this.timeDiaOut_start = timeDiaOut_start;
    }

    public void setTimeDiaOut_end(Date timeDiaOut_end) {
        this.timeDiaOut_end = timeDiaOut_end;
    }

    public void setUrinate(int urinate) {
        this.urinate = urinate;
    }

    public void setRound_Id(int round_Id) {
        this.round_Id = round_Id;
    }

    public int getProfit() {
        return profit;
    }
    public int getWeight() {
        return weight;
    }
    public String getBloodPressure() {
        return bloodPressure;
    }
    public void setProfit(int profit) {
        this.profit = profit;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(int totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getDesDiaLiquid() {
        return desDiaLiquid;
    }

    public void setDesDiaLiquid(String desDiaLiquid) {
        this.desDiaLiquid = desDiaLiquid;
    }

    @Override
    public String toString() {
        return "Dialysis{" + ", volDiaIn=" + volDiaIn + ", volDiaOut=" + volDiaOut + ", timeDiaIn_start=" + timeDiaIn_start + ", timeDiaIn_end=" + timeDiaIn_end + ", timeDiaOut_start=" + timeDiaOut_start + ", timeDiaOut_end=" + timeDiaOut_end + ", urinate=" + urinate + ", profit=" + profit + ", totalProfit=" + totalProfit + ", weight=" + weight + ", bloodPressure=" + bloodPressure + ", desDiaLiquid=" + desDiaLiquid + ", round_Id=" + round_Id + ", round=" + round + ", date=" + date + '}';
    }
    
}
