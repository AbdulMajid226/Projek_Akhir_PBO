import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ControllerKonversi {
    private ViewJframe view;
    private ModelKonversi model;

    // Konstruktor ControllerKonversi yang menghubungkan view dan model
    public ControllerKonversi(ViewJframe view, ModelKonversi model) {
        this.view = view;
        this.model = model;

        // Menambahkan ActionListener untuk tombol konversi
        this.view.convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertButtonActionPerformed(e);
            }
        });
    }

    // Metode untuk membulatkan nilai ke dua angka desimal
    private double roundToTwoDecimals(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // Metode yang dijalankan ketika tombol konversi ditekan
    public void convertButtonActionPerformed(ActionEvent evt) {
        try {
            // Mendapatkan input dari view dan mengkonversinya ke tipe data double
            double uang = Double.parseDouble(view.getInputUang());
            double hasilKonv = 0;

            // Mendapatkan mata uang asal dan tujuan dari combobox
            String mataUangAsal = view.getPilihan1();
            String mataUangTujuan = view.getPilihan2();

            // Jika mata uang asal adalah Rupiah
            if (mataUangAsal.equals("Rupiah")) {
                // Konversi langsung dari Rupiah ke mata uang tujuan
                switch (mataUangTujuan) {
                    case "Dollar":
                        hasilKonv = roundToTwoDecimals(model.IDRtoUSD(uang));
                        view.jLabelHasil.setText(uang + " rupiah : $" + hasilKonv);
                        break;
                    case "Euro":
                        hasilKonv = roundToTwoDecimals(model.IDRtoEur(uang));
                        view.jLabelHasil.setText(uang + " rupiah : €" + hasilKonv);
                        break;
                    case "Yen":
                        hasilKonv = roundToTwoDecimals(model.IDRtoYen(uang));
                        view.jLabelHasil.setText(uang + " rupiah : ¥" + hasilKonv);
                        break;
                    case "Ringgit":
                        hasilKonv = roundToTwoDecimals(model.IDRtoMYR(uang));
                        view.jLabelHasil.setText(uang + " rupiah : RM" + hasilKonv);
                        break;
                    case "Won":
                        hasilKonv = roundToTwoDecimals(model.IDRtoKRW(uang));
                        view.jLabelHasil.setText(uang + " rupiah : ₩" + hasilKonv);
                        break;
                    case "Poundsterling":
                        hasilKonv = roundToTwoDecimals(model.IDRtoGBP(uang));
                        view.jLabelHasil.setText(uang + " rupiah : £" + hasilKonv);
                        break;
                }
            } 
            // Jika mata uang tujuan adalah Rupiah
            else if (mataUangTujuan.equals("Rupiah")) {
                // Konversi langsung dari mata uang asal ke Rupiah
                switch (mataUangAsal) {
                    case "Dollar":
                        hasilKonv = roundToTwoDecimals(model.USDtoIDR(uang));
                        view.jLabelHasil.setText("$" + uang + " : " + hasilKonv + " rupiah");
                        break;
                    case "Euro":
                        hasilKonv = roundToTwoDecimals(model.EurtoIDR(uang));
                        view.jLabelHasil.setText("€" + uang + " : " + hasilKonv + " rupiah");
                        break;
                    case "Yen":
                        hasilKonv = roundToTwoDecimals(model.YentoIDR(uang));
                        view.jLabelHasil.setText("¥" + uang + " : " + hasilKonv + " rupiah");
                        break;
                    case "Ringgit":
                        hasilKonv = roundToTwoDecimals(model.MYRtoIDR(uang));
                        view.jLabelHasil.setText("RM" + uang + " : " + hasilKonv + " rupiah");
                        break;
                    case "Won":
                        hasilKonv = roundToTwoDecimals(model.KRWtoIDR(uang));
                        view.jLabelHasil.setText("₩" + uang + " : " + hasilKonv + " rupiah");
                        break;
                    case "Poundsterling":
                        hasilKonv = roundToTwoDecimals(model.GBPtoIDR(uang));
                        view.jLabelHasil.setText("£" + uang + " : " + hasilKonv + " rupiah");
                        break;
                }
            } 
            // Jika konversi antara dua mata uang selain Rupiah
            else {
                double idrAmount = 0;

                // Konversi dari mata uang asal ke IDR terlebih dahulu
                switch (mataUangAsal) {
                    case "Dollar":
                        idrAmount = model.USDtoIDR(uang);
                        break;
                    case "Euro":
                        idrAmount = model.EurtoIDR(uang);
                        break;
                    case "Yen":
                        idrAmount = model.YentoIDR(uang);
                        break;
                    case "Ringgit":
                        idrAmount = model.MYRtoIDR(uang);
                        break;
                    case "Won":
                        idrAmount = model.KRWtoIDR(uang);
                        break;
                    case "Poundsterling":
                        idrAmount = model.GBPtoIDR(uang);
                        break;
                }

                // Konversi dari IDR ke mata uang tujuan
                switch (mataUangTujuan) {
                    case "Dollar":
                        hasilKonv = roundToTwoDecimals(model.IDRtoUSD(idrAmount));
                        view.jLabelHasil.setText(uang + " " + mataUangAsal + " : $" + hasilKonv);
                        break;
                    case "Euro":
                        hasilKonv = roundToTwoDecimals(model.IDRtoEur(idrAmount));
                        view.jLabelHasil.setText(uang + " " + mataUangAsal + " : €" + hasilKonv);
                        break;
                    case "Yen":
                        hasilKonv = roundToTwoDecimals(model.IDRtoYen(idrAmount));
                        view.jLabelHasil.setText(uang + " " + mataUangAsal + " : ¥" + hasilKonv);
                        break;
                    case "Ringgit":
                        hasilKonv = roundToTwoDecimals(model.IDRtoMYR(idrAmount));
                        view.jLabelHasil.setText(uang + " " + mataUangAsal + " : RM" + hasilKonv);
                        break;
                    case "Won":
                        hasilKonv = roundToTwoDecimals(model.IDRtoKRW(idrAmount));
                        view.jLabelHasil.setText(uang + " " + mataUangAsal + " : ₩" + hasilKonv);
                        break;
                    case "Poundsterling":
                        hasilKonv = roundToTwoDecimals(model.IDRtoGBP(idrAmount));
                        view.jLabelHasil.setText(uang + " " + mataUangAsal + " : £" + hasilKonv);
                        break;
                }
            }
        } catch (NumberFormatException ex) {
            // Menampilkan pesan error jika input tidak valid
            view.jLabelHasil.setText("Input tidak valid");
        }
    }
}
