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
        String start = request.getParameter("timeStartInput1");     
        String end = request.getParameter("timeEndInput1");  
        Object userId = request.getSession().getAttribute("userId");
    
        try{       
            SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
            Date dateSta = sf.parse(start);
            Date dateEnd = sf.parse(end);
            int cap = Integer.parseInt(request.getParameter("capacityInput1"));    
            TestDateTime tdt = new TestDateTime();  
            List<TestDateTime> td = tdt.collectRoundId();
            int lastArray = td.size()-1;                
            Dialysis dia = new Dialysis();  
            dia.getRecordIn(cap, dateSta, dateEnd ,td.get(lastArray).getRoundId());    
            int userIds = Integer.parseInt(userId.toString());
            tdt = tdt.showDate(userIds);
            request.setAttribute("showDate",tdt.chageDate(tdt.getDate()));
            
            getServletContext().getRequestDispatcher("/ShowDate.jsp").forward(request, response);
            
        }catch(IOException e){           
            System.out.println(e);
        }catch(ParseException e){       
            System.out.println(e);
        }catch(NumberFormatException e){
            System.out.println(e);
        }catch(ServletException e){
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
