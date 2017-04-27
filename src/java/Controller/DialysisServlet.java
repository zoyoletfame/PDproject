/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dialysis;
import Model.TestDateTime;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fame
 */
public class DialysisServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String startIn = request.getParameter("timeStartInput");
        String endIn = request.getParameter("timeEndInput");
        Object userId = request.getSession().getAttribute("userId");
        String startOut = request.getParameter("timeStartOut");
        String endOut = request.getParameter("timeEndOut");
        String urinate = request.getParameter("urinate");
        String date = request.getParameter("date");
        String desDia = request.getParameter("desDia");
        
        try {
            //parse string to date 
            SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            Date recDate = s.parse(date);
            int userIds = Integer.parseInt(userId.toString());
            int capIn = Integer.parseInt(request.getParameter("capacityInput"));
            double intensity = Double.parseDouble(request.getParameter("intensity"));
            // select roundID
            TestDateTime tdt = TestDateTime.collectRoundId(recDate, userIds);
            //insert data in
            if (startOut.isEmpty()) {
                Date dateInSta = sf.parse(startIn);
                Date dateInEnd = sf.parse(endIn);            
                Dialysis dia = new Dialysis();
                dia.getRecordIn(capIn, dateInSta, dateInEnd,intensity, tdt.getRoundId());             
                System.out.println("fdsf");
            } else {  // insert data out
                System.out.println("fdsfffffffffff");
                Date dateOutSta = sf.parse(startOut);
                Date dateOutEnd = sf.parse(endOut);
                int capOut = Integer.parseInt(request.getParameter("capacityOutput"));
                int urinateInt = Integer.parseInt(urinate);
                Dialysis.getRecordOut(capOut, dateOutSta, dateOutEnd, urinateInt, userIds, recDate,desDia); //อัพเดทข้อมูล
                Dialysis dia = Dialysis.eachProfit(capIn, capOut, userIds, recDate);   // คำนวณกำไร
                Dialysis.totalsProfit(recDate, userIds, dia.getProfit(), urinateInt);  // สุทธิ
            }
            //show date 
            request.setAttribute("roundId", tdt.getRoundId());
            request.setAttribute("showDate", TestDateTime.chageDate(recDate));        
            getServletContext().getRequestDispatcher("/Home.jsp").forward(request, response);

        } catch (IOException e) {
            System.out.println(e);
        } catch (ParseException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (ServletException e) {
            System.out.println(e);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
