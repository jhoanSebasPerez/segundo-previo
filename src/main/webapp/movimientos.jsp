<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="layout.jsp" />

<div class="container mx-auto my-10">
  <!-- Your content goes here -->
  <h1 class="text-2xl font-bold mb-4" id="title"></h1>

  <section class="bg-gray-100 p-4">
    <h2 class="text-2xl font-bold mb-4">Movements</h2>

    <ul class="space-y-4">
      <!-- Iterate over bills -->
      <c:forEach items="${bills}" var="bill">
        <li class="flex justify-between items-start bg-${bill.type eq 1 ? 'blue' : 'red'}-300 p-3">
          <div class="w-1/3">
            <p class="text-sm text-gray-500">${bill.dateBill}</p>
            <p class="text-base">${bill.observation}</p>
          </div>
          <div class="w-2/3 text-right">
            <p class="text-base">${bill.value}</p>
          </div>
          <div class="flex justify-end mt-4">
            <a href="${pageContext.request.contextPath}/movimientos?action=delete&id=${bill.id}" class="bg-red-500 hover:bg-red-600 text-white py-1 px-4 rounded">Delete</a>
          </div>
        </li>
      </c:forEach>
      <!-- Add more list items here -->
    </ul>


    <div class="flex justify-end mt-4">
      <a href="./add-movimiento.jsp" class="bg-green-500 hover:bg-green-600 text-white font-bold py-2 px-4 rounded">Add New Movement</a>
    </div>
  </section>
</div>

<script>
  // get username from session storage
  const username = sessionStorage.getItem('username');
  const title = document.getElementById('title');
  title.innerHTML = `Bienvenido, ${username}`;
</script>