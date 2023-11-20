<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="layout.jsp" />

<section class="p-4">
    <h2 class="text-2xl font-bold mb-4">Registro de movimiento</h2>
    <form method="post" action="movimientos">
        <div class="mb-4">
            <label for="description" class="block">Description:</label>
            <input type="text" id="description" name="description" class="border p-2 w-full">
        </div>
        <div class="flex items-center mb-4">
            <label for="income" class="mr-2">
                <input type="radio" id="income" name="movementType" value="1">
                Income
            </label>
            <label for="expense" class="mr-2">
                <input type="radio" id="expense" name="movementType" value="2">
                Expense
            </label>
        </div>
        <div class="mb-4">
            <label for="value" class="block">Value:</label>
            <input type="number" id="value" name="value" class="border p-2 w-full">
        </div>
        <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Submit</button>
        <button type="button" class="bg-red-500 hover:bg-red-700 text-white font-bold py-2 px-4 rounded">Cancel</button>
    </form>
</section>
