package testModel;

/**
 *
 * @author hai95
 */
public class CauHoi_DeThi {
    private int cauHoi_id, deThi_id, cauTraLoi;
    private boolean trangThai;
    public CauHoi_DeThi() {
		// TODO Auto-generated constructor stub
	}
    public CauHoi_DeThi(int cauHoi_id, int deThi_id, int cauTraLoi, boolean trangThai) {
		super();
		this.cauHoi_id = cauHoi_id;
		this.deThi_id = deThi_id;
		this.cauTraLoi = cauTraLoi;
		this.trangThai = trangThai;
	}

	public int getCauHoi_id() {
        return cauHoi_id;
    }

    public void setCauHoi_id(int cauHoi_id) {
        this.cauHoi_id = cauHoi_id;
    }

    public int getDeThi_id() {
        return deThi_id;
    }

    public void setDeThi_id(int deThi_id) {
        this.deThi_id = deThi_id;
    }

    public int getCauTraLoi() {
        return cauTraLoi;
    }

    public void setCauTraLoi(int cauTraLoi) {
        this.cauTraLoi = cauTraLoi;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
