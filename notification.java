import javax.swing.*;
public class notification extends JFrame{
    public void invalidphone(){
        JOptionPane.showMessageDialog(null, "Invalid Contact Number ... Please Re-enter ","Invalid Phonenumber",JOptionPane.ERROR_MESSAGE);
    }

    public void invalidsalary(){
        JOptionPane.showMessageDialog(null, "Invalid Salary ... Please Re-enter ","Invalid Birthday",JOptionPane.ERROR_MESSAGE);
    }
    public void invalidbday(){
        JOptionPane.showMessageDialog(null, "Invalid Brithday ... Please Re-enter ","Invalid Birthday",JOptionPane.ERROR_MESSAGE);
    }

    public void Sucssadd(){
        JOptionPane.showMessageDialog(null, "Contact Added Successfully...","Successfull!",JOptionPane.INFORMATION_MESSAGE);
    }

    public void Sucssupt(){
        JOptionPane.showMessageDialog(null, "Contact Updated Successfully...","Successfull!",JOptionPane.INFORMATION_MESSAGE);
    }

    public void searchcontact(){
        JOptionPane.showMessageDialog(null, "Search a Contact","Not Searched",JOptionPane.ERROR_MESSAGE);
    }
}
