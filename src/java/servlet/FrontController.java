/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controller.app.ApplicationController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import view.LookUpView;

/**
 *
 * @author Jelena
 */
public class FrontController extends HttpServlet {

    private ApplicationController appController;

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
        String url = request.getPathInfo();
        System.out.println("url:" + url);

        String view = appController.obradiZahtev(url, request);
        String strana = LookUpView.getView(view);
//            HttpSession sesija = request.getSession(true);
//            sesija.setAttribute("ulogovan_korisnik", KolekcijaKorisnika.getInstance().getUlogovanKorisnik());
        RequestDispatcher rd = getServletContext().getRequestDispatcher(strana);
        rd.forward(request, response);

        /*      
         String path = request.getPathInfo();
         System.out.println("Path: " + path);
         //obradi zahtev
         String view = appCon.obradiZahtev(path, request);
         String strana = LookUpView.getView(view);
         RequestDispatcher rd = getServletContext().getRequestDispatcher(strana);
         rd.forward(request, response);
         response.setContentType("text/html;charset=UTF-8");
         */
    }

    @Override
    public void init() throws ServletException {
        appController = new ApplicationController();
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