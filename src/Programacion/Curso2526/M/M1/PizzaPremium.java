package Programacion.Curso2526.M.M1;

import lombok.Getter;

@Getter
public class PizzaPremium extends Pizza {
    private int tipoBase;// 0-normal, 1-extrafina, 2-borde queso

    public PizzaPremium(int tipoBase) {
        if (tipoBase < 0 || tipoBase > 2) {
            throw new IllegalArgumentException("Tipo de base no válido: " + tipoBase);
        }
        this.tipoBase = tipoBase;
    }

    @Override
    protected int getMaxIngredientes() {
        return Integer.MAX_VALUE; // Premium: sin límite.
    }

    @Override
    public double getCosteBase() {
        return (tipoBase == 0) ? 0.0 : 2.0;
    }
}