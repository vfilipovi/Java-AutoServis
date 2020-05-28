package hr.tvz.zuti.autoservis.akcije.domain;

public class ServisDizelMotora extends ServisBenzMotora {

    @Override
    public void postaviPopust(int popust) {
        super.setPopust(popust/3);
    }

    @Override
    public String oglasiVrstuMotora() {
        return "Servis dizelskog motora";
    }
}
