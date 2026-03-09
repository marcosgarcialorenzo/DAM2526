-- Apartado 1
-- Hola mundo en PLSQL
BEGIN
DBMS_OUTPUT.PUT_LINE(' HOLA. ESTOY EMPEZANDO A APRENDER PLSQL');
END;
/ -- Suma de dos números
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
/ -- Mayor de dos números
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