package testModel;

/**
 *
 * @author hai95
 */
public class Question {
    private int id, loaiCauHoi_id;
    private String noiDung, hinh;
    private boolean trangThai;

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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
