<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="com.entities.*"%>
<%@page import="com.helpers.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Note Taker App: Edit Note</title>
    <%@include file="all_other_config.jsp" %>
  </head>
  <body class="p-0 m-0">
    <%@include file="navbar.jsp" %>
    <section class="flex flex-col items-center justify-center gap-5 py-8">
      <h1 class="text-3xl">Edit Note</h1>
      <%
            Session s = FactoryProvider.getFactory().openSession();
            String noteId = request.getParameter("note_id").trim();
            Note note = (Note) s.get(Note.class,noteId);
      %>
      <form class="flex flex-col justify-center items-center gap-5" action="UpdateNoteServlet" method="post">
        <input name="noteId" id="noteId" type="text" class="hidden" value="<%=note.getId()%>"/>
        <div class="flex flex-col">
          <p class="text-sm font-bold">Note Title</p>
          <input type="text" name="title" id="title" class="w-100 rounded-sm border border-gray-400 px-2 py-1 font-normal" value="<%=note.getTitle()%>"/>
        </div>
        <div class="flex flex-col">
          <p class="text-sm font-bold">Note Content</p>
          <textarea type="text" name="content" id="content" class="w-100 rounded-sm border border-gray-400 px-2 py-1 font-normal" rows="5"><%=note.getContent()%></textarea>
        </div>
        <button class="cursor-pointer rounded-md bg-blue-500 px-5 py-1 font-semibold text-white transition-all duration-300 hover:bg-blue-600">
            Save Note
        </button>
      </form>
    </section>
  </body>
</html>