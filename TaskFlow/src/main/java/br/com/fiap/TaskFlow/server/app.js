const express = require('express');
const app = express();
app.use(express.json());

let tasks = [
    { id: 1, title: "Tarefa 1" },
    { id: 2, title: "Tarefa 2" },
    { id: 3, title: "Tarefa 3" }
];

const users = [
    { username: 'usuario', password: 'senha123' }
];

app.post('/login', (req, res) => {
    const { username, password } = req.body;
    const user = users.find(u => u.username === username && u.password === password);
    if (user) {
        res.status(200).send('Login realizado com sucesso');
    } else {
        res.status(401).send('Falha no login');
    }
});

app.get('/tasks', (req, res) => {
    res.json(tasks);
});

app.post('/tasks', (req, res) => {
    const newTask = { id: tasks.length + 1, title: req.body.title };
    tasks.push(newTask);
    res.status(201).json(newTask);
});

app.listen(3000, () => {
    console.log('Servidor rodando na porta 3000');
});
