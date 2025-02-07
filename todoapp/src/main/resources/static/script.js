document.addEventListener("DOMContentLoaded", function () {
  const todoInput = document.getElementById("todoInput");
  const addTodoButton = document.getElementById("addTodoButton");
  const todoList = document.getElementById("todoList");

  // Fetch all todos on page load
  fetchTodos();

  // Add todo event
  addTodoButton.addEventListener("click", function () {
    const title = todoInput.value;
    if (title) {
      createTodo({ title, completed: false });
      todoInput.value = "";
    }
  });

  function fetchTodos() {
    fetch("/api/todos")
      .then((response) => response.json())
      .then((todos) => {
        todoList.innerHTML = "";
        todos.forEach((todo) => {
          const li = document.createElement("li");
          li.textContent = todo.title;

          // Create update and delete buttons
          const updateButton = document.createElement("button");
          updateButton.textContent = "Update";
          updateButton.style.backgroundColor = "Yellow";
          updateButton.style.color = "Black";
          updateButton.onclick = () => updateTodo(todo.id, todo.title);

          const deleteButton = document.createElement("button");
          deleteButton.textContent = "Delete";
          deleteButton.textContent = "Delete";
          deleteButton.style.backgroundColor = "Red";
          deleteButton.onclick = () => deleteTodo(todo.id);

          // Append buttons at the end of the list item
          li.appendChild(updateButton);
          li.appendChild(deleteButton);
          todoList.appendChild(li);
        });
      });
  }

  function createTodo(todo) {
    fetch("/api/todos", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(todo),
    })
      .then((response) => response.json())
      .then((newTodo) => {
        const li = document.createElement("li");
        li.textContent = newTodo.title;

        // Create update and delete buttons
        const updateButton = document.createElement("button");

        updateButton.textContent = "Update";
        updateButton.style.backgroundColor = "Yellow";
        updateButton.style.color = "Black";
        updateButton.onclick = () => updateTodo(newTodo.id, newTodo.title);

        const deleteButton = document.createElement("button");

        deleteButton.textContent = "Delete";
        deleteButton.style.backgroundColor = "Red";

        deleteButton.onclick = () => deleteTodo(newTodo.id);

        li.appendChild(updateButton);
        li.appendChild(deleteButton);
        todoList.appendChild(li);
      });
  }

  function updateTodo(id, currentTitle) {
    const newTitle = prompt("Update todo title:", currentTitle);
    if (newTitle) {
      fetch(`/api/todos/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ title: newTitle, completed: false }),
      })
        .then((response) => response.json())
        .then((updatedTodo) => {
          fetchTodos(); // Refresh the list
        });
    }
  }

  function deleteTodo(id) {
    fetch(`/api/todos/${id}`, {
      method: "DELETE",
    }).then(() => {
      fetchTodos(); // Refresh the list
    });
  }
});
