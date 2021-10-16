package entity;

import java.util.Date;

public class Order {
	private Integer id;
	private Integer userId; 	//訂單編號
	private Integer productId; 	//訂貨人
	private Date ts; 			//下單時間
	
	
	public Order() {
		super();
	}
	
	public Order(Integer id, Integer userId, Integer productId) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.ts = new Date();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Date getTs() {
		return ts;
	}
	public void setTs(Date ts) {
		this.ts = ts;
	}
	
	
}
