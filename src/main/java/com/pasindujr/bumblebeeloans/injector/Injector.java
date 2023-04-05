package com.pasindujr.bumblebeeloans.injector;

import com.pasindujr.bumblebeeloans.dao.AdminManager;

public class Injector {
    public AdminManager getAdminManager(){
        return new AdminManager();
    }
}
