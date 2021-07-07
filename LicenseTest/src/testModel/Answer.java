package testModel;

/**
 *
 * @author hai95
 */
public class Answer {
    private int id, cauhoi_id;
    private String noiDung, giaiThich;
    private boolean trangThai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCauhoi_id() {
        return cauhoi_id;
    }

    public void setCauhoi_id(int cauhoi_id) {
        this.cauhoi_id = cauhoi_id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getGiaiThich() {
        return giaiThich;
    }

    public void setGiaiThich(String giaiThich) {
        this.giaiThich = giaiThich;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
}
