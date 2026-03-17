CREATE OR REPLACE FUNCTION salario_promedio_dept(p_dept_no NUMBER)
RETURN NUMBER
IS
    v_promedio NUMBER;
    v_count NUMBER;
BEGIN
    -- comprobar si existe el departamento
    SELECT COUNT(*)
    INTO v_count
    FROM DEPART
    WHERE DEPT_NO = p_dept_no;

    IF v_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20001,'NO PODEMOS CALCULAR EL SALARIO PROMEDIO');
    END IF;

    -- calcular promedio
    SELECT AVG(SALARIO)
    INTO v_promedio
    FROM EMPLE
    WHERE DEPT_NO = p_dept_no;

    RETURN v_promedio;
END;
/

CREATE OR REPLACE FUNCTION empleado_salario_max
RETURN VARCHAR2
IS
    v_apellido EMPLE.APELLIDO%TYPE;
BEGIN
    SELECT APELLIDO
    INTO v_apellido
    FROM EMPLE
    WHERE SALARIO = (SELECT MAX(SALARIO) FROM EMPLE);

    RETURN v_apellido;
END;
/

CREATE OR REPLACE FUNCTION dept_mayor_comision
RETURN VARCHAR2
IS
    v_nombre DEPART.DNOMBRE%TYPE;
BEGIN
    SELECT d.DNOMBRE
    INTO v_nombre
    FROM DEPART d
    JOIN EMPLE e ON d.DEPT_NO = e.DEPT_NO
    GROUP BY d.DNOMBRE
    ORDER BY SUM(NVL(e.COMISION,0)) DESC
    FETCH FIRST 1 ROWS ONLY;

    RETURN v_nombre;
END;
/

SET SERVEROUTPUT ON;

DECLARE
    v_promedio NUMBER;
    v_apellido VARCHAR2(50);
    v_departamento VARCHAR2(50);
    v_dept NUMBER := 10; -- departamento de ejemplo
BEGIN

    -- función 1
    v_promedio := salario_promedio_dept(v_dept);
    DBMS_OUTPUT.PUT_LINE('Salario promedio del departamento ' || v_dept || ': ' || v_promedio);

    -- función 2
    v_apellido := empleado_salario_max;
    DBMS_OUTPUT.PUT_LINE('Empleado con salario máximo: ' || v_apellido);

    -- función 3
    v_departamento := dept_mayor_comision;
    DBMS_OUTPUT.PUT_LINE('Departamento con mayor comisión total: ' || v_departamento);

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/