/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverproject;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class ContainerPanel extends JPanel
{
    public ContainerPanel(JFrame Frame)
    {
        super();
        LoginScreen LS = new LoginScreen(Frame);
        this.add(LS);
    }
}
