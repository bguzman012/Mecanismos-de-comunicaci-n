/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.activemqq;

import com.mycompany.activemq.vistas.EnvioMensajes;
import com.mycompany.activemq.vistas.MenuPrincipal;
import com.mycompany.activemq.vistas.MenuPrincipalConsumidor;

/**
 *
 * @author Usuario
 */
public class MainSenMessagesConsumidor {
    
    public static void main(String[] args)  {
        
        MenuPrincipalConsumidor enviar = new MenuPrincipalConsumidor();
        
        enviar.setVisible(true);

    }

    
}
