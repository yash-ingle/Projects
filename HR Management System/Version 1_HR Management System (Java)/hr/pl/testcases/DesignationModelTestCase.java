import java.awt.*;
import javax.swing.*;
import com.thinking.machines.hr.pl.model.*;
import com.thinking.machines.hr.bl.exceptions.*;
class DesignationModelTestCase extends JFrame
{
private DesignationModel designationModel;
private JTable table;
private JScrollPane scrollPane;
private Container container;
DesignationModelTestCase()
{
designationModel=new DesignationModel();
table=new JTable(designationModel);
scrollPane=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
container=getContentPane();
container.setLayout(new BorderLayout());
container.add(scrollPane);
setSize(600,600);
setLocation(200,100);
setVisible(true);
}
public static void main(String gg[])
{
DesignationModelTestCase dmtc=new DesignationModelTestCase();
}
}