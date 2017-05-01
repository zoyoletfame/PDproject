/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import conDB.ConnectionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fame
 */
public class Patient {

    private String patUsername;
    private String patPassword;
    private String patFirstname;
    private String patLastname;
    private String patSex;
    private Date patBirthDate;
    private int patAge;
    private String hospName;
    private int telCenter;
    private int telNurse;
    private String detail;
    private int patId;

    public Patient() {
    }

    public Patient(String patUsername) {
        this.patUsername = patUsername;
    }

    public String getPatUsername() {
        return patUsername;
    }

    public String getPatPassword() {
        return patPassword;
    }

    public String getPatFirstname() {
        return patFirstname;
    }

    public String getPatLastname() {
        return patLastname;
    }

    public String getPatSex() {
        return patSex;
    }

    public Date getPatBirthDate() {
        return patBirthDate;
    }

    public int getPatAge() {
        return patAge;
    }

    public String getHospName() {
        return hospName;
    }

    public int getTelCenter() {
        return telCenter;
    }

    public int getTelNurse() {
        return telNurse;
    }

    public String getDetail() {
        return detail;
    }

    public int getpatId() {
        return patId;
    }

    public void setPatUsername(String patUsername) {
        this.patUsername = patUsername;
    }

    public void setPatPassword(String patPassword) {
        this.patPassword = patPassword;
    }

    public void setPatFirstname(String patFirstname) {
        this.patFirstname = patFirstname;
    }

    public void setPatLastname(String patLastname) {
        this.patLastname = patLastname;
    }

    public void setPatSex(String patSex) {
        this.patSex = patSex;
    }

    public void setPatBirthDate(Date patBirthDate) {
        this.patBirthDate = patBirthDate;
    }

    public void setPatAge(int patAge) {
        this.patAge = patAge;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName;
    }

    public void setTelCenter(int telCenter) {
        this.telCenter = telCenter;
    }

    public void setTelNurse(int telNurse) {
        this.telNurse = telNurse;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPatId(int patId) {
        this.patId = patId;
    }

    @Override
    public String toString() {
        return "Patient{" + "patUsername=" + patUsername + ", patPassword=" + patPassword + ", patFirstname=" + patFirstname + ", patLastname=" + patLastname + ", patSex=" + patSex + ", patBirthDate=" + patBirthDate + ", patAge=" + patAge + ", hospName=" + hospName + ", telCenter=" + telCenter + ", telNurse=" + telNurse + ", detail=" + detail + ", diaInId=" + patId + '}';
    }

    public static Patient collectIdPad(String user) {
        Patient p = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select patId from patient where patUsername like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, user);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                p = new Patient();
                p.setPatId(rs.getInt("patId"));

            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return p;
    }

    public static boolean login(String user, String pass) {
        boolean login = false;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "select * from patient where patUsername like ? and patPassword like ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                login = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return login;
    }

    public static void main(String[] args) {
        boolean f = Register("fame", "fd", "ดกด", "ดก", "ชาย");
        System.out.println(f);
    }

    public static boolean Register(String user, String pass, String fname, String lname, String sex) {
        boolean res = true;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "insert into patient(patUsername,patPassword,patFirstname,patLastname,patSex) value(?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            pstm.setString(3, fname);
            pstm.setString(4, lname);
            pstm.setString(5, sex);
            int rs = pstm.executeUpdate();
            con.close();
        } catch (SQLException e) {
            res = false;
            System.out.println("username Duplicate ");
        }
        return res;
    }

}
