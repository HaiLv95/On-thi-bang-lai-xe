package testModel;

/**
 *
 * @author hai95
 */
public class Answer {
    private int id, cauhoi_id;
    private String noiDung, giaiThich;
    private boolean trangThai, flag;
    public int getId() {
        return id;
    }
    public Answer() {
		// TODO Auto-generated constructor stub
	}
    public Answer(int id, int cauhoi_id, String noiDung, String giaiThich, boolean trangThai, boolean flag) {
		super();
		this.id = id;
		this.cauhoi_id = cauhoi_id;
		this.noiDung = noiDung;
		this.giaiThich = giaiThich;
		this.trangThai = trangThai;
		this.flag = flag;
	}

	public void setId(int id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
