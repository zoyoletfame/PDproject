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
import java.util.HashSet;
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
    private String thaiDate;

    public TestDateTime(int roundId, int round, Date date) {
        this.roundId = roundId;
        this.round = round;
        this.date = date;
    }

    public String getThaiDate() {
        return thaiDate;
    }

    public void setThaiDate(String thaiDate) {
        this.thaiDate = thaiDate;
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
        return "TestDateTime{" + "roundId=" + roundId + ", round=" + round + ", date=" + date + ", thaiDate=" + thaiDate + '}';
    }

    public static List<TestDateTime> getRoundValue(int userId, Date dateRound) {//เอา id จากวันที่
        List<TestDateTime> tdt = null;
        Connection con = null;
        try {
            con = ConnectionBuilder.getConnection();
            String sql = "SELECT * "
                    + "FROM record join patient on record.patient_patId_fk = patient.patId "
                    + "WHERE patId = ? and recDate = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            pstm.setDate(2, new java.sql.Date(dateRound.getTime()));
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TestDateTime td = new TestDateTime();
                td.setRoundId(rs.getInt("recId"));
                if (tdt == null) {
                    tdt = new ArrayList<>();
                }
                tdt.add(td);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return tdt;
    }

    public static TestDateTime collectRoundId(Date d, int userID, int round) { // show roundID
        TestDateTime tdt = null;
        Connection con = null;
        try {
            con = ConnectionBuilder.getConnection();
            String sql = "select recId from record join patient on record.patient_patId_fk = patient.patId "
                    + "where recDate = ? and patId = ? and recRound = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setDate(1, new java.sql.Date(d.getTime()));
            pstm.setInt(2, userID);
            pstm.setInt(3, round);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {

                tdt = new TestDateTime();
                tdt.setRoundId(rs.getInt("recId"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return tdt;
    }

    public static String changeDate(Date date) { //chage Date+543

        String ca = null;
        try {
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

            String newDate = s.format(date);
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

        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return ca;
    }

    public static List<TestDateTime> chageDateList(List<TestDateTime> date, List<TestDateTime> maxRound) { //chage Date+543
        List<TestDateTime> td = null;
        String ca = null;
        try {
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            for (int i = 0; i < date.size(); i++) {
                Date d = date.get(i).getDate();
                int Max = maxRound.get(i).getRound();
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
                TestDateTime tdt = new TestDateTime();
                tdt.setRound(Max);
                tdt.setThaiDate(ca);
                if (td == null) {
                    td = new ArrayList<>();
                }
                td.add(tdt);
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return td;
    }

    public static String changeDateBack(String date) { //chage Date+543

        String ca = null;
        try {
            String dates = date.substring(0, 2);
            String count = date.substring(3);
            String month = "";
            String year1 = "";
            for (int i = 4; i < count.length(); i++) {
                month = date.substring(3, i);
                year1 = date.substring(i);
                if (date.substring(i).equals("2")) {
                    break;
                }
            }

            int year2 = Integer.parseInt(year1) - 543;
            String year = String.valueOf(year2);
            ca = dates + month + year;
            switch (month) {
                case " มกราคม  ":
                    ca = dates + "-01-" + year;
                    break;
                case " กุมภาพันธ์  ":
                    ca = dates + "-02-" + year;
                    break;
                case " มีนาคม  ":
                    ca = dates + "-03-" + year;
                    break;
                case " เมษายน  ":
                    ca = dates + "-04-" + year;
                    break;
                case " พฤษภาคม  ":
                    ca = dates + "-05-" + year;
                    break;
                case " มิถุนายน  ":
                    ca = dates + "-06-" + year;
                    break;
                case " กรกฎาคม  ":
                    ca = dates + "-07-" + year;
                    break;
                case " สิงหาคม  ":
                    ca = dates + "-08-" + year;
                    break;
                case " กันยายน  ":
                    ca = dates + "-09-" + year;
                    break;
                case " ตุลาคม  ":
                    ca = dates + "-10-" + year;
                    break;
                case " พฤศจิกายน  ":
                    ca = dates + "-11-" + year;
                    break;
                case " ธันวาคม  ":
                    ca = dates + "-12-" + year;
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return ca;
    }

    public static List<TestDateTime> showDateAll(int userId) { //show Date when save
        List<TestDateTime> td = null;
        Connection con = null;
        try {
            con = ConnectionBuilder.getConnection();
            String sql = " select Distinct recDate from record JOIN patient ON record.patient_patId_fk = patient.patId "
                    + " where patId = ?  "
                    + " Order By recDate DESC";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                TestDateTime tdt = new TestDateTime();
                tdt.setDate(rs.getDate("recDate"));
                if (td == null) {
                    td = new ArrayList<>();
                }
                td.add(tdt);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return td;
    }

    public static TestDateTime showDate(int userId, int roundId) { //show Date when save
        TestDateTime tdt = null;
        Connection con = null;
        try {
            con = ConnectionBuilder.getConnection();
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
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return tdt;
    }

    public static boolean insertRound(int round, Date date, int rId) { // save round Date to DB  
        Connection con = null;

        try {
            con = ConnectionBuilder.getConnection();
            String sql = "INSERT INTO record(recRound,recDate,patient_patId_fk) VALUES(?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, round);
            pstm.setDate(2, new java.sql.Date(date.getTime()));
            pstm.setInt(3, rId);
            int rs = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return true;
    }

    public static TestDateTime getRoundMax(int id, Date date) {
        TestDateTime td = null;
        Connection con = null;

        try {
            con = ConnectionBuilder.getConnection();
            String sql = "select Max(recRound) "
                    + "from record join patient on record.patient_patId_fk = patient.patId "
                    + "where patId = ? and recDate = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                td = new TestDateTime();
                td.setRound(rs.getInt("Max(recRound)"));
            }

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return td;
    }

    public static List<TestDateTime> getRoundMaxList(int id, List<TestDateTime> date) {
        List<TestDateTime> tdt = null;
        Connection con = null;

        try {
            for (int i = 0; i < date.size(); i++) {
                Date d = date.get(i).getDate();

                con = ConnectionBuilder.getConnection();
                String sql = "select Max(recRound) "
                        + "from record join patient on record.patient_patId_fk = patient.patId "
                        + "where patId = ? and recDate = ?";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setInt(1, id);
                pstm.setDate(2, new java.sql.Date(d.getTime()));
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    TestDateTime td = new TestDateTime();
                    td.setRound(rs.getInt("Max(recRound)"));
                    if (tdt == null) {
                        tdt = new ArrayList<>();

                    }
                    tdt.add(td);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return tdt;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        String d = "2017-04-29";
        Date date = sf.parse(d);
        List<TestDateTime> dat = showDateAll(1);
        List<TestDateTime> td = getRoundMaxList(1, dat);
        List<TestDateTime> ch = chageDateList(dat, td);
        for (int i = 0; i < td.size(); i++) {
            System.out.println(td.get(i).getRound());
        }
        for (int i = 0; i < ch.size(); i++) {
            System.out.println(ch.get(i).getThaiDate());
            System.out.println(ch.get(i).getRound());
        }
    }
}
