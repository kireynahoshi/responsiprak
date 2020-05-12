/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsiprak;

/**
 *
 * @author User
 */
class MVC {
    public void DataP(){
        Data_P data_p = new Data_P();
        Model model = new Model();
        Controller controller = new Controller(data_p, model);
    }
    public void GajiP(){
        Gaji_P gaji_p = new Gaji_P();
        Model model = new Model();
        Controller controller = new Controller(gaji_p, model);
    }
    public void DataA(){
        Data_A data_a;
        data_a = new Data_A();
        Model model = new Model();
        Controller controller = new Controller(data_a, model);
    }
    public void Tambah_A(){
        Tambah_A tambah_a;
        tambah_a = new Tambah_A();
        Model model = new Model();
        Controller controller = new Controller(tambah_a, model);
    }
}
