package com.freshfold;

import com.freshfold.dao.PenggunaDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        PenggunaDAO dao = context.getBean(PenggunaDAO.class);

        dao.findByUsername("testing");

        System.out.println("Spring DAO berhasil dijalankan!");

        context.close();
    }
}