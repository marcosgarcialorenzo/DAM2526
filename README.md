# DAM2526 📚

Repositorio con ejercicios y proyectos del ciclo formativo **DAM (Desarrollo de Aplicaciones Multiplataforma)** correspondiente al curso 2025-2026.

---

## 📁 Estructura del Proyecto

```
DAM2526/
├── pom.xml
├── DAM2526.iml
├── README.md
│
├── src/
│   ├── BasesDeDatos/
│   │   └── Curso2526/
│   │       ├── ExamenesMGL/
│   │       │   └── SQL/
│   │       │       └── ConsultasSelect/
│   │       ├── MongoDB/
│   │       │   └── 9.1/
│   │       ├── PLSQL/
│   │       │   ├── TablasUsadas.sql
│   │       │   ├── 8.1.1/
│   │       │   └── 8.2/
│   │       └── SQL/
│   │           ├── 6.1 Personas/
│   │           ├── 6.2 Multinacional/
│   │           ├── 6.3 Universidad/
│   │           ├── 6.4 Instituto/
│   │           ├── 6.5 Creacion de vistas/
│   │           ├── 6.6 Red de Metro/
│   │           ├── 6.7 Universidad Popular/
│   │           └── 6.15 Vendedores/
│   │
│   └── Programacion/
│       ├── Curso2425/
│       │   └── Examenes/
│       │       └── Ev1/
│       │
│       └── Curso2526/
│           ├── Teclado.java
│           ├── TecladoGrafico.java
│           ├── TestAlumno.java
│           │
│           ├── A/   → Ejercicios básicos (clases, objetos, constructores)
│           │   └── A2/-A13/
│           │
│           ├── B/   → Estructuras de control (if, switch, bucles)
│           │   └── B1/-B15/
│           │
│           ├── C/   → Estructuras avanzadas (break, continue)
│           │   └── C1/-C6/
│           │
│           ├── D/   → Arrays
│           │   └── D1/-D6/
│           │
│           ├── E/   → Matrices y arrays de objetos
│           │   ├── E1/-E9/
│           │   └── HundirLaFlota/
│           │
│           ├── F/   → Strings
│           │   └── F1/-F7/
│           │
│           ├── G/   → Excepciones y manejo de errores
│           │   └── G1/-G3/
│           │
│           ├── H/   → Recursividad
│           │   └── H1/-H2/
│           │
│           ├── I/   → Ficheros y directorios
│           │   └── I1/-I6/
│           │
│           ├── J/   → Herencia y POO avanzada
│           │   └── J1/-J2/
│           │
│           ├── K/   → Colecciones (Vector, ArrayList, etc.)
│           │   └── K0/-K2/
│           │
│           ├── L/   → Interfaces y clases abstractas
│           │   └── L1/-L4/
│           │
│           ├── M/   → JDBC y acceso a bases de datos
│           │   └── M1/
│           │
│           ├── N/   → Entornos gráficos
│           │   ├─── N1/
│           │   └── JuegoBotones/
│           │
│           └── ExamenesMGL/
│               ├── Evaluacion1/
│               └── Evaluacion2/
```

---

## 🛠️ Tecnologías Utilizadas

- **Java** (JDK 21, configurado en Maven)
- **Maven** (gestión de build y dependencias)
- **SQL** (MySQL/MariaDB) y **MongoDB**
- **Lombok** y **H2 Database**
- **IDE**: IntelliJ IDEA

---

## 📝 Convenciones de Commits

Este repositorio sigue una convención estricta para los mensajes de commit:

### Estructura de un Commit

Un mensaje de commit debe seguir este formato:

```
<tipo>[alcance opcional]: <descripción corta en imperativo>
```

### Tipos de Commit

| Tipo       | Descripción                | Ejemplo                                                |
|------------|----------------------------|--------------------------------------------------------|
| `feat`     | Nueva funcionalidad        | `feat(K0): añadir método ordenar empleados por edad`   |
| `fix`      | Corrección de errores      | `fix(E7): corregir división por cero en método multar` |
| `docs`     | Documentación/comentarios  | `docs: añadir comentarios explicativos a F5`           |
| `refactor` | Reestructuración de código | `refactor(Empresa): simplificar método modificarEdad`  |


## 📄 Licencia

Este proyecto es de uso educativo para el ciclo DAM 2025-2026.

---

## 👤 Autor

**Marcos García Lorenzo** - Estudiante DAM en el IES Luis Vives