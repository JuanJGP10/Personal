import { useEffect, useState } from 'react';
import './App.css';

function App() {
  const [tareas, setTareas] = useState([]);
  const [cargando, setCargando] = useState(true);

  useEffect(() => {
    fetch('http://localhost:8080/api/tareas')
      .then((res) => res.json())
      .then((data) => {
        setTareas(data);
        setCargando(false);
      })
      .catch((error) => {
        console.error('Error al cargar las tareas:', error);
        setCargando(false);
      });
  }, []);

  return (
    <div className="app">
      <h1>Mis Tareas</h1>
      {cargando ? (
        <p>Cargando tareas...</p>
      ) : (
        <ul>
          {tareas.map((tarea) => (
            <li key={tarea.id}>
              <span style={{ textDecoration: tarea.completada ? 'line-through' : 'none' }}>
                {tarea.titulo}
              </span>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;
