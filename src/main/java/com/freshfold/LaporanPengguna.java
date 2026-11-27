package com.freshfold;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class LaporanPengguna {

    private static final String URL =
            "jdbc:mysql://localhost:3306/laundritify";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "";

    public static void tampilkanLaporan() {

        try (
            Connection connection = DriverManager.getConnection(
                    URL, USER, PASSWORD
            );

            InputStream reportStream =
                    LaporanPengguna.class.getResourceAsStream(
                            "/reports/LaporanPengguna.jrxml"
                    )
        ) {

            if (reportStream == null) {
                throw new Exception(
                        "File LaporanPengguna.jrxml tidak ditemukan!"
                );
            }

            JasperReport jasperReport =
                    JasperCompileManager.compileReport(reportStream);

            Map<String, Object> parameters = new HashMap<>();

            JasperPrint jasperPrint =
                    JasperFillManager.fillReport(
                            jasperReport,
                            parameters,
                            connection
                    );

            JasperViewer viewer =
                    new JasperViewer(jasperPrint, false);

            viewer.setTitle("Laporan Pengguna - Laundritify");
            viewer.setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Gagal menampilkan laporan!\n" + e.getMessage(),
                    "Kesalahan Laporan",
                    JOptionPane.ERROR_MESSAGE
            );

            e.printStackTrace();
        }
    }
}
