package testModel;

/**
 *
 * @author hai95
 */
public class Dethi {
    private int id,  timer, loaide_id;
    private String trangThai;
    private String email;
    public Dethi() {
		// TODO Auto-generated constructor stub
	}
    
    public Dethi(int id, int timer, int loaide_id, String trangThai, String email) {
		super();
		this.id = id;
		this.timer = timer;
		this.loaide_id = loaide_id;
		this.trangThai = trangThai;
		this.email = email;
	}

	public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    

    public int getLoaide_id() {
        return loaide_id;
    }

    public void setLoaide_id(int loaide_id) {
        this.loaide_id = loaide_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
