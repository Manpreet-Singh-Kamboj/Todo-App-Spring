package com.servlets;

import com.entities.Note;
import com.helpers.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class SaveNoteServlet extends HttpServlet {

    public SaveNoteServlet(){
        super();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            Note note = new Note(title,content,new Date());
            Session session = FactoryProvider.getFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(note);
            transaction.commit();
            resp.sendRedirect("all_notes.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
