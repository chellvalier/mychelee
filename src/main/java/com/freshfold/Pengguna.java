package com.freshfold;

import jakarta.persistence.*;

@Entity
@Table(name = "pengguna")
public class Pengguna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pengguna")
    private int idPengguna;

    @Column(name = "nama_lengkap", nullable = false, length = 100)
    private String namaLengkap;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "nomor_hp", nullable = false)
    private Integer nomorHp;

    @Column(name = "alamat", nullable = false, columnDefinition = "TEXT")
    private String alamat;

    public Pengguna() {
    }

    public Pengguna(String namaLengkap, String username,
                    String password, String email,
                    Integer nomorHp, String alamat) {
        this.namaLengkap = namaLengkap;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nomorHp = nomorHp;
        this.alamat = alamat;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(Integer nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
