
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="layout.jsp" />
<div class="container mx-auto">
<h1 class="text-3xl font-semibold text-gray-800 mt-5 mb-8">All Users</h1>

<!-- Button for add new user and their background color blue -->
<a href="./user-form.jsp" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
    Add New User
</a>

<table class="min-w-full divide-y divide-gray-200 my-5">
    <thead class="bg-blue-500 text-white">
    <tr>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider">
            ID
        </th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider">
            Name
        </th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider">
            Email
        </th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider">
            Country
        </th>
        <th scope="col" class="px-6 py-3 text-left text-xs font-medium uppercase tracking-wider">
            Actions
        </th>
    </tr>
    </thead>
    <tbody class="bg-white divide-y divide-gray-200">

    <c:forEach items="${users}" var="user">
        <tr class="">
            <td class="px-6 py-4 whitespace-nowrap">
                <div class="text-sm text-gray-900">${user.id}</div>
            </td>
            <td class="px-6 py-4 whitespace-nowrap">
                <div class="flex items-center">
                    <div>
                        <div class="text-sm font-medium text-gray-900">
                                ${user.name}
                        </div>
                    </div>
                </div>
            </td>
            <td class="px-6 py-4 whitespace-nowrap">
                <div class="text-sm text-gray-900">${user.email}</div>
            </td>
            <td class="px-6 py-4 whitespace-nowrap">
                <div class="text-sm text-gray-900">${user.country}</div>
            </td>
            <td class="px-6 py-4 whitespace-nowrap">
                <div class="flex items-center space-x-4">
                    <a href="${pageContext.request.contextPath}/update?id=${user.id}" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded text-sm">
                        Update
                    </a>
                    <a onclick="deleteUser(${user.id})" href="${pageContext.request.contextPath}/delete?id=${user.id}" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded text-sm">
                        Delete
                    </a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

<script>

    function deleteUser(id) {
        if (confirm("Are you sure you want to delete this user?")) {
            window.location.href = "${pageContext.request.contextPath}/delete?id=" + id;
        }
    }

</script>