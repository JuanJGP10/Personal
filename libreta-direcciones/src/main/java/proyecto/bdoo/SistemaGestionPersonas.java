package proyecto.bdoo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import proyecto.bdoo.persona.Persona;

public class SistemaGestionPersonas {
    private EntityManagerFactory emf;

    public SistemaGestionPersonas() {
        // Inicializar la conexión
        emf = Persistence.createEntityManagerFactory("PersonasDB.odb");
    }

    public void cerrar() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    // CREAR
    public Persona crearPersona(String nombre, String apellidos, String direccion, int codigoPostal, String ciudad,
            LocalDate fechaNacimiento) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        Persona persona = null;

        try {
            tx.begin();

            persona = new Persona();
            persona.setNombreProperty(nombre);
            persona.setApellidosProperty(apellidos);
            persona.setDireccionProperty(direccion);
            persona.setCodigoPostalProperty(codigoPostal);
            persona.setCiudadProperty(ciudad);
            persona.setFechaNacimientoProperty(fechaNacimiento);

            em.persist(persona);

            tx.commit();

        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

        return persona;
    }

    public boolean eliminarPersona(long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean eliminado = false;

        try {
            tx.begin();

            Persona persona = em.find(Persona.class, id);
            if (persona != null) {
                em.remove(persona);
                tx.commit();

                eliminado = true;

            } else {

            }
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }

        } finally {
            em.close();
        }

        return eliminado;
    }

    // Método para obtener todos los productos
    public List<Persona> obtenerTodasLasPersonas() {
        EntityManager em = emf.createEntityManager();
        List<Persona> personas = null;

        try {
            TypedQuery<Persona> query = em.createQuery(
                    "SELECT p FROM Persona p ORDER BY p.id",
                    Persona.class);
            personas = query.getResultList();
        } finally {
            em.close();
        }

        return personas;
    }

    // LEER
    public Persona buscarPersonaPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Persona persona = null;

        try {
            persona = em.find(Persona.class, id);
        } finally {
            em.close();
        }

        return persona;
    }

    // ACTUALIZAR
    public boolean actualizarPersona(long id, String nombre, String apellidos, String direccion, int codigoPostal,
            String ciudad,
            LocalDate fechaNacimiento) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean actualizado = false;

        try {
            tx.begin();

            Persona persona = em.find(Persona.class, id);
            if (persona != null) {

                persona.setNombre(nombre);
                persona.setApellidos(apellidos);
                persona.setDireccion(direccion);
                persona.setCodigoPostal(codigoPostal);
                persona.setCiudad(ciudad);
                persona.setFechaNacimiento(fechaNacimiento);

                em.merge(persona);
                tx.commit();

                actualizado = true;
            }
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

        return actualizado;
    }

}
