package com.ptit.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ptit.dao.CustomerDAO;
import com.ptit.entity.Customers;

@Component
public class DataMigrationRunner implements CommandLineRunner {

    private final CustomerDAO customerDAO;

    public DataMigrationRunner(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void run(String... args) {
        try {
            Customers admin = customerDAO.findByUsername("admin");
            if (admin != null) {
                boolean changed = false;
                String desiredName = "Nguyễn Minh Hiếu";
                String desiredEmail = "hwiyou2005@gmail.com";
                if (admin.getFullname() == null || !admin.getFullname().equals(desiredName)) {
                    admin.setFullname(desiredName);
                    changed = true;
                }
                if (admin.getEmail() == null || !admin.getEmail().equalsIgnoreCase(desiredEmail)) {
                    admin.setEmail(desiredEmail);
                    changed = true;
                }
                if (changed) {
                    customerDAO.save(admin);
                }
            }
        } catch (Exception ignored) {
            // No-op: avoid impacting startup if DB is unavailable
        }
    }
}
