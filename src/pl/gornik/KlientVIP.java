package pl.gornik;

public class KlientVIP extends Klient {
    private double znizka;

    public KlientVIP(String imie, String nazwisko, double znizka ){
        super(imie, nazwisko);
        this.znizka=znizka;
    }
    public double getZnizka() {
        return znizka;
    }

    @Override
    public double obliczSkladke() {
        double sumaSkladek=super.obliczSkladke();
        return sumaSkladek -(sumaSkladek * znizka);
      }
    }

