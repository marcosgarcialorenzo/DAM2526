-- Apartado 1
-- Hola mundo en PLSQL
BEGIN
DBMS_OUTPUT.PUT_LINE(' HOLA. ESTOY EMPEZANDO A APRENDER PLSQL');
END;
/ 
-- Suma de dos números
DECLARE
A NUMBER;
B NUMBER;
C NUMBER;
BEGIN
DBMS_OUTPUT.PUT_LINE(' SUMANDO NUMEROS ');
A:=&IntroduceNumero1;
B:=&IntroduceNumero2;
C:=A+B;
DBMS_OUTPUT.PUT_LINE(" La suma es "|| C);
END;
/ 
-- Mayor de dos números
DECLARE
A NUMBER;
B NUMBER;
mayor NUMBER;
BEGIN
DBMS_OUTPUT.PUT_LINE(' SUMANDO NUMEROS');
A:=&IntroduceNumero1;
B:=&IntroduceNumero2;
IF A>B THEN
mayor:=A;
ELSE
mayor:=B;
END IF;
DBMS_OUTPUT.PUT_LINE(' El mayor es '|| mayor);
END;
/


-- Apartado 2
-- Hola mundo en un procedimiento
CREATE OR REPLACE PROCEDURE ImprimirMensaje
IS
BEGIN
DBMS_OUTPUT.PUT_LINE('HOLA. ESTOY EMPEZANDO A APRENDER PLSQL ');
END;
EXECUTE ImprimirMensaje;
/ 
-- Procedimiento de suma de dos números
CREATE OR REPLACE PROCEDURE SUMA (A NUMBER, B NUMBER)
IS
    C NUMBER;
BEGIN
    C := A + B;
    DBMS_OUTPUT.PUT_LINE('La suma es ' || C);
END;

BEGIN
    SUMA(2,3);
END;
/
-- Procedimiento para encontrar el mayor de dos números
CREATE OR REPLACE PROCEDURE MAYOR (A NUMBER , B NUMBER)
IS
BEGIN
    IF A > B THEN
        DBMS_OUTPUT.PUT_LINE('El mayor es ' || A);
    ELSE
        DBMS_OUTPUT.PUT_LINE('El mayor es ' || B);
    END IF;
END;

BEGIN
    MAYOR(5,10);
END;
/