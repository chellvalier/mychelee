package com.freshfold.dao;

import com.freshfold.Pengguna;

public interface PenggunaDAO {

    void save(Pengguna pengguna);

    Pengguna findByUsername(String username);

    Pengguna login(String username, String password);
}
