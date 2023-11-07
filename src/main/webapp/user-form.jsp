
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="layout.jsp" />

<div class="container mx-auto">
    <!-- h1 title for table and add espace-->



    <div class="flex flex-col items-center justify-center min-h-screen bg-gray-100">
        <h1 class="text-3xl font-semibold text-gray-800 mt-5 mb-8">Create user</h1>
        <div class="w-full max-w-md">
            <form action="UserServlet" class="bg-white shadow-lg rounded px-8 pt-6 pb-8 mb-4"
                  method="POST">
                <div class="mb-4">
                    <!-- hidden input for id -->
                    <input type="hidden" name="id" value="${user ne null ? user.id : ''}"/>

                    <!-- hidden input for action -->
                    <input type="hidden" name="action" value="${user ne null ? 'update' : 'create'}"/>

                    <label class="block text-gray-700 font-bold mb-2" for="name">
                        Name
                    </label>
                    <input
                            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                            id="name"
                            type="text"
                            placeholder="John Doe"
                            name="name"
                            value="${user.name}"
                    />
                </div>
                <div class="mb-4">
                    <label class="block text-gray-700 font-bold mb-2" for="email">
                        Email
                    </label>
                    <input
                            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                            id="email"
                            type="email"
                            placeholder="johndoe@example.com"
                            name="email"
                            value="${user.email}"
                    />
                </div>
                <div class="mb-4">
                    <label class="block text-gray-700 font-bold mb-2" for="country">
                        Country
                    </label>
                    <input
                            class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                            id="country"
                            type="text"
                            placeholder="Colombia"
                            name="country"
                            value="${user.country}"
                    />
                </div>


                <div class="flex items-center justify-between">
                    <button
                            onclick={window.location.href = "index.jsp"}
                            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                            type="submit"
                    >
                        Submit
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>