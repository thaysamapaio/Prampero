/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(urlPatterns = {"/Calcular"})
public class Calcular extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        double a,b = 0,r=0;
        String botao;
        try {
            /* TODO output your page here. You may use following sample code. */
            a=Double.parseDouble(request.getParameter("txtA"));
            b=Double.parseDouble(request.getParameter("txtB"));
            botao=request.getParameter("b1");
            switch(botao.trim().charAt(0)){ //trim() -> limpa espaço em branco do inicio e fim
                                            //charAt() -> pega a letra na posição informada
                
            case '+' -> r=a+b;
                //interrompe a execução do item
            case '-' -> r=a-b;
                //interrompe a execução do item
            case '*' -> r=a*b;
                //interrompe a execução do item
            case '/' -> {
                    if (b!=0) {
                        r=a/b;
                    } else {
                        throw new Exception("Divisão por zero..."); //dispara uma exceção
                    }
                    //interrompe a execução do item
                }
                default -> {
                }
            }        
            //trim() -> limpa espaço em branco do inicio e fim
            //charAt() -> pega a letra na posição informada
            //roda quando ninguém foi escolhido
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calcular</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"Calcular\" method=\"post\">\n" +
"              A:<input type='text' name =\"txtA\" value='"+r+"' /> <br/>\n" +
"              B:<input type=\"text\" name =\"txtB\" /> <br/>\n" +
"              <input type=\"submit\" name=\"b1\" value=\"+\" /> &nbsp;&nbsp;\n" +
"              <input type=\"submit\" name=\"b1\" value=\"-\" /> &nbsp;&nbsp;\n" +
"              <input type=\"submit\" name=\"b1\" value=\"*\" /> &nbsp;&nbsp;\n" +
"              <input type=\"submit\" name=\"b1\" value=\"/\" /> \n" +
"           </form>");
            out.println("</body>");
            out.println("</html>");
        }
        
        catch(Exception ex){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calcular</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Erro: " + ex.getMessage() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
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
