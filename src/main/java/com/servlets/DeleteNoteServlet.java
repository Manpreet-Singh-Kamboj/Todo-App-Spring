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

public class DeleteNoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String noteId = req.getParameter("note_id").trim();
            Session session = FactoryProvider.getFactory().openSession();
            Note note = (Note) session.get(Note.class,noteId);
            if(note == null){
                resp.sendRedirect("index.jsp");
                return;
            }
            Transaction transaction = session.beginTransaction();
            session.delete(note);
            transaction.commit();
            resp.sendRedirect("all_notes.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
