package hr.tvz.zuti.autoservis.akcije.domain;

public class Farbanje extends Akcija {

    @Override
    public String kreirajOglas() {
        return "Farbanje automobila uz popust od " + super.getPopust() + " posto!";
    }

    @Override
    public void postaviPopust(int popust) {
        setPopust(popust/2);
    }

}
