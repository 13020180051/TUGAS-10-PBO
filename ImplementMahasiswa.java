import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ImplementMahasiswa implements
InterfaceMahasiswa{
public Mahasiswa insert(Mahasiswa o) throws
SQLException {//untuk insert ke database
PreparedStatement
st=DatabaseUtilities.getConnection().prepareStatement
("insert into mahasiswa values(?,?,?)");
st.setString(1, o.getNim());
st.setString(2, o.getNama());
st.setString(3, o.getAlamat());
st.executeUpdate();
return o;
}
public void update(Mahasiswa o) throws
SQLException {//untuk update ke database
PreparedStatement
st=DatabaseUtilities.getConnection().prepareStatement("upda
te mahasiswa set nama=?,alamat=? where nim=?");
st.setString(1, o.getNama());
st.setString(2, o.getAlamat());
st.setString(3, o.getNim());
st.executeUpdate();
}
public void delete(String nim) throws
SQLException {// untuk delete berdasarkan nim
PreparedStatement
st=DatabaseUtilities.getConnection().prepareStatemen
t("delete from mahasiswa where nim=?");
st.setString(1, nim);
st.executeUpdate();
}
public List getAll() throws SQLException { // untuk
read all, jadi semua data diambil dan ditampilkan
Statement
st=DatabaseUtilities.getConnection().createStatement();
ResultSet rs=st.executeQuery("select * from
mahasiswa");
List list=new ArrayList();
while(rs.next()){
Mahasiswa mhs=new Mahasiswa();
mhs.setNim(rs.getString("nim"));
mhs.setNama(rs.getString("nama"));
mhs.setAlamat(rs.getString("alamat"));
list.add(mhs);
}
return list;
}
}