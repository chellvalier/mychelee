/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.freshfold;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author THINKPAD
 */
public class LandingPage extends javax.swing.JFrame {

    /**
     * Creates new form LandingPage
     */
private boolean sudahLogin = false;
public LandingPage(boolean sudahLogin) {
    this();

    this.sudahLogin = sudahLogin;

    if (sudahLogin) {
        jButton1.setText("LOG OUT");
    }
}

public LandingPage() {
    initComponents();

    ImageIcon icon = new ImageIcon(
        getClass().getResource("/images/laundry1.png")
    );

    Image img = icon.getImage().getScaledInstance(
        350, 350, Image.SCALE_SMOOTH
    );

    lblHeroImage.setIcon(new ImageIcon(img));

    setupScrollPane();
    aturNavbarLayout();
    aturHeroLayout();
    aturServicesLayout();
    aturAdvantagesLayout();

    setSize(1000, 750);
    setLocationRelativeTo(null);
}

private void setupScrollPane() {

    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(
        new javax.swing.BoxLayout(
            contentPanel,
            javax.swing.BoxLayout.Y_AXIS
        )
    );

    pnlHero.setPreferredSize(new Dimension(1000, 450));
    pnlHero.setMaximumSize(
        new Dimension(Integer.MAX_VALUE, 450)
    );

    pnlServices.setPreferredSize(new Dimension(1000, 300));
    pnlServices.setMaximumSize(
        new Dimension(Integer.MAX_VALUE, 300)
    );

    pnlAdvantages.setPreferredSize(new Dimension(1000, 250));
    pnlAdvantages.setMaximumSize(
        new Dimension(Integer.MAX_VALUE, 250)
    );

    jPanel1.setPreferredSize(new Dimension(1000, 192));
    jPanel1.setMaximumSize(
        new Dimension(Integer.MAX_VALUE, 192)
    );

    contentPanel.add(pnlHero);
    contentPanel.add(pnlServices);
    contentPanel.add(pnlAdvantages);
    contentPanel.add(jPanel1);

    JScrollPane scrollPane = new JScrollPane(contentPanel);

    scrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
    );

    scrollPane.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
    );

    scrollPane.setBorder(null);

    pnlNavbar.setPreferredSize(new Dimension(1000, 80));

    getContentPane().removeAll();
    getContentPane().setLayout(new BorderLayout());

    getContentPane().add(pnlNavbar, BorderLayout.NORTH);
    getContentPane().add(scrollPane, BorderLayout.CENTER);

    revalidate();
    repaint();
}


private void aturNavbarLayout() {

    pnlNavbar.setLayout(null);

    pnlNavbar.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {

            int width = pnlNavbar.getWidth();
            int y = 22;

            // Logo di sebelah kiri
            lblLogo.setBounds(30, y, 250, 35);

            // Tombol Sign In di sebelah kanan
            int buttonWidth = 90;
            int buttonX = width - 40 - buttonWidth;

            jButton1.setBounds(
                buttonX, y, buttonWidth, 32
            );

            // Menu navigasi
            lblProfil.setBounds(
                buttonX - 65, y, 50, 32
            );

            lblTentang.setBounds(
                buttonX - 195, y, 115, 32
            );

            lblLayanan.setBounds(
                buttonX - 290, y, 80, 32
            );

            lblBeranda.setBounds(
                buttonX - 380, y, 75, 32
            );

            // Meratakan teks menu
            lblBeranda.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
            );

            lblLayanan.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
            );

            lblTentang.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
            );

            lblProfil.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
            );

            pnlNavbar.revalidate();
            pnlNavbar.repaint();
        }
    });
}

private void aturHeroLayout() {

    pnlHero.setLayout(null);

    pnlHero.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {

            int width = pnlHero.getWidth();

            // Posisi teks di sebelah kiri
            lblGreeting.setBounds(
                (int)(width * 0.05), 110, 350, 25
            );

            lblHeroTitle.setBounds(
                (int)(width * 0.05), 145, 450, 50
            );

            lblHeroDesc.setBounds(
                (int)(width * 0.05), 205, 450, 35
            );

            btnPesanSekarang.setBounds(
                (int)(width * 0.05), 285, 150, 40
            );

            // Posisi gambar di sebelah kanan
            int imageSize = 350;

            lblHeroImage.setBounds(
                (int)(width * 0.62), 50,
                imageSize, imageSize
            );

            pnlHero.revalidate();
            pnlHero.repaint();
        }
    });
}


private void aturServicesLayout() {

    pnlServices.setLayout(null);

    pnlServices.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {

            int width = pnlServices.getWidth();

            // Judul dan deskripsi di tengah
            lblServicesTitle.setBounds(
                0, 30, width, 35
            );

            lblServicesDesc.setBounds(
                0, 70, width, 30
            );

            lblServicesTitle.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
            );

            lblServicesDesc.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
            );

            // Mengatur posisi kartu layanan
            int cardWidth = 176;
            int cardHeight = 148;
            int gap = 54;

            int totalWidth = (cardWidth * 3) + (gap * 2);
            int startX = (width - totalWidth) / 2;

            pnlKiloan.setBounds(
                startX, 130, cardWidth, cardHeight
            );

            pnlExpress.setBounds(
                startX + cardWidth + gap, 130,
                cardWidth, cardHeight
            );

            pnlBedcover.setBounds(
                startX + (cardWidth + gap) * 2, 130,
                cardWidth, cardHeight
            );

            pnlServices.revalidate();
            pnlServices.repaint();
        }
    });
}



private void aturAdvantagesLayout() {

    pnlAdvantages.setLayout(null);

    pnlAdvantages.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {

            int width = pnlAdvantages.getWidth();

            // Judul utama
            lblAdvantagesTitle.setBounds(
                0, 30, width, 40
            );

            lblAdvantagesTitle.setHorizontalAlignment(
                javax.swing.SwingConstants.CENTER
            );

            // Pengaturan tiga kolom
            int margin = (int)(width * 0.06);
            int gap = 30;

            int columnWidth =
                (width - (2 * margin) - (2 * gap)) / 3;

            int titleY = 105;
            int descY = 145;

            // Kolom pertama
            lblAdvantage1.setBounds(
                margin, titleY, columnWidth, 35
            );

            lblAdvantageDesc1.setBounds(
                margin, descY, columnWidth, 45
            );

            // Kolom kedua
            lblAdvantage2.setBounds(
                margin + columnWidth + gap,
                titleY, columnWidth, 35
            );

            lblAdvantageDesc2.setBounds(
                margin + columnWidth + gap,
                descY, columnWidth, 45
            );

            // Kolom ketiga
            lblAdvantage3.setBounds(
                margin + (columnWidth + gap) * 2,
                titleY, columnWidth, 35
            );

            lblAdvantageDesc3.setBounds(
                margin + (columnWidth + gap) * 2,
                descY, columnWidth, 45
            );

            // Semua teks rata tengah
            javax.swing.JLabel[] labels = {
                lblAdvantage1,
                lblAdvantage2,
                lblAdvantage3,
                lblAdvantageDesc1,
                lblAdvantageDesc2,
                lblAdvantageDesc3
            };

            for (javax.swing.JLabel label : labels) {
                label.setHorizontalAlignment(
                    javax.swing.SwingConstants.CENTER
                );
            }

            pnlAdvantages.revalidate();
            pnlAdvantages.repaint();
        }
    });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNavbar = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblBeranda = new javax.swing.JLabel();
        lblLayanan = new javax.swing.JLabel();
        lblTentang = new javax.swing.JLabel();
        lblProfil = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlHero = new javax.swing.JPanel();
        lblGreeting = new javax.swing.JLabel();
        lblHeroTitle = new javax.swing.JLabel();
        lblHeroDesc = new javax.swing.JLabel();
        lblHeroImage = new javax.swing.JLabel();
        btnPesanSekarang = new javax.swing.JButton();
        pnlServices = new javax.swing.JPanel();
        lblServicesTitle = new javax.swing.JLabel();
        lblServicesDesc = new javax.swing.JLabel();
        pnlKiloan = new javax.swing.JPanel();
        lblKiloan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtKiloanDesc = new javax.swing.JTextArea();
        pnlExpress = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblExpressDesc = new javax.swing.JTextArea();
        lblExpress = new javax.swing.JLabel();
        pnlBedcover = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lblBedcoverDesc = new javax.swing.JTextArea();
        lblBedcover = new javax.swing.JLabel();
        pnlAdvantages = new javax.swing.JPanel();
        lblAdvantagesTitle = new javax.swing.JLabel();
        lblAdvantage1 = new javax.swing.JLabel();
        lblAdvantage2 = new javax.swing.JLabel();
        lblAdvantage3 = new javax.swing.JLabel();
        lblAdvantageDesc1 = new javax.swing.JLabel();
        lblAdvantageDesc2 = new javax.swing.JLabel();
        lblAdvantageDesc3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblFooterLogo = new javax.swing.JLabel();
        lblFooterDesc = new javax.swing.JLabel();
        lblCopyright = new javax.swing.JLabel();
        lblFooterContact = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNavbar.setBackground(new java.awt.Color(255, 255, 255));

        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(36, 91, 133));
        lblLogo.setText("LAUNDRITIFY");

        lblBeranda.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblBeranda.setForeground(new java.awt.Color(82, 98, 115));
        lblBeranda.setText("Beranda");

        lblLayanan.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblLayanan.setForeground(new java.awt.Color(82, 98, 115));
        lblLayanan.setText("Layanan");

        lblTentang.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTentang.setForeground(new java.awt.Color(82, 98, 115));
        lblTentang.setText("Tentang Kami");

        lblProfil.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblProfil.setForeground(new java.awt.Color(82, 98, 115));
        lblProfil.setText("Profil");

        jButton1.setBackground(new java.awt.Color(85, 88, 217));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SIGN IN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavbarLayout = new javax.swing.GroupLayout(pnlNavbar);
        pnlNavbar.setLayout(pnlNavbarLayout);
        pnlNavbarLayout.setHorizontalGroup(
            pnlNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavbarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblLogo)
                .addGap(196, 196, 196)
                .addComponent(lblBeranda)
                .addGap(18, 18, 18)
                .addComponent(lblLayanan)
                .addGap(18, 18, 18)
                .addComponent(lblTentang)
                .addGap(18, 18, 18)
                .addComponent(lblProfil)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(303, Short.MAX_VALUE))
        );
        pnlNavbarLayout.setVerticalGroup(
            pnlNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavbarLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogo)
                    .addComponent(lblBeranda)
                    .addComponent(lblLayanan)
                    .addComponent(lblTentang)
                    .addComponent(lblProfil)
                    .addComponent(jButton1))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(pnlNavbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        pnlHero.setBackground(new java.awt.Color(234, 245, 255));
        pnlHero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGreeting.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblGreeting.setForeground(new java.awt.Color(36, 91, 133));
        lblGreeting.setText("WELCOME TO LAUNDRITIFY");
        pnlHero.add(lblGreeting, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, -1, -1));

        lblHeroTitle.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblHeroTitle.setForeground(new java.awt.Color(36, 55, 70));
        lblHeroTitle.setText("Laundry made Easy!");
        pnlHero.add(lblHeroTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 117, -1, -1));

        lblHeroDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHeroDesc.setForeground(new java.awt.Color(82, 98, 115));
        lblHeroDesc.setText("Solusi praktis untuk kebutuhan Laundry anda.");
        pnlHero.add(lblHeroDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 161, -1, -1));

        lblHeroImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeroImage.setPreferredSize(new java.awt.Dimension(350, 350));
        pnlHero.add(lblHeroImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 28, -1, -1));

        btnPesanSekarang.setBackground(new java.awt.Color(36, 91, 133));
        btnPesanSekarang.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnPesanSekarang.setForeground(new java.awt.Color(255, 255, 255));
        btnPesanSekarang.setText("Pesan Sekarang");
        btnPesanSekarang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlHero.add(btnPesanSekarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 262, -1, -1));

        getContentPane().add(pnlHero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 450));

        pnlServices.setBackground(new java.awt.Color(255, 255, 255));
        pnlServices.setForeground(new java.awt.Color(255, 255, 255));
        pnlServices.setPreferredSize(new java.awt.Dimension(1000, 260));

        lblServicesTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblServicesTitle.setForeground(new java.awt.Color(36, 55, 70));
        lblServicesTitle.setText("Our Services");

        lblServicesDesc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblServicesDesc.setForeground(new java.awt.Color(82, 98, 115));
        lblServicesDesc.setText("Choose the best service for your laundry needs.");

        pnlKiloan.setBackground(new java.awt.Color(234, 245, 255));

        lblKiloan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblKiloan.setForeground(new java.awt.Color(36, 91, 133));
        lblKiloan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKiloan.setText("Cuci Kiloan");

        txtKiloanDesc.setEditable(false);
        txtKiloanDesc.setBackground(new java.awt.Color(234, 245, 255));
        txtKiloanDesc.setColumns(20);
        txtKiloanDesc.setForeground(new java.awt.Color(82, 98, 115));
        txtKiloanDesc.setLineWrap(true);
        txtKiloanDesc.setRows(5);
        txtKiloanDesc.setText("Solusi praktis untuk pakaian sehari-hari.");
        txtKiloanDesc.setWrapStyleWord(true);
        txtKiloanDesc.setBorder(null);
        jScrollPane1.setViewportView(txtKiloanDesc);

        javax.swing.GroupLayout pnlKiloanLayout = new javax.swing.GroupLayout(pnlKiloan);
        pnlKiloan.setLayout(pnlKiloanLayout);
        pnlKiloanLayout.setHorizontalGroup(
            pnlKiloanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlKiloanLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(pnlKiloanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKiloan))
                .addGap(29, 29, 29))
        );
        pnlKiloanLayout.setVerticalGroup(
            pnlKiloanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKiloanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKiloan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlExpress.setBackground(new java.awt.Color(234, 245, 255));

        lblExpressDesc.setEditable(false);
        lblExpressDesc.setBackground(new java.awt.Color(234, 245, 255));
        lblExpressDesc.setColumns(20);
        lblExpressDesc.setForeground(new java.awt.Color(82, 98, 115));
        lblExpressDesc.setLineWrap(true);
        lblExpressDesc.setRows(5);
        lblExpressDesc.setText("Layanan laundry dengan pengerjaan lebih cepat.");
        lblExpressDesc.setWrapStyleWord(true);
        lblExpressDesc.setBorder(null);
        jScrollPane2.setViewportView(lblExpressDesc);

        lblExpress.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblExpress.setForeground(new java.awt.Color(36, 91, 133));
        lblExpress.setText("Cuci Express");

        javax.swing.GroupLayout pnlExpressLayout = new javax.swing.GroupLayout(pnlExpress);
        pnlExpress.setLayout(pnlExpressLayout);
        pnlExpressLayout.setHorizontalGroup(
            pnlExpressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExpressLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(pnlExpressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblExpress))
                .addGap(30, 30, 30))
        );
        pnlExpressLayout.setVerticalGroup(
            pnlExpressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlExpressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblExpress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBedcover.setBackground(new java.awt.Color(234, 245, 255));

        lblBedcoverDesc.setEditable(false);
        lblBedcoverDesc.setBackground(new java.awt.Color(234, 245, 255));
        lblBedcoverDesc.setColumns(20);
        lblBedcoverDesc.setForeground(new java.awt.Color(82, 98, 115));
        lblBedcoverDesc.setLineWrap(true);
        lblBedcoverDesc.setRows(5);
        lblBedcoverDesc.setText("Perawatan khusus untuk perlengkapan tidur.");
        lblBedcoverDesc.setWrapStyleWord(true);
        lblBedcoverDesc.setBorder(null);
        jScrollPane4.setViewportView(lblBedcoverDesc);

        lblBedcover.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblBedcover.setForeground(new java.awt.Color(36, 91, 133));
        lblBedcover.setText("Cuci Bedcover");

        javax.swing.GroupLayout pnlBedcoverLayout = new javax.swing.GroupLayout(pnlBedcover);
        pnlBedcover.setLayout(pnlBedcoverLayout);
        pnlBedcoverLayout.setHorizontalGroup(
            pnlBedcoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBedcoverLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlBedcoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBedcoverLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBedcover))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlBedcoverLayout.setVerticalGroup(
            pnlBedcoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBedcoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBedcover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlServicesLayout = new javax.swing.GroupLayout(pnlServices);
        pnlServices.setLayout(pnlServicesLayout);
        pnlServicesLayout.setHorizontalGroup(
            pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlServicesLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(pnlKiloan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(pnlExpress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(pnlBedcover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(356, 356, 356))
            .addGroup(pnlServicesLayout.createSequentialGroup()
                .addGroup(pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlServicesLayout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(lblServicesDesc))
                    .addGroup(pnlServicesLayout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(lblServicesTitle)))
                .addContainerGap())
        );
        pnlServicesLayout.setVerticalGroup(
            pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlServicesLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblServicesTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblServicesDesc)
                .addGap(30, 30, 30)
                .addGroup(pnlServicesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlKiloan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlExpress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBedcover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        getContentPane().add(pnlServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 1000, 300));

        pnlAdvantages.setBackground(new java.awt.Color(234, 245, 255));

        lblAdvantagesTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblAdvantagesTitle.setForeground(new java.awt.Color(36, 55, 70));
        lblAdvantagesTitle.setText("Why Choose Laundritify?");

        lblAdvantage1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAdvantage1.setForeground(new java.awt.Color(36, 91, 133));
        lblAdvantage1.setText("Praktis dan Mudah");

        lblAdvantage2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAdvantage2.setForeground(new java.awt.Color(36, 91, 133));
        lblAdvantage2.setText("Pelayanan Berkualitas");

        lblAdvantage3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAdvantage3.setForeground(new java.awt.Color(36, 91, 133));
        lblAdvantage3.setText("Harga Terjangkau");

        lblAdvantageDesc1.setForeground(new java.awt.Color(82, 98, 115));
        lblAdvantageDesc1.setText("Pemesanan laundry lebih mudah.");

        lblAdvantageDesc2.setForeground(new java.awt.Color(82, 98, 115));
        lblAdvantageDesc2.setText("Pakaian dirawat dengan baik.");

        lblAdvantageDesc3.setForeground(new java.awt.Color(82, 98, 115));
        lblAdvantageDesc3.setText("Layanan dengan harga bersahabat.");

        javax.swing.GroupLayout pnlAdvantagesLayout = new javax.swing.GroupLayout(pnlAdvantages);
        pnlAdvantages.setLayout(pnlAdvantagesLayout);
        pnlAdvantagesLayout.setHorizontalGroup(
            pnlAdvantagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdvantagesLayout.createSequentialGroup()
                .addGroup(pnlAdvantagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdvantagesLayout.createSequentialGroup()
                        .addGroup(pnlAdvantagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlAdvantagesLayout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(lblAdvantageDesc1)
                                .addGap(155, 155, 155))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlAdvantagesLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(lblAdvantage1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(pnlAdvantagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdvantageDesc2)
                            .addComponent(lblAdvantage2)))
                    .addGroup(pnlAdvantagesLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(lblAdvantage3))
                    .addGroup(pnlAdvantagesLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblAdvantagesTitle))
                    .addGroup(pnlAdvantagesLayout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(lblAdvantageDesc3)))
                .addGap(420, 420, 420))
        );
        pnlAdvantagesLayout.setVerticalGroup(
            pnlAdvantagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdvantagesLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblAdvantagesTitle)
                .addGap(18, 18, 18)
                .addGroup(pnlAdvantagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdvantage2)
                    .addComponent(lblAdvantage1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAdvantagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdvantageDesc2)
                    .addComponent(lblAdvantageDesc1))
                .addGap(32, 32, 32)
                .addComponent(lblAdvantage3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAdvantageDesc3)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(pnlAdvantages, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 830, 1000, 250));

        jPanel1.setBackground(new java.awt.Color(36, 91, 133));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 120));

        lblFooterLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblFooterLogo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblFooterLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblFooterLogo.setText("LAUNDRITIFY");

        lblFooterDesc.setForeground(new java.awt.Color(234, 245, 255));
        lblFooterDesc.setText("Your Laundry, Our Priority.");

        lblCopyright.setForeground(new java.awt.Color(234, 245, 255));
        lblCopyright.setText("© 2026 Laundritify. All Rights Reserved.");

        lblFooterContact.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblFooterContact.setForeground(new java.awt.Color(255, 255, 255));
        lblFooterContact.setText("Contact Us");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFooterContact)
                    .addComponent(lblFooterDesc)
                    .addComponent(lblFooterLogo)
                    .addComponent(lblCopyright))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblFooterLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFooterDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCopyright)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFooterContact)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1080, 1000, 192));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (sudahLogin) {
            int pilihan = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Apakah Anda yakin ingin logout?",
            "Konfirmasi Logout",
            javax.swing.JOptionPane.YES_NO_OPTION
            );

        if (pilihan == javax.swing.JOptionPane.YES_OPTION) {
            new LandingPage(false).setVisible(true);
            this.dispose();
        }

    } else {
        RegisterForm register = new RegisterForm();
        register.setTitle("Register - Laundritify");
        register.setExtendedState(
            javax.swing.JFrame.MAXIMIZED_BOTH
        );
        register.setVisible(true);

        this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LandingPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LandingPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesanSekarang;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAdvantage1;
    private javax.swing.JLabel lblAdvantage2;
    private javax.swing.JLabel lblAdvantage3;
    private javax.swing.JLabel lblAdvantageDesc1;
    private javax.swing.JLabel lblAdvantageDesc2;
    private javax.swing.JLabel lblAdvantageDesc3;
    private javax.swing.JLabel lblAdvantagesTitle;
    private javax.swing.JLabel lblBedcover;
    private javax.swing.JTextArea lblBedcoverDesc;
    private javax.swing.JLabel lblBeranda;
    private javax.swing.JLabel lblCopyright;
    private javax.swing.JLabel lblExpress;
    private javax.swing.JTextArea lblExpressDesc;
    private javax.swing.JLabel lblFooterContact;
    private javax.swing.JLabel lblFooterDesc;
    private javax.swing.JLabel lblFooterLogo;
    private javax.swing.JLabel lblGreeting;
    private javax.swing.JLabel lblHeroDesc;
    private javax.swing.JLabel lblHeroImage;
    private javax.swing.JLabel lblHeroTitle;
    private javax.swing.JLabel lblKiloan;
    private javax.swing.JLabel lblLayanan;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblProfil;
    private javax.swing.JLabel lblServicesDesc;
    private javax.swing.JLabel lblServicesTitle;
    private javax.swing.JLabel lblTentang;
    private javax.swing.JPanel pnlAdvantages;
    private javax.swing.JPanel pnlBedcover;
    private javax.swing.JPanel pnlExpress;
    private javax.swing.JPanel pnlHero;
    private javax.swing.JPanel pnlKiloan;
    private javax.swing.JPanel pnlNavbar;
    private javax.swing.JPanel pnlServices;
    private javax.swing.JTextArea txtKiloanDesc;
    // End of variables declaration//GEN-END:variables
}
