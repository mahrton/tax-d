package org.taxd.remote;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = -4414015642821984680L;
	private int netPriceCents = 0;
	private ProductType productType = ProductType.OTHER;
	
	public enum ProductType {
		FOOD(7),
		MEDICINE(0), 
		OTHER(20);
		
		float vat = 0; 
		
		private ProductType(float vat) {
			this.vat = vat;
		}
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public int getNetPriceCents() {
		return netPriceCents;
	}

	public void setNetPriceCents(int netPriceCents) {
		this.netPriceCents = netPriceCents;
	}
}
