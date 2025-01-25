<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.query.Query" %>
<%@page import="com.helpers.FactoryProvider"%>
<%@page import="java.util.List"%>
<%@page import="com.entities.Note"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Note Taker App: Add Todo</title>
    <%@include file="all_other_config.jsp" %>
  </head>
  <body class="p-0 m-0">
    <%@include file="navbar.jsp" %>
    <section class="flex flex-col items-center justify-center gap-5 py-8">
      <h1 class="text-3xl">All Notes</h1>
      <%
        Session s = FactoryProvider.getFactory().openSession();
        Query<Note> q =  s.createQuery("from Note",Note.class);
        List<Note> notes = q.getResultList();
        for(Note note: notes){
            %>
              <div class="flex max-w-[calc(100%-30%)] flex-col gap-1 border px-3 py-2 rounded-md text-center">
                  <p class="font-bold"><%=note.getTitle()%></p>
                  <p><%=note.getContent()%></p>
              </div>
              <div class="flex gap-2">
                  <a href="edit_note.jsp?note_id=<%=note.getId()%>" class="cursor-pointer rounded-md bg-blue-500 px-5 py-1 font-normal text-white transition-all duration-300 hover:bg-blue-600">
                      Update Note
                  </a>
                  <a href="DeleteNoteServlet?note_id=<%=note.getId() %>" class="cursor-pointer rounded-md bg-red-500 px-5 py-1 font-normal text-white transition-all duration-300 hover:bg-red-600">
                      Delete Note
                  </a>
              </div>
            <%
        }
        s.close();
      %>

    </section>
  </body>
</html>
