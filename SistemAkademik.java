import java.sql.SQLException;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
public class SistemAkademik extends javax.swing.JFrame {
List record = new ArrayList();//untuk menampung getAll()
InterfaceMahasiswa mhsServis; //untuk membuat objek dari class implement mahasiswa
int row;//untuk membantu dalam menampilkan data di textfield nim nama alamat.
String kFak, kThn;
public SistemAkademik() {
initComponents();
mhsServis = new ImplementMahasiswa();
//supaya kalo data di table di klik maka data akan muncul langsung di textfield nim nama alamat
jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
public void valueChanged(ListSelectionEvent e) {
row = jTable1.getSelectedRow();
if (row != -1) {
isiText();
}
}
});
this.statusAwal();
daftarKode();
}// lanjut
void daftarKode() {
Object[] fak = {"130", "145"};
Object[] thn = {"2012", "2013", "2014", "2015", "2016", "2017", "2018"};
for (int i = 0; i < fak.length; i++) {
CbKodeFak.addItem(fak[i].toString());
}
kFak = CbKodeFak.getSelectedItem().toString();
for (int i = 0; i < thn.length; i++) {
CbThn.addItem(thn[i].toString());
}
kThn = CbThn.getSelectedItem().toString();
}
void loadData() {
try {
record = mhsServis.getAll();
} catch (SQLException ex) {
Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE,
null, ex);
}
}
void statusAwal() {
kosongkanText();
loadData();
isiTabel();
}
private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try {
// TODO add your handling code here:
if ("Simpan".equals(this. BtnSimpan.getText())) {
Mahasiswa mhs = new Mahasiswa();
mhs.setNim(kFak + kThn + txtNim.getText());
mhs.setNama(txtNama.getText());
mhs.setAlamat(txtAlamat.getText());
mhsServis.insert(mhs);
this.statusAwal();
JOptionPane.showMessageDialog(this, "data tersimpan");
} else {
txtNim.setEditable(true);
CbKodeFak.setVisible(true);
CbThn.setVisible(true);
BtnSimpan.setText("Simpan");
kosongkanText();
}
} catch (SQLException ex) {
Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE, null, ex);
}
} 
//untuk mengosongkan text bila setelah tambah data atau yang lainnya
void kosongkanText() {
txtNim.setText("");
txtNama.setText("");
txtAlamat.setText("");
}
private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try {
// TODO add your handling code here:
Mahasiswa mhs = new Mahasiswa();
mhs.setNim(txtNim.getText());
mhs.setNama(txtNama.getText());
mhs.setAlamat(txtAlamat.getText());
mhsServis.update(mhs);
this.statusAwal();
JOptionPane.showMessageDialog(this, "data berhasil diubah");
} catch (SQLException ex) {
Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE,
null, ex);
}
}
private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
try {
// TODO add your handling code here:
String nim = txtNim.getText();
mhsServis.delete(nim);
this.statusAwal();
JOptionPane.showMessageDialog(this, "data berhasil dihapus");
} catch (SQLException ex) {
Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE,
null, ex);
}
}
//untuk mengurusi table yang ada di antarmuka. supaya mempunya judul nim,
// nama, alamat, serta dengan isinya yang selalu update.
void isiTabel() {
Object data[][] = new Object[record.size()][3];
int x = 0;
for (Iterator it = record.iterator(); it.hasNext();) {
Mahasiswa mhs = (Mahasiswa) it.next();
data[x][0] = mhs.getNim();
data[x][1] = mhs.getNama();
data[x][2] = mhs.getAlamat();
x++;
}
String judul[] = {"NIM", "NAMA", "ALAMAT"};
jTable1.setModel(new DefaultTableModel(data, judul));
jScrollPane1.setViewportView(jTable1);
}
private void CbKodeFakActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
kFak = CbKodeFak.getSelectedItem().toString();
}
private void CbThnActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
kThn = CbThn.getSelectedItem().toString();
} 
private void txtNimKeyTyped(java.awt.event.KeyEvent evt) {
// TODO add your handling code here:
txtNim.setToolTipText("4 Angka");
if(txtNim.getText().length()>3){
ketnim.setText("4 Angka");
txtNim.setEditable(false);
}
}
private void txtNimMouseClicked(java.awt.event.MouseEvent evt)
{
// TODO add your handling code here:
txtNim.setEditable(true);
ketnim.setText(null);
} 
//coding untuk isi text ke dalam textfield nim nama alamat
void isiText() {
Mahasiswa mhs = (Mahasiswa) record.get(row);
txtNim.setText(mhs.getNim());
txtNim.setEditable(false);
txtNama.setText(mhs.getNama());
txtAlamat.setText(mhs.getAlamat());
CbKodeFak.setVisible(false);
CbThn.setVisible(false);
BtnSimpan.setText("Aktif");
}
public static void main(String args[]) {
/* Create and display the form */
try {
// TODO code application logic here
UIManager.setLookAndFeel(new NimbusLookAndFeel());
SwingUtilities.invokeLater(new Runnable() {
public void run() {
SistemAkademik form = new SistemAkademik();
form.setLocationRelativeTo(null);
form.setVisible(true);
}
});
} catch (UnsupportedLookAndFeelException ex) {
Logger.getLogger(SistemAkademik.class.getName()).log(Level.SEVERE, null, ex);
}
}
