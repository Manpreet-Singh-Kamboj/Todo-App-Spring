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

public class UpdateNoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            String noteId = req.getParameter("noteId");
            Session session = FactoryProvider.getFactory().openSession();
            Note note = (Note) session.get(Note.class,noteId);
            if(note == null){
                resp.sendRedirect("index.jsp");
                return;
            }
            Transaction transaction = session.beginTransaction();
            note.setTitle(title);
            note.setContent(content);
            transaction.commit();
            resp.sendRedirect("all_notes.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
