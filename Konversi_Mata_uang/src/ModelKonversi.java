/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
public class ModelKonversi {

    // Metode konversi IDR ke mata uang lain
    public double IDRtoUSD(double uang){
        return uang / 16225;
    }

    public double IDRtoEur(double uang){
        return uang / 17617;
    }

    public double IDRtoYen(double uang){
        return uang / 103;
    }

    public double IDRtoMYR(double uang){
        return uang / 3447;
    }

    public double IDRtoKRW(double uang){
        return uang / 11;
    }

    public double IDRtoGBP(double uang){
        return uang / 20669;
    }

    // Metode konversi mata uang lain ke IDR
    public double USDtoIDR(double uang){
        return uang * 16225;
    }

    public double EurtoIDR(double uang){
        return uang * 17617;
    }

    public double YentoIDR(double uang){
        return uang * 103;
    }

    public double MYRtoIDR(double uang){
        return uang * 3447;
    }

    public double KRWtoIDR(double uang){
        return uang * 11;
    }

    public double GBPtoIDR(double uang){
        return uang * 20669;
    }
}
