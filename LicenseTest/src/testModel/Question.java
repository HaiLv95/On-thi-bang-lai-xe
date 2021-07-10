package testModel;

/**
 *
 * @author hai95
 */
public class Question {
    private int id, loaiCauHoi_id;
    private String noiDung, hinh;

    public Question(String noiDung) {
        this.noiDung = noiDung;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLoaiCauHoi_id() {
        return loaiCauHoi_id;
    }

    public void setLoaiCauHoi_id(int loaiCauHoi_id) {
        this.loaiCauHoi_id = loaiCauHoi_id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
    
}
