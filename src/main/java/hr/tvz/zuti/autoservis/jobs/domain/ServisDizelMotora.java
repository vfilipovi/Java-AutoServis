package hr.tvz.zuti.autoservis.jobs.domain;

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
