package hu.petrik.szuperhosprojekt;

import java.text.MessageFormat;

public abstract class Bosszuallo implements Szuperhos {
    private double szuperero;
    private boolean vanEGyengesege;

    public Bosszuallo(double szuperero, boolean vanEGyengesege) {
        this.szuperero = szuperero;
        this.vanEGyengesege = vanEGyengesege;
    }

    public abstract boolean megmentiAVilagot();

    @Override
    public double mekkoraAzEreje() {
        return this.szuperero;
    }

    @Override
    public boolean legyoziE(Szuperhos hos) {
        if (hos instanceof Bosszuallo) {
            Bosszuallo ellenfel = (Bosszuallo) hos;
            if (ellenfel.isVanEGyengesege() && this.szuperero > ellenfel.mekkoraAzEreje()) {
                return true;
            }
        } else if (hos instanceof Batman) {
            return this.szuperero > 2 * hos.mekkoraAzEreje();
        }
        return false;
    }

    public double getSzuperero() {
        return szuperero;
    }

    public void setSzuperero(double szuperero) {
        this.szuperero = szuperero;
    }

    public boolean isVanEGyengesege() {
        return vanEGyengesege;
    }

    public void setVanEGyengesege(boolean vanEGyengesege) {
        this.vanEGyengesege = vanEGyengesege;
    }

    @Override
    public String toString() {
        String gyengesegSzoveg = vanEGyengesege ? "van gyengesége" : "nincs gyengesége";
        return MessageFormat.format("Szupererő: {0,number,#.##}; {1}", szuperero, gyengesegSzoveg);
    }
}




