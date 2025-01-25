<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Note Taker App: Add Note</title>
    <%@include file="all_other_config.jsp" %>
  </head>
  <body class="p-0 m-0">
    <%@include file="navbar.jsp" %>
    <section class="flex flex-col items-center justify-center gap-5 py-8">
      <h1 class="text-3xl">Add a New Note</h1>
      <form class="flex flex-col justify-center items-center gap-5" action="SaveNoteServlet" method="post">
        <div class="flex flex-col">
          <p class="text-sm font-bold">Note Title</p>
          <input type="text" name="title" id="title" class="w-100 rounded-sm border border-gray-400 px-2 py-1 font-normal" />
        </div>
        <div class="flex flex-col">
          <p class="text-sm font-bold">Note Content</p>
          <textarea type="text" name="content" id="content" class="w-100 rounded-sm border border-gray-400 px-2 py-1 font-normal" rows="5"></textarea>
        </div>
        <button class="cursor-pointer rounded-md bg-blue-500 px-5 py-1 font-semibold text-white transition-all duration-300 hover:bg-blue-600">
            Save Note
        </button>
      </form>
    </section>
  </body>
</html>