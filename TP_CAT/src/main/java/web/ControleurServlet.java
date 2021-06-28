package web;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import java.io.IOException;
import java.util.List;

@WebServlet(name="cs", urlPatterns={"*.php"})
public class ControleurServlet extends HttpServlet {
    private IProduitDao metier;

    @Override
    public void init() throws ServletException {
        metier = new ProduitDaoImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();
        if(path.equals("/index.php")){
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }
        else if(path.equals("/chercher.php")){

            String motCle = request.getParameter("motCle");
            ProduitModel model = new ProduitModel();
            model.setMotCle(motCle);

            List<Produit> prod = metier.produitParMC("%"+motCle+"%");
            model.setProduits(prod);
            request.setAttribute("model", model);
            request.getRequestDispatcher("produits.jsp").forward(request,response);
        }
        else if(path.equals("/saisie.php")){
            request.setAttribute("produit", new Produit());
            request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);
        }

        else if(path.equals("/saveProduit.php") &&(request.getMethod().equals("POST"))){
            String designation = request.getParameter("designation");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit p = new Produit();
            p.setDesignation(designation); p.setPrix(prix); p.setQuantite(quantite);
            metier.save(p);

            request.setAttribute("produit", p);
            request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
        }

        else if(path.equals("/Supprimer.php")){
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteProduit(id);
            //request.getRequestDispatcher("produits.jsp").forward(request,response);
              response.sendRedirect("chercher.php?motCle=");
        }
        else if(path.equals("/Edit.php")){
            Long id = Long.parseLong(request.getParameter("id"));
            Produit p = metier.getProduit(id);
            request.setAttribute("produit",p);

            request.getRequestDispatcher("EditProduit.jsp").forward(request,response);
        }
        else if(path.equals("/UpdateProduit.php")&&(request.getMethod().equals("POST"))){
            Long id = Long.parseLong(request.getParameter("id"));
            String designation = request.getParameter("designation");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit p = new Produit();
            p.setId(id);p.setDesignation(designation); p.setPrix(prix); p.setQuantite(quantite);
            metier.updateProduit(p);

            request.setAttribute("produit", p);
            request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
        }

        else{
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
