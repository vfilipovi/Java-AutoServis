package hr.tvz.zuti.autoservis.jobs.domain;

public class ServisBenzMotora extends Akcija implements OglasiVrstuMotora {

    @Override
    public String kreirajOglas() {
        return oglasiVrstuMotora() + " uz popust od " + super.getPopust() + " posto!";
    }

    @Override
    public void postaviPopust(int popust) {
        super.setPopust(popust/2);
    }

    @Override
    public String oglasiVrstuMotora() {
        return "Servis benzinskog motora";
    }
}
