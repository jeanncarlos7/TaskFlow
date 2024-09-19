document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    fetch('/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password })
    })
    .then(response => {
        if (response.ok) {
            window.location.href = 'index.html';
        } else {
            alert('Login falhou!');
        }
    });
});

document.getElementById('newTaskBtn').addEventListener('click', function() {
    const taskTitle = prompt('Digite o título da nova tarefa:');

    fetch('/tasks', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: taskTitle })
    })
    .then(response => response.json())
    .then(newTask => {
        
        const taskList = document.getElementById('taskList');
        const li = document.createElement('li');
        li.textContent = newTask.title;
        taskList.appendChild(li);
    });
});

fetch('/tasks')
    .then(response => response.json())
    .then(tasks => {
        const taskList = document.getElementById('taskList');
        tasks.forEach(task => {
            const li = document.createElement('li');
            li.textContent = task.title;
            taskList.appendChild(li);
        });
    });
