package com.vicky.HQLUpdate;

import java.util.Scanner;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import com.vicky.HQLUpdate.Entity.Employee4;

import Operation.DeleteData;
import Operation.InsertData;
import Operation.UpdateData;


public class App 
{
    public static void main( String[] args )
    {
        
       InsertData insert = new InsertData();
       insert.insertData();
      
       
       DeleteData delete = new DeleteData();
       delete.deleteData();
       
      
       UpdateData update = new UpdateData();
       update.updateData();
    }
}
