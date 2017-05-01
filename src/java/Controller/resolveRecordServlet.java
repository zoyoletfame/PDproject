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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fame
 */
public class resolveRecordServlet extends HttpServlet {

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
        Object Id = request.getSession().getAttribute("userId");
        String da = request.getParameter("dateLoop");
        String round = request.getParameter("maxRound");
        try {

            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            String dateBack = TestDateTime.changeDateBack(da);
            int userId = Integer.parseInt(Id.toString());
            Date date = s.parse(dateBack);
            Dialysis showAll = Dialysis.showRecordAll(userId, date, userId);
            request.setAttribute("dateValue", dateBack);
            request.setAttribute("dateRe", da);
            request.setAttribute("maxRound", round);
            request.setAttribute("volIn", showAll.getVolDiaIn());
            request.setAttribute("timeIn_start", showAll.getTimeDiaIn_start());
            request.setAttribute("timeIn_end", showAll.getTimeDiaIn_end());
            request.setAttribute("intensity", showAll.getIntensity());
            request.setAttribute("volOut", showAll.getVolDiaOut());
            request.setAttribute("timeOut_start", showAll.getTimeDiaOut_start());
            request.setAttribute("timeOut_end", showAll.getTimeDiaOut_end());
            request.setAttribute("urinate", showAll.getUrinate());
            request.setAttribute("desDiaLiquid", showAll.getDesDiaLiquid());
            getServletContext().getRequestDispatcher("/recordDialysis.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (ParseException e) {
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
