/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */public class Main {
    public static void main(String[] args) {
        ViewJframe view = new ViewJframe();
        ModelKonversi model = new ModelKonversi();
        ControllerKonversi controller = new ControllerKonversi(view, model);
        
        view.setVisible(true);
    }
}



