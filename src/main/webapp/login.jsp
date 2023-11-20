<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="layout.jsp" />
<!-- show error -->
<c:if test="${not empty error}">
    <div class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative" role="alert">
        <strong class="font-bold">Error!</strong>
        <span class="block sm:inline">${error}</span>
    </div>
</c:if>

<div class="flex justify-center items-center h-screen">
    <div class="bg-white p-8 rounded shadow-md">
        <h2 class="text-2xl font-bold mb-4">Bank Login</h2>
        <form method="POST" action="LoginServlet">
            <div class="mb-4">
                <label for="username" class="block text-gray-700 font-bold mb-2">Username</label>
                <input type="text" id="username" name="username" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" placeholder="Enter your username">
            </div>
            <div class="mb-4">
                <label for="password" class="block text-gray-700 font-bold mb-2">Password</label>
                <input type="password" id="password" name="password" class="w-full px-3 py-2 border border-gray-300 rounded focus:outline-none focus:border-blue-500" placeholder="Enter your password">
            </div>
            <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline">Login</button>
        </form>
    </div>
</div>