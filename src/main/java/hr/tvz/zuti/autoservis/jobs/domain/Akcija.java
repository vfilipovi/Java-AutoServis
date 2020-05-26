package hr.tvz.zuti.autoservis.jobs.domain;

public abstract class Akcija {
    private int popust;

    abstract public String kreirajOglas();

    abstract public void postaviPopust(int popust);

    protected void setPopust(int popust){
        this.popust = popust;
    }

    protected int getPopust(){
        return this.popust;
    }
}
