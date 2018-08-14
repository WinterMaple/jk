package cn.hfl.jk.vo;

import java.util.List;

import cn.hfl.jk.domain.Contract;
import cn.hfl.jk.domain.ExtCproduct;
import cn.hfl.jk.domain.Factory;

public class ContractProductVO {
	private String id;
	
//	private Contract contract;		//将复杂的关联关系变成单表操作
	private List<ExtCproductVO> extCproducts;	//和附件一对多
	private Factory factory;		//和生产厂家一对多

	private String productNo;
	private String productImage;
	private String productDesc;
	private Integer cnumber;
	private Integer outCnumber;
	private String loadingRate;
	private Integer boxNum;
	private String packingUnit;
	private Double price;
	private Double amount;
	private Integer finished;
	private String exts;
	private Integer orderNo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
/*	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}*/
	public List<ExtCproductVO> getExtCproducts() {
		return extCproducts;
	}
	public void setExtCproducts(List<ExtCproductVO> extCproducts) {
		this.extCproducts = extCproducts;
	}
	public Factory getFactory() {
		return factory;
	}
	public void setFactory(Factory factory) {
		this.factory = factory;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getCnumber() {
		return cnumber;
	}
	public void setCnumber(Integer cnumber) {
		this.cnumber = cnumber;
	}
	public Integer getOutCnumber() {
		return outCnumber;
	}
	public void setOutCnumber(Integer outCnumber) {
		this.outCnumber = outCnumber;
	}
	public String getLoadingRate() {
		return loadingRate;
	}
	public void setLoadingRate(String loadingRate) {
		this.loadingRate = loadingRate;
	}
	public Integer getBoxNum() {
		return boxNum;
	}
	public void setBoxNum(Integer boxNum) {
		this.boxNum = boxNum;
	}
	public String getPackingUnit() {
		return packingUnit;
	}
	public void setPackingUnit(String packingUnit) {
		this.packingUnit = packingUnit;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getFinished() {
		return finished;
	}
	public void setFinished(Integer finished) {
		this.finished = finished;
	}
	public String getExts() {
		return exts;
	}
	public void setExts(String exts) {
		this.exts = exts;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
}
